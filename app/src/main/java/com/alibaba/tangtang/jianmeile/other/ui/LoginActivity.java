package com.alibaba.tangtang.jianmeile.other.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.alibaba.tangtang.jianmeile.R;
import com.alibaba.tangtang.jianmeile.other.base.BaseActivity;
import com.alibaba.tangtang.jianmeile.other.utils.Exit;

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
                finish();
            }
        });
    }

    @Override
    protected void loadData(){
    }

    //按返回键的时候出对话框
   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK){
            final AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
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
                    finish();
                }
            });

        }
        return super.onKeyDown(keyCode, event);
    }*/

    @Override
    public void onBackPressed(){
        Exit.exit(LoginActivity.this);
    }
}
