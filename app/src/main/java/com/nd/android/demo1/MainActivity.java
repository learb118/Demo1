package com.nd.android.demo1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;

public class MainActivity extends AppCompatActivity {

    private Button btn_activecase,btn_close;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null){//隐藏标题栏
            getSupportActionBar().hide();
        }
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//无title
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);//全屏显示
        findViewById(R.id.layout_all).getBackground().setAlpha(150);//设置背景半透明
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设置屏幕横屏
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置屏幕竖屏

        btn_activecase=findViewById(R.id.btn_activecase);
        btn_close=findViewById(R.id.btn_close);

        layout=findViewById(R.id.layout_image);
        btn_activecase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
                btn_activecase.setEnabled(false);

//                new ImageDiaologFragment().show(getFragmentManager(),"custom");//dialogFragment方式的弹窗

//                Toast toast=Toast.makeText(MainActivity.this,"点击事件",Toast.LENGTH_LONG);
//                toast.show();

//                new TDialog.Builder(getSupportFragmentManager())
//                        .setLayoutRes(R.layout.imagedialog)
//                        .setWidth(800)  //设置弹窗固定宽度(单位:px)
//                        .setHeight(600)//设置弹窗固定高度
//                        .setScreenWidthAspect(MainActivity.this,0.8f) //动态设置弹窗宽度为屏幕宽度百分比(取值0-1f)
//                        .setScreenHeightAspect(MainActivity.this,0.6f)//设置弹窗高度为屏幕高度百分比(取值0-1f)
//                        .setGravity(Gravity.CENTER)//设置弹窗展示的位置
//                        .setDimAmount(0.6f) //设置弹窗背景色透明度(取值0-1f,0为全透明)
//                        .setCancelOutside(false)//设置弹窗外部是否可以点击取消(默认可点击取消)
//                        .setOnBindViewListener(new OnBindViewListener() {
//                            @Override
//                            public void bindView(BindViewHolder bindViewHolder) {
//                                bindViewHolder.setText(R.id.textView, "abcdef");
//                                bindViewHolder.setText(R.id.textView2,"我是Title");
//                            }
//                        })
//                        .create()
//                        .show();
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.GONE);
                btn_activecase.setEnabled(true);
            }
        });
    }
}
