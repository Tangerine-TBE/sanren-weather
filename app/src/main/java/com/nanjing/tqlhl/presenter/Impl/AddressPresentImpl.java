package com.nanjing.tqlhl.presenter.Impl;

import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.model.Api;
import com.nanjing.tqlhl.model.bean.AddressBean;
import com.nanjing.tqlhl.model.bean.LocationBean;
import com.nanjing.tqlhl.presenter.IAddressPresent;
import com.nanjing.tqlhl.utils.AddressUrl;
import com.nanjing.tqlhl.utils.RetrofitManager;
import com.nanjing.tqlhl.view.IAddressCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author: Administrator
 * @date: 2020/7/4 0004
 */
public class AddressPresentImpl implements IAddressPresent {





    @Override
    public void getLocationAddress(String city) {
        Retrofit retrofitAddress = RetrofitManager.getInstance().getRetrofitAddress();
        Api api = retrofitAddress.create(Api.class);
        String format = String.format(AddressUrl.ADDRESS, city);
        api.getAddress(format).enqueue(new Callback<AddressBean>() {
            @Override
            public void onResponse(Call<AddressBean> call, Response<AddressBean> response) {
                if (response.code()== HttpURLConnection.HTTP_OK) {
                    AddressBean.ResultBean result = response.body().getResult();
                    if (result != null) {
                        handlerSuccess(result,city);
                    }
                }
            }

            @Override
            public void onFailure(Call<AddressBean> call, Throwable t) {
                 LogUtils.i(AddressPresentImpl.this, "onFailure------------------->" + t.toString());
                for (IAddressCallback callback : mCallbacks) {
                    callback.onError();
                }
            }
        });
    }


    private void handlerSuccess(AddressBean.ResultBean body, String city) {
        for (IAddressCallback callback : mCallbacks) {
            AddressBean.ResultBean.LocationBean location = body.getLocation();
            callback.onLoadAddressSuccess(new LocationBean(city, location.getLng(), location.getLat()));
        }

    }

    private List<IAddressCallback> mCallbacks=new ArrayList<>();
    @Override
    public void registerCallback(IAddressCallback iAddressCallback) {
        if (!mCallbacks.contains(iAddressCallback)) {
            mCallbacks.add(iAddressCallback);
        }

    }

    @Override
    public void unregisterCallback(IAddressCallback iAddressCallback) {
        mCallbacks.remove(iAddressCallback);
    }
}
