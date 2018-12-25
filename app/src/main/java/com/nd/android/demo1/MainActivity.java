package com.nd.android.demo1;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null){//隐藏标题栏
            getSupportActionBar().hide();
        }
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//无title
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);//全屏显示

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设置屏幕横屏
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置屏幕竖屏

        btn1=findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ImageDiaologFragment().show(getFragmentManager(),"custom");
                findViewById(R.id.ll_title).getBackground().setAlpha(127);//设置背景半透明
//                Toast toast=Toast.makeText(MainActivity.this,"点击事件",Toast.LENGTH_LONG);
//                toast.show();
            }
        });
    }
}
