package com.nanjing.tqlhl.model.bean

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/8 14:49
 * @class describe
 */
class MjRealWeatherBean {
    /**
     * code : 0
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"condition":{"condition":"晴","conditionId":"5","humidity":"42","icon":"30","pressure":"999","realFeel":"18","sunRise":"2016-09-01 05:42:00","sunSet":"2016-09-01 18:45:00","temp":"24","tips":"冷热适宜，感觉很舒适。","updatetime":"2016-09-01 22:03:00","uvi":"0","windDir":"东北风","windLevel":"2","windSpeed":"2.45"}}
     * msg : success
     * rc : {"c":0,"p":"success"}
     */
//    var code = 0
    var data: DataBean? = null
//    var msg: String? = null
//    var rc: RcBean? = null

    class DataBean {
        /**
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         * condition : {"condition":"晴","conditionId":"5","humidity":"42","icon":"30","pressure":"999","realFeel":"18","sunRise":"2016-09-01 05:42:00","sunSet":"2016-09-01 18:45:00","temp":"24","tips":"冷热适宜，感觉很舒适。","updatetime":"2016-09-01 22:03:00","uvi":"0","windDir":"东北风","windLevel":"2","windSpeed":"2.45"}
         */
//        var city: CityBean? = null
        var condition: ConditionBean? = null

        class CityBean {
            /**
             * cityId : 284609
             * counname : 中国
             * name : 东城区
             * pname : 北京市
             */
            var cityId = 0
            var counname: String? = null
            var name: String? = null
            var pname: String? = null
        }

        class ConditionBean {
            /**
             * condition : 晴
             * conditionId : 5
             * humidity : 42
             * icon : 30
             * pressure : 999
             * realFeel : 18
             * sunRise : 2016-09-01 05:42:00
             * sunSet : 2016-09-01 18:45:00
             * temp : 24
             * tips : 冷热适宜，感觉很舒适。
             * updatetime : 2016-09-01 22:03:00
             * uvi : 0
             * windDir : 东北风
             * windLevel : 2
             * windSpeed : 2.45
             */
//            var condition: String? = null
//            var conditionId: String? = null
//            var humidity: String? = null
//            var icon: String? = null
            var pressure: String? = null
            var realFeel: String? = null
            var sunRise: String? = null
            var sunSet: String? = null
            var temp: String? = null
//            var tips: String? = null
//            var updatetime: String? = null
            var uvi: String? = null
            var windDir: String? = null
            var windLevel: String? = null
            var windSpeed: String? = null
        }
    }

    class RcBean {
        /**
         * c : 0
         * p : success
         */
        var c = 0
        var p: String? = null
    }
}