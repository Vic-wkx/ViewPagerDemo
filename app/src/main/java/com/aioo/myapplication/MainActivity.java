package com.aioo.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<String> mTitleList = new ArrayList<>();//页卡标题集合
    private Fragment firstFragment,secondFragment;//页卡视图
    private ArrayList<Fragment> mViewList = new ArrayList<>();//页卡视图集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tab);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        //添加页卡视图
        mViewList.add(firstFragment);
        mViewList.add(secondFragment);

        //添加页卡标题
        mTitleList.add("First");
        mTitleList.add("Second");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            //获取每个页卡
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mViewList.get(position);
            }

            //获取页卡数
            @Override
            public int getCount() {
                return mTitleList.size();
            }

            //获取页卡标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleList.get(position);
            }

        });

        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
    }
}
