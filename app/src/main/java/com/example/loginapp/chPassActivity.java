package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class chPassActivity extends AppCompatActivity {
    TextView e1;
    EditText e2,e3,e4;
    LDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chpass);

        e1=(TextView) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        e3=(EditText) findViewById(R.id.e3);
        e4=(EditText) findViewById(R.id.e4);

        String str = getIntent().getStringExtra("uname");
        e1.setText(str);

        db= new LDB(this);

    }

    public void cPass(View v) {

        String uname,op,ps1,ps2;
        uname=e1.getText().toString();
        op=e2.getText().toString();
        ps1=e3.getText().toString();
        ps2=e4.getText().toString();

        if(db.CheckPass(uname, op))
        {

            if(ps1.equals(ps2)==false)
            {
                Toast.makeText(this,"Password Mismatch, Try Again..", Toast.LENGTH_LONG).show();
            }
            else
            {

                db.ChangePass(uname, ps1);
                Toast.makeText(this,"Password Updated , Please Login", Toast.LENGTH_SHORT).show();
                Intent ob= new Intent("act.log");
                ob.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(ob);
                finish();
            }
        }
        else {
            Toast.makeText(this,"Invalid Password, Try Again..", Toast.LENGTH_LONG).show();

        }







    }
}