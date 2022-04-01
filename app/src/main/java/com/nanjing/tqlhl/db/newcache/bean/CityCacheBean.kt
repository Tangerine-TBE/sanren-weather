package com.nanjing.tqlhl.db.newcache.bean

import org.litepal.crud.LitePalSupport

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.db.newcache.bean
 * @class describe
 * @time 2020/9/17 14:03
 * @class describe
 */
class CityCacheBean : LitePalSupport() {
    var city: String? = null
    var longitude: String? = null
    var latitude: String? = null
    var wea: String? = null
    var windy: String? = null
    var team: String? = null
    var lowHigh: String? = null
    var aqi: String? = null
    var dayIcon: String? = null
    var nightIcon: String? = null
    var skyIcon:Int=0
}