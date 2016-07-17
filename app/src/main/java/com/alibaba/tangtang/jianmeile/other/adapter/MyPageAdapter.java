package com.alibaba.tangtang.jianmeile.other.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.tangtang.jianmeile.other.ui.GuideActivity;

import java.util.List;

/**
 * 用来显示单个的图片的适配器
 * Created by zhaoaiqiu on 2016/7/16.
 */
public class MyPageAdapter<T> extends PagerAdapter{

    private GuideActivity context;
    private List<T> datas;

    public MyPageAdapter(GuideActivity context, List<T> datas){
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount(){
        return datas==null?0:datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        ImageView imageView = new ImageView(context);
        imageView.setImageResource((Integer) datas.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }
}
