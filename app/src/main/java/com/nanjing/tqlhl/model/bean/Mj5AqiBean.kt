package com.nanjing.tqlhl.model.bean

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/10 15:55
 * @class describe
 */
class Mj5AqiBean {
    /**
     * code : 0
     * data : {"aqiForecast":[{"date":"2016-08-31","publishTime":"2016-08-31 00:00:00","value":39},{"date":"2016-09-01","publishTime":"2016-09-01 00:00:00","value":18},{"date":"2016-09-02","publishTime":"2016-09-01 21:20:00","value":67},{"date":"2016-09-03","publishTime":"2016-09-01 21:20:00","value":65},{"date":"2016-09-04","publishTime":"2016-09-01 21:20:00","value":134},{"date":"2016-09-05","publishTime":"2016-09-01 21:20:00","value":128}],"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}}
     * msg : success
     * rc : {"c":0,"p":"success"}
     */
    var code = 0
    var data: DataBean? = null
    var msg: String? = null
    var rc: RcBean? = null

    class DataBean {
        /**
         * aqiForecast : [{"date":"2016-08-31","publishTime":"2016-08-31 00:00:00","value":39},{"date":"2016-09-01","publishTime":"2016-09-01 00:00:00","value":18},{"date":"2016-09-02","publishTime":"2016-09-01 21:20:00","value":67},{"date":"2016-09-03","publishTime":"2016-09-01 21:20:00","value":65},{"date":"2016-09-04","publishTime":"2016-09-01 21:20:00","value":134},{"date":"2016-09-05","publishTime":"2016-09-01 21:20:00","value":128}]
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         */
        var city: CityBean? = null
        var aqiForecast: List<AqiForecastBean>? = null

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

        class AqiForecastBean {
            /**
             * date : 2016-08-31
             * publishTime : 2016-08-31 00:00:00
             * value : 39
             */
            var date: String? = null
            var publishTime: String? = null
            var value = 0
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