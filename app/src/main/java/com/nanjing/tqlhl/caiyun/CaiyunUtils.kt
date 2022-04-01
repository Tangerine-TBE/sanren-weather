package com.nanjing.tqlhl.caiyun

import android.util.Log
import com.nanjing.tqlhl.R
import com.nanjing.tqlhl.utils.ColorUtil
import kotlin.math.abs

private val directionArray by lazy {
    val orientation=arrayOf("正北", "东北", "正东", "东南", "正南", "西南", "正西", "西北", "正北")
    Array<Pair<Double, String>>(9){
        val p=it*45.0 to orientation[it]
        Log.i("mylog", p.toString())
        p
    }
}
/**
 * 获得风向
 */
fun getWindDirection(direction: Double):String{
    return directionArray.minBy {
        abs(it.first - direction)
    }?.second?:""
}

/**
 * speed：风速(km/h)
 */
fun windDegree(speed: Double):String{
    var speed1=speed/3.6//换为m/s
    speed1=(speed1*10+0.5).toInt().toDouble()/10//将speed保留一位小数
    val grade=when(speed1){//单位m/s
        in 0.0..0.2 -> {
            0
        }//{"无风"}
        in 0.3..1.5 -> {
            1
        }//{"软风"}
        in 1.6..3.3 -> {
            2
        }//{"轻风"}
        in 3.4..5.4 -> {
            3
        }//{"微风"}
        in 5.5..7.9 -> {
            4
        }//{"和风"}
        in 8.0..10.7 -> {
            5
        }//{"清风"}
        in 10.8..13.8 -> {
            6
        }//{"强风"}
        in 13.9..17.1 -> {
            7
        }//{"劲风"}
        in 17.2..20.7 -> {
            8
        }//{"大风"}
        in 20.8..24.4 -> {
            9
        }//{"烈风"}
        in 24.5..28.4 -> {
            10
        }//{"狂风"}
        in 28.5..32.6 -> {
            11
        }//{"暴风"}
        in 32.7..36.9 -> {
            12
        }//{"一级飓风"}
        in 37.0..41.4 -> {
            13
        }//{"一级飓风"}
        in 41.5..46.1 -> {
            14
        }//{"二级飓风"}
        in 46.2..50.9 -> {
            15
        }//{"三级飓风"}
        in 51.0..56.0 -> {
            16
        }//{"三级飓风"}
        in 56.1..61.2 -> {
            17
        }//{"四级飓风"}
        else ->{18}//{"四级飓风"}//17级以上
    }
    return if (grade>17){
        "17级以上"
    }else{
        "${grade}级"
    }
}

fun getAqiGrade(aqi: Int):String{
    return when(aqi){
        in 0..50 -> {
            "优"
        }
        in 51..100 -> {
            "良"
        }
        in 101..150 -> {
            "轻度污染"
        }
        in 151..200 -> {
            "中度污染"
        }
        in 201..300 -> {
            "重度污染"
        }
        else->{
            if (aqi>300){
                "严重污染"
            }else{
                "未知"
            }
        }

    }
}

/**
 * 主要天气现象
 */
fun getSkycon(skycon: String):String{
    return getSkyconInfo(skycon).skycon
}

/**
 * 获得天气现象的图标
 */
fun getSkyconIcon(skycon: String):Int{
    return getSkyconInfo(skycon).smallIcon
}
fun getSkyconBigIcon(skycon: String):Int{
    return getSkyconInfo(skycon).largeIcon
}

fun getSkyconBg(skycon: String):Int{
    return getSkyconInfo(skycon).bg
}
fun getSkyconColor(skycon: String):Int{
    return getSkyconInfo(skycon).color
}

class SkyconRes(val skycon: String, val smallIcon: Int, val largeIcon: Int, val bg: Int, val color: Int)

private fun getSkyconInfo(skycon: String):SkyconRes{
    return when(skycon){
        "CLEAR_DAY" -> {
            SkyconRes("晴", R.mipmap.iocn_small_qingtian, R.mipmap.iocn_large_qingtian,
                    R.mipmap.home_top_bg_fine,ColorUtil.CEHENGSE)
        }
        "CLEAR_NIGHT" -> {
            SkyconRes("晴夜", R.mipmap.icon_small_yewan, R.mipmap.icon_small_yewan,
                    R.mipmap.home_top_bg_fine,ColorUtil.CEHENGSE)
        }
        "PARTLY_CLOUDY_DAY" -> {
            SkyconRes("多云", R.mipmap.icon_small_duoyun, R.mipmap.icon_large_duoyun,
                    R.mipmap.home_top_bg_duoyun,ColorUtil.LAN)
        }
        "PARTLY_CLOUDY_NIGHT" -> {
            SkyconRes("多云", R.mipmap.icon_small_ye_duoyun, R.mipmap.icon_large_ye_duoyun,
                    R.mipmap.home_top_bg_ye_qing,ColorUtil.SHENLAN)
        }
        "CLOUDY" -> {
            SkyconRes("阴", R.mipmap.icon_small_yin, R.mipmap.icon_large_yin,
                    R.mipmap.home_top_bg_duoyun,ColorUtil.LAN)
        }
        "LIGHT_HAZE" -> {
            SkyconRes("轻度雾霾", R.mipmap.icon_small_wumai, R.mipmap.icon_large_wumai,
                    R.mipmap.home_top_bg_mai,ColorUtil.MAI)
        }
        "MODERATE_HAZE" -> {
            SkyconRes("中度雾霾", R.mipmap.icon_small_wumai, R.mipmap.icon_large_wumai,
                    R.mipmap.home_top_bg_mai,ColorUtil.MAI)
        }
        "HEAVY_HAZE" -> {
            SkyconRes("重度雾霾", R.mipmap.icon_small_wumai, R.mipmap.icon_large_wumai,
                    R.mipmap.home_top_bg_mai,ColorUtil.MAI)
        }
        "LIGHT_RAIN" -> {
            SkyconRes("小雨", R.mipmap.icon_small_xiaoyu, R.mipmap.icon_small_xiaoyu,
                    R.mipmap.home_top_bg_yu,ColorUtil.HUILAN)
        }
        "MODERATE_RAIN" -> {
            SkyconRes("中雨", R.mipmap.icon_small_zhongyu, R.mipmap.icon_small_zhongyu,
                    R.mipmap.home_top_bg_yu,ColorUtil.HUILAN)
        }
        "HEAVY_RAIN" -> {
            SkyconRes("大雨", R.mipmap.iocn_small_dayu, R.mipmap.iocn_large_dayu,
                    R.mipmap.home_top_bg_yu,ColorUtil.HUILAN)
        }
        "STORM_RAIN" -> {
            SkyconRes("暴雨", R.mipmap.iocn_small_dayu, R.mipmap.iocn_small_dayu,
                    R.mipmap.home_top_bg_yu,ColorUtil.HUILAN)
        }
        "FOG" -> {
            SkyconRes("雾", R.mipmap.icon_small_wutian, R.mipmap.icon_large_wutian,
                    R.mipmap.home_top_bg_duoyun,ColorUtil.LAN)
        }
        "LIGHT_SNOW" -> {
            SkyconRes("小雪", R.mipmap.icon_small_xiaoxue, R.mipmap.icon_large_xiaoxue,
                    R.mipmap.home_top_bg_xue,ColorUtil.LAN)
        }
        "MODERATE_SNOW" -> {
            SkyconRes("中雪", R.mipmap.icon_small_zhongxue, R.mipmap.icon_large_zhongxue,
                    R.mipmap.home_top_bg_xue,ColorUtil.LAN)
        }
        "HEAVY_SNOW" -> {
            SkyconRes("大雪", R.mipmap.icon_small_daxue, R.mipmap.icon_large_daxue,
                    R.mipmap.home_top_bg_xue,ColorUtil.LAN)
        }
        "STORM_SNOW" -> {
            SkyconRes("暴雪", R.mipmap.icon_small_daxue, R.mipmap.icon_large_daxue,
                    R.mipmap.home_top_bg_xue,ColorUtil.LAN)
        }
        "DUST" -> {
            SkyconRes("浮尘", R.mipmap.icon_small_shachen, R.mipmap.icon_large_shachen,
                    R.mipmap.home_top_bg_mai,ColorUtil.MAI)
        }
        "SAND" -> {
            SkyconRes("沙尘", R.mipmap.icon_small_shachen, R.mipmap.icon_large_shachen,
                    R.mipmap.home_top_bg_mai,ColorUtil.MAI)
        }
        "WIND" -> {
            SkyconRes("多云", R.mipmap.icon_small_duoyun, R.mipmap.icon_large_duoyun,
                    R.mipmap.home_top_bg_duoyun,ColorUtil.LAN)
        }
        else->{
            SkyconRes("晴", R.mipmap.iocn_small_qingtian, R.mipmap.iocn_large_qingtian,
                    R.mipmap.home_top_bg_fine,ColorUtil.CEHENGSE)
        }
    }
}