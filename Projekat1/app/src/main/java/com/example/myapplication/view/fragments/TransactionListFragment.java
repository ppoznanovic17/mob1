package com.example.myapplication.view.fragments;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.view.viewpager.ListPagerAdapter;
import com.example.myapplication.view.viewpager.MainActivityPageAdapter;
import com.example.myapplication.viewModel.TransactionsViewModel;
import com.google.android.material.tabs.TabLayout;

public class TransactionListFragment   extends Fragment {


    TransactionsViewModel transactionsViewModel;
    ViewPager viewPager;
    TabLayout tabLayout;

    public TransactionListFragment() {
        super(R.layout.fragment_lists);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println(getActivity().getComponentName());

        transactionsViewModel = new ViewModelProvider(getActivity()).get(TransactionsViewModel.class);

        viewPager = (ViewPager) getActivity().findViewById(R.id.lists_ViewPager);
        viewPager.setAdapter(new ListPagerAdapter(this.getChildFragmentManager()));
        tabLayout = view.findViewById(R.id.lists_TabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }




}
