package com.example.yenhenchia.projectpractice.TabLayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yenhenchia.projectpractice.R;
import com.example.yenhenchia.projectpractice.ScrollableSwipe.MerryFragment;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleMainFragment;

public class TabLayoutActivity extends AppCompatActivity {

    private SectionPagerAdapter sectionPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager)findViewById(R.id.viewPaper);
        viewPager.setAdapter(sectionPagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {

                case 0: {

                    fragment = new MerryFragment();
                }
                    break;
                case 1: {

                    fragment = new SimpleMainFragment();
                }
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {

            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {

                case 0: {

                    return "婚姻建議";
                }
                case 1: {

                    return "猜拳遊戲";
                }
                default: {

                    return null;
                }
            }
        }
    }
}
