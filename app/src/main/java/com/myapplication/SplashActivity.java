package com.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myapplication.base.BaseConst;
import com.myapplication.domain.guide.GuideActivity;
import com.myapplication.utils.InitUtils;
import com.myapplication.utils.SharedPreferencesUtil;

/**
 * Created by Administrator on 2017/6/9.
 */

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 2000;
    private String version;
    private boolean inFirstInCode;
    private boolean isFirstIn = true;
    private String token;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    if (isFirstIn) {
                        intentToGuideActivity();
                    } else {
//                        if (!TextUtils.isEmpty(token)) {
//                            BaseConst.MY_TOKEN = token;
//                            userPresenter.getUserInfo();
//                        } else {
                        intentToHome2Activity();
//                        }
                    }
                    break;
                case 200:
                    intentToGuideActivity();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {

//        presenter.getServerTime();
//        BaseConst.mEmojiList = EmojiUtils.getEmojiFile(SplashActivity.this);
        inFirstInCode = SharedPreferencesUtil.getBoolean(getApplication(), BaseConst.IS_FIRST_IN_CODE, true);
        version = InitUtils.getVersionName(MyApplication.getInstance().getApplicationContext());
        isFirstIn = SharedPreferencesUtil.getBoolean(getApplication(), BaseConst.IS_FIRST_IN, true);
//        token = SharedPreferencesUtil.getString(SplashActivity.this,BaseConst.USER_TOKEN);
//        if("1.9".endsWith(version) && inFirstInCode){
//            token = null;
//            isFirstIn = true;
//        }if(BaseConst.isDebug){
//            showChoice();
//        }else{
//            mHandler.sendEmptyMessageDelayed(100,SPLASH_TIME);
//        }

        mHandler.sendEmptyMessageDelayed(100, SPLASH_TIME);
    }

    private void intentToLoginActivity() {

    }

    private void intentToHomeActivity() {
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void intentToHome2Activity() {
        Intent intent = new Intent(SplashActivity.this,Home2Activity.class);
        startActivity(intent);
    }

    private void intentToGuideActivity() {
        Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
        startActivity(intent);
    }
}
