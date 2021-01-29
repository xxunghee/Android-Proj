package com.example.mykakaologin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;

import org.jetbrains.annotations.Nullable;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    final Function2 callback = (Function2)(new Function2() {
        // $FF: synthetic method
        // $FF: bridge method
        public Object invoke(Object var1, Object var2) {
            this.invoke((OAuthToken)var1, (Throwable)var2);
            return Unit.INSTANCE;
        }

        public final void invoke(@Nullable OAuthToken token, @Nullable Throwable error) {
            if (error != null) {
                Log.e("LoginActivity", "Kakao Login Failed :", error);
            } else if (token != null) {
                Log.d("LoginActivity", "Kakao Login Success");
                LoginActivity.this.startMainActivity();
            }
        }
    });

    private void startMainActivity(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_kakao_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 기기에 카카오톡이 설치되어 있는 경우, 카카오톡으로 로그인
                if(LoginClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
                    LoginClient.getInstance().loginWithKakaoTalk(LoginActivity.this, callback);
                }
                // 기기에 카카오톡이 없는 경우, 카카오 계정으로 로그인
                else {
                    LoginClient.getInstance().loginWithKakaoAccount(LoginActivity.this, callback);
                }
            }
        });
    }
}