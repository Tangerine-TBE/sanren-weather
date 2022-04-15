package com.nanjing.tqlhl.caiyun

class RealTimeWeather {
    var status: String? = null
    var api_version: String? = null
    var api_status: String? = null
    var lang: String? = null
    var unit: String? = null
    var tzshift = 0
    var timezone: String? = null
    var server_time: Long = 0
    var location: List<Double>? = null
    var result: Result? = null
    fun getAqi():Int{
        return result?.realtime?.air_quality?.aqi?.chn?:0
    }
    fun getAqiDes():String?{
        return result?.realtime?.air_quality?.description?.chn//空气质量：优
    }
    /**
     * 获得风向
     */
    fun getWindDirection():String{
        val direction=result?.realtime?.wind?.direction?:0.0
        return getWindDirection(direction)
    }

    fun getWindDegree():String{
        return windDegree(result?.realtime?.wind?.speed?:0.0)
    }

    /**
     * 相对湿度(%)
     */
    fun getHumidity():String{
        return result?.realtime?.humidity.let {
            if (it==null){
                "湿度:未知"
            }else{
                "湿度:${(it*100+0.5).toInt()}%"
            }
        }
    }

    /**
     * 舒适度
     */
    fun getComfortDes():String{
        return "舒适度:"+(result?.realtime?.life_index?.comfort?.desc?:"未知")
    }
    fun getComfort():String{
        return (result?.realtime?.life_index?.comfort?.desc?:"未知")
    }

    /**
     * 紫外线
     */
    fun getUltravioletDes():String{
        return "紫外线强度:"+(result?.realtime?.life_index?.ultraviolet?.desc?:"未知")
    }

    fun getUltraviolet():String{
        return (result?.realtime?.life_index?.ultraviolet?.desc?:"未知")
    }

    /**
     * 温度
     */
    fun getTemperature():String{
        return result?.realtime?.temperature.let {
            if (it==null){
                "未知"
            }else{
                "${it}°"
            }
        }
    }

    /**
     * 主要天气现象
     */
    fun getSkycon():String{
        return getSkycon(result?.realtime?.skycon ?: "")
    }
    fun getSkyconBigIcon():Int{
        return getSkyconBigIcon(result?.realtime?.skycon ?: "")
    }
    fun getSkyconIcon():Int{
        return getSkyconIcon(result?.realtime?.skycon ?: "")
    }
    fun getSkyconBg():Int{
        return getSkyconBg(result?.realtime?.skycon ?: "")
    }

    fun getSkyconColor():Int{
        return getSkyconColor(result?.realtime?.skycon ?: "")
    }
    class Result {
        var realtime: Realtime? = null
        var primary = 0
        class Realtime {
            var status: String? = null
            var temperature = 0
            var humidity = 0.0
            var cloudrate = 0.0
            var skycon: String? = null
            var visibility = 0.0
            var dswrf = 0.0
            var wind: Wind? = null
            class Wind {
                var speed = 0.0
                var direction = 0.0
            }
            var pressure = 0.0
            var apparent_temperature = 0.0
            var precipitation: Precipitation? = null
            class Precipitation {
                var local: Local? = null
                class Local {
                    var status: String? = null
                    var datasource: String? = null
                    var intensity = 0
                }
            }
            var air_quality: Air_quality? = null
            class Air_quality {
                var pm25 = 0.0
                var pm10 = 0.0
                var o3 = 0.0
                var so2 = 0.0
                var no2 = 0.0
                var co = 0.0
                var aqi: Aqi? = null
                class Aqi {
                    var chn = 0
                    var usa = 0
                }
                var description: Description? = null
                class Description {
                    var usa: String? = null
                    var chn: String? = null
                }
            }
            var life_index: Life_index? = null
            class Life_index {
                var ultraviolet: Ultraviolet? = null
                class Ultraviolet {
                    var index = 0
                    var desc: String? = null
                }
                var comfort: Comfort? = null
                class Comfort {
                    var index = 0
                    var desc: String? = null
                }
            }
        }
    }
}