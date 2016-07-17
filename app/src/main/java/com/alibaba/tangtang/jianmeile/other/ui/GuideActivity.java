package com.alibaba.tangtang.jianmeile.other.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.alibaba.tangtang.jianmeile.R;
import com.alibaba.tangtang.jianmeile.other.adapter.MyPageAdapter;
import com.alibaba.tangtang.jianmeile.other.base.BaseActivity;
import com.alibaba.tangtang.jianmeile.other.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页Activity
 */
public class GuideActivity extends BaseActivity{

    private ViewPager viewPager;


    private TabLayout tabLayout;
    private TextView textView_go;
    private TextView textView_now;
    private List<Integer> imageDatas;

    @Override
    protected int setViewId(){
        return R.layout.activity_guide;
    }

    @Override
    protected void findViews(){
        viewPager = (ViewPager) findViewById(R.id.vp_guideActivity);
        tabLayout = (TabLayout) findViewById(R.id.tl_guideActivity);
        textView_go = (TextView) findViewById(R.id.tv_guideActivity);//直接进入
        textView_now = (TextView) findViewById(R.id.now_guideActivity);//立即体验
    }

    @Override
    protected void init(){
        //viewPage初始化
        imageDatas = new ArrayList<>();
        imageDatas.add(R.drawable.start_one);
        imageDatas.add(R.drawable.start_two);
        imageDatas.add(R.drawable.start_three);
        imageDatas.add(R.drawable.start_four);
        imageDatas.add(R.drawable.start_file);

        MyPageAdapter adpater = new MyPageAdapter(this, imageDatas);
        viewPager.setAdapter(adpater);

        //tableLayout初始化
        for(int i = 0; i < imageDatas.size(); i++){
            tabLayout.addTab(tabLayout.newTab());
        }
    }

    @Override
    protected void initEvent(){
        //给viewPager设置监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
            }

            @Override
            public void onPageSelected(int position){
                tabLayout.getTabAt(position).select();
                if(position==imageDatas.size()-1){
                    textView_now.setVisibility(View.VISIBLE);
                }else {
                    textView_now.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state){
            }
        });
        //给tabLayout设置监听并联动viewPager
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){
            }
        });
        //点击跳转到MainActivity
        textView_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                intentToRegisterActivity();
            }
        });
        textView_now.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                intentToRegisterActivity();
            }
        });
    }
    //跳转到登录界面
    private void intentToRegisterActivity(){
        Intent intent = new Intent(GuideActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
        //TODO 把第一次进入存入到xml文件中做相应判断
        SharedPreferences sharedPreferences = getSharedPreferences(Constant.FIRST_XML_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(Constant.FLAG_FIRST_USED_VALUE,false);
        edit.commit();
    }

    @Override
    protected void loadData(){
    }
}
