package com.example.mybackbuttoncontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private BackPressHandler backPressHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backPressHandler = new BackPressHandler(this);
    }

    @Override
    public void onBackPressed() {
        backPressHandler.onBackPressed();
    }
}