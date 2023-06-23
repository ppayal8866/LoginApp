package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {
    String user, pass;
    EditText user_input, enter_otp;
    NeumorphButton get_otp, verify_otp;
    SharedPreferences preferences, rem, logged, userin, check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_input = findViewById(R.id.user_input);
        enter_otp = findViewById(R.id.enter_otp);
        get_otp = findViewById(R.id.get_otp);
        verify_otp = findViewById(R.id.verify_otp);

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
            user_input.setText(user);
            enter_otp.setText(pass);

        }

        SharedPreferences.Editor editor = rem.edit();


        get_otp.setOnClickListener(v -> {

            if (user_input.getText().toString().equals(user) && enter_otp.getText().toString().equals(pass) && !(user.equals("")) && !(pass.equals(""))) {
                // todo: maybe remove this?
                user_input.setText("");
                enter_otp.setText("");

                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                logged.edit().putBoolean("Inlogged", true).apply();
            } else if(user_input.getText().toString().equals("") || enter_otp.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Enter credentials", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(MainActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
            }
        });

        verify_otp.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });
    }
}