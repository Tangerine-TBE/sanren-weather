package com.example.module_ad.advertisement;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.module_ad.base.IShowAdCallback;
import com.example.module_ad.bean.AdBean;
import com.example.module_ad.utils.AdProbabilityUtil;
import com.example.module_ad.utils.Contents;
import com.example.module_ad.utils.LogUtils;
import com.example.module_ad.utils.SpUtil;
import com.example.module_ad.utils.StartActivityUtil;
import com.example.module_base.MainBaseApplication;

import java.util.Map;

public class SplashHelper {

    private Activity mActivity;
    private FrameLayout mSplashContainer;
    private Class mClass;
    private TTSplashAd mTtSplashAd;
    private TXSplashAd mTxSplashAd;
    private boolean mAddToutiaoAdError = false;
    private boolean mAddTengxunAdError = false;

    public SplashHelper(Activity activity,FrameLayout frameLayout,Class  aClass) {
        this.mActivity=activity;
        this.mSplashContainer=frameLayout;
        this.mClass=aClass;
    }

    public void showAd() {
        //广告key
        AdBean.DataBean data = SpUtil.getAdState();
        Map<String, String> adKey = SpUtil.getADKey();
        if (data != null&&adKey!=null) {
        AdBean.DataBean.StartPageBean.SpreadScreenBean spread_screen = data.getStart_page().getSpread_screen();
        //显示状态
        boolean status = spread_screen.isStatus();
        //显示比例
        String ad_percent = spread_screen.getAd_percent();
        final double probability = AdProbabilityUtil.showAdProbability(ad_percent);
            if (status) {
                //广点通开屏
                final String GDTAppKey = adKey.get(Contents.KGDT_MOBSDK_APPKEY);
                final String kaiPingKey = adKey.get(Contents.KGDT_MOBSDK_KAIPINGKEY);
                //穿山甲开屏
                final String touTiaoKaiPing = adKey.get(Contents.KT_OUTIAO_KAIPING);

                MainBaseApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        double random = Math.random();
                        mSplashContainer.setVisibility(View.VISIBLE);
                        if (random > probability) {
                            showTtSplashAd(touTiaoKaiPing, GDTAppKey, kaiPingKey);

                        } else {
                            showTxSplashAd(GDTAppKey, kaiPingKey, touTiaoKaiPing);

                        }
                        LogUtils.i(this, "onLoadAdMsgSuccess-------22222222222222222222-------------->" + random);
                    }
                });
            } else {
                StartActivityUtil.startActivity(mActivity, mClass, true);
            }

        }else {
            StartActivityUtil.startActivity(mActivity, mClass, true);
        }
    }

    // 加载头条广告
    private void showTtSplashAd(final String touTiaoKaiPing,final String GDTAppKey,final String kaiPingKey) {

        // TODO: 2020/7/17
        mTtSplashAd = new TTSplashAd(mActivity, touTiaoKaiPing, mSplashContainer, true,mClass);
        mTtSplashAd.showAd();
        mTtSplashAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddToutiaoAdError) {
                    showTxSplashAd(GDTAppKey,kaiPingKey,touTiaoKaiPing);
                    mAddToutiaoAdError = true;
                    showADError();
                }



            }
        });


    }

    // 加载腾讯广告
    private void showTxSplashAd(final String GDTAppKey,final String kaiPingKey,final String touTiaoKaiPing) {
        // TODO: 2020/7/17
        mTxSplashAd = new TXSplashAd(mActivity, GDTAppKey, kaiPingKey, mSplashContainer, true,mClass);
        mTxSplashAd.showAd();
        mTxSplashAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddTengxunAdError) {
                    showTtSplashAd(touTiaoKaiPing,GDTAppKey,kaiPingKey);
                    mAddTengxunAdError=true;
                    showADError();
                }




            }
        });

    }

    //都加载失败
    private void showADError() {
        if (mAddTengxunAdError&mAddToutiaoAdError) {
            StartActivityUtil.startActivity(mActivity, mClass, true);
        }
    }
}
