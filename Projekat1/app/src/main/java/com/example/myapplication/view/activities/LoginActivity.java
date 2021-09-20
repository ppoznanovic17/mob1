package com.example.myapplication.view.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    private static final String default_password = "11111";

    EditText nameEt;
    EditText lastNameEt;
    EditText bankEt;
    EditText passwordEt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nameEt = (EditText)findViewById(R.id.logInimeEt);
         lastNameEt = (EditText)findViewById(R.id.logInprezimeEt);
         bankEt = (EditText)findViewById(R.id.logInbankaEt);
         passwordEt = (EditText)findViewById(R.id.logInsiftaEt);
        initListeners();
    }

    public void init(){
        initListeners();
    }

    private void initListeners(){
        Button logInBtn = (Button)findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(v -> {
            SharedPreferences sharedPref = getSharedPreferences(getPackageName(),Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            String name = nameEt.getText().toString();
            String lastName = lastNameEt.getText().toString();
            String bank = bankEt.getText().toString();
            String password = passwordEt.getText().toString();
            System.out.println(name);
            System.out.println(lastName);
            System.out.println(bank);
            System.out.println(password);
            if(name.equals("") || name == null) {
                Toast.makeText(LoginActivity.this, "Molim vas unesite Vase ime.", Toast.LENGTH_LONG).show();
            }
            else if(lastName.equals("") || lastName == null) {
                Toast.makeText(LoginActivity.this, "Molim vas unesite Vase prezime.", Toast.LENGTH_LONG).show();
            }

            else if(bank.equals("") || bank == null) {
                Toast.makeText(LoginActivity.this, "Molim vas unesite ime Vase banke.", Toast.LENGTH_LONG).show();
            }
            else if(password.equals("") || password == null) {
                Toast.makeText(LoginActivity.this, "Molim vas unesite Vasu sifru.", Toast.LENGTH_LONG).show();
            }

            else if(password.length() < 5) {
                Toast.makeText(LoginActivity.this, "Sifra mora da sadrzi najmanje 5 karaktera", Toast.LENGTH_LONG).show();
            }

            else if(password.equals(default_password)) {
                editor.putBoolean("loggedIn", true);
                editor.putString("name", name);
                editor.putString("lastName", lastName);
                editor.putString("bank", bank);
                editor.apply();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(LoginActivity.this, "Pogresna sifra!!!", Toast.LENGTH_LONG).show();

            }


        });
    }
}
