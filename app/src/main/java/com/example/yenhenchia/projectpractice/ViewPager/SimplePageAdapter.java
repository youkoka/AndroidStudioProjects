package com.example.yenhenchia.projectpractice.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by yenhenchia on 2017/4/6.
 */

public class SimplePageAdapter extends FragmentPagerAdapter {

    public SimplePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        SimpleViewFragment simpleViewFragment = new SimpleViewFragment();

        return simpleViewFragment;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
