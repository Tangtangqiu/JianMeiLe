package com.alibaba.tangtang.jianmeile.other.base;

/**
 * 网络访问线程的接口，
 * Created by zhaoaiqiu on 2016/6/27.
 */
public interface NetCallback{
    public void success(String strResult);
    public void fail(String strResult);
}
