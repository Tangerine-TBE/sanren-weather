package com.nanjing.tqlhl.utils

/**
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.utils
 * @class describe
 * @author wujinming QQ:1245074510
 * @time 2020/10/23 10:21
 * @class describe
 */
class KtUtil {
    companion object{

        @JvmStatic
        //紫外线指数
        fun ultravioletIndex(value: Int) = when (value) {
            0 -> "无"
            in 1..2 -> "最弱"
            in 3..4 -> "弱"
            in 5..6 -> "中等 "
            in 7..9 -> "强 "
            in 10..30 ->"很强"
            else -> "无"
        }

    }
}