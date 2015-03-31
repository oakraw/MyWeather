package com.oakraw.myweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.oakraw.myweather.adapter.MyPagerAdapter;
import com.oakraw.myweather.custom.ParallaxPageTransformer;


public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private int CITY_CODE = 22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer()
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.bg, 2, 2))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.foreground, -0.65f,
                        ParallaxPageTransformer.ParallaxTransformInformation.PARALLAX_EFFECT_DEFAULT));

        pager.setPageTransformer(true, pageTransformer);

        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SelectCityActivity.class);
                startActivityForResult(intent,CITY_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CITY_CODE){
            if(resultCode == RESULT_OK){

            }
        }
    }
}
