package com.example.myapplication.view.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ChangeProfileActivity extends AppCompatActivity {

    EditText nameET ;
    EditText lastNameET;
    EditText bankET ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        init();
    }

    public void init(){
        initView();
        initListeners();

    }

    public void initView(){
        nameET = findViewById(R.id.imeTVprofileEdit);
        lastNameET = findViewById(R.id.prezimeeTVprofileEdit);
        bankET = findViewById(R.id.bankaTVprofileEdit);

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String lastName = sharedPreferences.getString("lastName", "");
        String bank = sharedPreferences.getString("bank", "");
        System.out.println(sharedPreferences.getAll());
        nameET.setText(name);
        lastNameET.setText(lastName);
        bankET.setText(bank);
    }

    public void initListeners(){
        Button noChange = findViewById(R.id.odustaniEdit);
        Button change = findViewById(R.id.changeEdit);

        noChange.setOnClickListener(view -> {
            finish();
        });

        change.setOnClickListener(view -> {
            String name = nameET.getText().toString();
            String lastName = lastNameET.getText().toString();
            String bank = bankET.getText().toString();

            SharedPreferences sharedPref = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", name);
            editor.putString("lastName", lastName);
            editor.putString("bank", bank);
            editor.apply();


            finish();
        });

    }



}
