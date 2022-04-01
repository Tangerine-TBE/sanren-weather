package com.nanjing.tqlhl.model.bean

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/8 15:34
 * @class describe
 */
class MjAqiBean {
    /**
     * code : 0
     * data : {"aqi":{"cityName":"东城区","co":"4","no2":"21","o3":"13","pm10":"43","pm25":"5","pubtime":"1472688000000","rank":"222/621","so2":"1","value":"43"},"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}}
     * msg : success
     * rc : {"c":0,"p":"success"}
     */
    var code = 0
    var data: DataBean? = null
    var msg: String? = null
    var rc: RcBean? = null

    class DataBean {
        /**
         * aqi : {"cityName":"东城区","co":"4","no2":"21","o3":"13","pm10":"43","pm25":"5","pubtime":"1472688000000","rank":"222/621","so2":"1","value":"43"}
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         */
        var aqi: AqiBean? = null
        var city: CityBean? = null

        class AqiBean {
            /**
             * cityName : 东城区
             * co : 4
             * no2 : 21
             * o3 : 13
             * pm10 : 43
             * pm25 : 5
             * pubtime : 1472688000000
             * rank : 222/621
             * so2 : 1
             * value : 43
             */
            var cityName: String? = null
            var co: String? = null
            var no2: String? = null
            var o3: String? = null
            var pm10: String? = null
            var pm25: String? = null
            var pubtime: String? = null
            var rank: String? = null
            var so2: String? = null
            var value: String? = null
        }

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