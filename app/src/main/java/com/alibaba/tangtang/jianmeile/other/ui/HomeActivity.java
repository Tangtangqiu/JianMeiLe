package com.alibaba.tangtang.jianmeile.other.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.alibaba.tangtang.jianmeile.R;
import com.alibaba.tangtang.jianmeile.diet.ui.DietFragment;
import com.alibaba.tangtang.jianmeile.mine.ui.MineFragment;
import com.alibaba.tangtang.jianmeile.other.base.BaseActivity;
import com.alibaba.tangtang.jianmeile.other.widget.My_image_View;
import com.alibaba.tangtang.jianmeile.show.ui.ShowFragment;
import com.alibaba.tangtang.jianmeile.study.ui.StudyFragment;
import com.alibaba.tangtang.jianmeile.train.ui.TrainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来放五Fragment
 */
public class HomeActivity extends BaseActivity{

    private FrameLayout frameLayout_home;
    private LinearLayout radioGroup_home;
    private FragmentManager fragmentManager;
    private List<Fragment> fragmentList;
    private TrainFragment trainFragment;
    private DietFragment dietFragment;
    private StudyFragment studyFragment;
    private ShowFragment showFragment;
    private MineFragment mineFragment;

    private My_image_View trainButton;
    private My_image_View dietButton;
    private My_image_View studyButton;
    private My_image_View showButton;
    private My_image_View mineButton;

    private Fragment lastFragment;
    private My_image_View lastImageButton;
    @Override
    protected int setViewId(){
        return R.layout.activity_home;
    }

    @Override
    protected void findViews(){
        frameLayout_home = (FrameLayout) findViewById(R.id.fl_homeActivity);
        radioGroup_home = (LinearLayout) findViewById(R.id.imageButtonContainer);
        trainButton = (My_image_View) findViewById(R.id.train_ib_home);
        dietButton = (My_image_View) findViewById(R.id.diet_ib_home);
        studyButton = (My_image_View) findViewById(R.id.study_ib_home);
        showButton = (My_image_View) findViewById(R.id.show_ib_home);
        mineButton = (My_image_View) findViewById(R.id.mine_ib_home);

        lastImageButton = trainButton;
        trainButton.onselect();

    }

    @Override
    protected void init(){
        //用来存放五个Fragment的集合
        fragmentList = new ArrayList<>();

        trainFragment = new TrainFragment();
        dietFragment = new DietFragment();
        studyFragment = new StudyFragment();
        showFragment = new ShowFragment();
        mineFragment = new MineFragment();
        //把五个Faragment添加到fragmentList集合中
        fragmentList.add(trainFragment);
        fragmentList.add(dietFragment);
        fragmentList.add(studyFragment);
        fragmentList.add(showFragment);
        fragmentList.add(mineFragment);
        //获得Fragment管理器
        fragmentManager = getSupportFragmentManager();
        //开启事务把fragment加入到container中
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //把Fragment添加到FramLayout容器中
        for(int i = 0; i < fragmentList.size(); i++){
            transaction.add(R.id.fl_homeActivity,fragmentList.get(i));
            transaction.hide(fragmentList.get(i));
        }
        //默认显示第一个Fragment
        transaction.show(fragmentList.get(0));
        lastFragment = fragmentList.get(0);

        //一定要提交事务
        transaction.commit();
    }
    @Override
    protected void initEvent(){

    }

    @Override
    protected void loadData(){

    }
    //ImageButton的选择
    public void choose(View view){
        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        switch(view.getId()){
            case R.id.train_ib_home:
                if(!(lastFragment instanceof TrainFragment)){
                    //隐藏上一个Fragment
                    transaction.hide(lastFragment);
                    //上一次图片选择默认图片
                    lastImageButton.unselect();
                    //当前点击显示Press的图片
                    trainButton.onselect();
                    //跟新lastImageButton的值
                    lastImageButton = trainButton;
                }
                //跟新lastFragment的值
                lastFragment = trainFragment;
                //点击时候显示相应的Fragment，
                transaction.show(trainFragment);
                break;
            case R.id.diet_ib_home:
                if(!(lastFragment instanceof DietFragment)){
                    transaction.hide(lastFragment);
                    lastImageButton.unselect();
                    dietButton.onselect();
                    lastImageButton = dietButton;
                }
                lastFragment = dietFragment;
                transaction.show(dietFragment);
                break;
            case R.id.study_ib_home:
                if(!(lastFragment instanceof StudyFragment)){
                    transaction.hide(lastFragment);

                    lastImageButton.unselect();
                    studyButton.onselect();
                    lastImageButton = studyButton;
                }
                lastFragment = studyFragment;
                transaction.show(studyFragment);
                break;
            case R.id.show_ib_home:
                if(!(lastFragment instanceof ShowFragment)){
                    transaction.hide(lastFragment);

                    lastImageButton.unselect();
                    showButton.onselect();
                    lastImageButton = showButton;
                }
                lastFragment = showFragment;
                transaction.show(showFragment);
                break;
            case R.id.mine_ib_home:
                if(!(lastFragment instanceof MineFragment)){
                    transaction.hide(lastFragment);
                    lastImageButton.unselect();
                    mineButton.onselect();
                    lastImageButton = mineButton;
                }
                lastFragment = mineFragment;
                transaction.show(mineFragment);
                break;
            default:
                break;
        }
        //提交事务
        transaction.commit();
    }

}
