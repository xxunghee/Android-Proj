package com.example.fragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    ImageSelectionCallback callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof ImageSelectionCallback) { // 액티비티 자체를 찾는 게 아니라 구현된 콜백을 찾음
            callback = (ImageSelectionCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        Button btn1 = rootView.findViewById(R.id.show1_btn);
        Button btn2 = rootView.findViewById(R.id.show2_btn);
        Button btn3 = rootView.findViewById(R.id.show3_btn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity activity = (MainActivity) getActivity();
                // activity.onImageSelected(0);
                // MainActivity가 아닌 다른 액티비티의 경우, 형 변환 필요
                // MainActivity가 인터페이스를 준수하기 때문에, 이미지를 바꿀 때 getActivity 대신 interface타입 사용 가능
                if(callback != null)
                    callback.onImageSelected(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null)
                    callback.onImageSelected(1);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null)
                    callback.onImageSelected(2);
            }
        });


        return rootView;
    }

}
