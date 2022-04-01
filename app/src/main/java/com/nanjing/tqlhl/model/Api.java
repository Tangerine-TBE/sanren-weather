package com.nanjing.tqlhl.model;


import com.example.module_ad.bean.AdBean;
import com.nanjing.tqlhl.model.bean.AddressBean;
import com.nanjing.tqlhl.model.bean.DayWeatherBean;
import com.nanjing.tqlhl.model.bean.HourWeatherBean;
import com.nanjing.tqlhl.model.bean.HuangLiBean;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj24WeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.model.bean.MjRealWeatherBean;
import com.nanjing.tqlhl.model.bean.RealtimeWeatherBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;
import com.nanjing.tqlhl.model.bean.WeiXinBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface Api {

        @GET
        Call<RealtimeWeatherBean> getRealtimeWeather(@Url String url);

        @GET
        Call<DayWeatherBean> getDayWeather(@Url String url);

        @GET
        Call<AddressBean> getAddress(@Url String city);

        @GET
        Call<HourWeatherBean> getHourWeather(@Url String hour);

        @POST("/api.php")
        Call<RegisterBean> getVerCode(@QueryMap Map<String,Object> params);

        @POST("/api.php")
        Call<RegisterBean> toRegister(@QueryMap Map<String,Object> params);

        @POST("/api.php")
        Call<LoginBean> toLogin(@QueryMap Map<String,Object> params);

        @POST("/api.php")
        Call<RegisterBean> toFindPwd(@QueryMap Map<String,Object> params);

        @POST("/api.php")
        Call<LoginBean> toThirdlyLogin(@QueryMap Map<String,Object> params);

        @POST("/api.php")
        Call<ThirdlyRegisterBean> toThirdlyRegister(@QueryMap Map<String,Object> params);

        @POST("/api.php")
        Call<RegisterBean> toLogout(@QueryMap Map<String,Object> params);


        @POST("/api.php")
        Call<RegisterBean> checkRegister(@QueryMap Map<String,Object> params);

        @GET("access_token")
        Call<WeiXinBean> toWxAccredit(@QueryMap Map<String,String> params);


        @GET("anSanrenWeather")
        Call<AdBean> getAdMessage(@QueryMap  Map<String,String> params);


        //墨迹天气------------------------------------------------------------
        //实时天气
        @POST("condition")
        Call<MjRealWeatherBean> getMjRealWeather(@Query("lon") String lon, @Query("lat") String lat);

        //24小时天气
        @POST("forecast24hours")
        Call<Mj24WeatherBean> getMj24HoursWeather(@Query("lon") String lon, @Query("lat") String lat);

        //15天天气
        @POST("forecast15days")
        Call<Mj15DayWeatherBean> getMj15DayWeather(@Query("lon") String lon, @Query("lat") String lat);

        //生活指数
        @POST("index")
        Call<ResponseBody> getMjLifeWeather(@Query("lon") String lon, @Query("lat") String lat);

        //空气质量指数
        @POST("aqi")
        Call<MjAqiBean> getMjAqiWeather(@Query("lon") String lon, @Query("lat") String lat);

        @POST("aqiforecast5days")
        Call<Mj5AqiBean> getMj5AqiWeather(@Query("lon") String lon, @Query("lat") String lat);

        //黄历
        @GET("laohuangli/d")
        Call<HuangLiBean> getHuangLi(@Query("key") String key,@Query("date") String day);


}
