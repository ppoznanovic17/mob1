package com.example.myapplication.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.view.activities.ChangeProfileActivity;
import com.example.myapplication.view.activities.LoginActivity;

public class ProfileFragment extends Fragment {

    TextView nameTV;
    TextView lastNameTV ;
    TextView bankTV;



    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTV =  getView().findViewById(R.id.imeTVprofile);
        lastNameTV =  getView().findViewById(R.id.prezimeeTVprofile);
        bankTV =  getView().findViewById(R.id.bankaTVprofile);
        init();

    }


    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    @Override
    public void onPause() {
        super.onPause();
        init();
    }

    public void init(){
        initView();
        initListeners();
    }

    public void initView(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getPackageName(),Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String lastName = sharedPreferences.getString("lastName", "");
        String bank = sharedPreferences.getString("bank", "");

         nameTV =  getView().findViewById(R.id.imeTVprofile);
         lastNameTV =  getView().findViewById(R.id.prezimeeTVprofile);
         bankTV =  getView().findViewById(R.id.bankaTVprofile);

        nameTV.setText(name);
        lastNameTV.setText(lastName);
        bankTV.setText(bank);
    }

    public void initListeners(){
        Button singOut = getView().findViewById(R.id.odjavaEdit);
        singOut.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getPackageName(),Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            System.out.println(sharedPreferences.getAll());
            editor.clear();
            editor.apply();
            System.out.println(sharedPreferences.getAll());
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);

        });

        Button change = getView().findViewById(R.id.izmeniEdit);
        change.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ChangeProfileActivity.class);
            startActivity(intent);
        });
    }
}
