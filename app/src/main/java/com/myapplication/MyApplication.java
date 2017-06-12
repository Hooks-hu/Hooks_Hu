package com.myapplication;

import android.app.Application;

/**
 * Created by Administrator on 2017/6/9.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
}
