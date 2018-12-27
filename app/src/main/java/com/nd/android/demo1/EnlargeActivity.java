package com.nd.android.demo1;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class EnlargeActivity extends AppCompatActivity {

    private ImageView imageView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null){//隐藏标题栏
            getSupportActionBar().hide();
        }
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);//全屏显示
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);

        Intent intent=getIntent();
        int ImageId=intent.getExtras().getInt("ImageId");
        imageView=findViewById(R.id.imageView2);
        imageView.setImageResource(ImageId);

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注意这里不使用finish
                ActivityCompat.finishAfterTransition(EnlargeActivity.this);
            }
        });
    }
}
