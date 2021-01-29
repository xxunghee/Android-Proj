package com.example.mykakaologin_kotlin

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, getString(R.string.kakao_app_key))
        Log.d("KEYHASH", Utility.getKeyHash(this));
    }
}
