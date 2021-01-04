package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        GestureDetector detector;

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction(); // 어떤 상태에서 호출된 건지 구분(눌림, 움직임, 뗌)
                float curX = event.getX();
                float curY = event.getY();

                if(action == MotionEvent.ACTION_DOWN) { // 손가락이 눌린 상태
                    println("손가락 눌림: (" + curX + ", " + curY + ")");
                }

                else if(action == MotionEvent.ACTION_MOVE) { // 손가락이 움직인 상태
                    println("손가락 움직임: (" + curX + ", " + curY + ")");
                }
                else if(action == MotionEvent.ACTION_UP) { // 손가락이 떨어진 상태
                    println("손가락 뗌: (" + curX + ", " + curY + ")");
                }

                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) { // 눌렸을 때
                println("onDown 호출");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) { // 스크롤 된 거리
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) { // 길게 눌렀을 때
                println("onLongPress 호출");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) { // 속도 계산
                println("onFling 호출: " + velocityX + ", " + velocityY);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            println("시스템 [BACK] 버튼 눌렸어요.");
            return true;
        }
        return false;
    }

    public void println(String data) {
        textView.append(data + "\n");
    }

    public void print(String data) {
        textView.append(data);
    }
}