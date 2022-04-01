package com.nanjing.tqlhl.model;

import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.model.bean.HuangLiBean;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj24WeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.model.bean.MjRealWeatherBean;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.RetrofitManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class WeatherData {

    private static WeatherData  sInstance;
    private final Api mApi;
    private double mLatitude;
    private double mLongitude;
    private final Api mApihl;

    public static WeatherData getInstance() {
        if (sInstance == null) {
            sInstance = new WeatherData();
        }
        return sInstance;
    }
     private WeatherData() {
         Retrofit retrofit = RetrofitManager.getInstance().getRetrofitMjWeather();
         mApi = retrofit.create(Api.class);

         Retrofit retrofit1 = RetrofitManager.getInstance().getMRetrofitHl();
         mApihl = retrofit1.create(Api.class);
     }


     public void doRequestTem(String Longitude,String Latitude,Callback<MjRealWeatherBean> callback) {
         mApi.getMjRealWeather(Longitude+"",Latitude+"").enqueue(callback);
     }

    public void doRequestHighAndLow(String Longitude,String Latitude,Callback<Mj15DayWeatherBean> callback) {
        mApi.getMj15DayWeather(Longitude+"",Latitude+"").enqueue(callback);
    }

    public void doRequestHour(String Longitude,String Latitude,Callback<Mj24WeatherBean> callback) {
        mApi.getMj24HoursWeather(Longitude+"",Latitude+"").enqueue(callback);
    }

    public void doRequestLife(String Longitude, String Latitude, Callback<ResponseBody> callback) {
        mApi.getMjLifeWeather(Longitude+"",Latitude+"").enqueue(callback);
    }

    public void doRequestAqi(String Longitude,String Latitude,Callback<MjAqiBean> callback) {
        mApi.getMjAqiWeather(Longitude+"",Latitude+"").enqueue(callback);
    }

    public void doRequest5Aqi(String Longitude,String Latitude,Callback<Mj5AqiBean> callback) {
        mApi.getMj5AqiWeather(Longitude+"",Latitude+"").enqueue(callback);
    }



    public void doRequestHl(Callback<HuangLiBean> callback) {
        mApihl.getHuangLi(Contents.HUANG_LI_KEY,new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis())).enqueue(callback);
    }

}
