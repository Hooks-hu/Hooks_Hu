package com.myapplication.base;

import com.myapplication.utils.emojihelper.EmojiResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class BaseConst {

    // USER_TOKEN
    public static String MY_TOKEN = "03cc865e668b47f080fd8be8fbe011ab";
    public static String SM_OPSMD5 = "3caf2a413559e89f8a1739856938e587";
    public static String MY_SN = "7a4391b1577179f3063632c3ea486ba5";
    public static final String LOG_PREFIX = "somall_template_";
    public static final boolean isDebug = false;// 是否为debug版本,上线改为false

    // IsFirstIn
    public static final String IS_FIRST_IN_CODE= "isfirstin_code1900";
    // IsFirstIn
    public static final String IS_FIRST_IN= "isfirstin";
    //系统时间与服务器时间差值
    public static long  SYSTEM_SERVER_TIME_DIFFERENCE = 0;
    //表情集合
    public static List<EmojiResponse> mEmojiList = new ArrayList<EmojiResponse>();

    //服务入口
    public  static  String  BASE_SERVER_ENTRY = "http://192.168.199.112:8080";
    // home界面Bannerjson
    public static final String BANNER_URL = BASE_SERVER_ENTRY + "/hooks/banner.json";
    // home界面Bannerjson
    public static final String XIAOMOSTART_URL = BASE_SERVER_ENTRY + "/hooks/xiaomostart.json";
    // home界面Bannerjson
    public static final String XIAOMOSTARTLIST_URL = BASE_SERVER_ENTRY + "/hooks/xiaomostartlist.json";
    // home界面星级推荐列表
    public static final String STARTRECOMAD_URL = BASE_SERVER_ENTRY + "/hooks/startRecomad.json";
}
