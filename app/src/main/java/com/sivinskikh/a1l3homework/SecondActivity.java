package com.sivinskikh.a1l3homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView cityname;
    private TextView conditions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        cityname = findViewById(R.id.cityView);
        conditions = findViewById(R.id.conditionsView);
        String userCityInput = getIntent().getStringExtra(MainActivity.userCityKey);
        cityname.setText("Weather information in " + userCityInput + ": ");
        weatherForecast(userCityInput);
    }

    private void weatherForecast(String location) {
        String locationInfo = location.toLowerCase().trim();
        switch (locationInfo) {
            case "moscow":
                conditions.setText(R.string.MoscowWeather);
                break;
            case "kiev":
                conditions.setText(R.string.KievWeather);
                break;
            case "riga":
                conditions.setText(R.string.RigaWeather);
                break;
            default:
                conditions.setText(R.string.LocationNotFound);
        }
    }
}
