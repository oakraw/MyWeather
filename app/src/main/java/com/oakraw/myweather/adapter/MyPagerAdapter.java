package com.oakraw.myweather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.oakraw.myweather.R;
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
        switch(position){
            case 0:
                return WeatherFragment.newInstance("Bangkok", R.drawable.bangkok);
            case 1:
                return WeatherFragment.newInstance("London", R.drawable.london);
            default:
                return WeatherFragment.newInstance("Paris", R.drawable.paris);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
