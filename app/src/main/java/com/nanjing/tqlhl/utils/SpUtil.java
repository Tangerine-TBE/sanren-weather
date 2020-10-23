package com.nanjing.tqlhl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.bean.AdBean;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.R;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: Administrator
 * @date: 2020/7/11 0011
 */
public class SpUtil {

    private static boolean sIsShow;

    public static   Map<String,String>  saveUserType(String type,String number,String pwd,String openId) {
        Map<String,String> mUserInfo=new HashMap<>();
        mUserInfo.put(Contents.USER_ID_TYPE, type);
        mUserInfo.put(Contents.USER_ACCOUNT, number);
        mUserInfo.put(Contents.USER_PWD, pwd);
        mUserInfo.put(Contents.USER_THIRDLY_OPENID, openId);
        return mUserInfo;
    }

    public static void saveUserInfo(LoginBean loginBean,Map<String, String> userInfo) {
        SharedPreferences sharedPreferences = BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, BaseApplication.getAppContext().MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(Contents.USER_IS_LOGIN, true);
        edit.putString(Contents.USER_ID, loginBean.getData().getId()+"");
        edit.putInt(Contents.USER_VIP_LEVEL, loginBean.getData().getVip());
        edit.putString(Contents.USER_VIP_TIME, loginBean.getData().getVipexpiretime());

        edit.putString(Contents.USER_ID_TYPE, userInfo.get(Contents.USER_ID_TYPE));
        edit.putString(Contents.USER_ACCOUNT,  userInfo.get(Contents.USER_ACCOUNT));
        edit.putString(Contents.USER_PWD,  userInfo.get(Contents.USER_PWD));
        edit.putString(Contents.USER_THIRDLY_OPENID,  userInfo.get(Contents.USER_THIRDLY_OPENID));

        edit.putLong(Contents.USER_LOGIN_TIME,System.currentTimeMillis());

        edit.apply();
    }

    public static void deleteUserInfo() {
        BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO,BaseApplication.getAppContext().MODE_PRIVATE).edit()
                .putString(Contents.USER_ID, "")
                .putInt(Contents.USER_VIP_LEVEL, 0)
                .putString(Contents.USER_VIP_TIME, "")
                .putString(Contents.USER_ID_TYPE, "")
                .putString(Contents.USER_ACCOUNT, "")
                .putString(Contents.USER_PWD, "")
                .putString(Contents.USER_THIRDLY_OPENID, "")
                .putBoolean(Contents.USER_IS_LOGIN, false)
                .apply();
    }

    private static final int sLoginTime=30;
    public static boolean loginTimeOut() {
        SharedPreferences sharedPreferences = BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, BaseApplication.getAppContext().MODE_PRIVATE);
        long startTime = sharedPreferences.getLong(Contents.USER_LOGIN_TIME, 0);
        boolean isLogin = sharedPreferences.getBoolean(Contents.USER_IS_LOGIN, false);
        if (isLogin&startTime!=0) {
            Date startDate = new Date(startTime);
            Date stopDate = new Date(System.currentTimeMillis());
            // 这样得到的差值是微秒级别
            long diff = stopDate.getTime() - startDate.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            if (days>sLoginTime) {
                deleteUserInfo();
                return true;
            }
        }
        return false;
    }
    public static AdBean.DataBean getAdState() {
        SharedPreferences ad_info = BaseApplication.getAppContext().getSharedPreferences(Contents.AD_INFO_SP, Context.MODE_PRIVATE);
        String ad = ad_info.getString(Contents.AD_INFO, "");

        if (!TextUtils.isEmpty(ad)) {
            AdBean.DataBean dataBean = JSON.parseObject(ad, AdBean.DataBean.class);
            return dataBean;
        }
        return  null;
    }



    public static  Map<String, String>  getADKey() {
        Map<String, String> map = new HashMap<>();
        SharedPreferences ad_info = BaseApplication.getAppContext().getSharedPreferences(Contents.AD_INFO_SP, Context.MODE_PRIVATE);
        String ad = ad_info.getString(Contents.AD_INFO, "");
        if (!TextUtils.isEmpty(ad)) {
            AdBean.DataBean dataBean = JSON.parseObject(ad, AdBean.DataBean.class);
            //广告信息
            AdBean.DataBean.AdvertisementBean advertisement = dataBean.getAdvertisement();
            //穿山甲广告
            String kTouTiaoAppKey = advertisement.getKTouTiaoAppKey();
            String kTouTiaoKaiPing = advertisement.getKTouTiaoKaiPing();
            String kTouTiaoBannerKey = advertisement.getKTouTiaoBannerKey();
            String kTouTiaoChaPingKey = advertisement.getKTouTiaoChaPingKey();
            String kTouTiaoJiLiKey = advertisement.getKTouTiaoJiLiKey();
            String kTouTiaoSeniorKey = advertisement.getKTouTiaoSeniorKey();
            map.put(Contents.KT_OUTIAO_APPKEY, kTouTiaoAppKey);
            map.put(Contents.KT_OUTIAO_KAIPING, kTouTiaoKaiPing);
            map.put(Contents.KT_OUTIAO_BANNERKEY, kTouTiaoBannerKey);
            map.put(Contents.KT_OUTIAO_CHAPINGKEY, kTouTiaoChaPingKey);
            map.put(Contents.KT_OUTIAO_JILIKEY, kTouTiaoJiLiKey);
            map.put(Contents.KT_OUTIAO_SENIORKEY, kTouTiaoSeniorKey);

            //广点通广告
            String kgdtMobSDKAppKey = advertisement.getKGDTMobSDKAppKey();
            String kgdtMobSDKChaPingKey = advertisement.getKGDTMobSDKChaPingKey();
            String kgdtMobSDKKaiPingKey = advertisement.getKGDTMobSDKKaiPingKey();
            String kgdtMobSDKBannerKey = advertisement.getKGDTMobSDKBannerKey();
            String kgdtMobSDKNativeKey = advertisement.getKGDTMobSDKNativeKey();
            String kgdtMobSDKJiLiKey = advertisement.getKGDTMobSDKJiLiKey();

            map.put(Contents.KGDT_MOBSDK_APPKEY, kgdtMobSDKAppKey);
            map.put(Contents.KGDT_MOBSDK_CHAPINGKEY, kgdtMobSDKChaPingKey);
            map.put(Contents.KGDT_MOBSDK_KAIPINGKEY, kgdtMobSDKKaiPingKey);
            map.put(Contents.KGDT_MOBSDK_BANNERKEY, kgdtMobSDKBannerKey);
            map.put(Contents.KGDT_MOBSDK_NATIVEKEY, kgdtMobSDKNativeKey);
            map.put(Contents.KGDT_MOBSDK_JILIKEY, kgdtMobSDKJiLiKey);

            return map;
        }
        return null;
    }






    public static void changePwdShow(EditText mPassWord_edit, ImageView mShowPassWord_image, boolean isShow) {
        if (isShow) {
            mShowPassWord_image.setImageResource(R.mipmap.pwd_show_select);
            mPassWord_edit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            mShowPassWord_image.setImageResource(R.mipmap.pwd_show_normal);
            mPassWord_edit.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public static void changePwdShow2(EditText mPassWord_edit, ImageView mShowPassWord_image, boolean isShow) {
        if (isShow) {
            mShowPassWord_image.setImageResource(R.mipmap.pwd_show_select);
            mPassWord_edit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            mShowPassWord_image.setImageResource(R.mipmap.pwd_show_normal);
            mPassWord_edit.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
