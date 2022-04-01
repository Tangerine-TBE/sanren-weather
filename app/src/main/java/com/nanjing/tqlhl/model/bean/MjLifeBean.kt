package com.nanjing.tqlhl.model.bean

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/8 15:33
 * @class describe
 */
class MjLifeBean {
    override fun toString(): String {
        return "MjLifeBean{" +
                "code=" + code +
                ", day='" + day + '\'' +
                ", desc='" + desc + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}'
    }

    /**
     * code : 21
     * day : 2020-09-09
     * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
     * level : 1
     * name : 紫外线指数
     * status : 最弱
     * updatetime : 2020-09-09 09:35:03
     */
    var code = 0
    var day: String? = null
    var desc: String? = null
    var level: String? = null
    var name: String? = null
    var status: String? = null
    var updatetime: String? = null
}