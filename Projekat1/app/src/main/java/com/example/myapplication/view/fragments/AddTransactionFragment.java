package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.model.Transaction;
import com.example.myapplication.viewModel.TransactionsViewModel;

public class AddTransactionFragment  extends Fragment {


    Spinner dropdown ;
    EditText titleEt;
    EditText valueEt;
    EditText descriptionEt;
    Button addTransactionBtn;

    Transaction t;

    View view;
    TransactionsViewModel transactionsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        System.out.println(getActivity().getComponentName());
        transactionsViewModel = new ViewModelProvider(getActivity()).get(TransactionsViewModel.class);
        t = new Transaction();

        init();
    }

    public AddTransactionFragment() {
        super(R.layout.fragment_add_transaction);

    }



    public void init(){
        initView();
        initListeners();

    }

    public void initView(){
         titleEt = getActivity().findViewById(R.id.add_transaction_Name_Et);
         valueEt = getActivity().findViewById(R.id.add_transaction_Value_Et);
         descriptionEt = getActivity().findViewById(R.id.add_transaction_Description_Et);
        addTransactionBtn = getActivity().findViewById(R.id.add_transaction_Add_Btn);

        dropdown = view.findViewById(R.id.spinner1);
        String[] items = new String[]{"Prihod", "Rashod"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void initListeners(){
        addTransactionBtn.setOnClickListener(view1 -> {
            if (titleEt.getText().toString().equals("") || titleEt.getText().toString() == null){
                Toast.makeText(getContext(), "Please enter transaction title", Toast.LENGTH_LONG).show();
            }else if (valueEt.getText().toString().equals("") || valueEt.getText().toString() == null){
                Toast.makeText(getContext(), "Please enter transaction value", Toast.LENGTH_LONG).show();
            }else if (descriptionEt.getText().toString().equals("") || descriptionEt.getText().toString() == null){
                Toast.makeText(getContext(), "Please enter transaction description", Toast.LENGTH_LONG).show();
            }else if (!valueEt.getText().toString().matches("[0-9]+")) {
                Toast.makeText(getContext(), "Value can only contains numbers", Toast.LENGTH_LONG).show();

            }else{
                    t.setType(dropdown.getSelectedItem().toString());
                    t.setTitle(titleEt.getText().toString());
                    t.setDescription(titleEt.getText().toString());
                    t.setValue(Integer.parseInt(valueEt.getText().toString()));
                    transactionsViewModel.addTransaction(t);
                    titleEt.setText("");
                    valueEt.setText("");
                    descriptionEt.setText("");
                    t = new Transaction();
                    Toast.makeText(getContext(), "Successful insert!", Toast.LENGTH_LONG).show();
            }

        });


    }



}
