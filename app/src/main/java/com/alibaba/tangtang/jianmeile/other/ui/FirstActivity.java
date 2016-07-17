package com.alibaba.tangtang.jianmeile.other.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.alibaba.tangtang.jianmeile.R;
import com.alibaba.tangtang.jianmeile.other.base.BaseActivity;
import com.alibaba.tangtang.jianmeile.other.constant.Constant;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 第一个Activity
 */
public class FirstActivity extends BaseActivity{

    private Timer timer;
    private boolean isFirst;

    @Override
    protected int setViewId(){
        return R.layout.activity_first;
    }

    @Override
    protected void findViews(){
    }

    @Override
    protected void init(){
        //得到是否是第一次使用
        SharedPreferences sharedPreferences = getSharedPreferences(Constant.FIRST_XML_NAME, Context.MODE_PRIVATE);
        isFirst = sharedPreferences.getBoolean(Constant.FLAG_FIRST_USED_VALUE, true);
        //这个界面显示两秒后跳转到引导页面
        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                //TODO 还有如果登录成功就直接跳转到HomeActivity---未做
                //如果是第一次使用就跳转到GuideActivity，否则就跳转到登录界面
                Intent intent = null;

                if(isFirst){
                    intent = new Intent(FirstActivity.this,GuideActivity.class);
                }else {
                    intent = new Intent(FirstActivity.this,LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },2000);
    }

    @Override
    protected void initEvent(){
    }

    @Override
    protected void loadData(){
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        timer.cancel();
    }
}
