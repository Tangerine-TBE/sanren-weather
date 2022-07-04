package com.nanjing.tqlhl.caiyun

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CaiyunRetrofit {
    /**
     * 通用预报接口：https://api.caiyunapp.com/v2.5/97jF1iLZ81PziwVm/121.6544,25.1552/weather.json
    实况天气接口：https://api.caiyunapp.com/v2.5/97jF1iLZ81PziwVm/121.6544,25.1552/realtime.json
    分钟级降雨预报接口：https://api.caiyunapp.com/v2.5/97jF1iLZ81PziwVm/121.6544,25.1552/minutely.json
    小时级预报接口：https://api.caiyunapp.com/v2.5/97jF1iLZ81PziwVm/121.6544,25.1552/hourly.json
    天级预报接口：https://api.caiyunapp.com/v2.5/97jF1iLZ81PziwVm/121.6544,25.1552/daily.json
     */
    private val caiyunRetrofit by lazy {

        Retrofit.Builder()
//                .client(OkHttpClient.Builder().apply {
//                    this.addInterceptor(LoggingInterceptor.Builder().setLevel(Level.BODY).build())
//                }.build())
                .baseUrl("https://api.caiyunapp.com/v2.5/97jF1iLZ81PziwVm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val caiyunApi by lazy {
        caiyunRetrofit.create(CaiyunApi::class.java)
    }
}