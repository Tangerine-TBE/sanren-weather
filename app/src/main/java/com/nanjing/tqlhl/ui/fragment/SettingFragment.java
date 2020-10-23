package com.nanjing.tqlhl.ui.fragment;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_ad.advertisement.BanFeedHelper;
import com.example.module_ad.utils.SizeUtils;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.SettingBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;
import com.nanjing.tqlhl.model.bean.WeiXinBean;
import com.nanjing.tqlhl.presenter.Impl.LoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.LogoutPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.ThirdlyLoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.WeChatPresentImpl;
import com.nanjing.tqlhl.ui.activity.AboutActivity;
import com.nanjing.tqlhl.ui.activity.AgreementActivity;
import com.nanjing.tqlhl.ui.activity.CityManageActivity;
import com.nanjing.tqlhl.ui.activity.LoginActivity;
import com.nanjing.tqlhl.ui.activity.PrivacyActivity;
import com.nanjing.tqlhl.ui.activity.UserFeedbackActivity;
import com.nanjing.tqlhl.ui.adapter.SettingAdapter;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.view.ILoginCallback;
import com.nanjing.tqlhl.view.ILogoutCallback;
import com.nanjing.tqlhl.view.IThirdlyLoginCallback;
import com.nanjing.tqlhl.view.IWeChatCallback;
import com.tamsiree.rxkit.RxBarTool;
import com.tamsiree.rxkit.view.RxToast;
import com.tamsiree.rxui.view.dialog.RxDialogSureCancel;
import com.nanjing.tqlhl.R;
import com.yidian.newssdk.exportui.NewsPortalFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class SettingFragment extends BaseFragment implements SettingAdapter.OnItemClickListener, ILoginCallback, IThirdlyLoginCallback, IWeChatCallback, ILogoutCallback {


    private NewsPortalFragment mNewsPortalFragment;

    @BindView(R.id.toolbar3)
    Toolbar mToolbar;

    @BindView(R.id.setting_container)
    RecyclerView mContainer;

    @BindView(R.id.banner_container)
    FrameLayout mBannerContainer;

    @BindView(R.id.feed_container)
    FrameLayout mFeedContainer;

    @BindView(R.id.login_go)
    TextView mLogin_go;

    @BindView(R.id.login_hint)
    TextView login_hint;

    List<SettingBean> mSettingBeanList = new ArrayList<>();
    private SettingAdapter mSettingAdapter;
    private LoginPresentImpl mLoginPresent;

    private boolean mIsLogin;
    private RxDialogSureCancel mRxDialogSureCancel;
    private SharedPreferences mSharedPreferences;

    private ThirdlyLoginPresentImpl mThirdlyLoginPresent;
    private WeChatPresentImpl mWeChatPresent;
    private Activity mActivity;
    private BanFeedHelper mBanFeedHelper;
    private RxDialogSureCancel mLogout;
    private LogoutPresentImpl mLogoutPresent;
    @Override
    public int getChildLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void intView() {
        mActivity=getActivity();
        setViewState(ViewState.SUCCESS);
        int height = RxBarTool.getStatusBarHeight(getContext());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.topMargin=height;
        mToolbar.setLayoutParams(layoutParams);


        mSettingBeanList.add(new SettingBean(R.mipmap.setting_city, "城市管理"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_feekback, "用户反馈"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_about, "关于我们"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_privacy, "隐私政策"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_agreement, "用户协议"));

        if (PackageUtil.getAppMetaData(getActivity(), Contents.PLATFORM_KEY).equals("_oppo")) {
            mSettingBeanList.add(new SettingBean(R.mipmap.icon_logout, "账号注销"));
        }


        mRxDialogSureCancel = new RxDialogSureCancel(mActivity);
        mLogout = new RxDialogSureCancel(getActivity());
        mLogout.setContent("你确定要注销此账号吗？");

        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        mContainer.setLayoutManager(manager);
        mSettingAdapter = new SettingAdapter();
        mContainer.setAdapter(mSettingAdapter);
        mSettingAdapter.setData(mSettingBeanList);

        mBanFeedHelper = new BanFeedHelper(getActivity(), mBannerContainer, mFeedContainer);
        mBanFeedHelper.showAd(BanFeedHelper.AdType.SETTING_PAGE);

    }

    @Override
    protected void intPresent() {
        mSharedPreferences = BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, mActivity.MODE_PRIVATE);

        mIsLogin = mSharedPreferences.getBoolean(Contents.USER_IS_LOGIN,false);


        if (mIsLogin) {
            TextViewSize(mLogin_go,false);
            mLogin_go.setText(mSharedPreferences.getInt(Contents.USER_ID, 666666) + "");
            login_hint.setVisibility(View.GONE);
        } else {
            TextViewSize(mLogin_go,false);
            mLogin_go.setText("立即登录!!!");
            login_hint.setVisibility(View.VISIBLE);
        }

        mLoginPresent = LoginPresentImpl.getInstance();
        mLoginPresent.registerCallback(this);

        mThirdlyLoginPresent = ThirdlyLoginPresentImpl.getInstance();
        mThirdlyLoginPresent.registerCallback(this);

        mWeChatPresent = WeChatPresentImpl.getInstance();
        mWeChatPresent.registerCallback(this);

        mLogoutPresent = LogoutPresentImpl.getInstance();
        mLogoutPresent.registerCallback(this);
    }


    @Override
    protected void intEvent() {
        mSettingAdapter.setOnItemClickListener(this);

        mLogin_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSharedPreferences.getBoolean(Contents.USER_IS_LOGIN,false)) {
                    mRxDialogSureCancel.show();
                } else {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                }

            }
        });

        mRxDialogSureCancel.setSureListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, mActivity.MODE_PRIVATE).edit().putBoolean(Contents.USER_IS_LOGIN,false).apply();
                mRxDialogSureCancel.dismiss();
                TextViewSize(mLogin_go,false);
                mLogin_go.setText("立即登录!!!");
                login_hint.setVisibility(View.VISIBLE);
            }
        });

        mRxDialogSureCancel.setCancelListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxDialogSureCancel.dismiss();
            }
        });



        mLogout.setSureListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mSharedPreferences.getInt(Contents.USER_ID, 0) + "";
                if (mLogoutPresent != null & !TextUtils.isEmpty("0")) {
                    mLogoutPresent.toLogout(id);
                }
            }
        });

        mLogout.setCancelListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLogout.dismiss();
            }
        });
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(mActivity, CityManageActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(mActivity, UserFeedbackActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(mActivity, AboutActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent.setClass(mActivity, PrivacyActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(mActivity, AgreementActivity.class);
                startActivity(intent);
                break;
            case 5:
                if (mSharedPreferences.getBoolean(Contents.USER_IS_LOGIN, false)) {
                    mLogout.show();
                } else {
                    RxToast.warning("您还没有登录！");
                }
                break;
        }

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        if (mLogin_go != null) {
            TextViewSize(mLogin_go,false);
            mLogin_go.setText(loginBean.getData().getId()+"");
            login_hint.setVisibility(View.GONE);
        }
    }

    @Override
    public void onThirdlyLoginSuccess(LoginBean bean) {
        if (mLogin_go != null) {
            TextViewSize(mLogin_go,false);
            mLogin_go.setText(bean.getData().getId()+"");
            login_hint.setVisibility(View.GONE);
        }
    }

    @Override
    public void onThirdlyLoginError() {

    }

    @Override
    public void onCheckThirdlyRegisterSuccess(RegisterBean bean) {

    }

    @Override
    public void onCheckError() {

    }

    @Override
    public void onThirdlyRegisterSuccess(ThirdlyRegisterBean bean) {

    }

    @Override
    public void onThirdlyRegisterError() {

    }

    private void TextViewSize(TextView login_go,boolean isTrue) {
        if (isTrue) {
            ViewGroup.LayoutParams layoutParams = login_go.getLayoutParams();
            layoutParams.height = 100;
            layoutParams.width = 300;
            login_go.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams = login_go.getLayoutParams();
            layoutParams.height= SizeUtils.dip2px(getActivity(),36);
            layoutParams.width=SizeUtils.dip2px(getActivity(),108);
            login_go.setLayoutParams(layoutParams);
        }


    }

    @Override
    public void onLoginError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }

    @Override
    protected void release() {
        if (mLoginPresent != null) {
            mLoginPresent.unregisterCallback(this);
        }

        if (mThirdlyLoginPresent != null) {
            mThirdlyLoginPresent.unregisterCallback(this);
        }

        if (mWeChatPresent != null) {
            mWeChatPresent.unregisterCallback(this);
        }

        if (mBanFeedHelper != null) {
            mBanFeedHelper.releaseAd();
        }

        if (mLogoutPresent != null) {
            mLogoutPresent.unregisterCallback(this);
        }

    }


    @Override
    public void onWxAccreditSuccess(WeiXinBean weiXinBean) {

    }

    @Override
    public void onWxAccreditError() {

    }

    @Override
    public void onCheckWxRegisterSuccess(RegisterBean bean) {

    }

    @Override
    public void onCheckWxError() {

    }

    @Override
    public void onWxRegisterSuccess(ThirdlyRegisterBean thirdlyRegisterBean) {

    }

    @Override
    public void onWxRegisterError() {

    }

    @Override
    public void onWxLoginSuccess(LoginBean loginBean) {
        if (mLogin_go != null) {
            TextViewSize(mLogin_go,false);
            mLogin_go.setText(loginBean.getData().getId()+"");
            login_hint.setVisibility(View.GONE);
        }
    }

    @Override
    public void onWxLoginError() {

    }

    @Override
    public void onLogoutSuccess(RegisterBean registerBean) {
        if (registerBean.getRet() == 200) {
            mLogout.dismiss();
            TextViewSize(mLogin_go, false);
            mLogin_go.setText("立即登录");
            BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, getActivity().MODE_PRIVATE).edit().putString(Contents.USER_ID, "").putBoolean(Contents.USER_IS_LOGIN, false).apply();
            RxToast.success("注销成功!");
        }
    }

    @Override
    public void onLogoutError() {
        RxToast.error("注销失败!");
    }
}