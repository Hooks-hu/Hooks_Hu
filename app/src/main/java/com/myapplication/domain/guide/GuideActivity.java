package com.myapplication.domain.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.myapplication.Home2Activity;
import com.myapplication.R;
import com.myapplication.base.BaseConst;
import com.myapplication.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class GuideActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewpager;
    private LinearLayout ll;
    private RelativeLayout bottomlayout;
    private Button guidetiaoguobutton1;

    private List<View> views;
    private GuidePagerAdapter vpAdapter;
    // 记录当前选中位置
    private int currentIndex;
    // 底部小点图片
    private ImageView[] dots;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        ll = (LinearLayout) findViewById(R.id.ll);
        bottomlayout = (RelativeLayout) findViewById(R.id.bottomlayout);
        guidetiaoguobutton1 = (Button) findViewById(R.id.guidetiaoguobutton1);
        guidetiaoguobutton1.setOnClickListener(this);
        //将第一次进入标志位false
        SharedPreferencesUtil.insertBoolean(GuideActivity.this, BaseConst.IS_FIRST_IN,false);
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        // 初始化引导图片列表
        views.add(inflater.inflate(R.layout.guide1, null));
        views.add(inflater.inflate(R.layout.guide2, null));
        views.add(inflater.inflate(R.layout.guide3, null));
        views.add(inflater.inflate(R.layout.guide4, null));
        views.add(inflater.inflate(R.layout.guide5, null));


        //初始化Adapter
        vpAdapter = new GuidePagerAdapter(views, this);
        viewpager.setAdapter(vpAdapter);
        //绑定回调
        viewpager.setOnPageChangeListener(this);
        //初始化底部小点
        initDots();
    }

    private void initDots(){
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[views.size()];
        // 循环取得小点图片C
        for (int i = 0; i < views.size(); i++){
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);// 都设为灰色
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.guidetiaoguobutton1){
            Intent intent = new Intent(GuideActivity.this,Home2Activity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
    @Override
    public void onPageScrollStateChanged(int state) {}
    @Override
    public void onPageSelected(int position) {
        //设置底部小点选中状态
        setCurrentDot(position);
        if(position == 4){
            Button guidetiaoguobutton = (Button)
                    findViewById(R.id.guidetiaoguobutton1);
            guidetiaoguobutton.setOnClickListener(this);
            guidetiaoguobutton.setVisibility(View.VISIBLE);
        }else {
            Button guidetiaoguobutton = (Button)
                    findViewById(R.id.guidetiaoguobutton1);
            guidetiaoguobutton.setOnClickListener(this);
            guidetiaoguobutton.setVisibility(View.GONE);
        }
    }

    private void setCurrentDot(int position){
        if (position < 0 || position > views.size() - 1
                || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(false);
        dots[currentIndex].setEnabled(true);
        currentIndex = position;
    }


}
