package com.example.finalproject.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;


public class infoClass extends AppCompatActivity implements View.OnClickListener {
    TextView txtinfo;
    Button btnGoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initialize();


    }

    private void initialize() {
        txtinfo=findViewById(R.id.textinfo);
        btnGoBack=findViewById(R.id.btnGoback);
        btnGoBack.setOnClickListener(this);
        String finalinfo=getIntent().getStringExtra("res");
        txtinfo.setText(finalinfo);
    }

    @Override
    public void onClick(View v) {
        finish();

    }

}
