package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.IWeatherCallback;

public interface IWeatherPresent extends IBasePresent<IWeatherCallback> {

    //获取实时天气
    void getRealTimeWeatherInfo(String Longitude,String Latitude);

    //获取天级天气
    void getDayWeatherInfo(String Longitude,String Latitude);

    //获取小时级天气
    void getHourWeatherInfo(String Longitude,String Latitude);

    //获取生活指数
    void getLifeWeatherInfo(String Longitude,String Latitude);

    //获取空气质量
    void getAqiWeatherInfo(String Longitude,String Latitude);

    //获取空气质量
    void get5AqiWeatherInfo(String Longitude,String Latitude);


    void pullToRefresh(String Longitude,String Latitude);

}
