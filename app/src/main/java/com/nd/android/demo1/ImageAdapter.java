package com.nd.android.demo1;

import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2018/12/26.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Image> mImageList;
    private ClickImageCallback clickimagecallback;//回调函数
    static class ViewHolder extends RecyclerView.ViewHolder{
        //View my_view;
        ImageView my_imageview;
        boolean isClick;

        public ViewHolder(View view){
            super(view);
            my_imageview=view.findViewById(R.id.my_image);
            Image image = new Image(R.drawable.casting_placeholder);
            my_imageview.setImageResource(image.getImageId());
        }
    }

    public ImageAdapter(List<Image> imageList){
        mImageList=imageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //用于创建ViewHolder实例（在这里加载子项布局）
        Log.w("ImageAdapter","onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);

        DisplayMetrics metrics = parent.getContext().getResources().getDisplayMetrics();
        int heightPixels = metrics.heightPixels;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height=heightPixels/5;

        final ViewHolder holder = new ViewHolder(view);
        holder.my_imageview.setOnClickListener(new View.OnClickListener() {//item里的图片的点击事件
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Image image = mImageList.get(position);
                if(!holder.isClick){
                    holder.my_imageview.setImageResource(image.getImageId());
                }else {
                    if (clickimagecallback != null) {
                        clickimagecallback.onClickImage(v, image);
                    }
                }
                //Toast.makeText(v.getContext(), "you clicked image, position : " +  position+second_click_position[position], Toast.LENGTH_SHORT).show();
                holder.isClick = true;
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //用于加载布局，会在每个子项滚动到屏幕时执行
        Log.w("ImageAdapter","onBindViewHolder"+position);
    }
    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    public interface ClickImageCallback {
        void onClickImage(View v, Image image);
    }

    public void setCallback(ClickImageCallback clickimagecallback) {
        this.clickimagecallback = clickimagecallback;
    }
}