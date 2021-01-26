package com.example.mykakaologin;

import androidx.appcompat.app.AppCompatActivity;
import com.kakao.sdk.common.util.Utility;

import android.os.Bundle;
import android.util.Log;

import com.kakao.sdk.common.KakaoSdk;

public class MainActivity extends AppCompatActivity {
    final String NATIVE_APP_KEY = "1251c57fc0dfd79671115a05f3749210";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 카카오 SDK 초기화
        KakaoSdk.init(this, NATIVE_APP_KEY);

        Log.d("TAG", Utility.INSTANCE.getKeyHash(this));
    }
}