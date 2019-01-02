package com.nd.android.demo1;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
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
    private Dialog dialog;

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
                init();
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyItemRangeChanged(0,12,"123456");
//                adapter.notifyDataSetChanged();//刷新可见item
                layout.setVisibility(View.GONE);
                btn_activecase.setEnabled(true);
                new Thread(){
                    public void run() {
                        try {
                            Thread.sleep(1);
                            rv_image.scrollToPosition(0);//跳转到顶部
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }.start();
            }
        });
        initImage(); // 初始化图片数据
        init();
    }

    private void init() {
        rv_image=findViewById(R.id.rv_image);
        //rv_image.setItemViewCacheSize(20);//设置viewholder最大缓存数
        ((DefaultItemAnimator) rv_image.getItemAnimator()).setSupportsChangeAnimations(false);//关闭局部刷新动画
        ((SimpleItemAnimator)rv_image.getItemAnimator()).setSupportsChangeAnimations(false);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);//用于指定布局方式
        rv_image.setLayoutManager(layoutManager);//设置布局管理器

        adapter = new ImageAdapter(ImageList);
        rv_image.setAdapter(adapter);//设置Adapter
        adapter.setCallback(callback);
    }

    private ImageAdapter.ClickImageCallback callback = new ImageAdapter.ClickImageCallback() {
        @Override
        public void onClickImage(View v, Image image) {
//                Intent intent=new Intent(v.getContext(), EnlargeActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putInt("ImageId", image.getImageId());
//                intent.putExtras(bundle);//设置参数
//                v.getContext().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), v, "sharedView").toBundle());
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
