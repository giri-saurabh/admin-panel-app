package com.example.fyp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fyp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class updateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView aiDepartment, webDepartment, bdDepartment, hpcDepartment;
    private LinearLayout aiNoData, webNoData, bdNoData, hpcNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        fab = findViewById(R.id.fab);

        hpcNoData = findViewById(R.id.hpcNoData);
        bdNoData = findViewById(R.id.bdNoData);
        webNoData = findViewById(R.id.webNoData);
        aiNoData = findViewById(R.id.aiNoData);

        hpcDepartment = findViewById(R.id.hpcDepartment);
        bdDepartment = findViewById(R.id.bdDepartment);
        webDepartment = findViewById(R.id.webDepartment);
        aiDepartment = findViewById(R.id.aiDepartment);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        hpcDepartment();
        aiDepartment();
        bdDepartment();
        webDepartment();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(updateFaculty.this,addTeacher.class);
                startActivity(intent);
            }
        });
    }

    private void hpcDepartment() {
        dbRef = reference.child("High Performance Computing");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hpcNoData.setVisibility(View.VISIBLE);
                    hpcDepartment.setVisibility(View.GONE);
                }else {
                    hpcNoData.setVisibility(View.GONE);
                    hpcDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    hpcDepartment.setHasFixedSize(true);
                    hpcDepartment.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list1, updateFaculty.this);
                    hpcDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void aiDepartment() {
        dbRef = reference.child("Artificial Intelligence");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aiNoData.setVisibility(View.VISIBLE);
                    aiDepartment.setVisibility(View.GONE);
                }else {
                    aiNoData.setVisibility(View.GONE);
                    aiDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    aiDepartment.setHasFixedSize(true);
                    aiDepartment.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list2, updateFaculty.this);
                    aiDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void bdDepartment() {
        dbRef = reference.child("Big Data");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bdNoData.setVisibility(View.VISIBLE);
                    bdDepartment.setVisibility(View.GONE);
                }else {
                    bdNoData.setVisibility(View.GONE);
                    bdDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    bdDepartment.setHasFixedSize(true);
                    bdDepartment.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list3, updateFaculty.this);
                    bdDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void webDepartment() {
        dbRef = reference.child("Web Development");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    webNoData.setVisibility(View.VISIBLE);
                    webDepartment.setVisibility(View.GONE);
                }else {
                    webNoData.setVisibility(View.GONE);
                    webDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    webDepartment.setHasFixedSize(true);
                    webDepartment.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list4, updateFaculty.this);
                    webDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}