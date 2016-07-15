package com.alibaba.tangtang.jianmeile.other.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zhaoaiqiu on 2016/6/27.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(setViewId());

        findViews();

        init();

        initEvent();

        loadData();
    }

    protected abstract int setViewId();
    /**
     * 查找Activity布局里面的控件
     */
    protected abstract void findViews();
    /**
     * 数据初始化
     */
    protected abstract void init();
    /**
     * 初始化各种事件监听
     */
    protected abstract void initEvent();
    /**
     * 加载各种数据
     */
    protected abstract void loadData();

}
