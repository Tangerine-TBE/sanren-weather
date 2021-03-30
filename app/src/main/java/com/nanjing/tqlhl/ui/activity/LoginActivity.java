package com.nanjing.tqlhl.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.module_ad.utils.LogUtils;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;
import com.nanjing.tqlhl.presenter.Impl.LoginPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.ThirdlyLoginPresentImpl;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.EditTextUtil;
import com.nanjing.tqlhl.utils.ImmersionUtil;
import com.nanjing.tqlhl.utils.Md5Util;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.utils.SpUtil;
import com.nanjing.tqlhl.view.ILoginCallback;
import com.nanjing.tqlhl.view.IThirdlyLoginCallback;
import com.tamsiree.rxkit.view.RxToast;
import com.tamsiree.rxui.view.dialog.RxDialog;
import com.tamsiree.rxui.view.dialog.RxDialogLoading;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.nanjing.tqlhl.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;

;

public class LoginActivity extends BaseMainActivity implements ILoginCallback, IThirdlyLoginCallback, View.OnClickListener, TextWatcher, View.OnFocusChangeListener {

    @BindView(R.id.login_register)
    TextView mRegister;

    @BindView(R.id.change_pwd)
    TextView mChange;

    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;


    @BindView(R.id.login_delete)
    ImageView mNumberDel;

    @BindView(R.id.pwd_delete)
    ImageView mPwdDel;

    @BindView(R.id.pwd_show)
    ImageView mPwdShow;

    @BindView(R.id.qq)
    ImageView mQQLoginBt;

    @BindView(R.id.weiXin)
    ImageView mWeiXinBt;



    @BindView(R.id.login)
    Button mLoginBt;

    @BindView(R.id.number)
    EditText mNumberEdt;

    @BindView(R.id.pwd)
    EditText mPwdEdt;

    @BindView(R.id.view_container)
    RelativeLayout mConstraintLayout;

    @BindView(R.id.login_bar)
    RelativeLayout login_bar;

    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;

    private LoginPresentImpl mLoginPresent;
    private RxDialog mRxDialog;
    private Tencent mTencent;
    private ThirdlyLoginPresentImpl mThirdlyLoginPresent;
    private boolean mIsShow=true;
    private String mOpenId;
    private IWXAPI mWxapi;
    private String mNumber;
    private String mPwd;


    @Override
    protected void setStatusBarColor() {

    }

    @Override
    public int getLayoutId() {
        ImmersionUtil.setImmersion(this);
        return R.layout.activity_login;
    }

    @Override
    protected void intView() {

        tv_bar_title.setText("登录");

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) login_bar.getLayoutParams();
        layoutParams.topMargin= MyStatusBarUtil.getStatusBarHeight(this);
        login_bar.setLayoutParams(layoutParams);

        EditTextUtil.setEditTextInputSpace(mPwdEdt,32);
        mRxDialog = new RxDialogLoading(this);
        mRxDialog.setCancelable(false);


        //QQ初始化
        mTencent = Tencent.createInstance(Contents.QQ_ID, BaseApplication.getAppContext());

        mWxapi = WXAPIFactory.createWXAPI(this,Contents.WECHAT_APP_ID, false);
        mWxapi.registerApp(Contents.WECHAT_APP_ID);
    }


    @Override
    protected void intPresent() {
        mLoginPresent = LoginPresentImpl.getInstance();
        mLoginPresent.registerCallback(this);

        mThirdlyLoginPresent = ThirdlyLoginPresentImpl.getInstance();
        mThirdlyLoginPresent.registerCallback(this);
    }

    @Override
    protected void intEvent() {

        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mNumberDel.setOnClickListener(this);
        mPwdDel.setOnClickListener(this);
        mPwdShow.setOnClickListener(this);

        mNumberEdt.addTextChangedListener(this);
        mPwdEdt.addTextChangedListener(this);

        mNumberEdt.setOnFocusChangeListener(this);
        mPwdEdt.setOnFocusChangeListener(this);



        //T注册页面
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });

        //T找回密码页面
        mChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ChangePwdActivity.class));
            }
        });


        //登陆
        mLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumber = mNumberEdt.getText().toString().trim();
                mPwd = Md5Util.md5(mPwdEdt.getText().toString().trim());
                if (!TextUtils.isEmpty(mNumber) && !TextUtils.isEmpty(mPwd)) {
                    Map<String, String> map = new TreeMap<>();
                    map.put(Contents.MOBILE, mNumber);
                    map.put(Contents.PASSWORD, mPwd);
                    if (mLoginPresent != null) {
                        mLoginPresent.toLogin(map);
                    }

                } else {
                    RxToast.normal(LoginActivity.this,"账号，密码不能不空").show();
                }

            }
        });

        //QQ登陆
        mQQLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginQQ();
            }
        });

        //微信登陆
        mWeiXinBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkWXInstalled();
            }
        });

    }

    private void checkWXInstalled() {
        if (!mWxapi.isWXAppInstalled()) {
            Toast.makeText(this, "您的设备未安装微信客户端", Toast.LENGTH_SHORT).show();
        } else {
            final SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test";
            mWxapi.sendReq(req);
        }
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

        Map<String, String> userType = SpUtil.saveUserType(Contents.LOCAL_TYPE, mNumber, mPwd, "");
        SpUtil.saveUserInfo(loginBean,userType);
        mRxDialog.dismiss();
        finish();
    }

    @Override
    public void onLoginError() {
        mRxDialog.dismiss();
        RxToast.error(this,"登陆失败").show();
    }

    @Override
    public void onLoading() {
        mRxDialog.show();
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

    }



    /**
     * QQ登录
     */
    private IUiListener listener;

    private void loginQQ() {
        listener = new IUiListener() {
            @Override
            public void onComplete(Object object) {
              //  LogUtils.i(   LoginActivity.this,"登录成功: " + object.toString() );
                JSONObject jsonObject = (JSONObject) object;
                try {
                    //得到token、expires、openId等参数
                    String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
                    String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
                    mOpenId = jsonObject.getString(Constants.PARAM_OPEN_ID);
                    mTencent.setAccessToken(token, expires);
                    mTencent.setOpenId(mOpenId);

                    //检查是否注册
                    doCheckRegister();
                    BaseApplication.getAppContext().getSharedPreferences("no_back_sp", Context.MODE_PRIVATE).edit().putBoolean("no_back",true).apply();
                    //获取个人信息
                    getQQInfo();
                } catch (Exception e) {
                }
            }

            @Override
            public void onError(UiError uiError) {
                //登录失败
               // LogUtils.i(   LoginActivity.this,"登录失败" + uiError.errorCode + "");

            }

            @Override
            public void onCancel() {
                //登录取消
               // LogUtils.i(   LoginActivity.this,"登录取消");
            }
        };
        //context上下文、第二个参数SCOPO 是一个String类型的字符串，表示一些权限
        //应用需要获得权限，由“,”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
        //第三个参数事件监听器
        mTencent.login(this, "all", listener);
        //注销登录
        //mTencent.logout(this);
    }

    /**
     * 获取QQ个人信息
     */
    private void getQQInfo() {
        //获取基本信息
        QQToken qqToken = mTencent.getQQToken();
        UserInfo info = new UserInfo(this, qqToken);
        info.getUserInfo(new IUiListener() {
            @Override
            public void onComplete(Object object) {
                try {
                   // LogUtils.i(   LoginActivity.this,"个人信息：" + object.toString());
                    //头像
                    String avatar = ((JSONObject) object).getString("figureurl_2");
                    String nickName = ((JSONObject) object).getString("nickname");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(UiError uiError) {
            }

            @Override
            public void onCancel() {
            }
        });
    }

    /**
     * 回调必不可少,官方文档未说明
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //腾讯QQ回调
        Tencent.onActivityResultData(requestCode, resultCode, data, listener);
        if (requestCode == Constants.REQUEST_API) {
            if (resultCode == Constants.REQUEST_LOGIN) {
                Tencent.handleResultData(data, listener);
            }
        }
    }





    //检查是否已经注册
    private void doCheckRegister() {
        mRxDialog.show();
        if (mThirdlyLoginPresent != null) {
            Map<String,String> userInfo= new TreeMap<>();
            userInfo.put(Contents.OPENID,mOpenId);
            userInfo.put(Contents.TYPE,Contents.QQ_TYPE);
            mThirdlyLoginPresent.checkRegister(userInfo);
        }
    }


    private void doRegister() {
        if (mThirdlyLoginPresent != null) {
            Map<String,String> userInfo= new TreeMap<>();
            userInfo.put(Contents.TYPE,Contents.QQ_TYPE);
            userInfo.put(Contents.OPENID,mOpenId);
            userInfo.put(Contents.PACKAGE,Contents.APP_PACKAGE);
            userInfo.put(Contents.PLATFORM,  PackageUtil.getAppMetaData(this, Contents.PLATFORM_KEY));
            mThirdlyLoginPresent.toThirdlyRegister(userInfo);
        }
    }


    private void doQQLogin() {
        if (mThirdlyLoginPresent != null) {
            Map<String, String> userInfo = new TreeMap<>();
            userInfo.put(Contents.OPENID, mOpenId);
            userInfo.put(Contents.TYPE,Contents.QQ_TYPE);
            mThirdlyLoginPresent.toThirdlyLogin(userInfo);
        }
    }


    //QQ登陆回调
    @Override
    public void onThirdlyLoginSuccess(LoginBean registerBean) {
        int ret = registerBean.getRet();
        if (ret == 200) {
            mRxDialog.dismiss();
            Map<String, String> userType = SpUtil.saveUserType(Contents.QQ_TYPE, "","",mOpenId);
            SpUtil.saveUserInfo(registerBean, userType);
            finish();
            LogUtils.i(LoginActivity.this, "----------------------->：" + registerBean.getMsg());

        }

    }

    @Override
    public void onThirdlyLoginError() {
        RxToast.error(this,"QQ登陆失败").show();
    }

    @Override
    public void onCheckThirdlyRegisterSuccess(RegisterBean bean) {
        BaseApplication.getAppContext().getSharedPreferences("no_back_sp", Context.MODE_PRIVATE).edit().putBoolean("no_back",false).apply();
        int ret = bean.getRet();
        if (ret == 200 && bean.getData().equals("1")) {
            doQQLogin();
        }if (ret == 200 && bean.getData().equals("0")){
            doRegister();
        }


    }

    @Override
    public void onCheckError() {

    }


    //QQ注册回调
    @Override
    public void onThirdlyRegisterSuccess(ThirdlyRegisterBean registerBean) {
        mRxDialog.show();
        int ret = registerBean.getRet();
        BaseApplication.getAppContext().getSharedPreferences("no_back_sp", Context.MODE_PRIVATE).edit().putBoolean("no_back",false).apply();
        LogUtils.i(LoginActivity.this, "onThirdlyRegisterSuccess----------------------->：" + ret);
        if (ret == 200) {
            doQQLogin();
            LogUtils.i(LoginActivity.this, "onThirdlyRegisterSuccess---------200-------------->：" + ret);
        }

        if (ret==700) {
            if (registerBean.getMsg().equals("该帐号已经注册")) {
                doQQLogin();
                LogUtils.i(LoginActivity.this, "onThirdlyRegisterSuccess--------------700--------->：" );
            }

        }


    }

    @Override
    public void onThirdlyRegisterError() {
        RxToast.error(this,"QQ注册失败").show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_delete:
                mNumberEdt.setText("");
                break;
            case R.id.pwd_delete:
                mPwdEdt.setText("");
                break;
            case R.id.pwd_show:
                // 密码可视
                SpUtil.changePwdShow2(mPwdEdt,mPwdShow,mIsShow);
                mIsShow=!mIsShow;
                mPwdEdt.setSelection(mPwdEdt.getText().length());
                break;
        }
    }

    private EditText getEditFocus() {
        View view = mConstraintLayout.findFocus();
        if (view instanceof EditText) {
            return (EditText) view;
        }
        return null;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        boolean empty = TextUtils.isEmpty(charSequence);
        EditText editFocus = getEditFocus();
        if (editFocus==mNumberEdt) {
            mNumberDel.setVisibility(empty?View.GONE:View.VISIBLE);
        } else if (editFocus==mPwdEdt) {
            mPwdDel.setVisibility(empty?View.GONE:View.VISIBLE);
        }


    }

    @Override
    public void afterTextChanged(Editable editable) {
        EditTextUtil.isChinese(editable);
    }


    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            switch (view.getId()) {
                case R.id.number:
                    mPwdDel.setVisibility(View.GONE);
                    mNumberDel .setVisibility(!TextUtils.isEmpty(mNumberEdt.getText().toString().trim())?View.VISIBLE:View.GONE);
                    break;
                case R.id.pwd:
                    mNumberDel.setVisibility(View.GONE);
                    mPwdDel.setVisibility(!TextUtils.isEmpty(mPwdEdt.getText().toString().trim())?View.VISIBLE:View.GONE);
                    break;
            }
        }
    }
}