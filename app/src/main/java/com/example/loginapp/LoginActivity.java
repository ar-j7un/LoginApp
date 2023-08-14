package com.example.loginapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText e1,e2;
    LDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);

        db= new LDB(this);
    }

    public void onLog(View v) {

        String a[];
        try {
            String un = e1.getText().toString();
            String ps = e2.getText().toString();
            a= db.getUser(un,ps);


            if(a[0].equals(un))
            {
                if (a[1].equals(ps))
                {
                    Intent o1 = new Intent(LoginActivity.this, HomeActivity.class);
                    o1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);


                    o1.putExtra("un",un);
                    startActivity(o1);
                    finish();
                }
                else
                {
                    Toast.makeText(this, "Invalid Credentials !! ", Toast.LENGTH_LONG).show();

                }


            }
            else
            {

                Toast.makeText(this, "User Not Found ...", Toast.LENGTH_LONG).show();
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}