package com.nanjing.tqlhl.base;

import android.content.Context;
import android.os.Handler;

import com.example.module_ad.advertisement.TTAdManagerHolder;
import com.example.module_tool.utils.SPUtil;
import com.nanjing.tqlhl.utils.ChangeBgUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.utils.SpUtils;
import com.tamsiree.rxkit.RxTool;
import com.umeng.commonsdk.UMConfigure;

import org.litepal.LitePal;

import static com.nanjing.tqlhl.utils.Contents.PLATFORM_KEY;

/**
 * @author: Administrator
 * @date: 2020/6/26 0026
 */
public class BaseApplication extends com.example.module_tool.base.BaseApplication {

    //控制log显示等级
    public static final int LogLevel=0;
    public static boolean isDay;
    public static  Handler  sHandler=null;
    public static  Context  sContext=null;


    private String APP_ID="OVxkIijsKHnVMy5IrvObeA84";
    private String APP_KEY="SVOdAAjAw4fX7rzF9wn74bIH9UI0Y9C6";



    @Override
    public void onCreate() {
        super.onCreate();
        RxTool.init(this);
        SpUtils.init(this);
        LitePal.initialize(this);
        LitePal.getDatabase();
        //友盟
        UMConfigure.preInit(this,"5f96c7712065791705f99284", PackageUtil.getAppMetaData(this,PLATFORM_KEY));
        if (SPUtil.getInstance().getBoolean(Contents.SP_AGREE)) {
            UMConfigure.init(this,UMConfigure.DEVICE_TYPE_PHONE,"5f96c7712065791705f99284");
        }
        //穿山甲广告
        TTAdManagerHolder.init(getApplicationContext());


        isDay = ChangeBgUtil.selectIcon();

        sContext=getApplicationContext();
        sHandler=new Handler();




    }


    public static Context getAppContext() {

        return sContext;
    }

    public static Handler getHandler() {
        return sHandler;
    }
}
