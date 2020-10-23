package com.nanjing.tqlhl.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import com.nanjing.tqlhl.base.BaseMainActivity;

public class ImmersionUtil {

    private static long lastClickTime;

    public static void setImmersion(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView =activity. getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }


    public static void setFullWindow(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);

    }


    //页面跳转
    public static void startActivity(Context c, Class<? extends BaseMainActivity> clz, boolean ifFinish) {
        Intent intent = new Intent(c, clz);
        c.startActivity(intent);
        if (ifFinish) {
            ((Activity) c).finish();
        }
    }


    //判断button是否被快速点击
    public static boolean isFastClick(long ClickIntervalTime) {
        long ClickingTime = System.currentTimeMillis();

        if ( ClickingTime - lastClickTime < ClickIntervalTime) {
            return true;
        }
        lastClickTime = ClickingTime;


        return false;
    }

}
