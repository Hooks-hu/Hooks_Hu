package com.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.myapplication.base.BaseActivity;


public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private Toolbar toolbar;
    private ViewPager gts_vp_fragments;
    private GradientTabStrip gts_gts_tabs;
    private GradientTabStripAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("设置");
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        gts_vp_fragments = (ViewPager) findViewById(R.id.gts_vp_fragments);
        gts_gts_tabs = (GradientTabStrip) findViewById(R.id.gts_gts_tabs);
        adapter = new GradientTabStripAdapter(getSupportFragmentManager());
        gts_vp_fragments.setAdapter(adapter);
        gts_gts_tabs.setAdapter(adapter);
        gts_gts_tabs.bindViewPager(gts_vp_fragments);
        gts_vp_fragments.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
    @Override
    public void onPageScrollStateChanged(int state) {}
    @Override
    public void onPageSelected(int position) {
        setTitle(adapter.getPageTitle(gts_vp_fragments.getCurrentItem()));
    }

}
