package com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;

import com.myapplication.domain.Find.FindFragment;
import com.myapplication.domain.event.EventFragment;
import com.myapplication.domain.home.HomeFragment;
import com.myapplication.domain.user.UserFragment;

/**
 * Created by Administrator on 2017/6/9.
 */

public class GradientTabStripAdapter extends FragmentPagerAdapter implements
        GradientTabStrip.GradientTabAdapter  {

    public GradientTabStripAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        String title = getPageTitle(position).toString();
        switch (position) {
            default:
            case 0:
                return HomeFragment.newInstance(title);
            case 1:
                return EventFragment.newInstance(title);
            case 2:
                return FindFragment.newInstance(title);
            case 3:
                return UserFragment.newInstance(title);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "微信";
            case 1:
                return "通讯录";
            case 2:
                return "发现";
            case 3:
                return "我";
        }
    }

    @Override
    public Drawable getNormalDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_chat_normal);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_contacts_normal);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_discovery_normal);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_account_normal);
        }
    }

    @Override
    public Drawable getSelectedDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_chat_selected);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_contacts_selected);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_discovery_selected);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.ic_gradienttabstrip_account_selected);
        }
    }

    @Override
    public boolean isTagEnable(int position) {
        return position != 3;
    }

    @Override
    public String getTag(int position) {
        switch (position) {
            default:
            case 0:
                return "888";
            case 1:
                return "";
            case 2:
                return "new";
        }
    }
}
