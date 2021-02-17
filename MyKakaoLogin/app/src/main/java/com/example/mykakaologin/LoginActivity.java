package com.example.mykakaologin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;
import com.kakao.sdk.user.model.Profile;
import com.kakao.sdk.user.model.User;

import org.jetbrains.annotations.Nullable;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    final String TAG = "LoginActivity";

    private String userName;
    private Long userId;

    final Function2 callback = (Function2)(new Function2() {
        // $FF: synthetic method
        // $FF: bridge method
        public Object invoke(Object var1, Object var2) {
            this.invoke((OAuthToken)var1, (Throwable)var2);
            return Unit.INSTANCE;
        }

        public final void invoke(@Nullable OAuthToken token, @Nullable Throwable error) {
            if (error != null) {
                Log.e(TAG, "Kakao Login Failed :", error);
            } else if (token != null) {
                Log.d(TAG, "Kakao Login Success");
                // 로그인 성공 시 사용자 정보 가져오기
                getUserInfo();
            }
        }
    });

    // 사용자 정보 가져오기
    public void getUserInfo() {
        UserApiClient.getInstance().me(new Function2() {
            // $FF: synthetic method
            // $FF: bridge method
            public Object invoke(Object var1, Object var2) {
                this.invoke((User)var1, (Throwable)var2);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable User user, @Nullable Throwable error) {
                if (error != null) {
                    Log.e(TAG, "사용자 정보 요청 실패", error);
                } else if (user != null) {
                    Log.d(TAG, "사용자 정보 요청 성공");
                    userId = user.getId();
                    Account userKakaoAccount = user.getKakaoAccount();
                    if (userKakaoAccount != null) {
                        Profile userProfile = userKakaoAccount.getProfile();
                        if (userProfile != null) {
                            userName = userProfile.getNickname();
                            startMainActivity();
                        }
                    }
                    else
                        userName = null;
                    Log.d(TAG, userName + " / " + userId);
                }
            }
        });
    }

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