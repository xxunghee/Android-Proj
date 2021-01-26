package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
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
    ArrayList<String> comments;

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
        ninizs.add(new Niniz("팬다 주니어", R.drawable.pendajr));
        ninizs.add(new Niniz("빠냐", R.drawable.bbanya));

        comments = new ArrayList<>();
        comments.add("스카피는");
        comments.add("죠르디는");
        comments.add("앙몬드는");
        comments.add("케로와 베로니는");
        comments.add("콥은");
        comments.add("팬다 주니어는");
        comments.add("빠냐는");

        //--- Adapter 설정
        adapter = new ListViewAdapter(ninizs);
        binding.list.setAdapter(adapter);

        //--- ListView의 캐릭터 클릭 시 캐릭터 정보 창으로 이동
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MemberActivity.class);
                putExtra(intent, position);
            }
        });
    }

    public void putExtra(Intent intent, int position) {
        if(position == 0) {
            intent.putExtra("color", R.color.scappy);
            intent.putExtra("imgID", R.drawable.profile_scappy);
            intent.putExtra("name", ninizs.get(position).getName());
            intent.putExtra("comment", comments.get(position));
        }
        else if(position == 1) {
            intent.putExtra("color", R.color.jordy);
            intent.putExtra("imgID", R.drawable.profile_jordy);
            intent.putExtra("name", ninizs.get(position).getName());
            intent.putExtra("comment", comments.get(position));
        }
        else if(position == 2) {
            intent.putExtra("color", R.color.angmond);
            intent.putExtra("imgID", R.drawable.profile_angmond);
            intent.putExtra("name", ninizs.get(position).getName());
            intent.putExtra("comment", comments.get(position));
        }
        else if(position == 3) {
            intent.putExtra("color", R.color.keroandberony);
            intent.putExtra("imgID", R.drawable.profile_keroandberony);
            intent.putExtra("name", ninizs.get(position).getName());
            intent.putExtra("comment", comments.get(position));
        }
        else if(position == 4) {
            intent.putExtra("color", R.color.cob);
            intent.putExtra("imgID", R.drawable.profile_cob);
            intent.putExtra("name", ninizs.get(position).getName());
            intent.putExtra("comment", comments.get(position));
        }
        else if(position == 5) {
            intent.putExtra("color", R.color.pendajr);
            intent.putExtra("imgID", R.drawable.profile_pendajr);
            intent.putExtra("name", ninizs.get(position).getName());
            intent.putExtra("comment", comments.get(position));
        }
        else {
            intent.putExtra("color", R.color.bbanya);
            intent.putExtra("imgID", R.drawable.profile_bbanya);
            intent.putExtra("name", ninizs.get(position).getName());
            intent.putExtra("comment", comments.get(position));
        }
        startActivity(intent);
    }
}