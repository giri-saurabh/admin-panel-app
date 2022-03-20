package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice, addGalleryImage, addMaterials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addImages);
        addMaterials = findViewById(R.id.addMaterials);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addMaterials.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.addNotice:
                intent = new Intent(MainActivity.this, uploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addImages:
                intent = new Intent(MainActivity.this, uploadImage.class);
                startActivity(intent);
                break;
            case R.id.addMaterials:
                intent = new Intent(MainActivity.this, uploadPDFActivity.class);
                startActivity(intent);
                break;


        }
    }
}