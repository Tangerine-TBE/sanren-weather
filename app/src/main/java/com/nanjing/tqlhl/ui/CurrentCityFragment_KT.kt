package com.nanjing.tqlhl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module_tool.utils.SPUtil
import com.google.gson.Gson
import com.nanjing.tqlhl.R
import com.nanjing.tqlhl.base.BaseApplication
import com.nanjing.tqlhl.caiyun.DailyWeather
import com.nanjing.tqlhl.caiyun.HourlyWeather
import com.nanjing.tqlhl.caiyun.RealTimeWeather
import com.nanjing.tqlhl.caiyun.viewmodel.CaiyunViewModel
import com.nanjing.tqlhl.model.bean.MjDesBean
import com.nanjing.tqlhl.ui.custom.mj15day.AirLevel
import com.nanjing.tqlhl.ui.custom.mj15day.WeatherModel
import com.nanjing.tqlhl.ui.fragment.CurrentCityFragment
import com.nanjing.tqlhl.utils.KtUtil.Companion.ultravioletIndex
import com.nanjing.tqlhl.utils.WeatherUtils
import kotlinx.android.synthetic.main.activity_air.*
import kotlinx.android.synthetic.main.fragment_current_city.*
import kotlinx.android.synthetic.main.fragment_current_city.weather15_view
import java.util.*

class CurrentCityFragment_KT constructor(val fragment: CurrentCityFragment) {
    companion object{
        private fun putRealTimeData(city: String, realtimeWeather: String){
            SPUtil.getInstance().putString(city + "realtime", realtimeWeather)
        }
        private fun getRealTimeData(city: String): RealTimeWeather?{
            val string=SPUtil.getInstance().getString(city + "realtime")
            val gson=Gson()
            return try {
                gson.fromJson(string, RealTimeWeather::class.java)
            }catch (e: Exception){
                null
            }
        }
        private fun putDailyData(city: String, dailyWeather: String){
            SPUtil.getInstance().putString(city + "daily", dailyWeather)
        }
        private fun getDailyData(city: String): DailyWeather?{
            val string=SPUtil.getInstance().getString(city + "daily")
            val gson=Gson()
            return try {
                gson.fromJson(string, DailyWeather::class.java)
            }catch (e: Exception){
                null
            }
        }
        private fun putHourlyData(city: String, hourlyWeather: String){
            SPUtil.getInstance().putString(city + "hourly", hourlyWeather)
        }
        private fun getHourlyData(city: String): HourlyWeather?{
            val string=SPUtil.getInstance().getString(city + "hourly")
            val gson=Gson()
            return try {
                gson.fromJson(string, HourlyWeather::class.java)
            }catch (e: Exception){
                null
            }
        }
    }
    private val viewModel by lazy {
        ViewModelProvider(fragment, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.newInstance()
            }
        }).get(CaiyunViewModel::class.java)
    }
    interface CaiyunDataCall{
        fun dailyDataCall(dailyWeather: DailyWeather)

        fun hourlyDataCall(hourlyWeather: HourlyWeather)

        fun realtimeDataCall(realTimeWeather: RealTimeWeather)
    }
    private var caiyunDataCall:CaiyunDataCall?=null

    fun pullToRefresh(lon: String, lat: String, city: String, successAction: (() -> Unit)? = null, failAction: (() -> Unit)? = null){
        fragment.realtimeWeather(lon, lat, city, {
            successAction?.invoke()
        }, {
            failAction?.invoke()
        })
        fragment.dailyWeather(lon, lat, city)
        fragment.hourWeather(lon, lat, city)
    }

    fun requestData(lon: String, lat: String, city: String){
        fragment.realtimeWeather(lon, lat, city)
        fragment.dailyWeather(lon, lat, city)
        fragment.hourWeather(lon, lat, city)
    }
    fun setCaiyunCall(caiyunDataCall: CaiyunDataCall){
        this.caiyunDataCall=caiyunDataCall
    }

    private fun CurrentCityFragment.realtimeWeather(lon: String, lat: String, city: String, successAction: (() -> Unit)? = null, failAction: (() -> Unit)? = null){
        viewModel.realtimeWeather(lon, lat, {
            successAction?.invoke()
            realtimeData(it)
            putRealTimeData(city, Gson().toJson(it))
        }, {
            failAction?.invoke()
            getRealTimeData(city)?.also {
                realtimeData(it)
            }
        })
    }

    private fun CurrentCityFragment.dailyWeather(lon: String, lat: String, city: String){
        viewModel.dailyWeather(lon, lat, { dailyWeather ->
            dailyWeatherData(dailyWeather)
            putDailyData(city, Gson().toJson(dailyWeather))
        }, {
            getDailyData(city)?.also {
                dailyWeatherData(it)
            }
        })
    }
    private fun CurrentCityFragment.hourWeather(lon: String, lat: String, city: String){
        viewModel.hourWeather(lon, lat, {
            caiyunDataCall?.hourlyDataCall(it)
            putHourlyData(city, Gson().toJson(it))
        }, {
            getHourlyData(city)?.also {
                caiyunDataCall?.hourlyDataCall(it)
            }
        })
    }
    private fun showWeatherDes(realTimeWeather: RealTimeWeather, hourlyWeather: HourlyWeather, dailyWeather: DailyWeather) {


    }

    private fun CurrentCityFragment.realtimeData(realTimeWeather: RealTimeWeather){
        caiyunDataCall?.realtimeDataCall(realTimeWeather)
//        it.getAqiDes()
//        it.getWindDirection()+it.getWindDegree()
//        it.getHumidity()//湿度89%
//        it.getComfort()//舒适度：闷热
//        it.getUltraviolet()//紫外线强度：弱
        tv_home_team.text=realTimeWeather.getTemperature()//32°
        tv_home_wea.text=realTimeWeather.getSkycon()//多云
        iv_icon_weather.setImageResource(realTimeWeather.getSkyconIcon())
//        tv_CurrentWeek//星期几
//        tv_TepRanger//温度范围,20°/55°
        iv_top_bg.setImageResource(realTimeWeather.getSkyconBg())
    }
    private fun CurrentCityFragment.dailyWeatherData(dailyWeather: DailyWeather){
        val data=dailyWeather.getNeedData()
        weather15_view.list=data.map {dailyNeedData->
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
        ultravioletValue.text=dailyWeather.result.daily.life_index.ultraviolet.first().desc
        comfortValue.text=dailyWeather.result.daily.life_index.comfort.first().desc
        carWashingValue.text=dailyWeather.result.daily.life_index.carWashing.first().desc
        coldRiskValue.text=dailyWeather.result.daily.life_index.coldRisk.first().desc

        tv_week_hint.text=data.firstOrNull()?.alias+" ${data?.firstOrNull()?.week}"
        tv_day_hint.text="现在"
        caiyunDataCall?.dailyDataCall(dailyWeather)
    }



}