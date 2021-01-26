package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

import com.example.mylistview.databinding.ActivityMemberBinding;

public class MemberActivity extends AppCompatActivity {
    ActivityMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_member);

        Intent intent = getIntent();
        binding.layout.setBackgroundColor(intent.getIntExtra("color", -1));
        binding.img.setImageResource(intent.getExtras().getInt("imgID"));
        binding.name.setText(intent.getExtras().getString("name"));
        binding.comment.setText(intent.getExtras().getString("comment"));
    }


    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}