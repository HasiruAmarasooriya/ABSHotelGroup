package com.example.abshotelgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    Button btnRoomPackage,btnPackage2,btnOurdetails;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnRoomPackage = (Button) findViewById(R.id.btnRoomPackage);
        btnPackage2 = (Button) findViewById(R.id.btnPackage2);
        btnOurdetails = (Button) findViewById(R.id.btnOurdetails);


        MyDB = new DBHelper(this);

        btnRoomPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btnPackage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VehiclePackages.class);
                startActivity(intent);
            }
        });

        btnOurdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Feedback.class);
                startActivity(intent);
            }
        });
    }
} 