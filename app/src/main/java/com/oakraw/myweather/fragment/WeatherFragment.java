package com.oakraw.myweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oakraw.myweather.R;

/**
 * Created by Rawipol on 2/19/15 AD.
 */
public class WeatherFragment extends Fragment {

    private static final String CITY_NAME = "NAME";
    private static final String IMG_BG = "IMAGE_BG";

    public static WeatherFragment newInstance(String name, int res){
        WeatherFragment fragment = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CITY_NAME, name);
        bundle.putInt(IMG_BG, res);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        ImageView bg = (ImageView) rootView.findViewById(R.id.bg);
        bg.setImageResource(getArguments().getInt(IMG_BG));

        TextView cityName = (TextView) rootView.findViewById(R.id.city_name);
        cityName.setText(getArguments().getString(CITY_NAME));
        return rootView;
    }
}
