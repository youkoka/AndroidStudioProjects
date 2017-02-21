package com.example.yenhenchia.projectpractice.ScrollableSwipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yenhenchia.projectpractice.R;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleMainFragment;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleResultFragment;

public class ScrollableSwipeActivity extends AppCompatActivity {

    private class SectionsPageAdapter extends FragmentPagerAdapter {

        public SectionsPageAdapter(FragmentManager fm) {

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

//            return super.getPageTitle(position);
        }
    }

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_swipe);

        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.viewpage_scrollable_swipe);
        viewPager.setAdapter(sectionsPageAdapter);
    }
}
