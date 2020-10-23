package com.nanjing.tqlhl.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.presenter.Impl.FindPwdPresentImpl;
import com.nanjing.tqlhl.ui.custom.LoginView;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.Md5Util;
import com.nanjing.tqlhl.view.IFindPwdCallback;
import com.tamsiree.rxkit.view.RxToast;
import com.tamsiree.rxui.view.dialog.RxDialogLoading;
import com.nanjing.tqlhl.R;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;

public class ChangePwdActivity extends BaseMainActivity implements IFindPwdCallback {


    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;


    @BindView(R.id.find_pwd_view)
    LoginView mFindPwdView;

    private FindPwdPresentImpl mFindPwdPresent;

    private RxDialogLoading mRxDialogLoading;


    @Override
    public int getLayoutId() {
        return R.layout.activity_change_pwd;
    }

    @Override
    protected void intView() {

        mFindPwdView.setLoginBtText(getString(R.string.find_word_tx));
    }


    @Override
    protected void intPresent() {
        mFindPwdPresent = FindPwdPresentImpl.getInstance();
        mFindPwdPresent.registerCallback(this);
    }

    @Override
    protected void intEvent() {
        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mFindPwdView.setonStateClickListener(new LoginView.onStateClickListener() {
            @Override
            public void getVerificationCodeClick(String number) {
                if (mFindPwdPresent != null) {
                    mFindPwdPresent.getVerificationCode(number);
                }
            }

            @Override
            public void onLoginClick(String phone, String code, String password) {
                String md5Pwd= Md5Util.md5(password);
                Map<String, String> map = new TreeMap<>();
                map.put(Contents.CODE, code);
                map.put(Contents.MOBILE, phone);
                map.put(Contents.PASSWORD, md5Pwd);
                if (mFindPwdPresent != null) {
                    mFindPwdPresent.findPwd(map);
                }
            }
        });

    }


    @Override
    public void onLoadCode() {
        RxToast.success(this, "验证码已发送").show();
    }

    @Override
    public void onFindPwdSuccess(RegisterBean registerBean) {
        mRxDialogLoading.dismiss();
        int ret = registerBean.getRet();
        if (ret == 200) {
            RxToast.success(this, "修改密码成功").show();
            finish();
        } else {
            RxToast.error(this, registerBean.getMsg()).show();
        }



    }

    @Override
    public void onLoading() {
        mRxDialogLoading = new RxDialogLoading(this);
        mRxDialogLoading.setCancelable(false);
        mRxDialogLoading.show();

    }

    @Override
    public void onError() {
        mRxDialogLoading.dismiss();
    }

    @Override
    protected void release() {
        if (mFindPwdPresent != null) {
            mFindPwdPresent.unregisterCallback(this);
        }
    }
}