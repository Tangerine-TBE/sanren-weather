package com.nanjing.tqlhl.utils

import java.util.*

/**
 * @name WeatherOne
 * @class name：com.example.tianqi.utils
 * @class describe
 * @author wujinming QQ:1245074510
 * @time 2021/3/30 13:45:04
 * @class describe
 */
//计算相差时间
fun calLastedTime(endDate: Date, nowDate: Date): Long {
    val nd = 1000 * 24 * 60 * 60.toLong()
    val nh = 1000 * 60 * 60.toLong()
    val nm = 1000 * 60.toLong()
    val ns = 1000;
    // 获得两个时间的毫秒时间差异
    val diff = endDate.time - nowDate.time
    // 计算差多少天
    val day = diff / nd
    // 计算差多少小时
    val hour = diff % nd / nh
    // 计算差多少分钟
    val min = diff % nd % nh / nm
    // 计算差多少秒//输出结果
    val sec = diff % nd % nh % nm / ns;
    return min
}