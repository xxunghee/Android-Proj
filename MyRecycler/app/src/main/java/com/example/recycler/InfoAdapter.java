package com.example.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler.databinding.ItemInfoBinding;

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
        ItemInfoBinding binding;

        ViewHolder(ItemInfoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        //++++ 데이터 넣는 함수 분리하여 구현
        public void bind(Info info) {
            binding.tvName.setText(info.getName());
            binding.tvAge.setText(info.getAge());
        }
    }

    //---- ViewHolder 생성
    @NonNull
    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //---- 인플레이션
        ItemInfoBinding binding = ItemInfoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    //++++ 데이터를 bind()에 전달
    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.ViewHolder holder, int position) {
        Info info = data.get(position);
        holder.bind(info);
    }

    //---- 전체 데이터 수 리턴
    @Override
    public int getItemCount() {
        return data.size();
    }
}
