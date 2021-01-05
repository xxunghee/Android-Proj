package com.example.myparcelable;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.content.*;

import android.os.Bundle;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                processIntent(intent);

                finish();
            }
        });


    }

    public void processIntent(Intent intent) {
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");

            if(data != null) {
                Toast.makeText(getApplicationContext(),data.code + ", " + data.message, Toast.LENGTH_LONG).show();
            }
        }
    }
}