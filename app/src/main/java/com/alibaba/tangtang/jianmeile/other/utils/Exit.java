package com.alibaba.tangtang.jianmeile.other.utils;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.alibaba.tangtang.jianmeile.R;

/**
 * 整个Application的退出框
 * Created by zhaoaiqiu on 2016/7/17.
 */
public class Exit{
    public static final void  exit(final Activity activity){
        final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.login_exit);
        Button negativeBtn = (Button) window.findViewById(R.id.negative_btn);
        Button positiveBtn = (Button) window.findViewById(R.id.positivi_btn);
        negativeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                alertDialog.dismiss();
            }
        });
        positiveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                activity.finish();
            }
        });
    }
}
