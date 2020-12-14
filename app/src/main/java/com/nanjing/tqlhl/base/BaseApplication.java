package com.nanjing.tqlhl.base;

import android.content.Context;
import android.os.Handler;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.example.module_ad.advertisement.TTAdManagerHolder;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.utils.SpUtils;
import com.tamsiree.rxkit.RxTool;
import com.umeng.commonsdk.UMConfigure;

import org.json.JSONObject;
import org.litepal.LitePal;

/**
 * @author: Administrator
 * @date: 2020/6/26 0026
 */
public class BaseApplication extends com.example.module_tool.base.BaseApplication {

    //控制log显示等级
    public static final int LogLevel=0;

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
        //用户反馈
        FeedbackAPI.init(this,"25822454","7a8bb94331a5141dcea61ecb1056bbbd");
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("appId", Contents.APP_PACKAGE);
            jsonObject.put("appName", Contents.AppNAME);
            jsonObject.put(Contents.VER, PackageUtil.packageCode2(getApplicationContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        FeedbackAPI.setAppExtInfo(jsonObject);

        //友盟
        UMConfigure.init(getApplicationContext(),UMConfigure.DEVICE_TYPE_PHONE,"5f96c7712065791705f99284");
        UMConfigure.setLogEnabled(true);

        //穿山甲广告
        TTAdManagerHolder.init(getApplicationContext());

        //科大
        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID + "=5f22b05a");



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
