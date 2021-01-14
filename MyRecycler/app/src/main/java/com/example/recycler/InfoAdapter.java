package com.example.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    //---- 데이터가 저장될 배열
    private ArrayList<Info> data = null;

    //---- 초기화
    InfoAdapter(ArrayList<Info> list) {
        data = list;
    }

    //---- 아이템 뷰를 저장하고 화면에 보여주는 ViewHolder 클래스 생성
    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView;
        private TextView ageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.tv_name);
            ageView = (TextView) itemView.findViewById(R.id.tv_age);
        }
    }

    //---- ViewHolder 생성
    @NonNull
    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //---- 인플레이션,
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_info, parent, false);

        //---- 아이템 뷰를 위한 ViewHolder 객체 생성하여 리턴
        InfoAdapter.ViewHolder viewHolder = new InfoAdapter.ViewHolder(view);
        return viewHolder;
    }

    //---- 바인딩하여 데이터를 아이템 뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.ViewHolder holder, int position) {
        Info info = data.get(position);
        holder.nameView.setText(info.getName());
        holder.ageView.setText(info.getAge());
    }

    //---- 전체 데이터 수 리턴
    @Override
    public int getItemCount() {
        return data.size();
    }
}
