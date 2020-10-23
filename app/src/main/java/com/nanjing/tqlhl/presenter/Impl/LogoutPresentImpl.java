package com.nanjing.tqlhl.presenter.Impl;

import com.nanjing.tqlhl.model.UserData;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.presenter.ILogoutPresent;
import com.nanjing.tqlhl.view.ILogoutCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoutPresentImpl implements ILogoutPresent {


    private static LogoutPresentImpl sInstance;
    private final UserData mUserData;
    private ILogoutCallback mILogoutCallback=null;

    public static LogoutPresentImpl getInstance() {
        if (sInstance == null) {
            sInstance = new LogoutPresentImpl();
        }
        return sInstance;
    }
     private LogoutPresentImpl() {
         mUserData = UserData.getInstance();
     }


    @Override
    public void toLogout(String id) {
        mUserData.doLogout(id, new Callback<RegisterBean>() {
            @Override
            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                if (response != null) {
                    RegisterBean body = response.body();
                    if (mILogoutCallback != null) {
                        mILogoutCallback.onLogoutSuccess(body);
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterBean> call, Throwable t) {
                if (mILogoutCallback != null) {
                    mILogoutCallback.onLogoutError();
                }
            }
        });
    }

    @Override
    public void registerCallback(ILogoutCallback iLogoutCallback) {
        this.mILogoutCallback=iLogoutCallback;
    }

    @Override
    public void unregisterCallback(ILogoutCallback iLogoutCallback) {
        if (mILogoutCallback != null) {
            mILogoutCallback=null;
        }
    }
}
