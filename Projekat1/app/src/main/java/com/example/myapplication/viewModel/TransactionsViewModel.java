package com.example.myapplication.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class TransactionsViewModel extends ViewModel {


    private final MutableLiveData<List<Transaction>> incomeTransactions = new MutableLiveData();
    private final MutableLiveData<List<Transaction>> expenseTransactions = new MutableLiveData();
    private List<Transaction> listOfIncome = new ArrayList();
    private List<Transaction> listOfExpense = new ArrayList();

    private final MutableLiveData<Integer> incomeLD = new MutableLiveData();
    private final MutableLiveData<Integer> expenseLD = new MutableLiveData();
    private final MutableLiveData<Integer> differenceLD = new MutableLiveData();

    public TransactionsViewModel(){
        for(int i=1; i<6; i++){
            if( i % 2 == 0) {
                Transaction t = new Transaction("Prihod", i * 100, "Naslov" + i, "Description" + i);
                listOfIncome.add(t);
            }else{
                Transaction t = new Transaction("Rashod", i * 100, "Naslov" + i, "Description" + i);
                listOfExpense.add(t);
            }

        }
        incomeTransactions.setValue(listOfIncome);
        expenseTransactions.setValue(listOfExpense);
    }

    public LiveData<Integer> getDifference(){
        Integer difference = 0;
        for(Transaction t: listOfIncome){
            difference += t.getValue();
        }

        for(Transaction t: listOfExpense){
            difference -= t.getValue();
        }
        differenceLD.setValue(difference);
        return differenceLD;
    }

    public LiveData<Integer> getIncome(){
        Integer income = 0;
        for(Transaction t: listOfIncome){
            income += t.getValue();
        }

        incomeLD.setValue(income);
        return incomeLD;
    }

    public LiveData<Integer> getExpense(){
        Integer expense = 0;
        for(Transaction t: listOfExpense){
            expense -= t.getValue();
        }
        expenseLD.setValue(expense);
        return expenseLD;
    }

    public LiveData<List<Transaction>> getIncomeTransactions(){
        List<Transaction> transactionList = new ArrayList<>();
        for(Transaction t: listOfIncome){
            transactionList.add(t);
        }

        System.out.println("PRIHOOOOD-----------------------------------------------------------------------------------------------");

        incomeTransactions.setValue(transactionList);
        return incomeTransactions;
    }

    public LiveData<List<Transaction>> getExpenseTransactions(){
        List<Transaction> transactionList = new ArrayList<>();
        for(Transaction t: listOfExpense){
            transactionList.add(t);
        }
        System.out.println("RASHOOOOD-----------------------------------------------------------------------------------------------");

        expenseTransactions.setValue(transactionList);
        return expenseTransactions;
    }

    public void addTransaction(Transaction t){
        if(t.getType().equals("Prihod")){
            listOfIncome.add(t);
            incomeTransactions.setValue(listOfIncome);
        }else if(t.getType().equals("Rashod")){
            listOfExpense.add(t);
            expenseTransactions.setValue(listOfExpense);
        }
    }

    public void removeTransaction(Transaction t){
        if(t.getType().equals("Prihod")){
            listOfIncome.remove(t);
            incomeTransactions.setValue(listOfIncome);
        }else if(t.getType().equals("Rashod")){
            listOfExpense.remove(t);
            expenseTransactions.setValue(listOfExpense);
        }
    }




}
