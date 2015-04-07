package com.oakraw.myweather;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.oakraw.myweather.adapter.CityAdapter;
import com.oakraw.myweather.model.CityInfo;
import com.oakraw.myweather.util.Network;

import java.util.ArrayList;


public class SelectCityActivity extends Activity {

    private ImageButton searchBtn;
    private EditText searchBox;
    private ListView listView;
    private final String url = "http://oakraw.com/work/weather_api/city_search.php?city=";
    private ArrayList<String> cityList = new ArrayList<>();
    private CityAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        searchBox = (EditText)findViewById(R.id.search_box);
        searchBtn = (ImageButton)findViewById(R.id.search_btn);
        listView = (ListView) findViewById(R.id.listView);
        mAdapter = new CityAdapter(this, cityList);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), cityList.get(position), Toast.LENGTH_SHORT).show();

            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = searchBox.getText().toString();
                sendRequest(key);
            }
        });
    }

    private void sendRequest(String key){
        String completeUrl = url + key;
        Network network = new Network();
        network.setOnPostExecuteListener(new Network.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {
                Log.d("oakTag", "from activity "+result);
                Gson gson = new Gson();
                CityInfo[] cityResult = gson.fromJson(result, CityInfo[].class);
                cityList.clear();
                for (int i = 0; i < cityResult.length; i++) {
                    cityList.add(cityResult[i].city + " ," + cityResult[i].coutry_code);
                }
                mAdapter.notifyDataSetChanged();

            }
        });
        network.execute(completeUrl);
    }

}
