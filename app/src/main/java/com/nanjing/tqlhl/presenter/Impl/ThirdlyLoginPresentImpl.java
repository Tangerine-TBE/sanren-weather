package com.nanjing.tqlhl.presenter.Impl;

import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.model.UserData;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;
import com.nanjing.tqlhl.presenter.IThirdlyLoginPresent;
import com.nanjing.tqlhl.view.IThirdlyLoginCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdlyLoginPresentImpl implements IThirdlyLoginPresent {


    private static ThirdlyLoginPresentImpl  sInstance;
    private final UserData mUserData;
    private IThirdlyLoginCallback mIThirdlyLoginCallback;

    public static ThirdlyLoginPresentImpl getInstance() {
        if (sInstance == null) {
            sInstance = new ThirdlyLoginPresentImpl();
        }
        return sInstance;
    }
     private ThirdlyLoginPresentImpl() {
         mUserData = UserData.getInstance();
     }





    @Override
    public void toThirdlyRegister(Map<String, String> userInfo) {
        mUserData.doThirdlyRegister(userInfo, new Callback<ThirdlyRegisterBean>() {
            @Override
            public void onResponse(Call<ThirdlyRegisterBean> call, Response<ThirdlyRegisterBean> response) {

                if (response.code()== HttpURLConnection.HTTP_OK) {
                    ThirdlyRegisterBean body = response.body();
                    if (body != null) {
                        for (IThirdlyLoginCallback callback : mCallbacks) {
                            callback.onThirdlyRegisterSuccess(body);
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<ThirdlyRegisterBean> call, Throwable t) {
                for (IThirdlyLoginCallback callback : mCallbacks) {
                    callback.onThirdlyRegisterError();
                }
            }
        });
    }

    @Override
    public void checkRegister(Map<String, String> userInfo) {
            mUserData.doCheckRegister(userInfo, new Callback<RegisterBean>() {
                @Override
                public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                    if (response.code()== HttpURLConnection.HTTP_OK) {
                        RegisterBean body = response.body();
                        if (body != null) {
                            for (IThirdlyLoginCallback callback : mCallbacks) {
                                callback.onCheckThirdlyRegisterSuccess(body);
                            }
                        }

                    }

                }

                @Override
                public void onFailure(Call<RegisterBean> call, Throwable t) {
                    for (IThirdlyLoginCallback callback : mCallbacks) {
                        callback.onCheckError();
                    }
                }
            });
    }


    @Override
    public void toThirdlyLogin(Map<String, String> userInfo) {
        mUserData.doThirdlyLogin(userInfo, new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                if (response.code()== HttpURLConnection.HTTP_OK) {
                    LoginBean body = response.body();
                    if (body != null) {
                        for (IThirdlyLoginCallback callback : mCallbacks) {
                            callback.onThirdlyLoginSuccess(body);
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                LogUtils.i(ThirdlyLoginPresentImpl.this,"------------------------>"+t.toString());
                for (IThirdlyLoginCallback callback : mCallbacks) {
                    callback.onThirdlyLoginError();
                }
            }
        });
    }

    private List<IThirdlyLoginCallback> mCallbacks=new ArrayList<>();

    @Override
    public void registerCallback(IThirdlyLoginCallback iThirdlyLoginCallback) {
        if (!mCallbacks.contains(iThirdlyLoginCallback)) {
            mCallbacks.add(iThirdlyLoginCallback);
        }

    }

    @Override
    public void unregisterCallback(IThirdlyLoginCallback iThirdlyLoginCallback) {
            mCallbacks.remove(iThirdlyLoginCallback);
    }
}
