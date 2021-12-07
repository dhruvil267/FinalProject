package com.example.finalproject.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private EditText txtEmail,txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btnLogin);
        txtEmail=findViewById(R.id.editTxtMail);
        txtPass=findViewById(R.id.editTxtPass);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String msg;
        if(!txtEmail.getText().toString().equals("alex@gmail.com")){
            msg="Plese Verify Email";
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();


        }else if(!txtPass.getText().toString().equals("1234")){
            msg="Plese Verify Password";
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();


        }else{
            Intent intent = new Intent(this,MainActivity.class);
            txtEmail.setText("");
            txtPass.setText("");
            startActivity(intent);
        }

    }
}