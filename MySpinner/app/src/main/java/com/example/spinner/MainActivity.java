package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.spinner.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //--- dataBinding
    ActivityMainBinding binding;

    //--- 과자 목록
    ArrayList<String> snackList = new ArrayList<>(Arrays.asList(
            new String[] {"선택하기", "바나나킥", "배배", "눈을감자", "고래밥", "꼬북칩"}));

    //--- Adapter
    ArrayAdapter<String> arrayAdapter;

    //--- 과자 이미지
    ArrayList<Integer> Imgs = new ArrayList<>(Arrays.asList(
            new Integer[] {0, R.drawable.bananakick, R.drawable.baebae, R.drawable.nungam, R.drawable.goraebap, R.drawable.kkobuk}));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //--- Adapter 설정, snackList 인자로 전달
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, snackList);
        binding.spinner.setAdapter(arrayAdapter);

        //--- Spinner에서 Item 선택 시
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setView(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    private void setView(int position) {
        binding.snackImg.setImageResource(Imgs.get(position));
        binding.snackName.setText(snackList.get(position) + " 선택!!");
    }
}