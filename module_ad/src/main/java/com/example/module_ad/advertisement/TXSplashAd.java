package com.example.module_ad.advertisement;

import android.app.Activity;
import android.content.Intent;
import android.widget.FrameLayout;

import com.example.module_ad.utils.CommonUtil;
import com.example.module_ad.utils.LogUtils;
import com.example.module_base.MainBaseApplication;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.AdError;

public class TXSplashAd extends AdWatcher{



    private SplashAD mSplashAD;
    private Activity mActivity;
    private String mAdId;
    private boolean mIsClose;
    private Class mClass;
    private FrameLayout mSplashContainer;
    private int outTime=2000;


    public TXSplashAd(Activity activity, String appid, String adid, FrameLayout frameLayout, boolean isClose, Class aClass) {
        this.mActivity=activity;
        this.mAdId=adid;
        this.mSplashContainer=frameLayout;
        this.mIsClose=isClose;
        this.mClass=aClass;
        GDTADManager.getInstance().initWith(activity, appid);
    }


    @Override
    public void showAd() {
        if (!CommonUtil.isNetworkAvailable(MainBaseApplication.getApplication())) {
            return;
        }
        mSplashAD = new SplashAD(mActivity, mAdId, new SplashADListener() {
            @Override
            public void onADDismissed() {
                LogUtils.i(TXSplashAd.this, "广告显示完毕---------------------->");
                goToMainActivity(mIsClose);
            }

            @Override
            public void onNoAD(AdError adError) {
                LogUtils.i(TXSplashAd.this, "广告加载失败---------------------->");
                if (mIShowAdCallback != null) {
                    mIShowAdCallback.onShowError();
                }

            }

            @Override
            public void onADPresent() {
                LogUtils.i(TXSplashAd.this, "广告加载成功---------------------->");

            }

            @Override
            public void onADClicked() {
                LogUtils.i(TXSplashAd.this, "广告被点击---------------------->");
            }

            @Override
            public void onADTick(long millisUntilFinished) {
                LogUtils.i(TXSplashAd.this, "广告倒计时---------------------->" + millisUntilFinished);
            }

            @Override
            public void onADExposure() {

            }

            @Override
            public void onADLoaded(long l) {

            }
        }, outTime);

        mSplashAD.fetchAndShowIn(mSplashContainer);
    }


    /**
     * 跳转到主页面
     */
    private void goToMainActivity(boolean b) {
        if (b) {
            mActivity.startActivity(new Intent(mActivity,mClass));
        }
        mActivity.finish();
    }
}
