package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Info> list = new ArrayList<Info>();
        list.add(new Info("ABC", 1));
        list.add(new Info("DEF", 2));
        list.add(new Info("GHI", 3));
        list.add(new Info("JKL", 4));
        list.add(new Info("MNO", 5));
        list.add(new Info("PQR", 6));
        list.add(new Info("STU", 7));
        list.add(new Info("VWX", 8));
        list.add(new Info("YZ", 9));

        //---- RecyclerView에 LayoutManager 지정
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        /** LinearLayout의 방향(기본: vertical)을 horizontal로 변경할 때
         *  recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)) ;
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //---- RecyclerView에 Adapter 지정
        InfoAdapter adapter = new InfoAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}