package com.example.module_ad.advertisement;

import android.app.Activity;
import android.widget.FrameLayout;

import com.example.module_ad.base.IBaseAdBean;
import com.example.module_ad.base.IBaseXXBean;
import com.example.module_ad.base.IShowAdCallback;
import com.example.module_ad.bean.AdBean;
import com.example.module_ad.utils.AdProbabilityUtil;
import com.example.module_ad.utils.Contents;
import com.example.module_ad.utils.SpUtil;

import java.util.Map;

public class BanFeedHelper {
    private String mKTouTiaoBannerKey;
    private String mKTouTiaoSeniorKey;
    private String mKgdtMobSDKAppKey;
    private String mKgdtMobSDKBannerKey;
    private String mKgdtMobSDKNativeKey;
    private boolean mAddToutiaoAdError = false;
    private boolean mAddTengxunAdError = false;
    private boolean mAddTxFeedError = false;
    private boolean mAddTtFeedError = false;


    private Activity mActivity;
    private TXBannerAd mTxBannerAd;
    private TXFeedAd mTxFeedAd;
    private TTBannerAd mTtBannerAd;
    private TTFeedAd mTtFeedAd;
    private FrameLayout mFeedContainer;
    private FrameLayout mBannerContainer;

    private String mNative_percent;
    private String mBanner_percent;
    private IBaseXXBean mBanner_screen;
    private IBaseXXBean mNative_screen;
    private IBaseAdBean mManager_page;


    public BanFeedHelper(Activity activity, FrameLayout banner, FrameLayout feed) {
        this.mActivity = activity;
        this.mBannerContainer = banner;
        this.mFeedContainer = feed;
    }




    public void releaseAd() {
        //穿山甲
        if (mTtFeedAd != null) {
            mTtFeedAd.releaseAd();
        }

        if (mTtBannerAd != null) {
            mTtBannerAd.releaseAd();
        }


        //广点通
        if (mTxBannerAd != null) {
            mTxBannerAd.releaseAd();
        }

        if (mTxFeedAd != null) {
            mTxFeedAd.releaseAd();
        }
    }


  public   enum AdType {
        CITY_MANAGER_PAGE,
        SETTING_PAGE,
        AIRQUALITY_PAGE,
        TEMPERATURE_PAGE,
        HOUSINGLOAN_PAGE,
         TOOL_PAGE
    }

    private void switchAdType(AdType type, AdBean.DataBean dataBean) {
        if (type== AdType.CITY_MANAGER_PAGE) {
            mManager_page = dataBean.getCity_manager_page();
        } else if (type== AdType.SETTING_PAGE) {
            mManager_page = dataBean.getSetting_page();
        } else if (type== AdType.AIRQUALITY_PAGE) {
            mManager_page = dataBean.getAirquality_page();
        } else if (type== AdType.TEMPERATURE_PAGE) {
            mManager_page = dataBean.getTemperature_page();
        } else if (type == AdType.HOUSINGLOAN_PAGE) {
            mManager_page = dataBean.getHousingloan_page();
        } else if (type == AdType.TOOL_PAGE){
            mManager_page=dataBean.getTool_page();
        }
    }

    public void showAd(AdType type) {

        AdBean.DataBean dataBean = SpUtil.getAdState();
        Map<String, String> adKey = SpUtil.getADKey();
        if (dataBean != null & adKey != null) {
            //状态信息

            switchAdType(type, dataBean);

            mBanner_screen = mManager_page.getBaseBanner_screen();
            mNative_screen = mManager_page.getBaseBanner_screen();


            // 显示比例
            mBanner_percent = mBanner_screen.getBaseAd_percent();
            double bannerProbability = AdProbabilityUtil.showAdProbability(mBanner_percent);
            mNative_percent = mNative_screen.getBaseAd_percent();
            double nativeProbability = AdProbabilityUtil.showAdProbability(mNative_percent);

            //穿山甲广告
            mKTouTiaoBannerKey = adKey.get(Contents.KT_OUTIAO_BANNERKEY);
            mKTouTiaoSeniorKey = adKey.get(Contents.KT_OUTIAO_SENIORKEY);

            //广点通广告
            mKgdtMobSDKAppKey = adKey.get(Contents.KGDT_MOBSDK_APPKEY);
            mKgdtMobSDKBannerKey = adKey.get(Contents.KGDT_MOBSDK_BANNERKEY);
            mKgdtMobSDKNativeKey = adKey.get(Contents.KGDT_MOBSDK_NATIVEKEY);

            // TODO: 2020/7/16
            //按比例展示banner
            double random = Math.random();
            if (mBanner_screen.isBaseStatus()) {
                if (random >= bannerProbability) {
                    showTTBannerAd();

                } else {
                    showTXBannerAd();
                }
            }

            //按比例展示feed
            if (mNative_screen.isBaseStatus()) {
                if (random >= nativeProbability) {
                    showTTFeedAd();
                } else {
                    showTXFeedAd();
                }
            }

        }
    }



    private void showTTBannerAd() {
        //TT
        mTtBannerAd = new TTBannerAd(mActivity, mKTouTiaoBannerKey, mBannerContainer);
        mTtBannerAd.showAd();
        mTtBannerAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddToutiaoAdError) {
                    showTXBannerAd();

                }
                mAddToutiaoAdError = true;
            }
        });

    }

    private void showTXBannerAd() {
        //TX
        mTxBannerAd = new TXBannerAd(mActivity, mKgdtMobSDKAppKey, mKgdtMobSDKBannerKey, mBannerContainer);
        mTxBannerAd.showAd();
        mTxBannerAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddTengxunAdError) {
                    showTTBannerAd();

                }
                mAddTengxunAdError = true;
            }
        });
    }


    private void showTTFeedAd() {
        mTtFeedAd = new TTFeedAd(mActivity, mKTouTiaoSeniorKey, mFeedContainer);
        mTtFeedAd.showAd();
        mTtFeedAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddTtFeedError) {
                    showTXFeedAd();

                }
                mAddTtFeedError = true;
            }
        });
    }

    private void showTXFeedAd() {
        mTxFeedAd = new TXFeedAd(mActivity, mKgdtMobSDKAppKey, mKgdtMobSDKNativeKey, mFeedContainer);
        mTxFeedAd.showAd();
        mTxFeedAd.setOnShowError(new IShowAdCallback() {
            @Override
            public void onShowError() {
                if (!mAddTxFeedError) {
                    showTTFeedAd();

                }
                mAddTxFeedError = true;
            }
        });
    }

}
