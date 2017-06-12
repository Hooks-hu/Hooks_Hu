package com.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Administrator on 2017/6/9.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupBackAsUp(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //为标题栏设置标题，即给ActionBar设置标题。
            actionBar.setTitle(title);
            //ActionBar加一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true);
            //不显示当前程序的图标。
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home) {
            //点击HOME ICON finish当前Activity
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
