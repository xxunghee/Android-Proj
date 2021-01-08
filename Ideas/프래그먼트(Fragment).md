# 프래그먼트(Fragment)

- 특징

  - 사용자 인터페이스(UI)의 일부로 Activiry를 본 떠 만든 것
  - 부분 화면을 독립적으로 만들어 줌
  - 여러 개의 Fragment를 하나의 Activity에 결합하여 창이 여러 개인 UI를 빌드할 수 있음
  - 하나의 Fragment를 여러 개의 Activity에 재사용 가능
  - Activity 위에서 동작하기 때문에 Activity의 수명 주기에 직접적인 영향을 받음
    Activity가 실행 중인 동안은 개별적으로 조작 가능

- ㅇ

- 구현

  1. Fragment 생성

     (app/src/main/java/MainFragment) 

     ```java
     import androidx.fragment.app.Fragment;
     
     import android.view.LayoutInflater;
     import android.view.*;
     import android.widget.*;
     
     public class MainFragment extends Fragment {
     
         // xml 레이아웃에 있는 것을 인플레이션
         @Override
         public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
             Button button = rootView.findViewById(R.id.button);
             button.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     MainActivity activity = (MainActivity)getActivity();
                     activity.onFragmentChanged(1); // 클릭 시 함수 호출
                 }
             });
             return rootView;
         }
     }
     ```

     (app/src/main/res/layout/fragment_main.xml)

     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
         xmlns:app="http://schemas.android.com/apk/res-auto"
         xmlns:tools="http://schemas.android.com/tools"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:background="#FAE5D9"
         android:orientation="vertical"
         tools:context=".MainFragment">
     
         <TextView
             android:id="@+id/textView"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:text="Main Fragment"
             android:textSize="50sp" />
     
         <Button
             android:id="@+id/button"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:text="화면 전환"
             app:backgroundTint="#41C5B1" />
     </LinearLayout>
     ```

     

  2. Activity에 Fragment 추가(XML 사용)

     activity_main.xml의 `<Layout>`태그 안에 생성한 MainFragment 추가

     ```xml
     <fragment
             android:id="@+id/mainFragment"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
             android:name="com.example.fragment.MainFragment"  />
     ```

     

  3. Fragment 초기화

     MainActivity.java의 `onCreate()`에 Fragment 추가

     ```java
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
     
         mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
     }
     public void onFragmentChanged(int index) {
         if(index == 0) {
             getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
         }
         else if(index == 1) {
             getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
         }
     }
     ```

     