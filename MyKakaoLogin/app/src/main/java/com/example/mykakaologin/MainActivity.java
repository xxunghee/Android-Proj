package com.example.mykakaologin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kakao.sdk.common.KakaoSdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 카카오 SDK 초기화
        KakaoSdk.init(this, "{NATIVE_APP_KEY}");
    }
}