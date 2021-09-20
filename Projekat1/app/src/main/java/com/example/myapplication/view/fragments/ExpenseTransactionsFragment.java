package com.example.myapplication.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.view.activities.ShowTransactionActivity;
import com.example.myapplication.view.recycler.adapter.ExpenseTransactionAdapter;
import com.example.myapplication.view.recycler.diff.ExpenseDiffer;
import com.example.myapplication.viewModel.TransactionsViewModel;

public class ExpenseTransactionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private Context cntx;
    private TransactionsViewModel transactionsViewModel;
    private ExpenseTransactionAdapter transactionAdapter;

    public ExpenseTransactionsFragment(){
        super(R.layout.fragment_list_rashoda);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        transactionsViewModel = new ViewModelProvider(getParentFragment().getActivity()).get(TransactionsViewModel.class);
        cntx = view.getContext();
        init();
    }

    public void init(){
        initView();
        initObservers();
        initRecycler();
    }


    public void initView(){
        recyclerView = getActivity().findViewById(R.id.rashodiRV);
    }

    private void initObservers() {
        transactionsViewModel.getExpenseTransactions().observe(this, incomes -> {
            transactionAdapter.submitList(incomes);
        });
    }

    public void initRecycler(){
        transactionAdapter = new ExpenseTransactionAdapter(new ExpenseDiffer(), transaction -> {
            Intent i = new Intent(getParentFragment().getActivity(), ShowTransactionActivity.class);
            i.putExtra("title", transaction.getTitle());
            i.putExtra("value", transaction.getValue().toString());
            i.putExtra("description", transaction.getDescription());
            startActivity(i);
            return null;
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(transactionAdapter);
    }
}
