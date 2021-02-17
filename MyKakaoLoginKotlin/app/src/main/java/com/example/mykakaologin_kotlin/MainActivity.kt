package com.example.mykakaologin_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {

    var id:Long = 0
    var nickname:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callback: ((OAuthToken?, Throwable?) -> Unit) = { token, error ->
            if (error != null) { //Login Fail
                Log.e("MainActivity", "Kakao Login Failed :", error)
            } else if (token != null) { //Login Success
                Log.d("MainActivity", "Kakao Login Success")

                getUserInfo();

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

    private fun getUserInfo() {
        // 사용자 정보 받아오기
        UserApiClient.instance.me { user, error ->
            if(error != null) {
                Log.e("MainActivity", "사용자 정보 요청 실패", error)
            }
            else if(user != null) {
                id = user.id
                nickname = user.kakaoAccount?.profile?.nickname
            }
        }
    }

    private fun showInfo(id:Long, name:String?) {
        Log.d("아이디이름", id.toString() + " / " + name)
    }
}