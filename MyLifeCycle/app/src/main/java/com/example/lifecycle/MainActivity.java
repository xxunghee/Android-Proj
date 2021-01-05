package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Log.d("Main", "OnCreate 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Main", "OnStart 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveState(); // 앱이 전화 등의 이유로 일시정지 되었을 때, 상태 저장

        Log.d("Main", "onPause 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Main", "onStop 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadState(); // 앱이 재실행 될 때 저장된 상태 복원

        Log.d("Main", "OnResume 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Main", "OnDestroy 호출");
    }

    public void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", editText.getText().toString());
        editor.commit();
    }

    public void loadState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref != null) {
            String name = pref.getString("name", "");
            editText.setText(name);
        }
    }
}