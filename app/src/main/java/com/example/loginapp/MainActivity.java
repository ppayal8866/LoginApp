package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {
    String user, pass;
    EditText email, password;
    NeumorphButton login, register;
    CheckBox remember;
    SharedPreferences preferences, rem, logged, userin, check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        remember = findViewById(R.id.remember);

        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);
        rem = getSharedPreferences("saveLogin", MODE_PRIVATE);
        logged = getSharedPreferences("loggedIn", MODE_PRIVATE);
        userin = getSharedPreferences("userin", MODE_PRIVATE);
        check = getSharedPreferences("check", MODE_PRIVATE);

        user = preferences.getString("email", "");
        pass = preferences.getString("password", "");

        if((logged.getBoolean("Inlogged", false)) && rem.getInt("saveLogin", 0) == 1){
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
        }

        int remValue = rem.getInt("saveLogin", 0);

        if(remValue ==1){
            email.setText(user);
            password.setText(pass);
            remember.setChecked(true);

        }

        SharedPreferences.Editor editor = rem.edit();
        remember.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if(remember.isChecked()){
                editor.putInt("saveLogin", 1);
                editor.apply();
            }else if(!remember.isChecked()){
                editor.putInt("saveLogin", 0);
                editor.apply();
            }
        });


        login.setOnClickListener(v -> {

            if (email.getText().toString().equals(user) && password.getText().toString().equals(pass) && !(user.equals("")) && !(pass.equals(""))) {
                if(!remember.isChecked()){
                    email.setText("");
                    password.setText("");
                }

                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                logged.edit().putBoolean("Inlogged", true).apply();
            } else if(email.getText().toString().equals("") || password.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Enter credentials", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(MainActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });
    }
}