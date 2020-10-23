package com.example.module_tool.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.module_ad.advertisement.TTAdManagerHolder;
import com.example.module_base.MainBaseApplication;
import com.example.module_tool.utils.SPUtil;


/**
 * Author : Gupingping
 * Date : 2019/1/9
 * QQ : 464955343
 */
public class BaseApplication extends MainBaseApplication {
    public static BaseApplication application;
    public static Handler handler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
        //MultiDex分包方法 必须最先初始化
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(Looper.getMainLooper());
        SPUtil.init(this);
        //穿山甲广告
        TTAdManagerHolder.init(getApplicationContext());

    }

    public static BaseApplication getApplication() {
        return application;
    }


}

