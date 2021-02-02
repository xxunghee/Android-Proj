package com.example.mybackbuttoncontrol;

import android.app.Activity;
import android.widget.Toast;

public class BackPressHandler {
    private long backClickTime = 0;
    private Activity activity;

    public BackPressHandler(Activity activity) {
        this.activity = activity;
    }

    public void onBackPressed() {
        if(System.currentTimeMillis() > backClickTime + 2000) {
            backClickTime = System.currentTimeMillis();
            Toast.makeText(activity, "뒤로 가기 버튼을 한 번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(System.currentTimeMillis() <= backClickTime + 2000) {
            activity.finish();
        }
    }
}
