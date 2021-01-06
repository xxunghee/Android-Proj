package com.example.mylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.*;
import android.view.*;
import android.content.*;

import android.os.Bundle;

public class SubActivity extends AppCompatActivity {
    private static final String TAG = "SubActivity";
    Log log; // logcat에 생명 주기 나타내기 위함.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        log.d(TAG, "onCreate"); // Logcat에 현재 생명 주기의 호출 함수명 출력


        Intent intent = getIntent();
        TextView personInfo = findViewById(R.id.person);
        Info p = (Info)getIntent().getSerializableExtra("person");
        personInfo.setText("이름: "+p.getName()+" | 나이: "+p.getAge());

        Button btn_m = findViewById(R.id.btn_toMain);
        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log.d(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log.d(TAG, "onDestroy");
    }
}