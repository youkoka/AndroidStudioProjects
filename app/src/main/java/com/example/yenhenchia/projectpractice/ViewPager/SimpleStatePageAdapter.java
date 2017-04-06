package com.example.yenhenchia.projectpractice.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by yenhenchia on 2017/4/6.
 */

public class SimpleStatePageAdapter extends FragmentStatePagerAdapter {

    public SimpleStatePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        SimpleViewFragment simpleViewFragment = SimpleViewFragment.newInstance(position);

        return simpleViewFragment;
    }

    @Override
    public int getCount() {

        return 6;
    }
}
