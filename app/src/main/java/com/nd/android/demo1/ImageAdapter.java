package com.nd.android.demo1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2018/12/26.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Image> mImageList;

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
        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Image image = mImageList.get(position);

                Toast.makeText(v.getContext(), "you clicked view, position : " + position , Toast.LENGTH_SHORT).show();
            }
        });
        holder.myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Image image = mImageList.get(position);
                holder.myview.setImageResource(image.getImageId());
                //Toast.makeText(v.getContext(), "you clicked image, position : " +  position, Toast.LENGTH_SHORT).show();
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
