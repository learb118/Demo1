package com.nd.android.demo1;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.drm.DrmStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_activecase,btn_close;
    private ConstraintLayout layout;
    private RecyclerView rv_image;
    private ListView lv_image;
    private List<Image> ImageList=new ArrayList<>();
    private ImageAdapter adapter;

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
        findViewById(R.id.layout_all).getBackground().setAlpha(180);//设置背景透明度

        btn_activecase=findViewById(R.id.btn_activecase);
        btn_close=findViewById(R.id.btn_close);
        layout=findViewById(R.id.constraintLayout);

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
                adapter.notifyItemRangeRemoved(0,12);//全部刷新
//                adapter.notifyDataSetChanged();//刷新可见item
                layout.setVisibility(View.GONE);
                btn_activecase.setEnabled(true);
            }
        });


        initImage(); // 初始化图片数据
        rv_image=findViewById(R.id.rv_image);
        rv_image.setItemViewCacheSize(12);//设置viewholder最大缓存数
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);//用于指定布局方式
        rv_image.setLayoutManager(layoutManager);//设置布局管理器
        adapter = new ImageAdapter(ImageList);
        adapter.setHasStableIds(true);
        rv_image.setAdapter(adapter);//设置Adapter
        adapter.setCallback(new ImageAdapter.ClickImageCallback() {
            @Override
            public void onClickImage(View v, Image image) {
                Intent intent=new Intent(v.getContext(), EnlargeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ImageId", image.getImageId());
                intent.putExtras(bundle);//设置参数
                v.getContext().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), v, "sharedView").toBundle());
            }
        });

//        lv_image=findViewById(R.id.lv_image);
//        initImage(); // 初始化图片数据
//        ImageAdapter adapter = new ImageAdapter(MainActivity.this, R.layout.item_image, ImageList);
//        ListView listView = findViewById(R.id.lv_image);
//        listView.setAdapter(adapter);
    }

    private ImageAdapter.ClickImageCallback callback = new ImageAdapter.ClickImageCallback() {
        @Override
        public void onClickImage(View v, Image image) {

        }
    };

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
