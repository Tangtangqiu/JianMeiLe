package com.alibaba.tangtang.jianmeile.other.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.tangtang.jianmeile.R;

/**
 *HomeActivity下面的选择图片按钮
 * Created by zhaoaiqiu on 2016/7/17.
 */
public class My_image_View extends LinearLayout{
    int nomalPicRes;
    int pressPicRes;
    private ImageView my_imageView;

    public My_image_View(Context context){
        super(context);
        initView(context,null);
    }

    public My_image_View(Context context, AttributeSet attrs){
        super(context, attrs);
        initView(context,attrs);
    }
    //属性初始化
    private void initView(Context context, AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.my_imageview, this, true);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.My_image_View);
        nomalPicRes = array.getResourceId(R.styleable.My_image_View_normalpic,-1);
        pressPicRes = array.getResourceId(R.styleable.My_image_View_prespic,-1);
        my_imageView = (ImageView) view.findViewById(R.id.my_imageView);
        my_imageView.setImageResource(nomalPicRes);
        array.recycle();
    }
    /**
     * 点击选择press图片
     */
    public void onselect(){
        my_imageView.setImageResource(pressPicRes);
    }

    /**
     * 点击选择默认图片
     */
    public void unselect(){
        my_imageView.setImageResource(nomalPicRes);
    }
}

