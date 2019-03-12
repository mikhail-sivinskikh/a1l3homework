package com.sivinskikh.a1l3homework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView weatherView;
    private EditText cityName;
    private Button changeScreenBtn;
    static final String userCityKey = "CITY";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherView = findViewById(R.id.testview);
        cityName = findViewById(R.id.cityName);
        changeScreenBtn = findViewById(R.id.toSecondActivityBtn);
        setChangeScreenBtnBehaviour();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(userCityKey, cityName.getText().toString());
        super.onSaveInstanceState(outState);
    }

    private void setChangeScreenBtnBehaviour() {
        changeScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(userCityKey, cityName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
