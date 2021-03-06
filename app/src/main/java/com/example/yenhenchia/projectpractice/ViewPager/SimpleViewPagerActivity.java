package com.example.yenhenchia.projectpractice.ViewPager;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.yenhenchia.projectpractice.R;

public class SimpleViewPagerActivity extends AppCompatActivity {

    private BaseViewPager baseViewPager;
    private SimplePageAdapter simplePageAdapter;
    private  SimpleStatePageAdapter simpleStatePageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_view_pager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.baseToolBar);
        toolbar.setTitle("Android Project");
        toolbar.setSubtitle("Android Sub Project");

        setSupportActionBar(toolbar);

        this.baseViewPager = (BaseViewPager)findViewById(R.id.BaseViewPager);

        FragmentManager fragmentManager = getSupportFragmentManager();

        this.simplePageAdapter = new SimplePageAdapter(fragmentManager);
        this.simpleStatePageAdapter = new SimpleStatePageAdapter(fragmentManager);

        this.baseViewPager.setAdapter(simpleStatePageAdapter);
    }
}
