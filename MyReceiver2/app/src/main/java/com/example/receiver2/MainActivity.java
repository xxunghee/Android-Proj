package com.example.receiver2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int number = 0; // 전송한 메세지 수

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int receivedData = intent.getIntExtra("msg", 0);
            Toast.makeText(context, "Data: "+receivedData, Toast.LENGTH_LONG).show();

            if(intent.getAction().equals("BroadcastReceive")) {
                Toast.makeText(context, "Data: "+receivedData, Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // IntentFilter 설정
        IntentFilter filter = new IntentFilter();
        filter.addAction("BroadcastReceive");
        registerReceiver(broadcastReceiver, filter); // 리시버 연결

        // 버튼 클릭 시 메세지 전달
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("BroadcastReceive");
                intent.putExtra("msg", number);
                sendBroadcast(intent);
                number++;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver); // 리시버 연결 해제
    }
}