package com.nanjing.tqlhl.ui

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.nanjing.tqlhl.caiyun.DailyWeather
import com.nanjing.tqlhl.caiyun.HourlyWeather
import com.nanjing.tqlhl.caiyun.RealTimeWeather
import com.nanjing.tqlhl.model.bean.DescribeBean
import com.nanjing.tqlhl.ui.activity.DayDetailsActivity
import com.nanjing.tqlhl.ui.adapter.WeatherDescribeAdapter
import com.nanjing.tqlhl.ui.custom.mj15day.AirLevel
import com.nanjing.tqlhl.ui.custom.mj15day.WeatherModel
import kotlinx.android.synthetic.main.activity_details.*
import java.util.*

class DayDetailsActivity_KT constructor(dayDetailsActivity: DayDetailsActivity) {
    companion object{
        private const val REALTIME_WEATHER = "real_w"
        private const val HOURLY_WEATHER = "hourly_w"
        private const val DAILY_WEATHER = "daily_w"

        fun getIntent(context: Context, realTimeWeather: RealTimeWeather, hourlyWeather: HourlyWeather, dailyWeather: DailyWeather):Intent{
            return Intent(context, DayDetailsActivity::class.java).apply {
                val gson=Gson()
                this.putExtra(REALTIME_WEATHER, gson.toJson(realTimeWeather))
                this.putExtra(HOURLY_WEATHER, gson.toJson(hourlyWeather))
                this.putExtra(DAILY_WEATHER, gson.toJson(dailyWeather))
            }
        }
    }
    public var realTimeWeather: RealTimeWeather? = null
        private set
    public var hourlyWeather: HourlyWeather? = null
        private set
    public var dailyWeather: DailyWeather? = null
        private set
    init {
        val intent: Intent = dayDetailsActivity.intent
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
        dayDetailsActivity.initView()
    }

    private fun DayDetailsActivity.initView(){
        val daily=dailyWeather?.getNeedData()?.get(0)

        tv_det_wea.text=realTimeWeather?.getSkycon()//小雨
        tv_det_team.text="${daily?.getMinTem()}°/${daily?.getMaxTem()}°"//23°/30°
        tv_sun_up.text="日出:${dailyWeather?.result?.daily?.astro?.firstOrNull()?.sunrise?.time}"//日出：6:30
        tv_sun_down.text="日落:${dailyWeather?.result?.daily?.astro?.firstOrNull()?.sunset?.time}"//日落：6:30
        realTimeWeather?.getSkyconBigIcon()?.let {
            iv_det_wea.setImageResource(it)//天气图标
        }
        tv_hint1.text=daily?.alias+"  "+daily?.week

        val desList = ArrayList<DescribeBean.Des>()
        desList.add(DescribeBean.Des("紫外线", realTimeWeather?.result?.realtime?.life_index?.ultraviolet?.desc))
        desList.add(DescribeBean.Des("体感温度", realTimeWeather?.result?.realtime?.apparent_temperature.toString()))
        desList.add(DescribeBean.Des("空气质量", realTimeWeather?.getAqiDes()))
        desList.add(DescribeBean.Des(realTimeWeather?.getWindDirection(), realTimeWeather?.getWindDegree()))
        desList.add(DescribeBean.Des("能见度", realTimeWeather?.result?.realtime?.visibility.toString() + "公里"))
        desList.add(DescribeBean.Des("气压", realTimeWeather?.result?.realtime?.pressure?.toString() + "hPa"))
        val manager = GridLayoutManager(this, 3)
        rv_det_container.layoutManager = manager
        val describeAdapter = WeatherDescribeAdapter()
        describeAdapter.setData(desList)
        rv_det_container.adapter = describeAdapter

    }
}