package com.example.myapplication.view.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.viewModel.TransactionsViewModel;

public class StateFragment extends Fragment {

    private TransactionsViewModel transactionsViewModel;

    public StateFragment() {
        super(R.layout.fragment_state);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println(getActivity().getComponentName());

        transactionsViewModel = new ViewModelProvider(getActivity()).get(TransactionsViewModel.class);
        init();
    }

    public void init(){
        initObservers();
    }

    public void initObservers(){
        TextView differenceTv = getView().findViewById(R.id.razlikaTv);
        TextView incomeTv = getView().findViewById(R.id.prihodTv);
        TextView expenseTv = getView().findViewById(R.id.rashodTV);

        transactionsViewModel.getIncome().observe(getViewLifecycleOwner(), (income) -> {
            incomeTv.setText(income.toString());
            differenceTv.setText(transactionsViewModel.getDifference().getValue().toString());
            if(transactionsViewModel.getDifference().getValue() > 0){
                differenceTv.setTextColor(Color.rgb(68, 204, 68));
            }else{
                differenceTv.setTextColor(Color.rgb(204, 68, 68));
            }

        });


        transactionsViewModel.getExpense().observe(getViewLifecycleOwner(), (income) -> {
            expenseTv.setText(income.toString());
            differenceTv.setText(transactionsViewModel.getDifference().getValue().toString());
            if(transactionsViewModel.getDifference().getValue() > 0){
                differenceTv.setTextColor(Color.rgb(68, 204, 68));
            }else{
                differenceTv.setTextColor(Color.rgb(204, 68, 68));
            }
        });


    }
}
