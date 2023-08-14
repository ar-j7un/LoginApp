package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        String str = getIntent().getStringExtra("un");
        TextView tv = (TextView)findViewById(R.id.t1);
        tv.setText("Welcome "+str);


    }

    @Override
    public void onBackPressed() {
        Intent ob = new Intent(this, LoginActivity.class);
        ob.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ob);
        finish();

    }

    public void PassChange(View v)
    {
        String str = getIntent().getStringExtra("un");
        Intent Pass = new Intent(this, chPassActivity.class);
        Pass.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        Pass.putExtra("uname",str);
        startActivity(Pass);
        finish();


    }
    public void LogOut(View v)
    {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}