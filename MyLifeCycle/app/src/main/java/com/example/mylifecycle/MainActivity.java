package com.example.mylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.content.*;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Info person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeData();

        Button btn_s = findViewById(R.id.btn_toSub);
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 왜 여기서 Intent(this, SubActivity.class) 하면 안 될까!!! 왜ㅔ!!!!1!!
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("person", person);
                startActivity(intent);
            }
        });
    }

    public void InitializeData() {
        person = new Info();
        person.setName("Mike");
        person.setAge(13);
    }
}