package com.example.module_ad.utils;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 铭少
 * @date: 2020/9/12 0012
 * @description：
 */
public class ActivityManager {

    private static List<Activity> sActivityList=new ArrayList<>();

    public static void addActivity(Activity activity) {
        sActivityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        sActivityList.remove(activity);
    }

    public static void removeAllActivity() {
        for (Activity activity : sActivityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        sActivityList.clear();
    }

    public static void exitApp(Context context) {
        removeAllActivity();
        android.app.ActivityManager systemService = (android.app.ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        systemService.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }




}
