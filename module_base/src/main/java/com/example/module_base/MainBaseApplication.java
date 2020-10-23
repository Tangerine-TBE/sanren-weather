package com.example.module_base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;


/**
 * Author : Gupingping
 * Date : 2019/1/9
 * QQ : 464955343
 */
public class MainBaseApplication extends Application {

    public static MainBaseApplication application;
    public static Handler sHandler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
        //MultiDex分包方法 必须最先初始化
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sHandler = new Handler(Looper.getMainLooper());

    }

    public static MainBaseApplication getApplication() {
        return application;
    }

    public static Handler getHandler() {
        return sHandler;
    }



}

