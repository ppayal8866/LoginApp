package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import soup.neumorphism.NeumorphButton;

public class Register extends AppCompatActivity {
    EditText name, email, password, phone;
    RadioGroup gender;
    NeumorphButton register;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.register);
        gender = findViewById(R.id.gender);

        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);



        register.setOnClickListener(v -> {
            String nameValue = name.getText().toString();
            String emailValue = email.getText().toString();
            String passwordValue = password.getText().toString();
            String phoneValue = phone.getText().toString();
            RadioButton checkbtn = findViewById(gender.getCheckedRadioButtonId());
            String genderValue = checkbtn.getText().toString();

            if(nameValue.length()>1 || emailValue.length()>1 || phoneValue.length()>1 || passwordValue.length()>1) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", nameValue);
                editor.putString("email", emailValue);
                editor.putString("phone", phoneValue);
                editor.putString("password", passwordValue);
                editor.putString("gender", genderValue);
                editor.apply();
                Toast.makeText(Register.this, "User registered! Login to continue", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(Register.this, "Enter value in the fields", Toast.LENGTH_SHORT).show();
            }

        });

    }
}