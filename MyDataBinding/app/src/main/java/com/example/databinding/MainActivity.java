package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    int num;
    String str;

    //---- Binding 객체 생성
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //---- layout 설정
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //---- 클릭 이벤트 설정(클릭 시 textView 숫자 ++)
        binding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Integer.parseInt((String)binding.textView.getText());
                str = Integer.toString(num+1);
                binding.textView.setText(str);
            }
        });
    }
}