package com.example.mykakaomsg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.mykakaomsg.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private final var TAG = "LoginActivity"
    private var context = this@LoginActivity

    // 로그인 공통 callback 구성
    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e(TAG, "로그인 실패", error)
        }
        else if (token != null) {
            Log.i(TAG, "로그인 성공 ${token.accessToken}")
            startMainActivity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(context, R.layout.activity_login)

        binding.imageButton.setOnClickListener {
            LoginClient.instance.run {
                // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
                if (LoginClient.instance.isKakaoTalkLoginAvailable(context)) {
                    LoginClient.instance.loginWithKakaoTalk(context, callback = callback)
                } else {
                    LoginClient.instance.loginWithKakaoAccount(context, callback = callback)
                }
            }
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(context, MainActivity::class.java))
    }
}