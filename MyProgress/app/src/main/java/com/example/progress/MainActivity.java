package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.lang.*;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        Button button = findViewById(R.id.button);
        button.setOnClickListener((new View.OnClickListener() {
            int val;
            @Override
            public void onClick(View v) {
                val = progressBar.getProgress();
                val += 10;
                if(val > 100) {
                    val = 0;
                }
                progressBar.setProgress(val);
                if(textView != null)
                    textView.setText(val);
            }
        }));
    }
}