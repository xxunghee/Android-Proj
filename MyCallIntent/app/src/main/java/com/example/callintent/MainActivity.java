package com.example.callintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.view.*;
import android.widget.*;
import android.content.*;
import android.net.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-0000-0000"));
                startActivity(intent);
                 /*
                Intent intent = new Intent();
                ComponentName name = new ComponentName("org.techtown.callintent",
                        "org.techtown.callintent.MenuActivitty");
                intent.setComponent(name);
                startActivityForResult(intent, 101);
                */
            }
        });
    }
}