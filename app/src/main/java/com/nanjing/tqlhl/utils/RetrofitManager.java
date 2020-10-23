package com.nanjing.tqlhl.utils;


import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.nanjing.tqlhl.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static RetrofitManager sInstance;
    private final Retrofit mRetrofit;
    private final Retrofit mRetrofitAddress;
    private final Retrofit mMRetrofitWeiXin;
    private final Retrofit mRetrofitMjWeather;
    private final Retrofit mMRetrofitHl;

    public Retrofit getApiAd() {
        return mApiAd;
    }

    private final Retrofit mApiAd;

    public Retrofit getMRetrofitHl() {
        return mMRetrofitHl;
    }

    public Retrofit getRetrofitMjWeather() {
        return mRetrofitMjWeather;
    }

    public Retrofit getMRetrofitWeiXin() {
        return mMRetrofitWeiXin;
    }

    public Retrofit getRetrofitUser() {
        return mRetrofitUser;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public Retrofit getRetrofitAddress() {
        return mRetrofitAddress;
    }


    private final Retrofit mRetrofitUser;

    public static RetrofitManager getInstance() {
        if (sInstance == null) {
            sInstance = new RetrofitManager();
        }
        return sInstance;
    }

    private RetrofitManager() {

        mApiAd = new Retrofit.Builder()
                .baseUrl(WeatherUrl.AD_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient().build())
                .build();

        mMRetrofitHl = new Retrofit.Builder()
                .baseUrl(WeatherUrl.HUANG_LI)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient().build())
                .build();


        mRetrofit = new Retrofit.Builder()
                .baseUrl(WeatherUrl.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient().build())
                .build();

        mRetrofitAddress = new Retrofit.Builder()
                .baseUrl(AddressUrl.ADDRESS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRetrofitUser = new Retrofit.Builder()
                .baseUrl(WeatherUrl.USER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient().build())
                .build();

        mMRetrofitWeiXin = new Retrofit.Builder()
                .baseUrl(WeatherUrl.WECHAT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient().build())
                .build();

        mRetrofitMjWeather = new Retrofit.Builder()
                .baseUrl(WeatherUrl.MJ_WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getMjClient().build())
                .build();


    }

    private OkHttpClient.Builder getClient(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(10,TimeUnit.SECONDS);
        //add log record
        if (BuildConfig.DEBUG) {
            //打印网络请求日志
            LoggingInterceptor httpLoggingInterceptor = new LoggingInterceptor.Builder()
                    .loggable(BuildConfig.DEBUG)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request("请求")
                    .response("响应")
                    .build();
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }
        return httpClientBuilder;
    }

    private OkHttpClient.Builder getMjClient(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(10,TimeUnit.SECONDS);
            //打印网络请求日志
            LoggingInterceptor httpLoggingInterceptor = new LoggingInterceptor.Builder()
                    .loggable(BuildConfig.DEBUG)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .addHeader("Authorization","APPCODE 52ce58f29858415596449874e5555eec")
                    .request("请求")
                    .response("响应")
                    .build();
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        return httpClientBuilder;
    }


}
