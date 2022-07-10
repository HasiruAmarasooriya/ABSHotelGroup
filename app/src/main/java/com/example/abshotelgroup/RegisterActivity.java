package com.example.abshotelgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username,email,password,confirmpassword;
    Button btnRegister,btnSignIn ;
    DBHelper MyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmpassword=(EditText)findViewById(R.id.confirmpassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnSignIn = (Button) findViewById(R.id.btnSingIn);



        MyDB = new DBHelper(this);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String emai = email.getText().toString();
                String pass = password.getText().toString();
                String confirmpass = confirmpassword.getText().toString();


                if (TextUtils.isEmpty(user)){
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Name.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(emai)){
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Email.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(pass)){
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Password.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(confirmpass)){
                    Toast.makeText(RegisterActivity.this, "Please Enter Your Confirm Password.", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    if(pass.equals(confirmpass))
                    {
                        Boolean usercheckResult = MyDB.checkusername(user);

                        if(usercheckResult == false)
                        {
                           Boolean regRisult = MyDB.insertData(user,emai,pass);
                           if(regRisult == true)
                           {

                               Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                               Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                               startActivity(intent);
                           }
                           else
                           {
                               Toast.makeText(RegisterActivity.this, "Registration Field", Toast.LENGTH_SHORT).show();
                           }
                        }
                        else
                        {

                            Toast.makeText(RegisterActivity.this, "User already Exists.\n Please Sing In.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {

                        Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}