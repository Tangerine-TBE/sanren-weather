package com.nanjing.tqlhl.presenter.Impl;

import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.model.UserData;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.presenter.ILoginPresent;
import com.nanjing.tqlhl.view.ILoginCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresentImpl implements ILoginPresent {
    private static LoginPresentImpl  sInstance;
    private final UserData mUserData;

    public static LoginPresentImpl getInstance() {
        if (sInstance == null) {
            sInstance = new LoginPresentImpl();
        }
        return sInstance;
    }
     private LoginPresentImpl() {
         mUserData = UserData.getInstance();

    }


    @Override
    public void toLogin(Map<String, String> userInfo) {
        handlerLoading();
        mUserData.doLogin(userInfo, new Callback<LoginBean>() {
                private LoginBean mBody;
                @Override
                public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                    LogUtils.i(LoginPresentImpl.this,"toLogin---------->"+response.code());
                    if (response.code()== HttpURLConnection.HTTP_OK) {
                        mBody = response.body();
                        if (mBody != null) {
                            for (ILoginCallback callback : mCallbacks) {
                                callback.onLoginSuccess(mBody);
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<LoginBean> call, Throwable t) {
                    LogUtils.i(LoginPresentImpl.this,"onFailure---------->");
                    for (ILoginCallback callback : mCallbacks) {
                        callback.onLoginError();
                    }
                }
            });

    }

    private void handlerLoading() {
        for (ILoginCallback callback : mCallbacks) {
            callback.onLoading();
        }
    }

    private List<ILoginCallback> mCallbacks=new ArrayList<>();

    @Override
    public void registerCallback(ILoginCallback iLoginCallback) {
        if (!mCallbacks.contains(iLoginCallback)) {
            mCallbacks.add(iLoginCallback);
        }
    }

    @Override
    public void unregisterCallback(ILoginCallback iLoginCallback) {
            mCallbacks.remove(iLoginCallback);
    }
}
