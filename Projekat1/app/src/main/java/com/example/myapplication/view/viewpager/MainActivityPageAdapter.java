package com.example.myapplication.view.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.view.fragments.AddTransactionFragment;
import com.example.myapplication.view.fragments.ProfileFragment;
import com.example.myapplication.view.fragments.StateFragment;
import com.example.myapplication.view.fragments.TransactionListFragment;

public class MainActivityPageAdapter extends FragmentPagerAdapter {


    private final int ITEM_COUNT = 4;
    public static final int FRAGMENT_1 = 0;
    public static final int FRAGMENT_2 = 1;
    public static final int FRAGMENT_3 = 2;
    public static final int FRAGMENT_4 = 3;


    public MainActivityPageAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case FRAGMENT_1: fragment = new StateFragment(); break;
            case FRAGMENT_2: fragment = new AddTransactionFragment(); break;
            case FRAGMENT_3: fragment = new TransactionListFragment(); break;
            default: fragment = new ProfileFragment(); break;
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
            case FRAGMENT_1: return "0";
            case FRAGMENT_2: return "1";
            case FRAGMENT_3: return "2";
            default: return "3";
        }
    }

}
