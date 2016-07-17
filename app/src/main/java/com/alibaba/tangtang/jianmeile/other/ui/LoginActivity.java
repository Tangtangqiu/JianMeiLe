package com.alibaba.tangtang.jianmeile.other.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.alibaba.tangtang.jianmeile.R;
import com.alibaba.tangtang.jianmeile.other.base.BaseActivity;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity{

    private Button btn_login;

    @Override
    protected int setViewId(){
        return R.layout.activity_login;
    }

    @Override
    protected void findViews(){
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    @Override
    protected void init(){
    }

    @Override
    protected void initEvent(){
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                //TODO 没有finish当前页面为了方便调试
            }
        });
    }

    @Override
    protected void loadData(){
    }

    //按返回键的时候出对话框
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK){
            new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("系统提示")

                    .setMessage("确定要退出吗")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            return;
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            finish();
                        }
                    }).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
