package com.example.fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ImageSelectionCallback{
    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.img01, R.drawable.img02, R.drawable.img03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);

    }

    // MainActivity가 인터페이스를 준수하기 때문에, 이미지를 바꿀 때 getActivity 대신 interface타입 사용 가능
    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(images[position]);
    }
}