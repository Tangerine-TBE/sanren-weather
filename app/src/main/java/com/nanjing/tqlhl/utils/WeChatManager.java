package com.nanjing.tqlhl.utils;

import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;

public class WeChatManager {

    private IWXAPI mWxapi;
    private String WECHAT_APP_ID="wxd50ba7d3843506b0";
    private static WeChatManager  sInstance;
    public static WeChatManager getInstance() {
        if (sInstance == null) {
            sInstance = new WeChatManager();
        }
        return sInstance;
    }
     private WeChatManager() {
     }

     public IWXAPI getWXApi(Context context) {
         //微信注册

         return mWxapi;
     }


}
