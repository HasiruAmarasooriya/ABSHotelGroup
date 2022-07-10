package com.example.abshotelgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarPackage extends AppCompatActivity {

    Button btnBook2;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_package);

        btnBook2 = (Button) findViewById(R.id.btnBook2);


        MyDB = new DBHelper(this);

        btnBook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VehicleBookingForm.class);
                startActivity(intent);
            }
        });
    }
}