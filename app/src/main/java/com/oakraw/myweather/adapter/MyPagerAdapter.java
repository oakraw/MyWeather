package com.oakraw.myweather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.oakraw.myweather.fragment.WeatherFragment;

/**
 * Created by Rawipol on 2/19/15 AD.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new WeatherFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
