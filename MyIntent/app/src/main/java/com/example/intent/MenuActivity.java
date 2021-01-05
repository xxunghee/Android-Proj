package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.view.*;
import android.content.*;

import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "Mike"); // intent를 통해서 다른 Activity로 데이터 전달

                setResult(RESULT_OK, intent); // 정상응답
                finish(); // 이전 화면으로 돌아가기
            }
        });
    }
}