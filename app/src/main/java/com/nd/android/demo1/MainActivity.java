package com.nd.android.demo1;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_activecase,btn_close;
    private ConstraintLayout layout;
    private RecyclerView rv_image;
    private List<Image> ImageList=new ArrayList<>();

    public ImageAdapter getAdapter() {
        return adapter;
    }

    private ImageAdapter adapter;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);//全屏显示

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.layout_all).getBackground().setAlpha(180);//设置背景透明度

        btn_activecase=findViewById(R.id.btn_activecase);
        btn_close=findViewById(R.id.btn_close);
        layout=findViewById(R.id.constraintLayout);

        btn_activecase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
                btn_activecase.setEnabled(false);
                initAdapter();
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.INVISIBLE);
                btn_activecase.setEnabled(true);
            }
        });
        initImage(); // 初始化图片数据
        initAdapter();
    }

     void initAdapter() {
        rv_image=findViewById(R.id.rv_image);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);//用于指定布局方式
        rv_image.setLayoutManager(layoutManager);//设置布局管理器

        adapter = new ImageAdapter(ImageList);
        rv_image.setAdapter(adapter);//设置Adapter
        adapter.setCallback(callback);
    }

    private ImageAdapter.ClickImageCallback callback = new ImageAdapter.ClickImageCallback() {
        @Override
        public void onClickImage(View v, Image image) {
            dialogShow(image);
        }
    };

    void dialogShow(Image image) {
        dialog = new Dialog(MainActivity.this, R.style.Dialog);
        dialog.setContentView(R.layout.activity_enlarge);
        ImageView imageView=dialog.findViewById(R.id.imageView2);
        imageView.setImageResource(image.getImageId());
        dialog.setCanceledOnTouchOutside(true); // Sets whether this dialog is
        dialog.show();
        Window w = dialog.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(lp);
        imageView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
    }

    private void initImage(){
        Image apple=new Image(R.drawable.apple_pic);
        ImageList.add(apple);
        Image banana=new Image(R.drawable.banana_pic);
        ImageList.add(banana);
        Image cherry=new Image(R.drawable.cherry_pic);
        ImageList.add(cherry);
        Image grape=new Image(R.drawable.grape_pic);
        ImageList.add(grape);
        Image mango=new Image(R.drawable.mango_pic);
        ImageList.add(mango);
        Image orange=new Image(R.drawable.orange_pic);
        ImageList.add(orange);
        Image pear=new Image(R.drawable.pear_pic);
        ImageList.add(pear);
        Image pineapple=new Image(R.drawable.pineapple_pic);
        ImageList.add(pineapple);
        Image strawberry=new Image(R.drawable.strawberry_pic);
        ImageList.add(strawberry);
        Image watermelon=new Image(R.drawable.watermelon_pic);
        ImageList.add(watermelon);
        ImageList.add(watermelon);
        ImageList.add(watermelon);
    }
}
