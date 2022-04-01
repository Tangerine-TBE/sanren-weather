package com.example.module_ad.advertisement;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;

import com.example.module_ad.utils.CommonUtil;
import com.example.module_ad.utils.LogUtils;
import com.example.module_base.MainBaseApplication;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.util.AdError;


public class TXBannerAd  extends AdWatcher{

    private UnifiedBannerView bv;
    private Activity mActivity;
    private String mAdId;
    private FrameLayout mBannerContainer;

    public TXBannerAd(Activity activity,String appid, String adid, FrameLayout frameLayout) {
        this.mActivity=activity;
        this.mAdId=adid;
        this.mBannerContainer=frameLayout;
        GDTAdSdk.init(activity.getApplication(), appid);
    }

    @Override
    public void showAd() {
        if (getBanner()!=null) {
            getBanner().loadAD();
        }
    }

    private UnifiedBannerView getBanner() {
        if (CommonUtil.isNetworkAvailable(MainBaseApplication.getApplication())) {

        if(this.bv != null){
            mBannerContainer.removeView(bv);
            bv.destroy();
        }

        this.bv = new UnifiedBannerView(mActivity, mAdId, new UnifiedBannerADListener() {
            @Override
            public void onNoAD(AdError adError) {
                LogUtils.i(TXBannerAd.this,   "广告加载失败----------------->" );
                if (mIShowAdCallback != null) {
                    mIShowAdCallback.onShowError();
                }

            }

            @Override
            public void onADReceive() {

                LogUtils.i(TXBannerAd.this,   "广告加载成功回调----------------->" );
            }

            @Override
            public void onADExposure() {
                LogUtils.i(TXBannerAd.this,   "onADExposure----------------->" );
            }

            @Override
            public void onADClosed() {
                LogUtils.i(TXBannerAd.this,   "当广告关闭 ----------------->" );
                mBannerContainer.setVisibility(View.GONE);
            }

            @Override
            public void onADClicked() {
                LogUtils.i(TXBannerAd.this,   "当广告点击----------------->" );
            }

            @Override
            public void onADLeftApplication() {
                LogUtils.i(TXBannerAd.this,   "由于广告点击离开 APP 时调用----------------->" );
            }
        });

        // 不需要传递tags使用下面构造函数
        // this.bv = new UnifiedBannerView(this, Constants.APPID, posId, this);
        mBannerContainer.addView(bv, getUnifiedBannerLayoutParams());
        mBannerContainer.setVisibility(View.VISIBLE);
        return this.bv;
        }
        return null;
    }

    private FrameLayout.LayoutParams getUnifiedBannerLayoutParams() {
        Point screenSize = new Point();
        mActivity.getWindowManager().getDefaultDisplay().getSize(screenSize);
        return new FrameLayout.LayoutParams(screenSize.x,  Math.round(screenSize.x / 6.4F));
    }

    @Override
    public void releaseAd() {
        if (bv != null) {
            bv.destroy();
        }
    }

}
