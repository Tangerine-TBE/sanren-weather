package com.nanjing.tqlhl.presenter.Impl;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.model.WeatherData;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj24WeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.model.bean.MjLifeBean;
import com.nanjing.tqlhl.model.bean.MjRealWeatherBean;
import com.nanjing.tqlhl.presenter.IWeatherPresent;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.view.IWeatherCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherPresentImpl implements IWeatherPresent {


    private final WeatherData mWeatherData;
    private String mLongitude;
    private String mLatitude;


    public WeatherPresentImpl() {
        mWeatherData = WeatherData.getInstance();
    }


    //请求实时天气
    @Override
    public void getRealTimeWeatherInfo(String Longitude, String Latitude) {
        if (TextUtils.isEmpty(Longitude)) {
            return;
        }
        handlerLoading();
        this.mLongitude = Longitude;
        this.mLatitude = Latitude;
        doRequestRealTimeWeather(Longitude, Latitude, false);
    }


    //请求天级天气
    @Override
    public void getDayWeatherInfo(String Longitude,String Latitude) {
        if (TextUtils.isEmpty(Longitude)) {
            return;
        }
        doRequestDayWeather( Longitude, Latitude,false);
    }

    //请求小时天气
    @Override
    public void getHourWeatherInfo(String Longitude,String Latitude) {
            mWeatherData.doRequestHour(Longitude,Latitude, new Callback<Mj24WeatherBean>() {
                @Override
                public void onResponse(Call<Mj24WeatherBean> call, Response<Mj24WeatherBean> response) {
                    if (response.code()== HttpURLConnection.HTTP_OK) {
                        Mj24WeatherBean body = response.body();
                        if (body != null) {
                            for (IWeatherCallback callback : mCallbacks) {
                                callback.onLoadHourWeatherData(body);
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<Mj24WeatherBean> call, Throwable t) {
                    onHandleError();
                }
            });
    }

    private void onHandleError() {
        for (IWeatherCallback callback : mCallbacks) {
            callback.onError();
        }
    }

    @Override
    public void getLifeWeatherInfo(String Longitude, String Latitude) {
        mWeatherData.doRequestLife(Longitude , Latitude , new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code()== HttpURLConnection.HTTP_OK) {
                    try {
                        String string = response.body().string();
                        JSONObject jsonObject = new JSONObject(string);
                        JSONObject data = jsonObject.optJSONObject("data");
                        JSONObject liveIndex = data.getJSONObject("liveIndex");
                        JSONArray jsonArray = liveIndex.getJSONArray(DateUtil.getDate());
                        List<MjLifeBean> lifeBeans = JSON.parseArray(jsonArray.toString(), MjLifeBean.class);

                        for (IWeatherCallback callback : mCallbacks) {

                            callback.onLoadLifeWeatherData(lifeBeans);
                        }

                    } catch (Exception e) {
                        onHandleError();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                LogUtils.i(WeatherPresentImpl.this,"onFailure------------------>"+t.toString());
                onHandleError();
            }
        });
    }



    @Override
    public void getAqiWeatherInfo(String Longitude, String Latitude) {
        mWeatherData.doRequestAqi(Longitude, Latitude, new Callback<MjAqiBean>() {
            @Override
            public void onResponse(Call<MjAqiBean> call, Response<MjAqiBean> response) {
                if (response.code()== HttpURLConnection.HTTP_OK) {
                    MjAqiBean body = response.body();
                    if (body != null) {
                        for (IWeatherCallback callback : mCallbacks) {
                            callback.onLoadAqiWeatherData(body);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<MjAqiBean> call, Throwable t) {
                LogUtils.i(WeatherPresentImpl.this,"onFailure------------------>"+t.toString());
                onHandleError();
            }
        });
    }

    @Override
    public void get5AqiWeatherInfo(String Longitude, String Latitude) {
        mWeatherData.doRequest5Aqi(Longitude, Latitude, new Callback<Mj5AqiBean>() {
            @Override
            public void onResponse(Call<Mj5AqiBean> call, Response<Mj5AqiBean> response) {
                if (response.code()== HttpURLConnection.HTTP_OK) {
                    Mj5AqiBean body = response.body();
                    if (body != null) {
                        for (IWeatherCallback callback : mCallbacks) {

                            callback.onLoad5AqiWeatherData(body);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Mj5AqiBean> call, Throwable t) {
                LogUtils.i(WeatherPresentImpl.this,"onFailure------------------>"+t.toString());
                onHandleError();
            }
        });
    }

    //下拉刷新
    @Override
    public void pullToRefresh(String Longitude,String Latitude) {
          LogUtils.i(this, "经度------------>" + mLongitude+"纬度---------"+mLatitude);
        doRequestRealTimeWeather(Longitude,Latitude,true);
        doRequestDayWeather(Longitude,Latitude,true);
        getHourWeatherInfo(Longitude,Latitude);
        getAqiWeatherInfo(Longitude,Latitude);
        getLifeWeatherInfo(Longitude,Latitude);

    }


    //请求实时天气
    private void doRequestRealTimeWeather(String Longitude,String Latitude,boolean isFresh) {

        mWeatherData.doRequestTem(Longitude,Latitude, new Callback<MjRealWeatherBean>() {
            @Override
            public void onResponse(Call<MjRealWeatherBean> call, Response<MjRealWeatherBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    MjRealWeatherBean body = response.body();
                    if (body != null) {
                        if (isFresh) {
                            handlerRefreshSuccess();
                            MjRealWeatherBean.DataBean result = body.getData();
                            handlerSuccess(result);
                        } else {
                            MjRealWeatherBean.DataBean result = body.getData();
                            handlerSuccess(result);
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<MjRealWeatherBean> call, Throwable t) {
                if (isFresh) {
                    handlerRefreshError();
                } else {
                    onHandleError();
                }
                LogUtils.i(WeatherPresentImpl.this,"onFailure------------------>"+t.toString());

            }
        });
    }

    private void handlerLoading() {
        for (IWeatherCallback callback : mCallbacks) {
            callback.onLoading();
        }
    }

    //请求天级天气
    private void doRequestDayWeather(String Longitude,String Latitude,boolean isFresh) {
        mWeatherData.doRequestHighAndLow(Longitude,Latitude, new Callback<Mj15DayWeatherBean>() {
            @Override
            public void onResponse(Call<Mj15DayWeatherBean> call, Response<Mj15DayWeatherBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    Mj15DayWeatherBean dayWeatherBean = response.body();
                    if (dayWeatherBean != null) {
                        if (isFresh) {
                            handlerRefreshSuccess();
                            Mj15DayWeatherBean.DataBean result = dayWeatherBean.getData();
                            handlerDaySuccess(result);

                        } else {
                            Mj15DayWeatherBean.DataBean result = dayWeatherBean.getData();
                            handlerDaySuccess(result);
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<Mj15DayWeatherBean> call, Throwable t) {
                LogUtils.i(WeatherPresentImpl.this,"onFailure------------------>"+t.toString());
                if (isFresh) {
                    handlerRefreshError();
                } else {
                    onHandleError();
                }

            }
        });
    }

    private void handlerRefreshError() {
        for (IWeatherCallback callback : mCallbacks) {
            callback.onRefreshError();
        }
    }

    private void handlerRefreshSuccess() {
        for (IWeatherCallback callback : mCallbacks) {
            callback.onRefreshSuccess();
        }
    }


    private void handlerDaySuccess(Mj15DayWeatherBean.DataBean result) {

        for (IWeatherCallback callback : mCallbacks) {
            callback.onLoadDayWeatherData(result);

        }
    }


    private void handlerSuccess(MjRealWeatherBean.DataBean body ) {
        if (body != null) {
            for (IWeatherCallback callback : mCallbacks) {
                callback.onLoadRealtimeWeatherData(body);

            }
        }
    }

    private List<IWeatherCallback> mCallbacks = new ArrayList<>();

    @Override
    public void registerCallback(IWeatherCallback iWeatherCallback) {
        if (!mCallbacks.contains(iWeatherCallback)) {
            mCallbacks.add(iWeatherCallback);
        }
    }

    @Override
    public void unregisterCallback(IWeatherCallback iWeatherCallback) {
        mCallbacks.remove(iWeatherCallback);
    }

}
