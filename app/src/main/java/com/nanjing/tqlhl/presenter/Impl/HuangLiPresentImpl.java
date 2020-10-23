package com.nanjing.tqlhl.presenter.Impl;

import com.nanjing.tqlhl.model.WeatherData;
import com.nanjing.tqlhl.model.bean.HuangLiBean;
import com.nanjing.tqlhl.presenter.IHuangLiPresent;
import com.nanjing.tqlhl.view.IHuangLiCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HuangLiPresentImpl implements IHuangLiPresent {


    private static HuangLiPresentImpl sInstance;
    private final WeatherData mData;

    public static HuangLiPresentImpl getInstance() {
        if (sInstance == null) {
            sInstance = new HuangLiPresentImpl();
        }
        return sInstance;
    }
     private HuangLiPresentImpl() {
         mData = WeatherData.getInstance();
     }


    @Override
    public void getHuangLi() {
        mData.doRequestHl(new Callback<HuangLiBean>() {
            @Override
            public void onResponse(Call<HuangLiBean> call, Response<HuangLiBean> response) {
                if (response.code()== HttpURLConnection.HTTP_OK) {
                    HuangLiBean body = response.body();
                    if (body != null) {
                        for (IHuangLiCallback callback : mCallbacks) {
                            callback.onLoadHuangLi(body);
                        }

                }
                }

            }

            @Override
            public void onFailure(Call<HuangLiBean> call, Throwable t) {
                for (IHuangLiCallback callback : mCallbacks) {
                    callback.onLoadHuangLiError();
                }

            }
        });
    }

    private List<IHuangLiCallback> mCallbacks=new ArrayList<>();

    @Override
    public void registerCallback(IHuangLiCallback iHuangLiCallback) {
        if (!mCallbacks.contains(iHuangLiCallback)) {
            mCallbacks.add(iHuangLiCallback);
        }

    }

    @Override
    public void unregisterCallback(IHuangLiCallback iHuangLiCallback) {
        mCallbacks.remove(iHuangLiCallback);
    }
}
