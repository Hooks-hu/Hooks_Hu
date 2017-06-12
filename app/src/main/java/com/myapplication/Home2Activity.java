package com.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.domain.view.DisableScrollViewPager;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Home2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView main_tab_newsImageView1;
    private TextView tv_message_number1;
    private TextView tabitem_text1;
    private LinearLayout tabitem1;
    private ImageView main_tab_newsImageView;
    private TextView tv_message_number2;
    private TextView tabitem_text2;
    private LinearLayout tabitem2;
    private ImageView main_tab_circleImageView;
    private TextView tv_message_number3;
    private TextView tabitem_text3;
    private LinearLayout tabitem3;
    private ImageView main_tab_courseImageView;
    private TextView tv_message_number4;
    private TextView tabitem_text4;
    private LinearLayout tabitem4;
    private LinearLayout bottom_tab_layout;
    private LinearLayout tabctrl;
    private DisableScrollViewPager viewpager;
    private TextView tv_1;
    private ImageView icon_tri;
    private ImageView bg_img;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private RelativeLayout guide_view;
    private ImageView iv_logo;
    private RelativeLayout loading_layout;
    private static final int[] tabItems = new int[]{R.id.tabitem1, R.id.tabitem2, R.id.tabitem3, R.id.tabitem4};
    private static final int[] tabitem_text = {R.id.tabitem_text1, R.id.tabitem_text2, R.id.tabitem_text3, R.id.tabitem_text4};
    private View[] tabItemsView = new View[tabItems.length];
    private TextView[] tabitemTextView = new TextView[tabitem_text.length];
    private Home2FragmentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        main_tab_newsImageView1 = (ImageView) findViewById(R.id.main_tab_newsImageView1);
        tv_message_number1 = (TextView) findViewById(R.id.tv_message_number1);
        tabitem_text1 = (TextView) findViewById(R.id.tabitem_text1);
        tabitem1 = (LinearLayout) findViewById(R.id.tabitem1);
        main_tab_newsImageView = (ImageView) findViewById(R.id.main_tab_newsImageView);
        tv_message_number2 = (TextView) findViewById(R.id.tv_message_number2);
        tabitem_text2 = (TextView) findViewById(R.id.tabitem_text2);
        tabitem2 = (LinearLayout) findViewById(R.id.tabitem2);
        main_tab_circleImageView = (ImageView) findViewById(R.id.main_tab_circleImageView);
        tv_message_number3 = (TextView) findViewById(R.id.tv_message_number3);
        tabitem_text3 = (TextView) findViewById(R.id.tabitem_text3);
        tabitem3 = (LinearLayout) findViewById(R.id.tabitem3);
        main_tab_courseImageView = (ImageView) findViewById(R.id.main_tab_courseImageView);
        tv_message_number4 = (TextView) findViewById(R.id.tv_message_number4);
        tabitem_text4 = (TextView) findViewById(R.id.tabitem_text4);
        tabitem4 = (LinearLayout) findViewById(R.id.tabitem4);
        bottom_tab_layout = (LinearLayout) findViewById(R.id.bottom_tab_layout);
        tabctrl = (LinearLayout) findViewById(R.id.tabctrl);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        icon_tri = (ImageView) findViewById(R.id.icon_tri);
        bg_img = (ImageView) findViewById(R.id.bg_img);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        guide_view = (RelativeLayout) findViewById(R.id.guide_view);
        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        loading_layout = (RelativeLayout) findViewById(R.id.loading_layout);
        viewpager = (DisableScrollViewPager) findViewById(R.id.viewpager);
        for (int i = 0; i < tabItemsView.length; i++)
            tabItemsView[i] = findViewById(tabItems[i]);
        for (int i = 0; i < tabitem_text.length; i++)
            tabitemTextView[i] = (TextView) findViewById(tabitem_text[i]);
        adapter = new Home2FragmentAdapter(this.getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(4);
        checkSelect(0);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageSelected(int position){
                checkSelect(position);
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2){
            }
            @Override
            public void onPageScrollStateChanged(int arg0){
            }
        });
        tabitem1.setOnClickListener(this);
        tabitem2.setOnClickListener(this);
        tabitem3.setOnClickListener(this);
        tabitem4.setOnClickListener(this);
        guide_view.setOnClickListener(this);
    }

    private void checkSelect(int idx) {
        int len = tabItems.length;
        for (int i = 0; i < len; i++) {
            if (idx == i) {
                tabitemTextView[i].setTextColor(Color.parseColor("#ff000000"));
                tabItemsView[i].setSelected(true);
            } else {
                tabitemTextView[i].setTextColor(Color.parseColor("#ff747474"));
                tabItemsView[i].setSelected(false);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tabitem1:
                if (0 == viewpager.getCurrentItem())
                    return;
                viewpager.setCurrentItem(0, false);
                break;
            case R.id.tabitem2:
                viewpager.setCurrentItem(1, false);
                break;
            case R.id.tabitem3:
                viewpager.setCurrentItem(2, false);
                break;
            case R.id.tabitem4:
                viewpager.setCurrentItem(3, false);
                break;
            case R.id.guide_view:

                break;
        }
    }


    private long mClickBackTime;
    @Override
    public void onBackPressed() {
        if (Math.abs(System.currentTimeMillis() - mClickBackTime) <= 2000) {
            super.onBackPressed();
            mClickBackTime = 0;
        } else {
            mClickBackTime = System.currentTimeMillis();
            Toast.makeText(this,"再按一次返回键退出摩Show",Toast.LENGTH_SHORT).show();
        }
    }

}
