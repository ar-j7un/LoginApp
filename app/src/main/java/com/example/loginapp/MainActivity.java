package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLog(View v)
    {
        Intent obj = new Intent("act.log");
        startActivity(obj);

    }
    public void onSign(View v)
    {
        Intent obj1 = new Intent("act.sign");
        startActivity(obj1);

    }
}