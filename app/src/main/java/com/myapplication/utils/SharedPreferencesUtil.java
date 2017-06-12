package com.myapplication.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Map;

/**
 * SharedPreferences工具类
 */
public class SharedPreferencesUtil {

    private static final String SP_NAME_CICLE = "SP_NAME_CICLE";


    public static boolean insertString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        return edit.commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public static boolean insertLong(Context context, String key, long value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        Editor edit = sharedPreferences.edit();
        edit.putLong(key, value);
        return edit.commit();
    }


    public static Map<String, ?> getAll(Application context) {
        return context.getSharedPreferences(SP_NAME_CICLE, Context.MODE_PRIVATE).getAll();
    }

    public static long getLong(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, 0L);
    }


    public static void insertInt(Application context, String key, int value) {
        context.getSharedPreferences(SP_NAME_CICLE, Context.MODE_PRIVATE).edit()
                .putInt(key, value).commit();
    }


    public static int getInt(Application context, String key) {
        return context.getSharedPreferences(SP_NAME_CICLE, Context.MODE_PRIVATE)
                .getInt(key, 0);
    }

    public static boolean insertBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, value);
        return edit.commit();
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public static boolean getBoolean(Application context, String key, boolean defualtValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defualtValue);
    }

    public static boolean getBoolean(Application context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }


    public static void clear(Application context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SP_NAME_CICLE, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

    //------------------------------------------通用------------------------------------------------

    public static void saveToSharedPreferences(Context context, String spName, String key, long value) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();
    }

    public static void saveToSharedPreferences(Context context, String spName, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static void saveToSharedPreferences(Context context, String spName, String key, float value) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putFloat(key, value).commit();
    }

    public static void saveToSharedPreferences(Context context, String spName, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static void saveToSharedPreferences(Context context, String spName, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static long getFromSharedPreferences(Context context, String spName, String key, long defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getLong(key, defaultValue);
    }

    public static boolean getFromSharedPreferences(Context context, String spName, String key, boolean defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }

    public static float getFromSharedPreferences(Context context, String spName, String key, float defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getFloat(key, defaultValue);
    }

    public static int getFromSharedPreferences(Context context, String spName, String key, int defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getInt(key, defaultValue);
    }

    public static String getFromSharedPreferences(Context context, String spName, String key, String defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }
}
