package com.nanjing.tqlhl.presenter.Impl;

import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.model.UserData;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.presenter.IRegisterPresent;
import com.nanjing.tqlhl.view.IRegisterCallback;

import java.net.HttpURLConnection;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresentImpl implements IRegisterPresent {

    private static RegisterPresentImpl sInstance;

    private StringBuilder mAppend;
    private IRegisterCallback mIRegisterCallback = null;
    private UserData mUserData;

    public static RegisterPresentImpl getInstance() {
        if (sInstance == null) {
            sInstance = new RegisterPresentImpl();
        }
        return sInstance;
    }

    private RegisterPresentImpl() {
        mUserData = UserData.getInstance();

    }

    //获取验证码
    @Override
    public void getVerificationCode(String phoneNumber) {
        mUserData.doCode(phoneNumber, new Callback<RegisterBean>() {
            @Override
            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    RegisterBean body = response.body();
                    if (body != null) {
                        LogUtils.i(RegisterPresentImpl.this,"*getVerificationCode----------------------。"+body.getRet());
                        mIRegisterCallback.onLoadCode();
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterBean> call, Throwable t) {

            }
        });


    }

    //http://www.aisou.club/api.php?password=123456&mobile=18720282934&code=67385&platform=_360&package=com.chenxing.androidruler&timestamp=1594086842472&nonce=8451&signature=5a0606c02f38593be8f1d24818e6d085&service=passport.registerByMobile

    //注册
    @Override
    public void registerNumber(Map<String, String> userInfo) {
        handlerLoading();
        mUserData.doRegister(userInfo, new Callback<RegisterBean>() {
            @Override
            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    RegisterBean body = response.body();
                    handlerSuccess(body);

                }
            }

            @Override
            public void onFailure(Call<RegisterBean> call, Throwable t) {
                handlerError();
            }
        });

    }


    private void handlerLoading() {
        if (mIRegisterCallback != null) {
            mIRegisterCallback.onLoading();
        }
    }

    private void handlerError() {
        if (mIRegisterCallback != null) {
            mIRegisterCallback.onError();
        }
    }

    private void handlerSuccess(RegisterBean body) {
        if (body != null) {
            mIRegisterCallback.onRegisterSuccess(body);
        }
    }

    @Override
    public void registerCallback(IRegisterCallback iRegisterCallback) {
        this.mIRegisterCallback = iRegisterCallback;
    }

    @Override
    public void unregisterCallback(IRegisterCallback iRegisterCallback) {
        if (mIRegisterCallback != null) {
            mIRegisterCallback = null;
        }
    }
}
