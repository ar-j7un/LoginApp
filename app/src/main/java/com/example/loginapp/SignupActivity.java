package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    LDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        e3=(EditText) findViewById(R.id.e3);

        db= new LDB(this);

    }

    public void onSign(View v) {

        String uname,ps1,ps2;
        uname=e1.getText().toString();
        ps1=e2.getText().toString();
        ps2=e3.getText().toString();

        if(ps1.equals(ps2)==false)
        {
            Toast.makeText(this,"Password Mismatch, Try Again..", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Sign Up Success, Please Login", Toast.LENGTH_SHORT).show();
            db.addUser(uname, ps1);
            Intent ob= new Intent("act.log");
            startActivity(ob);
        }
    }
}