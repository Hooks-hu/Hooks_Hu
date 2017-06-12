package com.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myapplication.domain.Find.FindFragment;
import com.myapplication.domain.event.EventFragment;
import com.myapplication.domain.home.HomeFragment;
import com.myapplication.domain.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Home2FragmentAdapter extends FragmentPagerAdapter {
    public static final int TAB_COUNT = 4;
    private List<Fragment> mDataList;
    private String[] titles = new String[]{"首页", "活动", "关注", "个人中心"};

    public Home2FragmentAdapter(FragmentManager fm) {
        super(fm);
        mDataList = new ArrayList<>();
        for (int position = 0; position < TAB_COUNT; position++) {
            Fragment fragment = initFragment(position);
            mDataList.add(fragment);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mDataList.get(position);
    }

    private Fragment initFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new EventFragment();
                break;
            case 2:
                fragment = new FindFragment();
                break;
            case 3:
                fragment = new UserFragment();
                break;
            default:
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
