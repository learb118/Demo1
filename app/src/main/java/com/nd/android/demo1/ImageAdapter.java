package com.nd.android.demo1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2018/12/26.
 */

public class ImageAdapter extends ArrayAdapter {
    private final int resourceId;

    public ImageAdapter(Context context, int textViewResourceId, List<Image> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Image image=(Image)getItem(position);//获取当前的Image实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);//实例化一个对象
        ImageView myimage=view.findViewById(R.id.my_image);//获取布局内的图片视图
        myimage.setImageResource(image.getImageId());//为图片视图设置资源
        return view;
    }
}
