package com.nanjing.tqlhl.ui

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.nanjing.tqlhl.caiyun.DailyWeather
import com.nanjing.tqlhl.caiyun.HourlyWeather
import com.nanjing.tqlhl.caiyun.RealTimeWeather
import com.nanjing.tqlhl.ui.activity.AirActivity
import com.nanjing.tqlhl.ui.custom.mj15day.AirLevel
import com.nanjing.tqlhl.ui.custom.mj15day.WeatherModel
import kotlinx.android.synthetic.main.activity_air.*

class AirActivity_KT constructor(airActivity: AirActivity) {
    companion object{
        private const val CITY_KEY="city_k"
        private const val REALTIME_WEATHER = "real_w"
        private const val HOURLY_WEATHER = "hourly_w"
        private const val DAILY_WEATHER = "daily_w"

        fun getIntent(context: Context, city:String, realTimeWeather: RealTimeWeather, hourlyWeather: HourlyWeather, dailyWeather: DailyWeather):Intent{
            return Intent(context,AirActivity::class.java).apply {
                this.putExtra(CITY_KEY,city)
                val gson=Gson()
                this.putExtra(REALTIME_WEATHER,gson.toJson(realTimeWeather))
                this.putExtra(HOURLY_WEATHER,gson.toJson(hourlyWeather))
                this.putExtra(DAILY_WEATHER,gson.toJson(dailyWeather))
            }
        }
    }
    public var realTimeWeather: RealTimeWeather? = null
        private set
    public var hourlyWeather: HourlyWeather? = null
        private set
    public var dailyWeather: DailyWeather? = null
        private set
    public var city:String?=null
        private set
    init {
        val intent: Intent = airActivity.intent
        city=intent.getStringExtra(CITY_KEY)
        val realtimeWeatherStr = intent.getStringExtra(REALTIME_WEATHER)
        val hourlyWeatherStr = intent.getStringExtra(HOURLY_WEATHER)
        val dailyWeatherStr = intent.getStringExtra(DAILY_WEATHER)
        try {
            val gson = Gson()
            realTimeWeather = gson.fromJson(realtimeWeatherStr, RealTimeWeather::class.java)
            hourlyWeather = gson.fromJson(hourlyWeatherStr, HourlyWeather::class.java)
            dailyWeather = gson.fromJson(dailyWeatherStr, DailyWeather::class.java)
        } catch (e: Exception) {
        }
        airActivity.initView()
    }

    fun AirActivity.initView(){
        av_line.setAqiValue(realTimeWeather?.getAqi()?:0)
        tv_aqi_value.text=realTimeWeather?.getAqiDes()
        val air_quality=realTimeWeather?.result?.realtime?.air_quality
        pm25Value.text=air_quality?.pm25?.toString()//
        pm10Value.text=air_quality?.pm10?.toString()//
        so2Value.text=air_quality?.so2?.toString()//
        no2Value.text=air_quality?.no2?.toString()//
//        noValue.text=air_quality?.no2?.toString()//
        o3Value.text=air_quality?.o3?.toString()//


        val data=dailyWeather?.getNeedData()
        weather15_view.list=data?.map {dailyNeedData->
            WeatherModel().also {
                it.dayTemp= dailyNeedData.getMaxTem()
                it.nightTemp=dailyNeedData.getMinTem()
                it.dayWeather=dailyNeedData.getSkyconDes()
                it.nightWeather=dailyNeedData.getSkyconDes()
                it.date=dailyNeedData.date
                it.week=dailyNeedData.week
                it.dayPic=dailyNeedData.getSkyconIcon()
                it.nightPic=dailyNeedData.getSkyconIcon()
                it.windOrientation=dailyNeedData.getWindDirection()
                it.windLevel=dailyNeedData.getWindDegree()
                it.airLevel= AirLevel.POISONOUS
            }
        }
    }
}