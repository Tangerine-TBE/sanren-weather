package com.example.module_ad.utils;

import android.util.Log;

import com.example.module_ad.base.AdApplication;


/**
 * @author: Administrator
 * @date: 2020/6/27 0027
 */
public class LogUtils {
    private static int LEVEL= AdApplication.LogLevel;

    private static int DEBUG=0;
    private static int INFO=1;
    private static int WARM=2;
    private static int ERROR=3;


    public static void d(Object context, String msg) {
        if (DEBUG >= LEVEL) {
            Log.d(context.getClass().getSimpleName(), msg);
        }
    }
    public static void i(Object context,String msg) {
        if (INFO >= LEVEL) {
            Log.i(context.getClass().getSimpleName(), msg);
        }
    }
    public static void w(Object context,String msg) {
        if (WARM >= LEVEL) {
            Log.w(context.getClass().getSimpleName(), msg);
        }
    }
    public static void e(Object context,String msg) {
        if (ERROR >= LEVEL) {
            Log.e(context.getClass().getSimpleName(), msg);
        }
    }
}
