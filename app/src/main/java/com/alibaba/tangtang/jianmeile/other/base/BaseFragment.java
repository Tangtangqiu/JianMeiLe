package com.alibaba.tangtang.jianmeile.other.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment的基类
 * Created by zhaoaiqiu on 2016/6/27.
 */
public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(setViewId(),null);

        findViews(view);
        init();
        initEvent();
        loadData();

        return view;
    }

    protected abstract int setViewId();
    /**
     * 查找Activity布局里面的控件
     */
    protected abstract void findViews(View view);
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
