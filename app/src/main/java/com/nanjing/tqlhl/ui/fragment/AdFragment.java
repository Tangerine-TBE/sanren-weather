package com.nanjing.tqlhl.ui.fragment;

import android.content.Context;
import android.widget.FrameLayout;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.advertisement.SplashHelper;
import com.example.module_ad.bean.AdBean;
import com.example.module_ad.utils.CommonUtil;
import com.example.module_ad.utils.LogUtils;
import com.example.module_ad.utils.SpUtil;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.presenter.Impl.AdPresentImpl;
import com.nanjing.tqlhl.ui.activity.MainActivity;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.ImmersionUtil;
import com.nanjing.tqlhl.view.IAdCallback;

import java.util.Map;

import butterknife.BindView;

public class AdFragment extends BaseFragment implements IAdCallback {


    @BindView(R.id.ad_container)
    FrameLayout mSplashContainer;
    private boolean isShow;


    private AdPresentImpl mAdPresent;
    private SplashHelper mSplashHelper;

    @Override
    public int getChildLayout() {
        return R.layout.fragment_ad;
    }


    @Override
    protected void intView() {
        setViewState(ViewState.SUCCESS);
        mSplashHelper = new SplashHelper(getActivity(), mSplashContainer, MainActivity.class);
    }

    @Override
    protected void intPresent() {
        mAdPresent = AdPresentImpl.getInstance();
        mAdPresent.registerCallback(this);
        if (CommonUtil.isNetworkAvailable(getContext())) {
            AdBean.DataBean data = SpUtil.getAdState();
            Map<String, String> adKey = SpUtil.getADKey();
            if (data != null || adKey != null) {
                mSplashHelper.showAd();
                isShow=true;
            }

                if (mAdPresent != null) {
                    mAdPresent.toRequestAd();
            }
        } else {
            ImmersionUtil.startActivity(getContext(), MainActivity.class, true);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onLoadAdMsgSuccess(AdBean adBean) {
        LogUtils.i(this, "onLoadAdMsgSuccess-------1111111111111111111111111-------------->" + Thread.currentThread().getName());
        if (adBean != null) {
            AdBean.DataBean data = adBean.getData();
            LogUtils.i(this, "77777777777777-------------->" + data.getAdvertisement().toString());
            String ad = JSON.toJSONString(data);
            BaseApplication.getAppContext().getSharedPreferences(Contents.AD_INFO_SP, Context.MODE_PRIVATE).edit().putString(Contents.AD_INFO, ad).apply();
            if (!isShow) {
                mSplashHelper.showAd();
            }
        }
    }


    @Override
    public void onLoadAdMsgError() {
        ImmersionUtil.startActivity(getActivity(),MainActivity.class,true);
    }

    @Override
    protected void release() {
        if (mAdPresent != null) {
            mAdPresent.unregisterCallback(this);
        }
    }


}
