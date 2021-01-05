package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.view.*;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 클릭 시 Main -> Menu 전환
                // Context는 버튼이면 버튼이 포함되어 있는 주변 정보를 갖고 있음(레이아웃, 환경 등)
                // 안드로이드에서 UI 객체는 생성시 Context 넘겨받도록 되어 있음.
                // OnCreate 함수 안에서는 this가 Activity 객체가 되므로 버튼 등의 Context이다.

                // MenuActivity에 대한 참조를 가능하게 함.
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MENU); // 어떤 화면으로부터 응답을 받은 건지 구분 가능한 코드
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU) { // MenuActivity에서 보내는 코드
            Toast.makeText(getApplicationContext(), "OnActivityResult 호출\n 요청 코드: " + requestCode
                    + "\n결과 코드:" + resultCode, Toast.LENGTH_LONG).show();
            if(data != null) {
                String name = data.getStringExtra("name");
                if(name != null) {
                    Toast.makeText(this, "응답으로 받은 데이터: " + name, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}