package com.example.abshotelgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {


    EditText username,email,NIC,date,numberofRooms,packagetype  ;
    Button btnBooking;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        username = (EditText) findViewById(R.id.PersonName);
        email = (EditText) findViewById(R.id.EmailAddress);
        NIC = (EditText) findViewById(R.id.NIC2);
        date = (EditText) findViewById(R.id.Date);
        numberofRooms = (EditText) findViewById(R.id.NumberOfRooms);
        packagetype = (EditText) findViewById(R.id.Packagetype);

        btnBooking = (Button) findViewById(R.id.btnBooking);

        MyDB = new DBHelper(this);

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String emai = email.getText().toString();
                String nic = NIC.getText().toString();
                String dat = date.getText().toString();
                String numberofrooms = numberofRooms.getText().toString();
                String packagetyp = packagetype.getText().toString();

                if(TextUtils.isEmpty(user)){

                    Toast.makeText(MainActivity4.this, "Please enter your User Name", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(emai)){

                    Toast.makeText(MainActivity4.this, "Please enter Your email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(nic)){

                    Toast.makeText(MainActivity4.this, "Please enter Your NIC", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(dat)){

                    Toast.makeText(MainActivity4.this, "Please enter  Date", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(numberofrooms)){

                    Toast.makeText(MainActivity4.this, "Please enter Number of Rooms", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(packagetyp)){

                    Toast.makeText(MainActivity4.this, "Please enter Package Type", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(MainActivity4.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ConfirmBooking.class);
                    startActivity(intent);
                }


                }

        });



    }
}