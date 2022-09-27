package com.nanjing.tqlhl.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_ad.advertisement.BanFeedHelper;
import com.example.module_ad.utils.SizeUtils;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.SettingBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;
import com.nanjing.tqlhl.model.bean.WeiXinBean;
import com.nanjing.tqlhl.presenter.Impl.LoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.LogoutPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.ThirdlyLoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.WeChatPresentImpl;
import com.nanjing.tqlhl.ui.adapter.SettingAdapter;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.SpUtil;
import com.nanjing.tqlhl.view.ILoginCallback;
import com.nanjing.tqlhl.view.ILogoutCallback;
import com.nanjing.tqlhl.view.IThirdlyLoginCallback;
import com.nanjing.tqlhl.view.IWeChatCallback;
import com.tamsiree.rxkit.view.RxToast;
import com.tamsiree.rxui.view.dialog.RxDialogSureCancel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SettingActivity extends BaseMainActivity implements SettingAdapter.OnItemClickListener, ILoginCallback, IThirdlyLoginCallback, IWeChatCallback, ILogoutCallback {


    @BindView(R.id.setting_container)
    RecyclerView mContainer;
    @BindView(R.id.banner_container)
    FrameLayout mBannerContainer;

    @BindView(R.id.feed_container)
    FrameLayout mFeedContainer;

    @BindView(R.id.login_go)
    TextView mLogin_go;
    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;

    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;
    @BindView(R.id.rl_vip_des)
    RelativeLayout rl_vip_des;
    @BindView(R.id.setting_login)
    RelativeLayout setting_login;
    private BanFeedHelper mBanFeedHelper;


    List<SettingBean> mSettingBeanList = new ArrayList<>();
    private SettingAdapter mSettingAdapter;
    private LoginPresentImpl mLoginPresent;

    private boolean mIsLogin;
    private RxDialogSureCancel mRxDialogSureCancel;
    private SharedPreferences mSharedPreferences;

    private ThirdlyLoginPresentImpl mThirdlyLoginPresent;
    private WeChatPresentImpl mWeChatPresent;
    private RxDialogSureCancel mLogout;
    private LogoutPresentImpl mLogoutPresent;


    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void intPresent() {
        mLogoutPresent = LogoutPresentImpl.getInstance();
        mLogoutPresent.registerCallback(this);
        mSharedPreferences = BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, MODE_PRIVATE);

        mIsLogin = mSharedPreferences.getBoolean(Contents.USER_IS_LOGIN, false);


        if (mIsLogin) {
            TextViewSize(mLogin_go, true);
            mLogin_go.setText(mSharedPreferences.getString(Contents.USER_ID, ""));
        } else {
            TextViewSize(mLogin_go, false);
            mLogin_go.setText("立即登录");
        }

        mLoginPresent = LoginPresentImpl.getInstance();
        mLoginPresent.registerCallback(this);

        mThirdlyLoginPresent = ThirdlyLoginPresentImpl.getInstance();
        mThirdlyLoginPresent.registerCallback(this);

        mWeChatPresent = WeChatPresentImpl.getInstance();
        mWeChatPresent.registerCallback(this);

        mBanFeedHelper = new BanFeedHelper(this, mBannerContainer, mFeedContainer);
        mBanFeedHelper.showAd(BanFeedHelper.AdType.SETTING_PAGE);

    }


    @Override
    protected void intView() {
        mLogout = new RxDialogSureCancel(this);
        mLogout.setContent("你确定要注销此账号吗？");
        mLogout.setSureListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mSharedPreferences.getString(Contents.USER_ID, "0") + "";
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
        tv_bar_title.setVisibility(View.VISIBLE);
        tv_bar_title.setText("设置");
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_city, "城市管理"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_feekback, "用户反馈"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_guanyu, "关于我们"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_banben, "隐私政策"));
        mSettingBeanList.add(new SettingBean(R.mipmap.setting_user, "用户协议"));
        mSettingBeanList.add(new SettingBean(R.drawable.ic_baseline_settings_power_24, "账号注销"));

        mRxDialogSureCancel = new RxDialogSureCancel(this);

        LinearLayoutManager manager = new GridLayoutManager(this, 4);
        mContainer.setLayoutManager(manager);
        mSettingAdapter = new SettingAdapter();
        mContainer.setAdapter(mSettingAdapter);
        mSettingAdapter.setData(mSettingBeanList);
    }


    @Override
    protected void intEvent() {
        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mSettingAdapter.setOnItemClickListener(this);


        setting_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSharedPreferences.getBoolean(Contents.USER_IS_LOGIN, false)) {
                    mRxDialogSureCancel.show();
                } else {
                    startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                    getSharedPreferences(Contents.BUY_PAGER_SP, Context.MODE_PRIVATE).edit().putBoolean(Contents.BUY_PAGER, false).apply();
                }

            }
        });

        mRxDialogSureCancel.setSureListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpUtil.deleteUserInfo();
                mRxDialogSureCancel.dismiss();
                TextViewSize(mLogin_go, false);
                mLogin_go.setText("立即登录");
            }
        });

        mRxDialogSureCancel.setCancelListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxDialogSureCancel.dismiss();
            }
        });

        rl_vip_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, VipActivity.class));
            }
        });

    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, CityManageActivity.class);
                break;
            case 1:
                intent.setClass(this, SendFeedbackActivity.class);
                break;
            case 2:
                intent.setClass(this, AboutActivity.class);
                break;
            case 3:
                intent.setClass(this, PrivacyActivity.class);
                break;
            case 4:
                intent.setClass(this, AgreementActivity.class);
                break;
            case 5:
                if (mSharedPreferences.getBoolean(Contents.USER_IS_LOGIN, false)) {
                    if (!isFinishing()) {
                        mLogout.show();
                    }
                } else {
                    RxToast.warning("您还没有登录！");
                }
                return;
        }
        startActivity(intent);
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        if (mLogin_go != null) {
            TextViewSize(mLogin_go, true);
            mLogin_go.setText(loginBean.getData().getId() + "");
        }
    }

    @Override
    public void onThirdlyLoginSuccess(LoginBean bean) {
        if (mLogin_go != null) {
            TextViewSize(mLogin_go, true);
            mLogin_go.setText(bean.getData().getId() + "");
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

    private void TextViewSize(TextView login_go, boolean isTrue) {
        if (isTrue) {
            ViewGroup.LayoutParams layoutParams = login_go.getLayoutParams();
            layoutParams.height = 100;
            layoutParams.width = 300;
            login_go.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams = login_go.getLayoutParams();
            layoutParams.height = SizeUtils.dip2px(this, 26);
            layoutParams.width = SizeUtils.dip2px(this, 76);
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
            TextViewSize(mLogin_go, true);
            mLogin_go.setText(loginBean.getData().getId() + "");
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
            BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, MODE_PRIVATE).edit().putString(Contents.USER_ID, "").putBoolean(Contents.USER_IS_LOGIN, false).apply();
            RxToast.success("注销成功!");
        }
    }

    @Override
    public void onLogoutError() {
        RxToast.error("注销失败!");
    }
}