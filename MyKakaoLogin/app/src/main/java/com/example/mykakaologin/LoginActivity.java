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

    // 잘 모르겠음.. Kotlin -> Java 했는데.. 복붙함..
    final Function2 callback = (Function2)(new Function2() {
        // $FF: synthetic method
        // $FF: bridge method
        public Object invoke(Object var1, Object var2) {
            this.invoke((OAuthToken)var1, (Throwable)var2);
            return Unit.INSTANCE;
        }

        public final void invoke(@Nullable OAuthToken token, @Nullable Throwable error) {
            if (error != null) {
                Log.e("MainActivity", "Kakao Login Failed :", error);
            } else if (token != null) {
                Log.d("MainActivity", "Kakao Login Success");
                LoginActivity.this.startHomeActivity();
            }

        }
    });

    private void startHomeActivity(){
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
                if(LoginClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
                    LoginClient.getInstance().loginWithKakaoTalk(LoginActivity.this, callback);
                }
                else {
                    LoginClient.getInstance().loginWithKakaoAccount(LoginActivity.this, callback);
                }

            }
        });
    }
}