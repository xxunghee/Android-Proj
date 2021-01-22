package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    final int DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //--- Handler 할당
        handler = new Handler();

        //--- 1초 delay
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                //--- IntroActivity로 전환
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //--- Handler 해제
        handler.removeCallbacksAndMessages(null);
    }
}