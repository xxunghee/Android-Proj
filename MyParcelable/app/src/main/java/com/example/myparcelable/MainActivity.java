package com.example.myparcelable;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import android.content.*;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                SimpleData data = new SimpleData(200, "OK");
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }
}