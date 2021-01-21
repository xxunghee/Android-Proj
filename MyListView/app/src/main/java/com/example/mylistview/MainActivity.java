package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.mylistview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //--- 데이터 바인딩
    ActivityMainBinding binding;

    //--- 사용자 정의 자료형 Niniz(String name, ing ImgID)
    ArrayList<Niniz> ninizs;

    //--- Custom Adapter
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //--- 데이터 입력
        ninizs = new ArrayList<>();
        ninizs.add(new Niniz("스카피", R.drawable.scappy));
        ninizs.add(new Niniz("죠르디", R.drawable.jordy));
        ninizs.add(new Niniz("앙몬드", R.drawable.angmond));
        ninizs.add(new Niniz("케로 & 베로니", R.drawable.keroandberony));
        ninizs.add(new Niniz("콥", R.drawable.cob));
        ninizs.add(new Niniz("팬다 주니어", R.drawable.penda));
        ninizs.add(new Niniz("빠냐", R.drawable.bbanya));

        //--- Adapter 설정
        adapter = new ListViewAdapter(ninizs);
        binding.list.setAdapter(adapter);

        //--- ListView의 캐릭터 클릭 시 상단에 선택된 캐릭터의 이미지와 이름 나타냄
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                binding.clickedImg.setImageResource(((Niniz)parent.getItemAtPosition(position)).getImg());
                binding.clickedTv.setText(((Niniz) parent.getItemAtPosition(position)).getName());
            }
        });
    }
}