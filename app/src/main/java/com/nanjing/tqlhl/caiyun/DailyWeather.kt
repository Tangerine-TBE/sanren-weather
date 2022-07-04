package com.nanjing.tqlhl.caiyun

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

/**
 * https://api.caiyunapp.com/v2.5/97jF1iLZ81PziwVm/121.6544,25.1552/daily.json
 */
data class DailyWeather(
        val api_status: String,
        val api_version: String,
        val lang: String,
        val location: List<Double>,
        val result: Result,
        val server_time: Int,
        val status: String,
        val timezone: String,
        val tzshift: Int,
        val unit: String
){
    /**
     * @param
     */
    class DailyNeedData constructor(val date:String, val week:String, val alias:String, private val skycon:String, val temperature: Temperature, val wind: Wind, val aqi: Aqi){
        fun getMaxTem():Int{
            return (temperature.max+0.5).toInt()
        }
        fun getMinTem():Int{
            return (temperature.min+0.5).toInt()
        }
        fun getSkyconDes():String{
            return getSkycon(skycon)
        }
        fun getSkyconIcon():Int{
            return getSkyconIcon(skycon)
        }
        fun getWindDirection():String{
            return getWindDirection(wind.max.direction)
        }
        fun getWindDegree():String{
            return windDegree(wind.max.speed)
        }
        fun getAqiGrade():String{
            return getAqiGrade(aqi.max.chn)
        }
    }

    var needData_ :List<DailyNeedData>?=null

    fun getNeedData():List<DailyNeedData>{
        needData_?.also {
            return it
        }
        val skycons=result.daily.skycon
        val temperatures=result.daily.temperature
        val winds=result.daily.wind
        val aqi=result.daily.air_quality.aqi
        val needData=ArrayList<DailyNeedData>()
        val simpleDateFormat =SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
        val numberFormat=NumberFormat.getNumberInstance().apply {
            this.minimumIntegerDigits=2
        }
        val calendar=Calendar.getInstance()
        val today:LongRange
        val tomorrow:LongRange
        val day=24L*60L*60L*1000L
        calendar.apply {
            this.timeInMillis=System.currentTimeMillis()
            this.set(Calendar.HOUR_OF_DAY,0)
            this.set(Calendar.MINUTE,0)
            this.set(Calendar.SECOND,0)
            this.set(Calendar.MILLISECOND,0)
            val start=this.timeInMillis

            this.set(Calendar.HOUR_OF_DAY,23)
            this.set(Calendar.MINUTE,59)
            this.set(Calendar.SECOND,59)
            this.set(Calendar.MILLISECOND,999)
            today=start .. this.timeInMillis
            tomorrow=start+day .. this.timeInMillis+day
        }

        for (i in 0 until (intArrayOf(skycons.size,temperatures.size,winds.size,aqi.size).min()?:0)){
            val time=simpleDateFormat.parse(skycons[i].date.substringBefore("T"))
            val date:String
            val week:String
            val alias:String//今天
            if (time==null){
                date="出错了"
                week="出错了"
                alias="出错了"
            }else{
                calendar.timeInMillis=time.time
                date=numberFormat.format((calendar.get(Calendar.MONTH)+1))+"/"+numberFormat.format(calendar.get(Calendar.DAY_OF_MONTH))

                week=calendar.get(Calendar.DAY_OF_WEEK).let {
                    when(it){
                        Calendar.SUNDAY->{
                            "星期日"
                        }
                        Calendar.MONDAY->{
                            "星期一"
                        }
                        Calendar.TUESDAY->{
                            "星期二"
                        }
                        Calendar.WEDNESDAY->{
                            "星期三"
                        }
                        Calendar.THURSDAY->{
                            "星期四"
                        }
                        Calendar.FRIDAY->{
                            "星期五"
                        }
                        Calendar.SATURDAY->{
                            "星期六"
                        }
                        else->{
                            "出错了"
                        }
                    }
                }
                alias=if (today.contains(time.time)){
                    "今天"
                }else if (tomorrow.contains(time.time)){
                    "明天"
                }else{
                    val interval=time.time-today.first
                    val dayCount = abs(interval/day)
                    if (interval>0){
                        "${dayCount}天后"
                    }else{
                        "${dayCount}天前"
                    }
                }
            }

            needData.add(DailyNeedData(
                    date,
                    week,
                    alias,
                    skycons[i].value,
                    temperatures[i],
                    winds[i],
                    aqi[i]
            ))
        }
        needData_=needData
        return needData
    }

    data class Result(
            val daily: Daily,
            val primary: Int
    )

    data class Daily(
            val air_quality: AirQuality,
            val astro: List<Astro>,
            val cloudrate: List<Cloudrate>,
            val dswrf: List<Dswrf>,
            val humidity: List<Humidity>,
            val life_index: LifeIndex,
            val precipitation: List<Precipitation>,
            val pressure: List<Pressure>,
            val skycon: List<Skycon>,
            val skycon_08h_20h: List<Skycon08h20h>,
            val skycon_20h_32h: List<Skycon20h32h>,
            val status: String,
            val temperature: List<Temperature>,
            val visibility: List<Visibility>,
            val wind: List<Wind>
    )

    data class AirQuality(
            val aqi: List<Aqi>,
            val pm25: List<Pm25>
    )

    data class Astro(
            val date: String,
            val sunrise: Sunrise,
            val sunset: Sunset
    )

    data class Cloudrate(
            val avg: Double,
            val date: String,
            val max: Double,
            val min: Double
    )

    data class Dswrf(
            val avg: Double,
            val date: String,
            val max: Double,
            val min: Double
    )

    data class Humidity(
            val avg: Double,
            val date: String,
            val max: Double,
            val min: Double
    )

    data class LifeIndex(
            val carWashing: List<CarWashing>,
            val coldRisk: List<ColdRisk>,
            val comfort: List<Comfort>,
            val dressing: List<Dressing>,
            val ultraviolet: List<Ultraviolet>
    )

    data class Precipitation(
            val avg: Double,
            val date: String,
            val max: Double,
            val min: Double
    )

    data class Pressure(
            val avg: Double,
            val date: String,
            val max: Double,
            val min: Double
    )

    data class Skycon(
            val date: String,
            val value: String
    )

    data class Skycon08h20h(
            val date: String,
            val value: String
    )

    data class Skycon20h32h(
            val date: String,
            val value: String
    )

    data class Temperature(
            val avg: Double,
            val date: String,
            val max: Double,
            val min: Double
    )

    data class Visibility(
            val avg: Double,
            val date: String,
            val max: Double,
            val min: Double
    )

    data class Wind(
            val avg: AvgX,
            val date: String,
            val max: MaxX,
            val min: MinX
    )

    data class Aqi(
            val avg: Avg,
            val date: String,
            val max: Max,
            val min: Min
    )

    data class Pm25(
            val avg: Int,
            val date: String,
            val max: Int,
            val min: Int
    )

    data class Avg(
            val chn: Int,
            val usa: Int
    )

    data class Max(
            val chn: Int,
            val usa: Int
    )

    data class Min(
            val chn: Int,
            val usa: Int
    )

    data class Sunrise(
            val time: String
    )

    data class Sunset(
            val time: String
    )

    data class CarWashing(
            val date: String,
            val desc: String,
            val index: String
    )

    data class ColdRisk(
            val date: String,
            val desc: String,
            val index: String
    )

    data class Comfort(
            val date: String,
            val desc: String,
            val index: String
    )

    data class Dressing(
            val date: String,
            val desc: String,
            val index: String
    )

    data class Ultraviolet(
            val date: String,
            val desc: String,
            val index: String
    )

    data class AvgX(
            val direction: Double,
            val speed: Double
    )

    data class MaxX(
            val direction: Double,
            val speed: Double
    )

    data class MinX(
            val direction: Double,
            val speed: Double
    )
}