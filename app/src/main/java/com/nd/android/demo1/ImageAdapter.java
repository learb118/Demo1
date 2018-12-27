package com.nd.android.demo1;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

/**
 * Created by Administrator on 2018/12/26.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Image> mImageList;
    private boolean second_click_position []= new boolean[12];

    static class ViewHolder extends RecyclerView.ViewHolder{
        View imageview;
        ImageView myview;
        public ViewHolder(View view){
            super(view);
            imageview=view;
            myview=view.findViewById(R.id.my_image);
        }
    }

    public ImageAdapter(List<Image> imageList){
        mImageList=imageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.w("ImageAdapter","onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        final ViewHolder holder = new ViewHolder(view);
//        holder.imageview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                Image image = mImageList.get(position);
//                holder.myview.setImageResource(image.getImageId());
//                //Toast.makeText(v.getContext(), "you clicked view, position : " + position , Toast.LENGTH_SHORT).show();
//            }
//        });
        holder.myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Image image = mImageList.get(position);
                if(second_click_position[position]==false){
                    holder.myview.setImageResource(image.getImageId());
                }else {
                    Intent intent=new Intent(v.getContext(), EnlargeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("ImageId", image.getImageId());
                    intent.putExtras(bundle);//设置参数
                    v.getContext().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), v, "sharedView").toBundle());
                }
                //Toast.makeText(v.getContext(), "you clicked image, position : " +  position+second_click_position[position], Toast.LENGTH_SHORT).show();
                second_click_position[position]=true;
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image image = new Image(R.drawable.casting_placeholder);
        //holder.myview.setImageResource(image.getImageId());
        Log.w("ImageAdapter","onBindViewHolder"+position);
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

}
