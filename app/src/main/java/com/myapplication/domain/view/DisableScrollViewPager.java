package com.myapplication.domain.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/6/9.
 */

public class DisableScrollViewPager extends ViewPager {

    private boolean isCanScroll = false;


    public DisableScrollViewPager(Context context) {
        super(context);
    }

    public DisableScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        // TODO Auto-generated method stub
        // return super.onTouchEvent(arg0);
        return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return false;
    }
}
