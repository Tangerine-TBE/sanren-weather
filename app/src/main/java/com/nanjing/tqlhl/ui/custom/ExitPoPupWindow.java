package com.nanjing.tqlhl.ui.custom;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.example.module_ad.advertisement.FeedHelper;
import com.example.module_ad.utils.ActivityManager;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.tamsiree.rxkit.RxDeviceTool;
import com.nanjing.tqlhl.R;


public class ExitPoPupWindow  extends PopupWindow {

    private final View mView;
    private Button mCancelBt;
    private Button mSureBt;
    private  Activity mActivity;
    private FrameLayout mAdContainer;


    public ExitPoPupWindow(Activity activity) {
        super(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.mActivity=activity;
        int screenHeight = RxDeviceTool.getScreenHeight(BaseApplication.getAppContext());
        mView = LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.diy_exit_popup_window, null);
        setContentView(mView);
        setHeight(screenHeight);
        setBackgroundDrawable(new ColorDrawable(ColorUtil.TRANSPARENT));
        setFocusable(true);
        setOutsideTouchable(false);
        setAnimationStyle(R.style.ExitPopup);

        initView();
        initEvent();
        mFeedHelper = new FeedHelper(activity, mAdContainer);
    }

    private void initEvent() {
        mCancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                mAdContainer.removeAllViews();
            }
        });

        mSureBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
             //   ActivityManager.exitApp(mActivity);
                ActivityManager.removeAllActivity();
                if (mFeedHelper != null) {
                    mFeedHelper.releaseAd();
                }
            }
        });

    }

    private void initView( ) {
        mCancelBt = mView.findViewById(R.id.cancel);
        mSureBt = mView.findViewById(R.id.sure);
        mAdContainer = mView.findViewById(R.id.exitAd_container);
    }

    private FeedHelper mFeedHelper;

    public void popupShowAd(Activity activity) {

        mFeedHelper.showAd();
    }



}