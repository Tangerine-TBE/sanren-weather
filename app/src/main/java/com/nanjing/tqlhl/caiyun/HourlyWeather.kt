package com.nanjing.tqlhl.caiyun

data class HourlyWeather(
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
     * @param datetime "datetime": "2022-03-02T14:00+08:00"
     * @param temperature 温度
     * @param skycon 天气现象
     * @param direction 风向
     * @param speed 风速
     */
    class HourlyNeedData constructor(private val datetime:String, private val temperature:Double, private val skycon:String, private val direction:Double, private val speed:Double){
        fun getTem():String{
            return "${(temperature+0.5).toInt()}°"
        }

        fun getTemValue():Int{
            return (temperature+0.5).toInt()
        }

        fun getTime():String{
            return datetime.substringAfter("T").substringBefore("+")
        }
        fun getSkyconDes():String{
            return getSkycon(skycon)
        }
        fun getSkyconIcon():Int{
            return getSkyconIcon(skycon)
        }
        fun getSkyconBigIcon():Int{
            return getSkyconBigIcon(skycon)
        }
        fun getWindDirection():String{
            return getWindDirection(direction)
        }
        fun getWindDegree():String{
            return windDegree(speed)
        }

    }
    private var needData:List<HourlyNeedData>?=null
    fun getData():List<HourlyNeedData>{
        needData?.also {
            return it
        }
        val temperatures=result.hourly.temperature
        val skycons=result.hourly.skycon
        val wind=result.hourly.wind

        val data=ArrayList<HourlyNeedData>()
        for (i in 0 until (intArrayOf(temperatures.size,skycons.size,wind.size).min()?:0)){
            data.add(
                    HourlyNeedData(temperatures[i].datetime,
                            temperatures[i].value,
                            skycons[i].value,
                            wind[i].direction,
                            wind[i].speed)
            )
        }
        needData=data
        return data
    }

    data class Result(
            val forecast_keypoint: String,
            val hourly: Hourly,
            val primary: Int
    )

    data class Hourly(
            val air_quality: AirQuality,
            val cloudrate: List<Cloudrate>,
            val description: String,
            val dswrf: List<Dswrf>,
            val humidity: List<Humidity>,
            val precipitation: List<Precipitation>,
            val pressure: List<Pressure>,
            val skycon: List<Skycon>,
            val status: String,
            val temperature: List<Temperature>,
            val visibility: List<Visibility>,
            val wind: List<Wind>
    )

    data class AirQuality(
            val aqi: List<Aqi>,
            val pm25: List<Pm25>
    )

    data class Cloudrate(
            val datetime: String,
            val value: Double
    )

    data class Dswrf(
            val datetime: String,
            val value: Double
    )

    data class Humidity(
            val datetime: String,
            val value: Double
    )

    data class Precipitation(
            val datetime: String,
            val value: Double
    )

    data class Pressure(
            val datetime: String,
            val value: Double
    )

    data class Skycon(
            val datetime: String,
            val value: String
    )

    data class Temperature(
            val datetime: String,
            val value: Double
    )

    data class Visibility(
            val datetime: String,
            val value: Double
    )

    data class Wind(
            val datetime: String,
            val direction: Double,
            val speed: Double
    )

    data class Aqi(
            val datetime: String,
            val value: Value
    )

    data class Pm25(
            val datetime: String,
            val value: Int
    )

    data class Value(
            val chn: Int,
            val usa: Int
    )
}