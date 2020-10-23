package com.example.module_ad.advertisement;

import android.app.Activity;
import android.widget.FrameLayout;

import com.example.module_ad.base.IShowAdCallback;
import com.example.module_ad.bean.AdBean;
import com.example.module_ad.utils.AdProbabilityUtil;
import com.example.module_ad.utils.Contents;
import com.example.module_ad.utils.SpUtil;

import java.util.Map;

public class FeedHelper {

    private Activity mActivity;
    private FrameLayout mFeedAdContainer;
    private boolean mAddToutiaoAdError=false;
    private boolean mAddTengxunAdError=false;
    private TTFeedAd mTTFeedAd;
    private TXFeedAd mTxFeedAd;

    public FeedHelper(Activity activity,FrameLayout frameLayout) {
        this.mActivity=activity;
        this.mFeedAdContainer=frameLayout;
    }


    public void showAd() {
        //拿到缓存接口信息
        AdBean.DataBean dataBean = SpUtil.getAdState();
        Map<String, String> adKey = SpUtil.getADKey();
        if (dataBean != null&adKey!=null) {
            AdBean.DataBean.HomePageBean.NativeScreenBean native_screen = dataBean.getHome_page().getNative_screen();
            //判断时候展示广告
            boolean status = native_screen.isStatus();
            String ad_percent = native_screen.getAd_percent();
            double probability = AdProbabilityUtil.showAdProbability(ad_percent);
            if (status) {
                //穿山甲
                String kTouTiaoSeniorKey = adKey.get(Contents.KT_OUTIAO_SENIORKEY);
                //广点通
                String kgdtMobSDKAppKey =  adKey.get(Contents.KGDT_MOBSDK_APPKEY);
                String kgdtMobSDKNativeKey = adKey.get(Contents.KGDT_MOBSDK_NATIVEKEY);
                double random = Math.random();
                if (random >probability) {
                    //初始化广告
                    showTTFeedAd(kTouTiaoSeniorKey,kgdtMobSDKAppKey,kgdtMobSDKNativeKey);

                } else {
                    showTXFeedAd(kgdtMobSDKAppKey,kgdtMobSDKNativeKey,kTouTiaoSeniorKey);
                }
            }
        }
    }


    //头条
    private void showTTFeedAd(final String kTouTiaoSeniorKey, final String kgdtMobSDKAppKey, final String kgdtMobSDKNativeKey) {
        mTTFeedAd = new TTFeedAd(mActivity, kTouTiaoSeniorKey, mFeedAdContainer);
        mTTFeedAd.showAd();
        mTTFeedAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddToutiaoAdError) {
                    showTXFeedAd(kgdtMobSDKAppKey,kgdtMobSDKNativeKey,kTouTiaoSeniorKey);
                }
                mAddToutiaoAdError=true;
            }
        });

    }

    //腾讯
    private void showTXFeedAd(final String kgdtMobSDKAppKey, String kgdtMobSDKNativeKey, final String kTouTiaoSeniorKey) {
        mTxFeedAd = new TXFeedAd(mActivity, kgdtMobSDKAppKey, kgdtMobSDKNativeKey, mFeedAdContainer);
        mTxFeedAd.showAd();
        mTxFeedAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddTengxunAdError) {
                    showTTFeedAd(kTouTiaoSeniorKey,kgdtMobSDKAppKey,kTouTiaoSeniorKey);
                }
                mAddTengxunAdError=true;
            }
        });

    }

    public void releaseAd() {
        if (mTTFeedAd != null) {
            mTTFeedAd.releaseAd();
        }

        if (mTxFeedAd!=null) {
            mTxFeedAd.releaseAd();
        }
    }


}
