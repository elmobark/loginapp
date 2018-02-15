package com.apine.socr.loginapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        Intent in =new Intent(this,WelcomeActivity.class);
        in.putExtra(appSettings.IUN,getIntent().getStringExtra(appSettings.IUN));
        startActivity(in);
    }
}
