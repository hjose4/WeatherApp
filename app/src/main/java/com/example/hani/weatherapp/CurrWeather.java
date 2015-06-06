package com.example.hani.weatherapp;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Hani on 6/6/2015.
 */
public class CurrWeather {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public ForecastTemp forecastTemp = new ForecastTemp();
    public long timestamp;

    public class ForecastTemp {
        public float day;
        public float min;
        public float max;
        public float night;
        public float eve;
        public float morning;
    }

    public String getStringDate() {
        return sdf.format(new Date(timestamp));
    }
}