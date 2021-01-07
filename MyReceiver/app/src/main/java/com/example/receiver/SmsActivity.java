package com.example.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SmsActivity extends AppCompatActivity {
    TextView txv2;
    TextView txv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        txv2 = findViewById(R.id.textView2); // 발신번호
        txv3 = findViewById(R.id.textView3); // 문자 내용

        // 액티비티가 새로 만들어진 경우에는 Intent 객체 생성해야 함.
        Intent intent = getIntent();
        processIntent(intent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processIntent(intent);
    }

    public void processIntent(Intent intent) {
        String sender = "문자 없음";
        String content = "";
        if(intent!=null) {
            sender = intent.getStringExtra("sender");
            content = intent.getStringExtra("contents");
        }

        txv2.setText(sender);
        txv3.setText(content);
    }
}