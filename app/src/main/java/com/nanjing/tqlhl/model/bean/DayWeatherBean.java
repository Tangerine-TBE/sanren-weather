package com.nanjing.tqlhl.model.bean;

import java.util.List;

public class DayWeatherBean  {

    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Taipei
     * server_time : 1593505245
     * location : [25.1552,121.6544]
     * result : {"daily":{"status":"ok","astro":[{"date":"2020-06-30T00:00+08:00","sunrise":{"time":"05:06"},"sunset":{"time":"18:47"}},{"date":"2020-07-01T00:00+08:00","sunrise":{"time":"05:06"},"sunset":{"time":"18:47"}},{"date":"2020-07-02T00:00+08:00","sunrise":{"time":"05:07"},"sunset":{"time":"18:47"}},{"date":"2020-07-03T00:00+08:00","sunrise":{"time":"05:07"},"sunset":{"time":"18:47"}},{"date":"2020-07-04T00:00+08:00","sunrise":{"time":"05:08"},"sunset":{"time":"18:47"}}],"precipitation":[{"date":"2020-06-30T00:00+08:00","max":0.5783,"min":0,"avg":0.0085},{"date":"2020-07-01T00:00+08:00","max":24.7261,"min":0,"avg":1.5669},{"date":"2020-07-02T00:00+08:00","max":16.6933,"min":0,"avg":1.6975},{"date":"2020-07-03T00:00+08:00","max":1.1945,"min":0,"avg":0.3434},{"date":"2020-07-04T00:00+08:00","max":1.4903,"min":0,"avg":0.2885}],"temperature":[{"date":"2020-06-30T00:00+08:00","max":32,"min":26,"avg":27.06},{"date":"2020-07-01T00:00+08:00","max":31,"min":26,"avg":28.99},{"date":"2020-07-02T00:00+08:00","max":30,"min":26,"avg":28.16},{"date":"2020-07-03T00:00+08:00","max":30,"min":26,"avg":28.27},{"date":"2020-07-04T00:00+08:00","max":30,"min":26,"avg":28}],"wind":[{"date":"2020-06-30T00:00+08:00","max":{"speed":8.03,"direction":259.91},"min":{"speed":0.16,"direction":241.21},"avg":{"speed":4.68,"direction":258.03}},{"date":"2020-07-01T00:00+08:00","max":{"speed":11.08,"direction":285.2},"min":{"speed":1.85,"direction":253.39},"avg":{"speed":5.15,"direction":240.91}},{"date":"2020-07-02T00:00+08:00","max":{"speed":7.54,"direction":136.71},"min":{"speed":0.94,"direction":228.11},"avg":{"speed":4.56,"direction":179.34}},{"date":"2020-07-03T00:00+08:00","max":{"speed":5.91,"direction":218.21},"min":{"speed":0.47,"direction":243.58},"avg":{"speed":2.62,"direction":167.91}},{"date":"2020-07-04T00:00+08:00","max":{"speed":7.43,"direction":254.99},"min":{"speed":2.62,"direction":224.68},"avg":{"speed":4.33,"direction":235.5}}],"humidity":[{"date":"2020-06-30T00:00+08:00","max":0.82,"min":0.64,"avg":0.8},{"date":"2020-07-01T00:00+08:00","max":0.84,"min":0.68,"avg":0.78},{"date":"2020-07-02T00:00+08:00","max":0.84,"min":0.71,"avg":0.79},{"date":"2020-07-03T00:00+08:00","max":0.85,"min":0.65,"avg":0.78},{"date":"2020-07-04T00:00+08:00","max":0.82,"min":0.66,"avg":0.76}],"cloudrate":[{"date":"2020-06-30T00:00+08:00","max":1,"min":0.93,"avg":1},{"date":"2020-07-01T00:00+08:00","max":1,"min":0.86,"avg":0.98},{"date":"2020-07-02T00:00+08:00","max":1,"min":1,"avg":1},{"date":"2020-07-03T00:00+08:00","max":1,"min":0.89,"avg":0.98},{"date":"2020-07-04T00:00+08:00","max":1,"min":1,"avg":1}],"pressure":[{"date":"2020-06-30T00:00+08:00","max":98944.29,"min":98704.29,"avg":98844.92},{"date":"2020-07-01T00:00+08:00","max":99024.29,"min":98704.29,"avg":98814.3},{"date":"2020-07-02T00:00+08:00","max":99165.55,"min":98795.89,"avg":98936.77},{"date":"2020-07-03T00:00+08:00","max":99405.55,"min":99017.15,"avg":99189.33},{"date":"2020-07-04T00:00+08:00","max":99325.55,"min":99005.55,"avg":99194.54}],"visibility":[{"date":"2020-06-30T00:00+08:00","max":24.13,"min":19.03,"avg":20.57},{"date":"2020-07-01T00:00+08:00","max":41.91,"min":17.74,"avg":25.77},{"date":"2020-07-02T00:00+08:00","max":37.91,"min":17.76,"avg":23.48},{"date":"2020-07-03T00:00+08:00","max":41.91,"min":16.93,"avg":25.66},{"date":"2020-07-04T00:00+08:00","max":41.91,"min":19.34,"avg":28.12}],"dswrf":[{"date":"2020-06-30T00:00+08:00","max":804.8,"min":0,"avg":217.2},{"date":"2020-07-01T00:00+08:00","max":797.5,"min":0,"avg":292},{"date":"2020-07-02T00:00+08:00","max":617.6,"min":0,"avg":199.8},{"date":"2020-07-03T00:00+08:00","max":800.9,"min":0,"avg":264.4},{"date":"2020-07-04T00:00+08:00","max":691.1,"min":0,"avg":262.2}],"air_quality":{"aqi":[{"date":"2020-06-30T00:00+08:00","max":{"chn":13,"usa":13},"avg":{"chn":8.12,"usa":8.12},"min":{"chn":7,"usa":7}},{"date":"2020-07-01T00:00+08:00","max":{"chn":9,"usa":9},"avg":{"chn":7.54,"usa":7.54},"min":{"chn":7,"usa":7}},{"date":"2020-07-02T00:00+08:00","max":{"chn":8,"usa":8},"avg":{"chn":7.54,"usa":7.54},"min":{"chn":7,"usa":7}},{"date":"2020-07-03T00:00+08:00","max":{"chn":8,"usa":8},"avg":{"chn":7.5,"usa":7.5},"min":{"chn":7,"usa":7}},{"date":"2020-07-04T00:00+08:00","max":{"chn":9,"usa":9},"avg":{"chn":7.83,"usa":7.83},"min":{"chn":7,"usa":7}}],"pm25":[{"date":"2020-06-30T00:00+08:00","max":6,"avg":5.12,"min":4},{"date":"2020-07-01T00:00+08:00","max":7,"avg":5.12,"min":4},{"date":"2020-07-02T00:00+08:00","max":6,"avg":4.54,"min":3},{"date":"2020-07-03T00:00+08:00","max":6,"avg":4.5,"min":3},{"date":"2020-07-04T00:00+08:00","max":7,"avg":5.5,"min":3}]},"skycon":[{"date":"2020-06-30T00:00+08:00","value":"CLOUDY"},{"date":"2020-07-01T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"LIGHT_RAIN"}],"skycon_08h_20h":[{"date":"2020-06-30T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-01T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"MODERATE_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"MODERATE_RAIN"}],"skycon_20h_32h":[{"date":"2020-06-30T00:00+08:00","value":"CLOUDY"},{"date":"2020-07-01T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"MODERATE_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"LIGHT_RAIN"}],"life_index":{"ultraviolet":[{"date":"2020-06-30T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-01T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-02T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-03T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-04T00:00+08:00","index":"1","desc":"最弱"}],"carWashing":[{"date":"2020-06-30T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-01T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-02T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-03T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-04T00:00+08:00","index":"3","desc":"较不适宜"}],"dressing":[{"date":"2020-06-30T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-01T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-02T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-03T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-04T00:00+08:00","index":"2","desc":"很热"}],"comfort":[{"date":"2020-06-30T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-01T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-02T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-03T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-04T00:00+08:00","index":"0","desc":"闷热"}],"coldRisk":[{"date":"2020-06-30T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-01T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-02T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-03T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-04T00:00+08:00","index":"3","desc":"易发"}]}},"primary":0}
     */

    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private int tzshift;
    private String timezone;
    private int server_time;
    private ResultBean result;
    private List<Double> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean   {
        /**
         * daily : {"status":"ok","astro":[{"date":"2020-06-30T00:00+08:00","sunrise":{"time":"05:06"},"sunset":{"time":"18:47"}},{"date":"2020-07-01T00:00+08:00","sunrise":{"time":"05:06"},"sunset":{"time":"18:47"}},{"date":"2020-07-02T00:00+08:00","sunrise":{"time":"05:07"},"sunset":{"time":"18:47"}},{"date":"2020-07-03T00:00+08:00","sunrise":{"time":"05:07"},"sunset":{"time":"18:47"}},{"date":"2020-07-04T00:00+08:00","sunrise":{"time":"05:08"},"sunset":{"time":"18:47"}}],"precipitation":[{"date":"2020-06-30T00:00+08:00","max":0.5783,"min":0,"avg":0.0085},{"date":"2020-07-01T00:00+08:00","max":24.7261,"min":0,"avg":1.5669},{"date":"2020-07-02T00:00+08:00","max":16.6933,"min":0,"avg":1.6975},{"date":"2020-07-03T00:00+08:00","max":1.1945,"min":0,"avg":0.3434},{"date":"2020-07-04T00:00+08:00","max":1.4903,"min":0,"avg":0.2885}],"temperature":[{"date":"2020-06-30T00:00+08:00","max":32,"min":26,"avg":27.06},{"date":"2020-07-01T00:00+08:00","max":31,"min":26,"avg":28.99},{"date":"2020-07-02T00:00+08:00","max":30,"min":26,"avg":28.16},{"date":"2020-07-03T00:00+08:00","max":30,"min":26,"avg":28.27},{"date":"2020-07-04T00:00+08:00","max":30,"min":26,"avg":28}],"wind":[{"date":"2020-06-30T00:00+08:00","max":{"speed":8.03,"direction":259.91},"min":{"speed":0.16,"direction":241.21},"avg":{"speed":4.68,"direction":258.03}},{"date":"2020-07-01T00:00+08:00","max":{"speed":11.08,"direction":285.2},"min":{"speed":1.85,"direction":253.39},"avg":{"speed":5.15,"direction":240.91}},{"date":"2020-07-02T00:00+08:00","max":{"speed":7.54,"direction":136.71},"min":{"speed":0.94,"direction":228.11},"avg":{"speed":4.56,"direction":179.34}},{"date":"2020-07-03T00:00+08:00","max":{"speed":5.91,"direction":218.21},"min":{"speed":0.47,"direction":243.58},"avg":{"speed":2.62,"direction":167.91}},{"date":"2020-07-04T00:00+08:00","max":{"speed":7.43,"direction":254.99},"min":{"speed":2.62,"direction":224.68},"avg":{"speed":4.33,"direction":235.5}}],"humidity":[{"date":"2020-06-30T00:00+08:00","max":0.82,"min":0.64,"avg":0.8},{"date":"2020-07-01T00:00+08:00","max":0.84,"min":0.68,"avg":0.78},{"date":"2020-07-02T00:00+08:00","max":0.84,"min":0.71,"avg":0.79},{"date":"2020-07-03T00:00+08:00","max":0.85,"min":0.65,"avg":0.78},{"date":"2020-07-04T00:00+08:00","max":0.82,"min":0.66,"avg":0.76}],"cloudrate":[{"date":"2020-06-30T00:00+08:00","max":1,"min":0.93,"avg":1},{"date":"2020-07-01T00:00+08:00","max":1,"min":0.86,"avg":0.98},{"date":"2020-07-02T00:00+08:00","max":1,"min":1,"avg":1},{"date":"2020-07-03T00:00+08:00","max":1,"min":0.89,"avg":0.98},{"date":"2020-07-04T00:00+08:00","max":1,"min":1,"avg":1}],"pressure":[{"date":"2020-06-30T00:00+08:00","max":98944.29,"min":98704.29,"avg":98844.92},{"date":"2020-07-01T00:00+08:00","max":99024.29,"min":98704.29,"avg":98814.3},{"date":"2020-07-02T00:00+08:00","max":99165.55,"min":98795.89,"avg":98936.77},{"date":"2020-07-03T00:00+08:00","max":99405.55,"min":99017.15,"avg":99189.33},{"date":"2020-07-04T00:00+08:00","max":99325.55,"min":99005.55,"avg":99194.54}],"visibility":[{"date":"2020-06-30T00:00+08:00","max":24.13,"min":19.03,"avg":20.57},{"date":"2020-07-01T00:00+08:00","max":41.91,"min":17.74,"avg":25.77},{"date":"2020-07-02T00:00+08:00","max":37.91,"min":17.76,"avg":23.48},{"date":"2020-07-03T00:00+08:00","max":41.91,"min":16.93,"avg":25.66},{"date":"2020-07-04T00:00+08:00","max":41.91,"min":19.34,"avg":28.12}],"dswrf":[{"date":"2020-06-30T00:00+08:00","max":804.8,"min":0,"avg":217.2},{"date":"2020-07-01T00:00+08:00","max":797.5,"min":0,"avg":292},{"date":"2020-07-02T00:00+08:00","max":617.6,"min":0,"avg":199.8},{"date":"2020-07-03T00:00+08:00","max":800.9,"min":0,"avg":264.4},{"date":"2020-07-04T00:00+08:00","max":691.1,"min":0,"avg":262.2}],"air_quality":{"aqi":[{"date":"2020-06-30T00:00+08:00","max":{"chn":13,"usa":13},"avg":{"chn":8.12,"usa":8.12},"min":{"chn":7,"usa":7}},{"date":"2020-07-01T00:00+08:00","max":{"chn":9,"usa":9},"avg":{"chn":7.54,"usa":7.54},"min":{"chn":7,"usa":7}},{"date":"2020-07-02T00:00+08:00","max":{"chn":8,"usa":8},"avg":{"chn":7.54,"usa":7.54},"min":{"chn":7,"usa":7}},{"date":"2020-07-03T00:00+08:00","max":{"chn":8,"usa":8},"avg":{"chn":7.5,"usa":7.5},"min":{"chn":7,"usa":7}},{"date":"2020-07-04T00:00+08:00","max":{"chn":9,"usa":9},"avg":{"chn":7.83,"usa":7.83},"min":{"chn":7,"usa":7}}],"pm25":[{"date":"2020-06-30T00:00+08:00","max":6,"avg":5.12,"min":4},{"date":"2020-07-01T00:00+08:00","max":7,"avg":5.12,"min":4},{"date":"2020-07-02T00:00+08:00","max":6,"avg":4.54,"min":3},{"date":"2020-07-03T00:00+08:00","max":6,"avg":4.5,"min":3},{"date":"2020-07-04T00:00+08:00","max":7,"avg":5.5,"min":3}]},"skycon":[{"date":"2020-06-30T00:00+08:00","value":"CLOUDY"},{"date":"2020-07-01T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"LIGHT_RAIN"}],"skycon_08h_20h":[{"date":"2020-06-30T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-01T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"MODERATE_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"MODERATE_RAIN"}],"skycon_20h_32h":[{"date":"2020-06-30T00:00+08:00","value":"CLOUDY"},{"date":"2020-07-01T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"MODERATE_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"LIGHT_RAIN"}],"life_index":{"ultraviolet":[{"date":"2020-06-30T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-01T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-02T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-03T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-04T00:00+08:00","index":"1","desc":"最弱"}],"carWashing":[{"date":"2020-06-30T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-01T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-02T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-03T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-04T00:00+08:00","index":"3","desc":"较不适宜"}],"dressing":[{"date":"2020-06-30T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-01T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-02T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-03T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-04T00:00+08:00","index":"2","desc":"很热"}],"comfort":[{"date":"2020-06-30T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-01T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-02T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-03T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-04T00:00+08:00","index":"0","desc":"闷热"}],"coldRisk":[{"date":"2020-06-30T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-01T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-02T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-03T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-04T00:00+08:00","index":"3","desc":"易发"}]}}
         * primary : 0
         */

        private DailyBean daily;
        private int primary;

        public DailyBean getDaily() {
            return daily;
        }

        public void setDaily(DailyBean daily) {
            this.daily = daily;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class DailyBean {
            /**
             * status : ok
             * astro : [{"date":"2020-06-30T00:00+08:00","sunrise":{"time":"05:06"},"sunset":{"time":"18:47"}},{"date":"2020-07-01T00:00+08:00","sunrise":{"time":"05:06"},"sunset":{"time":"18:47"}},{"date":"2020-07-02T00:00+08:00","sunrise":{"time":"05:07"},"sunset":{"time":"18:47"}},{"date":"2020-07-03T00:00+08:00","sunrise":{"time":"05:07"},"sunset":{"time":"18:47"}},{"date":"2020-07-04T00:00+08:00","sunrise":{"time":"05:08"},"sunset":{"time":"18:47"}}]
             * precipitation : [{"date":"2020-06-30T00:00+08:00","max":0.5783,"min":0,"avg":0.0085},{"date":"2020-07-01T00:00+08:00","max":24.7261,"min":0,"avg":1.5669},{"date":"2020-07-02T00:00+08:00","max":16.6933,"min":0,"avg":1.6975},{"date":"2020-07-03T00:00+08:00","max":1.1945,"min":0,"avg":0.3434},{"date":"2020-07-04T00:00+08:00","max":1.4903,"min":0,"avg":0.2885}]
             * temperature : [{"date":"2020-06-30T00:00+08:00","max":32,"min":26,"avg":27.06},{"date":"2020-07-01T00:00+08:00","max":31,"min":26,"avg":28.99},{"date":"2020-07-02T00:00+08:00","max":30,"min":26,"avg":28.16},{"date":"2020-07-03T00:00+08:00","max":30,"min":26,"avg":28.27},{"date":"2020-07-04T00:00+08:00","max":30,"min":26,"avg":28}]
             * wind : [{"date":"2020-06-30T00:00+08:00","max":{"speed":8.03,"direction":259.91},"min":{"speed":0.16,"direction":241.21},"avg":{"speed":4.68,"direction":258.03}},{"date":"2020-07-01T00:00+08:00","max":{"speed":11.08,"direction":285.2},"min":{"speed":1.85,"direction":253.39},"avg":{"speed":5.15,"direction":240.91}},{"date":"2020-07-02T00:00+08:00","max":{"speed":7.54,"direction":136.71},"min":{"speed":0.94,"direction":228.11},"avg":{"speed":4.56,"direction":179.34}},{"date":"2020-07-03T00:00+08:00","max":{"speed":5.91,"direction":218.21},"min":{"speed":0.47,"direction":243.58},"avg":{"speed":2.62,"direction":167.91}},{"date":"2020-07-04T00:00+08:00","max":{"speed":7.43,"direction":254.99},"min":{"speed":2.62,"direction":224.68},"avg":{"speed":4.33,"direction":235.5}}]
             * humidity : [{"date":"2020-06-30T00:00+08:00","max":0.82,"min":0.64,"avg":0.8},{"date":"2020-07-01T00:00+08:00","max":0.84,"min":0.68,"avg":0.78},{"date":"2020-07-02T00:00+08:00","max":0.84,"min":0.71,"avg":0.79},{"date":"2020-07-03T00:00+08:00","max":0.85,"min":0.65,"avg":0.78},{"date":"2020-07-04T00:00+08:00","max":0.82,"min":0.66,"avg":0.76}]
             * cloudrate : [{"date":"2020-06-30T00:00+08:00","max":1,"min":0.93,"avg":1},{"date":"2020-07-01T00:00+08:00","max":1,"min":0.86,"avg":0.98},{"date":"2020-07-02T00:00+08:00","max":1,"min":1,"avg":1},{"date":"2020-07-03T00:00+08:00","max":1,"min":0.89,"avg":0.98},{"date":"2020-07-04T00:00+08:00","max":1,"min":1,"avg":1}]
             * pressure : [{"date":"2020-06-30T00:00+08:00","max":98944.29,"min":98704.29,"avg":98844.92},{"date":"2020-07-01T00:00+08:00","max":99024.29,"min":98704.29,"avg":98814.3},{"date":"2020-07-02T00:00+08:00","max":99165.55,"min":98795.89,"avg":98936.77},{"date":"2020-07-03T00:00+08:00","max":99405.55,"min":99017.15,"avg":99189.33},{"date":"2020-07-04T00:00+08:00","max":99325.55,"min":99005.55,"avg":99194.54}]
             * visibility : [{"date":"2020-06-30T00:00+08:00","max":24.13,"min":19.03,"avg":20.57},{"date":"2020-07-01T00:00+08:00","max":41.91,"min":17.74,"avg":25.77},{"date":"2020-07-02T00:00+08:00","max":37.91,"min":17.76,"avg":23.48},{"date":"2020-07-03T00:00+08:00","max":41.91,"min":16.93,"avg":25.66},{"date":"2020-07-04T00:00+08:00","max":41.91,"min":19.34,"avg":28.12}]
             * dswrf : [{"date":"2020-06-30T00:00+08:00","max":804.8,"min":0,"avg":217.2},{"date":"2020-07-01T00:00+08:00","max":797.5,"min":0,"avg":292},{"date":"2020-07-02T00:00+08:00","max":617.6,"min":0,"avg":199.8},{"date":"2020-07-03T00:00+08:00","max":800.9,"min":0,"avg":264.4},{"date":"2020-07-04T00:00+08:00","max":691.1,"min":0,"avg":262.2}]
             * air_quality : {"aqi":[{"date":"2020-06-30T00:00+08:00","max":{"chn":13,"usa":13},"avg":{"chn":8.12,"usa":8.12},"min":{"chn":7,"usa":7}},{"date":"2020-07-01T00:00+08:00","max":{"chn":9,"usa":9},"avg":{"chn":7.54,"usa":7.54},"min":{"chn":7,"usa":7}},{"date":"2020-07-02T00:00+08:00","max":{"chn":8,"usa":8},"avg":{"chn":7.54,"usa":7.54},"min":{"chn":7,"usa":7}},{"date":"2020-07-03T00:00+08:00","max":{"chn":8,"usa":8},"avg":{"chn":7.5,"usa":7.5},"min":{"chn":7,"usa":7}},{"date":"2020-07-04T00:00+08:00","max":{"chn":9,"usa":9},"avg":{"chn":7.83,"usa":7.83},"min":{"chn":7,"usa":7}}],"pm25":[{"date":"2020-06-30T00:00+08:00","max":6,"avg":5.12,"min":4},{"date":"2020-07-01T00:00+08:00","max":7,"avg":5.12,"min":4},{"date":"2020-07-02T00:00+08:00","max":6,"avg":4.54,"min":3},{"date":"2020-07-03T00:00+08:00","max":6,"avg":4.5,"min":3},{"date":"2020-07-04T00:00+08:00","max":7,"avg":5.5,"min":3}]}
             * skycon : [{"date":"2020-06-30T00:00+08:00","value":"CLOUDY"},{"date":"2020-07-01T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"LIGHT_RAIN"}]
             * skycon_08h_20h : [{"date":"2020-06-30T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-01T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"HEAVY_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"MODERATE_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"MODERATE_RAIN"}]
             * skycon_20h_32h : [{"date":"2020-06-30T00:00+08:00","value":"CLOUDY"},{"date":"2020-07-01T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-02T00:00+08:00","value":"MODERATE_RAIN"},{"date":"2020-07-03T00:00+08:00","value":"LIGHT_RAIN"},{"date":"2020-07-04T00:00+08:00","value":"LIGHT_RAIN"}]
             * life_index : {"ultraviolet":[{"date":"2020-06-30T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-01T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-02T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-03T00:00+08:00","index":"1","desc":"最弱"},{"date":"2020-07-04T00:00+08:00","index":"1","desc":"最弱"}],"carWashing":[{"date":"2020-06-30T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-01T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-02T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-03T00:00+08:00","index":"3","desc":"较不适宜"},{"date":"2020-07-04T00:00+08:00","index":"3","desc":"较不适宜"}],"dressing":[{"date":"2020-06-30T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-01T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-02T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-03T00:00+08:00","index":"2","desc":"很热"},{"date":"2020-07-04T00:00+08:00","index":"2","desc":"很热"}],"comfort":[{"date":"2020-06-30T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-01T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-02T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-03T00:00+08:00","index":"0","desc":"闷热"},{"date":"2020-07-04T00:00+08:00","index":"0","desc":"闷热"}],"coldRisk":[{"date":"2020-06-30T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-01T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-02T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-03T00:00+08:00","index":"3","desc":"易发"},{"date":"2020-07-04T00:00+08:00","index":"3","desc":"易发"}]}
             */

            private String status;
            private AirQualityBean air_quality;
            private LifeIndexBean life_index;
            private List<AstroBean> astro;
            private List<PrecipitationBean> precipitation;
            private List<TemperatureBean> temperature;
            private List<WindBean> wind;
            private List<HumidityBean> humidity;
            private List<CloudrateBean> cloudrate;
            private List<PressureBean> pressure;
            private List<VisibilityBean> visibility;
            private List<DswrfBean> dswrf;
            private List<SkyconBean> skycon;
            private List<Skycon08h20hBean> skycon_08h_20h;
            private List<Skycon20h32hBean> skycon_20h_32h;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public LifeIndexBean getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexBean life_index) {
                this.life_index = life_index;
            }

            public List<AstroBean> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroBean> astro) {
                this.astro = astro;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<PressureBean> getPressure() {
                return pressure;
            }

            public void setPressure(List<PressureBean> pressure) {
                this.pressure = pressure;
            }

            public List<VisibilityBean> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityBean> visibility) {
                this.visibility = visibility;
            }

            public List<DswrfBean> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfBean> dswrf) {
                this.dswrf = dswrf;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<Skycon08h20hBean> getSkycon_08h_20h() {
                return skycon_08h_20h;
            }

            public void setSkycon_08h_20h(List<Skycon08h20hBean> skycon_08h_20h) {
                this.skycon_08h_20h = skycon_08h_20h;
            }

            public List<Skycon20h32hBean> getSkycon_20h_32h() {
                return skycon_20h_32h;
            }

            public void setSkycon_20h_32h(List<Skycon20h32hBean> skycon_20h_32h) {
                this.skycon_20h_32h = skycon_20h_32h;
            }

            public static class AirQualityBean  {
                private List<AqiBean> aqi;
                private List<Pm25Bean> pm25;

                public List<AqiBean> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBean> aqi) {
                    this.aqi = aqi;
                }

                public List<Pm25Bean> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25Bean> pm25) {
                    this.pm25 = pm25;
                }

                public static class AqiBean {
                    /**
                     * date : 2020-06-30T00:00+08:00
                     * max : {"chn":13,"usa":13}
                     * avg : {"chn":8.12,"usa":8.12}
                     * min : {"chn":7,"usa":7}
                     */

                    private String date;
                    private MaxBean max;
                    private AvgBean avg;
                    private MinBean min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public MaxBean getMax() {
                        return max;
                    }

                    public void setMax(MaxBean max) {
                        this.max = max;
                    }

                    public AvgBean getAvg() {
                        return avg;
                    }

                    public void setAvg(AvgBean avg) {
                        this.avg = avg;
                    }

                    public MinBean getMin() {
                        return min;
                    }

                    public void setMin(MinBean min) {
                        this.min = min;
                    }

                    public static class MaxBean {
                        /**
                         * chn : 13
                         * usa : 13
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }

                    public static class AvgBean {
                        /**
                         * chn : 8.12
                         * usa : 8.12
                         */

                        private double chn;
                        private double usa;

                        public double getChn() {
                            return chn;
                        }

                        public void setChn(double chn) {
                            this.chn = chn;
                        }

                        public double getUsa() {
                            return usa;
                        }

                        public void setUsa(double usa) {
                            this.usa = usa;
                        }
                    }

                    public static class MinBean {
                        /**
                         * chn : 7
                         * usa : 7
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }
                }

                public static class Pm25Bean {
                    /**
                     * date : 2020-06-30T00:00+08:00
                     * max : 6
                     * avg : 5.12
                     * min : 4
                     */

                    private String date;
                    private int max;
                    private double avg;
                    private int min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public int getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public int getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }
            }

            public static class LifeIndexBean {
                private List<UltravioletBean> ultraviolet;
                private List<CarWashingBean> carWashing;
                private List<DressingBean> dressing;
                private List<ComfortBean> comfort;
                private List<ColdRiskBean> coldRisk;

                public List<UltravioletBean> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<UltravioletBean> ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public List<CarWashingBean> getCarWashing() {
                    return carWashing;
                }

                public void setCarWashing(List<CarWashingBean> carWashing) {
                    this.carWashing = carWashing;
                }

                public List<DressingBean> getDressing() {
                    return dressing;
                }

                public void setDressing(List<DressingBean> dressing) {
                    this.dressing = dressing;
                }

                public List<ComfortBean> getComfort() {
                    return comfort;
                }

                public void setComfort(List<ComfortBean> comfort) {
                    this.comfort = comfort;
                }

                public List<ColdRiskBean> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<ColdRiskBean> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                public static class UltravioletBean {
                    /**
                     * date : 2020-06-30T00:00+08:00
                     * index : 1
                     * desc : 最弱
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class CarWashingBean {
                    /**
                     * date : 2020-06-30T00:00+08:00
                     * index : 3
                     * desc : 较不适宜
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DressingBean {
                    /**
                     * date : 2020-06-30T00:00+08:00
                     * index : 2
                     * desc : 很热
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBean {
                    /**
                     * date : 2020-06-30T00:00+08:00
                     * index : 0
                     * desc : 闷热
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdRiskBean {
                    /**
                     * date : 2020-06-30T00:00+08:00
                     * index : 3
                     * desc : 易发
                     */

                    private String date;
                    private String index;
                    private String desc;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class AstroBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * sunrise : {"time":"05:06"}
                 * sunset : {"time":"18:47"}
                 */

                private String date;
                private SunriseBean sunrise;
                private SunsetBean sunset;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public SunriseBean getSunrise() {
                    return sunrise;
                }

                public void setSunrise(SunriseBean sunrise) {
                    this.sunrise = sunrise;
                }

                public SunsetBean getSunset() {
                    return sunset;
                }

                public void setSunset(SunsetBean sunset) {
                    this.sunset = sunset;
                }

                public static class SunriseBean {
                    /**
                     * time : 05:06
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class SunsetBean {
                    /**
                     * time : 18:47
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }

            public static class PrecipitationBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : 0.5783
                 * min : 0.0
                 * avg : 0.0085
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class TemperatureBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : 32.0
                 * min : 26.0
                 * avg : 27.06
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class WindBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : {"speed":8.03,"direction":259.91}
                 * min : {"speed":0.16,"direction":241.21}
                 * avg : {"speed":4.68,"direction":258.03}
                 */

                private String date;
                private MaxBeanX max;
                private MinBeanX min;
                private AvgBeanX avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public MaxBeanX getMax() {
                    return max;
                }

                public void setMax(MaxBeanX max) {
                    this.max = max;
                }

                public MinBeanX getMin() {
                    return min;
                }

                public void setMin(MinBeanX min) {
                    this.min = min;
                }

                public AvgBeanX getAvg() {
                    return avg;
                }

                public void setAvg(AvgBeanX avg) {
                    this.avg = avg;
                }

                public static class MaxBeanX {
                    /**
                     * speed : 8.03
                     * direction : 259.91
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class MinBeanX {
                    /**
                     * speed : 0.16
                     * direction : 241.21
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }

                public static class AvgBeanX {
                    /**
                     * speed : 4.68
                     * direction : 258.03
                     */

                    private double speed;
                    private double direction;

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }
                }
            }

            public static class HumidityBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : 0.82
                 * min : 0.64
                 * avg : 0.8
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class CloudrateBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : 1.0
                 * min : 0.93
                 * avg : 1.0
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class PressureBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : 98944.29
                 * min : 98704.29
                 * avg : 98844.92
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class VisibilityBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : 24.13
                 * min : 19.03
                 * avg : 20.57
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class DswrfBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * max : 804.8
                 * min : 0.0
                 * avg : 217.2
                 */

                private String date;
                private double max;
                private double min;
                private double avg;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }
            }

            public static class SkyconBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * value : CLOUDY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon08h20hBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * value : LIGHT_RAIN
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Skycon20h32hBean {
                /**
                 * date : 2020-06-30T00:00+08:00
                 * value : CLOUDY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
