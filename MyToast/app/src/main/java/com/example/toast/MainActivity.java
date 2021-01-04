package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastView = Toast.makeText(getApplicationContext(), "토스트", Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.TOP|Gravity.LEFT, 30, 800); // Offset 조절하며 위치 조정
                toastView.show();
            }
        });
    }
}