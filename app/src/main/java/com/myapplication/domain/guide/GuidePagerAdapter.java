package com.myapplication.domain.guide;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class GuidePagerAdapter extends PagerAdapter {

    // 界面列表
    private List<View> views;
    private Activity activity;
    private static final String SHAREDPREFERENCES_NAME = "first_pref";
    public GuidePagerAdapter(List<View> views, Activity activity){
        this.views = views;
        this.activity = activity;
    }
    // 销毁arg1位置的界面
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2){
        ((ViewPager) arg0).removeView(views.get(arg1));
    }
    @Override
    public void finishUpdate(View arg0){
    }
    // 获得当前界面数
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    // 初始化arg1位置的界面
    @Override
    public Object instantiateItem(View arg0, int arg1){
        ((ViewPager) arg0).addView(views.get(arg1), 0);
        //原本是要划到最后一页才能注册/登陆，现在加上1＝＝1使得每一页都可以
        //if (arg1 == 2) {
        //Button guidetiaoguobutton = (Button) arg0
        // 		 .findViewById(R.id.guidetiaoguobutton1);
//		 guidetiaoguobutton.setVisibility(View.VISIBLE);
//		 }
//		 @Override
//		 public void onClick(View v) {
//		 // 设置已经引导
//		 setGuided();
//		 goRegister();
//		 }
        // });
        //
        //
        // ImageView loginBtn = (ImageView) arg0
        // .findViewById(R.id.btn_login);
        // loginBtn.setOnClickListener(new OnClickListener() {
        //
        // @Override
        // public void onClick(View v) {
        // // 设置已经引导
        // setGuided();
        // goLogin();
        //
        // }
        //
        // });
        // }
        return views.get(arg1);
    }

//    private void goRegister() {
//        // 跳转
//        Intent intent = new Intent(activity, RegisterActivity.class);
//        activity.startActivity(intent);
//        activity.finish();
//    }
//
//    private void goLogin() {
//        // 跳转
//        Intent intent = new Intent(activity, LoginActivity.class);
//        activity.startActivity(intent);
//        activity.finish();
//    }

    /**
     *
     * method desc：设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        // SharedPreferences preferences = activity.getSharedPreferences(
        // SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        // Editor editor = preferences.edit();
        // // 存入数据
        // editor.putBoolean("isFirstIn", false);
        // // 提交修改
        // editor.commit();
//        SharedPreferencesUtil.getInstance().setBoolean("isFirstIn", false);
    }

    // 判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View arg0, Object arg1){
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1){
    }

    @Override
    public Parcelable saveState(){
        return null;
    }

    @Override
    public void startUpdate(View arg0){
    }
}
