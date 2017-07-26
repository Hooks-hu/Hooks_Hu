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
    public static final String CHOICE_VIDEO_SUC = "user_choice_video_suc";
    // IsFirstIn
    public static final String IS_FIRST_IN_CODE= "isfirstin_code1900";
    // IsFirstIn
    public static final String IS_FIRST_IN= "isfirstin";
    //系统时间与服务器时间差值
    public static long  SYSTEM_SERVER_TIME_DIFFERENCE = 0;
    //表情集合
    public static List<EmojiResponse> mEmojiList = new ArrayList<EmojiResponse>();

    public static int IS_MOINS_PAGE = 0;
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


    public interface  PermissionContent{// 获取各种选限时的文案
        public final static String PERMISSTION_RECORDER = "当前应用缺少必要的权限,录音权限或者读取存储权限(录音,照片,视频等需要),该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。";
        public final static String PERMISSTION_PIC = "当前应用缺少必要的权限,拍照或者读取存储权限(录音,照片,视频等需要),该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。";
        public final static String PERMISSTION_VIDEO = "当前应用缺少必要的权限,录像、录音或者读取存储权限(录音,照片,视频等需要),该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。";
        public final static String PERMISSTION_STORAGE = "当前应用缺少读取存储权限(录音,照片,视频等需要),该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。";
    }
}
