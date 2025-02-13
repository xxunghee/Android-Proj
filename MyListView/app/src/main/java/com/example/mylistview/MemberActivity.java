package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.mylistview.databinding.ActivityMemberBinding;

public class MemberActivity extends AppCompatActivity {
    ActivityMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_member);

        Intent intent = getIntent();

        binding.layout.setBackgroundColor(ResourcesCompat.getColor(getResources(),intent.getIntExtra("color", -1),null));
        binding.img.setImageResource(intent.getExtras().getInt("imgID"));
        binding.name.setText(intent.getExtras().getString("name"));
        binding.comment.setText(intent.getExtras().getString("comment"));

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        binding.img.setAnimation(animation);

        binding.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.img.startAnimation(animation);
            }
        });
    }


    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}