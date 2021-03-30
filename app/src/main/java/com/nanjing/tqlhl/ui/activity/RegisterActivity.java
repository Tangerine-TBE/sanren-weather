package com.nanjing.tqlhl.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.presenter.Impl.LoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.RegisterPresentImpl;
import com.nanjing.tqlhl.ui.custom.LoginView;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.Md5Util;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.utils.SpUtil;
import com.nanjing.tqlhl.view.ILoginCallback;
import com.nanjing.tqlhl.view.IRegisterCallback;
import com.tamsiree.rxkit.view.RxToast;
import com.tamsiree.rxui.view.dialog.RxDialogLoading;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;

;

public class RegisterActivity extends BaseMainActivity implements IRegisterCallback, ILoginCallback {

    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;

    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;

    @BindView(R.id.register_view)
    LoginView mRegisterView;

    private RegisterPresentImpl mRegisterPresent;
    private RxDialogLoading mRxDialogLoading;
    private LoginPresentImpl mLoginPresent;

    private String phoneNumber;
    private String pwdNumber;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void intView() {
        tv_bar_title.setText("注册");

        mRxDialogLoading = new RxDialogLoading(this);
    }


    @Override
    protected void intPresent() {
        mRegisterPresent = RegisterPresentImpl.getInstance();
        mRegisterPresent.registerCallback(this);

        mLoginPresent = LoginPresentImpl.getInstance();
        mLoginPresent.registerCallback(this);
    }

    @Override
    protected void intEvent() {
        //关闭页面
        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mRegisterView.setonStateClickListener(new LoginView.onStateClickListener() {

            //获取验证码
            @Override
            public void getVerificationCodeClick(String number) {
                if (!TextUtils.isEmpty(number)) {
                    if (mRegisterPresent != null) {
                        mRegisterPresent.getVerificationCode(number);
                        LogUtils.i(RegisterActivity.this, "---------------------->" + number);
                    }
                } else {
                    RxToast.normal(RegisterActivity.this, "请输入手机号码").show();
                }
            }

            //注册
            @Override
            public void onLoginClick(String phone, String code, String password) {
                phoneNumber = phone;
                pwdNumber = Md5Util.md5(password);
                Map<String, String> map = new TreeMap<>();
                map.put(Contents.MOBILE, phone);
                map.put(Contents.PASSWORD, password);
                map.put(Contents.CODE, code);
                map.put(Contents.PACKAGE, Contents.APP_PACKAGE);
                map.put(Contents.PLATFORM, PackageUtil.getAppMetaData(RegisterActivity.this, Contents.PLATFORM_KEY));
                if (mRegisterPresent != null) {
                    mRegisterPresent.registerNumber(map);
                }
            }
        });

    }

    //获取验证码成功
    @Override
    public void onLoadCode() {
        RxToast.normal(this, "验证码已发送").show();
    }


    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        int ret = registerBean.getRet();
            if (ret == 200) {
                Map<String, String> loginMap = new TreeMap<>();
                loginMap.put(Contents.MOBILE, phoneNumber);
                loginMap.put(Contents.PASSWORD, pwdNumber);
                if (mLoginPresent != null) {
                    mLoginPresent.toLogin(loginMap);
                }
                RxToast.success(this, "注册成功").show();
            } else {
                mRxDialogLoading.dismiss();
                RxToast.error(this, registerBean.getMsg()).show();
            }

    }

    @Override
    public void onLoading() {
        mRxDialogLoading.setLoadingColor(ColorUtil.COLOR_TOOLBAR);
        mRxDialogLoading.setCancelable(false);
        mRxDialogLoading.show();

    }

    @Override
    protected void release() {
        if (mRegisterPresent != null && mLoginPresent != null) {
            mRegisterPresent.unregisterCallback(this);
            mLoginPresent.unregisterCallback(this);
        }


    }

    @Override
    public void onError() {
        mRxDialogLoading.dismiss();
        RxToast.error(this,"登陆失败").show();
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Map<String, String> userType = SpUtil.saveUserType(Contents.LOCAL_TYPE, phoneNumber, pwdNumber, "");
        SpUtil.saveUserInfo(loginBean, userType);
        mRxDialogLoading.dismiss();
        finish();
    }

    @Override
    public void onLoginError() {
        mRxDialogLoading.dismiss();
    }

}