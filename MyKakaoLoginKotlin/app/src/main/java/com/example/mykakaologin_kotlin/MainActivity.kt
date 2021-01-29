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
                Log.e(TAG, "Kakao Login Failed :", error)
            } else if (token != null) { //Login Success
                Log.d(TAG, "Kakao Login Success")
                startHomeActivity()
            }
        }
        findViewById<ImageView>(R.id.btn_kakao_login).setOnClickListener {
            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니라면 카카오계정으로 로그인
            LoginClient.instance.run {
                if (isKakaoTalkLoginAvailable(this@MainActivity)) {
                    loginWithKakaoTalk(this@MainActivity, callback = callback)
                } else {
                    loginWithKakaoAccount(this@MainActivity, callback = callback)
                }
            }
        }
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}