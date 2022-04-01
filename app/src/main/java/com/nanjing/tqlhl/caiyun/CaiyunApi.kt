package com.nanjing.tqlhl.caiyun

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CaiyunApi {

    @GET("{lon},{lat}/realtime.json")//121.6544,25.1552/realtime.json
    fun getRealWeather(@Path("lon") lon: String,@Path("lat") lat: String):Call<RealTimeWeather>

    @GET("{lon},{lat}/hourly.json")//121.6544,25.1552/hourly.json
    fun getHourWeather(@Path("lon") lon: String,@Path("lat") lat: String):Call<HourlyWeather>

    @GET("{lon},{lat}/daily.json")//121.6544,25.1552/daily.json
    fun getDailyWeather(@Path("lon") lon: String,@Path("lat") lat: String):Call<DailyWeather>
}