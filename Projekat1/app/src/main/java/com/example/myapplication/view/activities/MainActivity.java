package com.example.myapplication.view.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.view.viewpager.MainActivityPageAdapter;
import com.example.myapplication.viewModel.TransactionsViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    TransactionsViewModel transactionsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transactionsViewModel = new ViewModelProvider(this).get(TransactionsViewModel.class);
        init();
    }

    public void init(){
        initViewPager();
        initNavigation();
    }

    private void initViewPager(){
        viewPager = findViewById(R.id.ViewPager);
        viewPager.setAdapter(new MainActivityPageAdapter(getSupportFragmentManager()));
    }

    private void initNavigation() {
        ((BottomNavigationView)findViewById(R.id.main_BottomNavigation)).setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.state_mi: viewPager.setCurrentItem(MainActivityPageAdapter.FRAGMENT_1, false); break;
                case R.id.input_mi: viewPager.setCurrentItem(MainActivityPageAdapter.FRAGMENT_2, false); break;
                case R.id.list_mi: viewPager.setCurrentItem(MainActivityPageAdapter.FRAGMENT_3, false); break;
                case R.id.profile_mi: viewPager.setCurrentItem(MainActivityPageAdapter.FRAGMENT_4, false); break;
            }
            return true;
        });
    }
}
