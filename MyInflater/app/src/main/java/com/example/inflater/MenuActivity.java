package com.example.inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        container = findViewById(R.id.container);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLayout();
            }
        });
    }
    // container에 새로운 레이아웃(sub1) 추가가
    public void addLayout() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub1, container, true);

        Toast.makeText(this, "부분 화면이 추가되었습니다", Toast.LENGTH_LONG).show();
    }
}