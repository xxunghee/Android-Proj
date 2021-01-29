package com.example.mykakaologin_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callback: ((OAuthToken?, Throwable?) -> Unit) = { token, error ->
            if (error != null) { //Login Fail
                Log.e("MainActivity", "Kakao Login Failed :", error)
            } else if (token != null) { //Login Success
                Log.d("MainActivity", "Kakao Login Success")
                startHomeActivity()
            }
        }

        // 로그인 버튼 클릭
        findViewById<ImageView>(R.id.btn_kakao_login).setOnClickListener {
            LoginClient.instance.run {
                // 기기에 카카오톡이 설치되어 있는 경우, 카카오톡으로 로그인
                if (isKakaoTalkLoginAvailable(this@MainActivity)) {
                    loginWithKakaoTalk(this@MainActivity, callback = callback)
                }
                // 기기에 카카오톡이 없는 경우, 카카오 계정으로 로그인
                else {
                    loginWithKakaoAccount(this@MainActivity, callback = callback)
                }
            }
        }
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}