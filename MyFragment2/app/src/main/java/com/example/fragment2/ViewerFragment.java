package com.example.fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {

    ImageView  imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        imageView = rootView.findViewById(R.id.imageView);
        return rootView;
    }

    // 이미지 바꾸기
    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}