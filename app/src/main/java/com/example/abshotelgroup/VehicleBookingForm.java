package com.example.abshotelgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VehicleBookingForm extends AppCompatActivity {

    EditText username,email,NIC,date,Duration,packagetype  ;
    Button btnBooking;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_booking_form);

        username = (EditText) findViewById(R.id.PersonName);
        email = (EditText) findViewById(R.id.EmailAddress);
        NIC = (EditText) findViewById(R.id.NIC2);
        Duration = (EditText) findViewById(R.id.Date);
        packagetype = (EditText) findViewById(R.id.Packagetype);

        btnBooking = (Button) findViewById(R.id.btnBooking);

        MyDB = new DBHelper(this);

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String emai = email.getText().toString();
                String nic = NIC.getText().toString();
                String dat = Duration.getText().toString();
                String packagetyp = packagetype.getText().toString();

                if(TextUtils.isEmpty(user)){

                    Toast.makeText(VehicleBookingForm.this, "Please enter your User Name", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(emai)){

                    Toast.makeText(VehicleBookingForm.this, "Please enter Your email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(nic)){

                    Toast.makeText(VehicleBookingForm.this, "Please enter Your NIC", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(dat)){

                    Toast.makeText(VehicleBookingForm.this, "Please enter  Date", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(packagetyp)){

                    Toast.makeText(VehicleBookingForm.this, "Please enter Package Type", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(VehicleBookingForm.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),VehicleBookingConfirm.class);
                    startActivity(intent);
                }


            }

        });
    }
}