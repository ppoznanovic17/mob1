package com.example.myapplication.view.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ShowTransactionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_file);
        initView();
    }

    public void initView(){
        TextView titleTV = findViewById(R.id.naslovView);
        TextView valueTV = findViewById(R.id.valueView);
        TextView descriptionTV = findViewById(R.id.descriptionView);

        String title = getIntent().getExtras().getString("title");
        String value = getIntent().getExtras().getString("value", "/");
        String description = getIntent().getExtras().getString("description");

        titleTV.setText(title);
        valueTV.setText(value);
        descriptionTV.setText(description);

    }
}
