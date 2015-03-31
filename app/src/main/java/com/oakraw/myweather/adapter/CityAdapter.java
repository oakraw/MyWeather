package com.oakraw.myweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Rawipol on 3/30/15 AD.
 */
public class CityAdapter extends BaseAdapter {

    ArrayList<String> cities;
    Context mContext;

    public CityAdapter(Context mContext, ArrayList<String> cities) {
        this.cities = cities;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater.inflate()
        return null;
    }
}
