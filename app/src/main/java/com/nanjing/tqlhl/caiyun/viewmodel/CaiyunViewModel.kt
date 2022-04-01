package com.nanjing.tqlhl.caiyun.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.nanjing.tqlhl.caiyun.CaiyunRetrofit
import com.nanjing.tqlhl.caiyun.DailyWeather
import com.nanjing.tqlhl.caiyun.HourlyWeather
import com.nanjing.tqlhl.caiyun.RealTimeWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.PrintWriter
import java.io.StringWriter

class CaiyunViewModel:ViewModel() {
    private val gson by lazy { Gson() }
    private var realCall:Call<RealTimeWeather>?=null
    private var hourCall:Call<HourlyWeather>?=null
    private var dailyCall:Call<DailyWeather>?=null

    fun realtimeWeather(lon:String, lat:String, successCall:(RealTimeWeather)->Unit, failCall:(String)->Unit){
        realCall= CaiyunRetrofit.caiyunApi.getRealWeather(lon, lat)
        realCall?.enqueue(object: Callback<RealTimeWeather>{
            override fun onResponse(call: Call<RealTimeWeather>, response: Response<RealTimeWeather>) {
                response.body().also {
                    if (it==null){
                        failCall.invoke("出错了")
                    }else{
                        Log.i("myLog",gson.toJson(it))
                        successCall.invoke(it)
                    }
                }
            }

            override fun onFailure(call: Call<RealTimeWeather>, t: Throwable) {
                failCall.invoke("出错了")
                printfErrorLog(t)
            }
        })
    }

    fun hourWeather(lon:String, lat:String, successCall:(HourlyWeather)->Unit, failCall:(String)->Unit){
        hourCall=CaiyunRetrofit.caiyunApi.getHourWeather(lon, lat)
        hourCall?.enqueue(object: Callback<HourlyWeather>{
            override fun onResponse(call: Call<HourlyWeather>, response: Response<HourlyWeather>) {
                response.body().also {
                    if (it==null){
                        failCall.invoke("出错了")
                    }else{
                        Log.i("myLog",gson.toJson(it))
                        successCall.invoke(it)
                    }
                }
            }

            override fun onFailure(call: Call<HourlyWeather>, t: Throwable) {
                failCall.invoke("出错了")
                printfErrorLog(t)
            }
        })
    }

    fun dailyWeather(lon:String, lat:String, successCall:(DailyWeather)->Unit, failCall:(String)->Unit){
        dailyCall=CaiyunRetrofit.caiyunApi.getDailyWeather(lon, lat)
        dailyCall?.enqueue(object: Callback<DailyWeather>{
            override fun onResponse(call: Call<DailyWeather>, response: Response<DailyWeather>) {
                response.body().also {
                    if (it==null){
                        failCall.invoke("出错了")
                    }else{
                        Log.i("myLog",gson.toJson(it))
                        successCall.invoke(it)
                    }
                }
            }

            override fun onFailure(call: Call<DailyWeather>, t: Throwable) {
                failCall.invoke("出错了")
                printfErrorLog(t)
            }
        })
    }

    private fun printfErrorLog(t:Throwable){
        val sw=StringWriter()
        val pw=PrintWriter(sw)
        t.printStackTrace(pw)
        pw.flush()
        Log.e("myLog-出错了",sw.toString())
    }

    override fun onCleared() {
        super.onCleared()
        realCall?.cancel()
        hourCall?.cancel()
        dailyCall?.cancel()
    }

}