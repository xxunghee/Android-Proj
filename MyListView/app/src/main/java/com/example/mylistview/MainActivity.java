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
        comments.add("스노우타운 최고 인기 셰프, 스카피\n귀여운 외모와 달리 북극곰 시절\n영광의 상처(X)를 간직한 듬직한 토끼이다.");
        comments.add("떠내려 온 빙하에서 깨어난 공룡, 죠르디\n빛나는 과거를 뒤로한 채\n지금은 취업을 꿈꾸며 하루하루 열심히 산다.");
        comments.add("초콜릿 잼을 달고 사는 하프물범, 앙몬드\n매사에 느긋하지만 초콜릿 앞에서는\n빛보다 빠르게 움직인다.");
        comments.add("장난꾸러기 쌍둥이 펭귄 남매 케로베로니\n가끔 투닥거려도 항상 붙어다니며\n따뜻한 불 옆에 있는 것을 좋아한다.");
        comments.add("빠냐의 탐정 콤비, 콥\n호기심이 많아 소소한 사건에도 관심을 갖고\n자칭 스노우타운 탐정으로 활동한다.");
        comments.add("스노우 타운에 불시착한 외계인, 팬다\n흥이 많고 어디서나 주목 받고 싶어\n파티라면 빠지지 않는다.");
        comments.add("콥의 탐정 콤비, 빠냐\n호기심이 많아 소소한 사건에도 관심을 갖고\n자칭 스노우타운 탐정으로 활동한다.");

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