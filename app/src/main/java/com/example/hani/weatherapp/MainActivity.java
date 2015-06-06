package com.example.hani.weatherapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {


    protected LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showWeather();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void showWeather()
    {
        String urlString;
        String Data;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        //urlString = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=35&lon=139&cnt=10&mode=json";
        urlString = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+location.getLatitude()+"&lon="+location.getLongitude()+"&cnt=10&mode=json";



        try {

            URL url = new URL(urlString);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //is = new BufferedInputStream(urlConnection.getInputStream());
            InputStream is = urlConnection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String responseString;
            StringBuilder sb = new StringBuilder();

            while ((responseString = reader.readLine()) != null) {
                sb = sb.append(responseString);
            }

            Data = sb.toString();


        } catch (Exception e ) {

            System.out.println(e.getMessage());

        }
    }
}
