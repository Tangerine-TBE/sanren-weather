package com.nanjing.tqlhl.presenter.Impl;


import com.example.module_ad.bean.AdBean;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.model.Api;
import com.nanjing.tqlhl.presenter.IAdPresent;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.utils.RetrofitManager;
import com.nanjing.tqlhl.view.IAdCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AdPresentImpl implements IAdPresent {

    private static AdPresentImpl  sInstance;
    private Map<String, String> mMap;
    private final Api mApi;

    public static AdPresentImpl getInstance() {
        if (sInstance == null) {
            sInstance = new AdPresentImpl();
        }
        return sInstance;
    }
     private AdPresentImpl() {
         Retrofit apiAd = RetrofitManager.getInstance().getApiAd();
         mApi = apiAd.create(Api.class);
         mMap = new HashMap<>();
         mMap.put(Contents.AD_NAME, Contents.APP_PACKAGE);
         mMap.put(Contents.AD_VERSION, Contents.AD_VERSION_VALUES);
         mMap.put(Contents.AD_CHANNEL, PackageUtil.getAppMetaData(BaseApplication.getAppContext(), Contents.PLATFORM_KEY));


     }

    @Override
    public void toRequestAd() {

        mApi.getAdMessage(mMap).enqueue(new Callback<AdBean>() {
            @Override
            public void onResponse(Call<AdBean> call, Response<AdBean> response) {
                if (response.code()== HttpURLConnection.HTTP_OK) {
                    AdBean body = response.body();
                    if (body != null) {
                        for (IAdCallback callback : mCallbacks) {
                            callback.onLoadAdMsgSuccess(body);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<AdBean> call, Throwable t) {
                for (IAdCallback callback : mCallbacks) {
                    callback.onLoadAdMsgError();
                }
            }
        });

    }

    private List<IAdCallback> mCallbacks=new ArrayList<>();
    @Override
    public void registerCallback(IAdCallback iAdCallback) {
        if (!mCallbacks.contains(iAdCallback)) {
            mCallbacks.add(iAdCallback);
        }
    }

    @Override
    public void unregisterCallback(IAdCallback iAdCallback) {
        mCallbacks.remove(iAdCallback);
    }
}
