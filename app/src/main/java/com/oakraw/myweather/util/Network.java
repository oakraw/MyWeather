package com.oakraw.myweather.util;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Rawipol on 3/3/15 AD.
 */
public class Network extends AsyncTask<String, Void, String> {

    public interface OnPostExecuteListener{
        public void onPostExecute(String result);
    }

    OnPostExecuteListener onPostExecuteListener;

    public void setOnPostExecuteListener(OnPostExecuteListener onPostExecuteListener){
        this.onPostExecuteListener = onPostExecuteListener;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... url) {
        String result = "";

        try {
            HttpGet httpGet = new HttpGet(url[0]);
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == 200){
                InputStream inputStream = response.getEntity().getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d("oakTag",result);
        onPostExecuteListener.onPostExecute(result);
    }
}
