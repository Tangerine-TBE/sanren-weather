package com.nanjing.tqlhl.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_ad.utils.LogUtils;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.just.agentweb.AgentWeb;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.PriceBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;
import com.nanjing.tqlhl.model.bean.WeiXinBean;
import com.nanjing.tqlhl.presenter.Impl.LoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.ThirdlyLoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.WeChatPresentImpl;
import com.nanjing.tqlhl.ui.adapter.VipAdapter;
import com.nanjing.tqlhl.ui.custom.SmoothCheckBox;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.utils.SpUtil;
import com.nanjing.tqlhl.view.ILoginCallback;
import com.nanjing.tqlhl.view.IThirdlyLoginCallback;
import com.nanjing.tqlhl.view.IWeChatCallback;
import com.tamsiree.rxkit.view.RxToast;
import com.tamsiree.rxui.view.dialog.RxDialogShapeLoading;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.activity
 * @class describe
 * @time 2020/9/10 20:11
 * @class describe
 */
public class VipActivity extends BaseMainActivity implements SmoothCheckBox.OnCheckedChangeListener, ILoginCallback, IThirdlyLoginCallback, IWeChatCallback {

    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
    @BindView(R.id.tv_buy_vip)
    TextView tv_buy_vip;
    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;
    @BindView(R.id.rv_vipContainer)
    RecyclerView rv_vipContainer;
    @BindView(R.id.scb_wx)
    SmoothCheckBox scb_wx;
    @BindView(R.id.scb_zfb)
    SmoothCheckBox scb_zfb;
    @BindView(R.id.web_container)
    LinearLayout web_container;

    private LoginPresentImpl mLoginPresent;
    private ThirdlyLoginPresentImpl mThirdlyLoginPresent;
    private WeChatPresentImpl mWeChatPresent;
    private RxDialogShapeLoading mRxDialogLoading;
    private RxDialogShapeLoading mRxDialogShapeLoading;
    private PriceBean mBean;
    private VipAdapter mVipAdapter;
    private List<PriceBean> mPriceBeanList = new ArrayList<>();
    private String mPlay = Contents.ALI_PAY;
    private String mUrl = Contents.PAY_ALI_URL;
    private SharedPreferences mSharedPreferences;
    private boolean mIsLogin;
    private boolean isBuy;
    private int mVipLevel;
    private boolean isPay;
    @Override
    public int getLayoutId() {
        return R.layout.activity_vip;
    }

    @Override
    protected void intView() {

        tv_bar_title.setVisibility(View.VISIBLE);
        tv_bar_title.setText("充值会员");

        mBean = new PriceBean(Contents.VIP_title_13,Contents.VIP_hint_13, Contents.VIP13, Contents.VIP_price_13);
        mPriceBeanList.add(new PriceBean(Contents.VIP_title_13, Contents.VIP_hint_13, Contents.VIP13, Contents.VIP_price_13));
        mPriceBeanList.add(new PriceBean(Contents.VIP_title_12, Contents.VIP_hint_12, Contents.VIP12, Contents.VIP_price_12));
        mPriceBeanList.add(new PriceBean(Contents.VIP_title_3, Contents.VIP_hint_3, Contents.VIP3, Contents.VIP_price_3));
        mPriceBeanList.add(new PriceBean(Contents.VIP_title_1, Contents.VIP_hint_1, Contents.VIP1, Contents.VIP_price_1));


        GridLayoutManager manager = new GridLayoutManager(this, 4);
        rv_vipContainer.setLayoutManager(manager);
        mVipAdapter = new VipAdapter();
        mVipAdapter.setData(mPriceBeanList);
        rv_vipContainer.setAdapter(mVipAdapter);

        scb_zfb.setChecked(true);
        mSharedPreferences = BaseApplication.getAppContext().getSharedPreferences(Contents.USER_INFO, MODE_PRIVATE);
    }


    @Override
    protected void intPresent() {
        mLoginPresent = LoginPresentImpl.getInstance();
        mLoginPresent.registerCallback(this);

        mThirdlyLoginPresent = ThirdlyLoginPresentImpl.getInstance();
        mThirdlyLoginPresent.registerCallback(this);

        mWeChatPresent = WeChatPresentImpl.getInstance();
        mWeChatPresent.registerCallback(this);
    }

    @Override
    protected void setStatusBarColor() {
        MyStatusBarUtil.setColor(this, Color.WHITE);
    }

    @Override
    protected void intEvent() {
        scb_zfb.setOnCheckedChangeListener(this);
        scb_wx.setOnCheckedChangeListener(this);

        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mVipAdapter.setItemClickListener(new VipAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PriceBean priceBean, int position) {
                mBean = priceBean;
            }
        });



        tv_buy_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIsLogin = mSharedPreferences.getBoolean(Contents.USER_IS_LOGIN, false);
                if (mIsLogin) {
                    mVipLevel = mSharedPreferences.getInt(Contents.USER_VIP_LEVEL, 0);
                    if (mVipLevel > 0) {
                        RxToast.info("您已经是VIP了");
                    } else {
                        toPay();
                        isPay = true;
                        isBuy = true;
                        getSharedPreferences(Contents.NO_BACK_SP, MODE_PRIVATE).edit().putBoolean(Contents.NO_BACK, true).apply();
                    }
                } else {
                    startActivity(new Intent(VipActivity.this, LoginActivity.class));
                    getSharedPreferences(Contents.BUY_PAGER_SP, MODE_PRIVATE).edit().putBoolean(Contents.BUY_PAGER, true).apply();
                    isBuy = false;
                }
            }
        });
    }

    /**
     * 生成订单号
     */
    private String getTrade() {
        String channel = PackageUtil.getAppMetaData(this, Contents.PLATFORM_KEY);
        String str = channel.substring(channel.indexOf("_") + 1);
        if (str.equals("360")) {
            str = "SLL";
        }
        str = str.toUpperCase();
        String id = mSharedPreferences.getString(Contents.USER_ID, "");
        return mBean.getVipLevel() + "_" + id + "_" + str + "_" + mPlay + "_" + new Random().nextInt(100000);
    }

    private void toPay() {
        String app_name = Contents.AppNAME;
        String url = mUrl + Contents.TRADE + "=" + getTrade() + "&" + Contents.SUBJECT + "=" + app_name + mBean.getVipLevel() + "&" + Contents.PRICE + "=" + mBean.getPrice() + "&" + Contents.BODY + "=" + app_name + mBean.getTitle();

        LogUtils.i(this,"toPay--------->" + url);
        AgentWeb.with(this)
                .setAgentWebParent(web_container, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(url);


        if (mRxDialogLoading == null) {
            mRxDialogLoading = new RxDialogShapeLoading(this);
        }
        mRxDialogLoading.setCancelable(false);
        mRxDialogLoading.setLoadingText("正在拉起支付页面...");
        mRxDialogLoading.show();

    }
    @Override
    public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
        if (isChecked) {
            if (checkBox==scb_zfb) {
                scb_wx.setChecked(false);
                mPlay = Contents.ALI_PAY;
                mUrl = Contents.PAY_ALI_URL;


            }
            else if (checkBox==scb_wx) {
                scb_zfb.setChecked(false);

                mPlay = Contents.WX_PAY;
                mUrl = Contents.PAY_WX_URL;

            }

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mRxDialogLoading != null) {
            mRxDialogLoading.dismiss();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isBuy) {
            if (mRxDialogShapeLoading == null) {
                mRxDialogShapeLoading=new RxDialogShapeLoading(this);
            }
            mRxDialogShapeLoading.setCancelable(false);
            mRxDialogShapeLoading.setLoadingText("正在校验数据,请勿关闭...");
            mRxDialogShapeLoading.show();


            BaseApplication.getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkVIP();
                    getSharedPreferences(Contents.NO_BACK_SP, MODE_PRIVATE).edit().putBoolean(Contents.NO_BACK, true).apply();
                }

            }, 2000);

        }

    }

    private String mId_type;
    private String mAccount;
    private String mPwd;
    private String mOpenid;
    //检查是否购买了Vip
    private void checkVIP() {
        mId_type = mSharedPreferences.getString(Contents.USER_ID_TYPE, "");
        if (isPay & !TextUtils.isEmpty(mId_type)) {
            mAccount = mSharedPreferences.getString(Contents.USER_ACCOUNT, "");
            mPwd = mSharedPreferences.getString(Contents.USER_PWD, "");
            mOpenid = mSharedPreferences.getString(Contents.USER_THIRDLY_OPENID, "");
            LogUtils.i(this,"onResume--------->" + mId_type + "       " + mAccount + "     " + mPwd + "        " + mOpenid);

            Map<String, String> userInfo = new TreeMap<>();
            userInfo.put(Contents.OPENID, mOpenid);

            if (mId_type.equals(Contents.LOCAL_TYPE)) {
                Map<String, String> map = new TreeMap<>();
                map.put(Contents.MOBILE, mAccount);
                map.put(Contents.PASSWORD, mPwd);
                if (mLoginPresent != null) {
                    mLoginPresent.toLogin(map);
                }
            } else if (mId_type.equals(Contents.QQ_TYPE)) {
                userInfo.put(Contents.TYPE, Contents.QQ_TYPE);
                mThirdlyLoginPresent.toThirdlyLogin(userInfo);
            } else if (mId_type.equals(Contents.WECHAT_TYPE)) {
                userInfo.put(Contents.TYPE, Contents.WECHAT_TYPE);
                mWeChatPresent.toWxLogin(userInfo);
            }

        }

    }

    private void payFinishTip(LoginBean loginBean) {
        LoginBean.DataBean data = loginBean.getData();
        if (isBuy) {
            if (data != null) {
                if (mRxDialogShapeLoading != null) {
                    mRxDialogShapeLoading.dismiss();
                }
                int vip = data.getVip();
                if (vip > 0) {
                    RxToast.success("支付成功");

                } else {
                    RxToast.warning("支付失败");

                }
                isPay = false;

            }
        }

    }


    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        payFinishTip(loginBean);
        Map<String, String> userType = SpUtil.saveUserType(Contents.LOCAL_TYPE, mAccount, mPwd, "");
        SpUtil.saveUserInfo(loginBean, userType);
    }


    @Override
    public void onThirdlyLoginSuccess(LoginBean loginBean) {
        payFinishTip(loginBean);
        Map<String, String> userType = SpUtil.saveUserType(Contents.QQ_TYPE, "", "", mOpenid);
        SpUtil.saveUserInfo(loginBean, userType);
    }
    @Override
    public void onWxLoginSuccess(LoginBean loginBean) {
        payFinishTip(loginBean);
        Map<String, String> userType = SpUtil.saveUserType(Contents.WECHAT_TYPE, "", "", mOpenid);
        SpUtil.saveUserInfo(loginBean, userType);
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

        getSharedPreferences(Contents.NO_BACK_SP, MODE_PRIVATE).edit().putBoolean(Contents.NO_BACK, false).apply();
    }


    @Override
    public void onLoginError() {

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

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

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
    public void onWxLoginError() {

    }
}
