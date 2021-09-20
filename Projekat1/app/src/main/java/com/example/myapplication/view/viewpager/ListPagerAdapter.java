package com.example.myapplication.view.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.ListFragment;

import com.example.myapplication.view.fragments.AddTransactionFragment;
import com.example.myapplication.view.fragments.ExpenseTransactionsFragment;
import com.example.myapplication.view.fragments.IncomeTransactionsFragment;
import com.example.myapplication.view.fragments.ProfileFragment;
import com.example.myapplication.view.fragments.StateFragment;

public class ListPagerAdapter extends FragmentPagerAdapter {


    private final int ITEM_COUNT = 2;
    public static final int FRAGMENT_1 = 0;
    public static final int FRAGMENT_2 = 1;


    public ListPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case FRAGMENT_1: fragment = new IncomeTransactionsFragment(); break;
            default: FRAGMENT_2: fragment = new ExpenseTransactionsFragment(); break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case FRAGMENT_1: return "Prihod";
            default : return "Rashod";
        }
    }
}
