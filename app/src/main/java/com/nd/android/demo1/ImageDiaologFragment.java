package com.nd.android.demo1;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/12/25.
 */

public class ImageDiaologFragment extends DialogFragment  {
//    implements DialogInterface.OnClickListener
//    private static final String TAG = "CustomDialogFragment";
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder =
//                new AlertDialog.Builder(getActivity())
//                        .setTitle("标题")
//                        .setMessage("消息")
//                        .setPositiveButton("确定", this)
//                        .setNegativeButton("取消", this)
//                        .setCancelable(false);
//                        // 这里不能调用show方法
//        return builder.create();
//    }
//    @Override
//    public void onClick(DialogInterface dialog, int which) {
//        switch (which) {
//            case DialogInterface.BUTTON_NEGATIVE:
//                Toast.makeText(getActivity(), "取消", Toast.LENGTH_SHORT).show();
//                break;
//            case DialogInterface.BUTTON_POSITIVE:
//                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//        }
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置背景透明
        return inflater.inflate(R.layout.imagedialog, container, false);
    }
}
