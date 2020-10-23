package com.nanjing.tqlhl.model.bean;

import java.util.List;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/8 15:32
 * @class describe
 */
public class Mj15DayWeatherBean {
    /**
     * code : 0
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"forecast":[{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaningCrescent","moonrise":"2016-08-31 04:19:00","moonset":"2016-08-31 18:07:00","predictDate":"2016-08-31","sunrise":"2016-08-31 05:41:00","sunset":"2016-08-31 18:47:00","tempDay":"34","tempNight":"18","updatetime":"2016-08-31 23:07:06","windDirDay":"北风","windDirNight":"西北风","windLevelDay":"3","windLevelNight":"3","windSpeedDay":"5.0","windSpeedNight":"5.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"New","moonrise":"2016-09-01 05:20:00","moonset":"2016-09-01 18:41:00","predictDate":"2016-09-01","sunrise":"2016-09-01 05:42:00","sunset":"2016-09-01 18:45:00","tempDay":"27","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"北风","windLevelDay":"3","windLevelNight":"2","windSpeedDay":"5.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-02 06:20:00","moonset":"2016-09-02 19:14:00","predictDate":"2016-09-02","sunrise":"2016-09-02 05:43:00","sunset":"2016-09-02 18:44:00","tempDay":"27","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-03 07:19:00","moonset":"2016-09-03 19:44:00","predictDate":"2016-09-03","sunrise":"2016-09-03 05:44:00","sunset":"2016-09-03 18:42:00","tempDay":"28","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"大部晴朗","moonphase":"WaxingCrescent","moonrise":"2016-09-04 08:16:00","moonset":"2016-09-04 20:14:00","predictDate":"2016-09-04","sunrise":"2016-09-04 05:45:00","sunset":"2016-09-04 18:41:00","tempDay":"28","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-05 09:13:00","moonset":"2016-09-05 20:44:00","predictDate":"2016-09-05","sunrise":"2016-09-05 05:46:00","sunset":"2016-09-05 18:39:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"西北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-06 10:08:00","moonset":"2016-09-06 21:16:00","predictDate":"2016-09-06","sunrise":"2016-09-06 05:47:00","sunset":"2016-09-06 18:37:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"北风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-07 11:04:00","moonset":"2016-09-07 21:50:00","predictDate":"2016-09-07","sunrise":"2016-09-07 05:48:00","sunset":"2016-09-07 18:36:00","tempDay":"27","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"东北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingCrescent","moonrise":"2016-09-08 11:59:00","moonset":"2016-09-08 22:27:00","predictDate":"2016-09-08","sunrise":"2016-09-08 05:49:00","sunset":"2016-09-08 18:34:00","tempDay":"31","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"北风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"局部阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"晴","moonphase":"First","moonrise":"2016-09-09 12:53:00","moonset":"2016-09-09 23:09:00","predictDate":"2016-09-09","sunrise":"2016-09-09 05:50:00","sunset":"2016-09-09 18:33:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东风","windDirNight":"南风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"雷阵雨","conditionIdDay":"4","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-10 13:45:00","moonset":"2016-09-10 23:55:00","predictDate":"2016-09-10","sunrise":"2016-09-10 05:51:00","sunset":"2016-09-10 18:31:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"东风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-11 14:35:00","moonset":"2016-09-12 00:46:00","predictDate":"2016-09-11","sunrise":"2016-09-11 05:52:00","sunset":"2016-09-11 18:29:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西南风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-12 15:24:00","moonset":"2016-09-13 01:43:00","predictDate":"2016-09-12","sunrise":"2016-09-12 05:53:00","sunset":"2016-09-12 18:28:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西南风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingGibbous","moonrise":"2016-09-13 16:08:00","moonset":"2016-09-14 02:44:00","predictDate":"2016-09-13","sunrise":"2016-09-13 05:54:00","sunset":"2016-09-13 18:26:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"西北风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-14 16:50:00","moonset":"2016-09-15 03:50:00","predictDate":"2016-09-14","sunrise":"2016-09-14 05:55:00","sunset":"2016-09-14 18:24:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"东风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"晴","conditionIdDay":"0","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-15 17:30:00","moonset":"2016-09-16 04:57:00","predictDate":"2016-09-15","sunrise":"2016-09-15 05:55:00","sunset":"2016-09-15 18:23:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"西风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"}]}
     * msg : success
     * rc : {"c":0,"p":"success"}
     */

    private int code;
    private DataBean data;
    private String msg;
    private RcBean rc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RcBean getRc() {
        return rc;
    }

    public void setRc(RcBean rc) {
        this.rc = rc;
    }

    public static class DataBean {
        /**
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         * forecast : [{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaningCrescent","moonrise":"2016-08-31 04:19:00","moonset":"2016-08-31 18:07:00","predictDate":"2016-08-31","sunrise":"2016-08-31 05:41:00","sunset":"2016-08-31 18:47:00","tempDay":"34","tempNight":"18","updatetime":"2016-08-31 23:07:06","windDirDay":"北风","windDirNight":"西北风","windLevelDay":"3","windLevelNight":"3","windSpeedDay":"5.0","windSpeedNight":"5.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"New","moonrise":"2016-09-01 05:20:00","moonset":"2016-09-01 18:41:00","predictDate":"2016-09-01","sunrise":"2016-09-01 05:42:00","sunset":"2016-09-01 18:45:00","tempDay":"27","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"北风","windLevelDay":"3","windLevelNight":"2","windSpeedDay":"5.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-02 06:20:00","moonset":"2016-09-02 19:14:00","predictDate":"2016-09-02","sunrise":"2016-09-02 05:43:00","sunset":"2016-09-02 18:44:00","tempDay":"27","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-03 07:19:00","moonset":"2016-09-03 19:44:00","predictDate":"2016-09-03","sunrise":"2016-09-03 05:44:00","sunset":"2016-09-03 18:42:00","tempDay":"28","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"东南风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"大部晴朗","moonphase":"WaxingCrescent","moonrise":"2016-09-04 08:16:00","moonset":"2016-09-04 20:14:00","predictDate":"2016-09-04","sunrise":"2016-09-04 05:45:00","sunset":"2016-09-04 18:41:00","tempDay":"28","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-05 09:13:00","moonset":"2016-09-05 20:44:00","predictDate":"2016-09-05","sunrise":"2016-09-05 05:46:00","sunset":"2016-09-05 18:39:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"西北风","windDirNight":"西北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingCrescent","moonrise":"2016-09-06 10:08:00","moonset":"2016-09-06 21:16:00","predictDate":"2016-09-06","sunrise":"2016-09-06 05:47:00","sunset":"2016-09-06 18:37:00","tempDay":"30","tempNight":"21","updatetime":"2016-09-01 22:07:06","windDirDay":"北风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingCrescent","moonrise":"2016-09-07 11:04:00","moonset":"2016-09-07 21:50:00","predictDate":"2016-09-07","sunrise":"2016-09-07 05:48:00","sunset":"2016-09-07 18:36:00","tempDay":"27","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"东北风","windLevelDay":"2","windLevelNight":"2","windSpeedDay":"3.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingCrescent","moonrise":"2016-09-08 11:59:00","moonset":"2016-09-08 22:27:00","predictDate":"2016-09-08","sunrise":"2016-09-08 05:49:00","sunset":"2016-09-08 18:34:00","tempDay":"31","tempNight":"17","updatetime":"2016-09-01 22:07:06","windDirDay":"东南风","windDirNight":"北风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"局部阵雨","conditionIdDay":"3","conditionIdNight":"30","conditionNight":"晴","moonphase":"First","moonrise":"2016-09-09 12:53:00","moonset":"2016-09-09 23:09:00","predictDate":"2016-09-09","sunrise":"2016-09-09 05:50:00","sunset":"2016-09-09 18:33:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东风","windDirNight":"南风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"雷阵雨","conditionIdDay":"4","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-10 13:45:00","moonset":"2016-09-10 23:55:00","predictDate":"2016-09-10","sunrise":"2016-09-10 05:51:00","sunset":"2016-09-10 18:31:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"东风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-11 14:35:00","moonset":"2016-09-12 00:46:00","predictDate":"2016-09-11","sunrise":"2016-09-11 05:52:00","sunset":"2016-09-11 18:29:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"西南风","windDirNight":"北风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-12 15:24:00","moonset":"2016-09-13 01:43:00","predictDate":"2016-09-12","sunrise":"2016-09-12 05:53:00","sunset":"2016-09-12 18:28:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"西南风","windLevelDay":"1","windLevelNight":"1","windSpeedDay":"1.0","windSpeedNight":"1.0"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"少云","moonphase":"WaxingGibbous","moonrise":"2016-09-13 16:08:00","moonset":"2016-09-14 02:44:00","predictDate":"2016-09-13","sunrise":"2016-09-13 05:54:00","sunset":"2016-09-13 18:26:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"东北风","windDirNight":"西北风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"},{"conditionDay":"阵雨","conditionIdDay":"3","conditionIdNight":"33","conditionNight":"阵雨","moonphase":"WaxingGibbous","moonrise":"2016-09-14 16:50:00","moonset":"2016-09-15 03:50:00","predictDate":"2016-09-14","sunrise":"2016-09-14 05:55:00","sunset":"2016-09-14 18:24:00","tempDay":"31","tempNight":"20","updatetime":"2016-09-01 22:07:06","windDirDay":"南风","windDirNight":"东风","windLevelDay":"2","windLevelNight":"1","windSpeedDay":"3.0","windSpeedNight":"1.0"},{"conditionDay":"晴","conditionIdDay":"0","conditionIdNight":"31","conditionNight":"多云","moonphase":"WaxingGibbous","moonrise":"2016-09-15 17:30:00","moonset":"2016-09-16 04:57:00","predictDate":"2016-09-15","sunrise":"2016-09-15 05:55:00","sunset":"2016-09-15 18:23:00","tempDay":"31","tempNight":"18","updatetime":"2016-09-01 22:07:06","windDirDay":"西风","windDirNight":"西风","windLevelDay":"1","windLevelNight":"2","windSpeedDay":"1.0","windSpeedNight":"3.0"}]
         */

        private CityBean city;
        private List<ForecastBean> forecast;

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class CityBean {
            /**
             * cityId : 284609
             * counname : 中国
             * name : 东城区
             * pname : 北京市
             */

            private int cityId;
            private String counname;
            private String name;
            private String pname;

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public String getCounname() {
                return counname;
            }

            public void setCounname(String counname) {
                this.counname = counname;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPname() {
                return pname;
            }

            public void setPname(String pname) {
                this.pname = pname;
            }
        }

        public static class ForecastBean {
            /**
             * conditionDay : 多云
             * conditionIdDay : 1
             * conditionIdNight : 31
             * conditionNight : 多云
             * moonphase : WaningCrescent
             * moonrise : 2016-08-31 04:19:00
             * moonset : 2016-08-31 18:07:00
             * predictDate : 2016-08-31
             * sunrise : 2016-08-31 05:41:00
             * sunset : 2016-08-31 18:47:00
             * tempDay : 34
             * tempNight : 18
             * updatetime : 2016-08-31 23:07:06
             * windDirDay : 北风
             * windDirNight : 西北风
             * windLevelDay : 3
             * windLevelNight : 3
             * windSpeedDay : 5.0
             * windSpeedNight : 5.0
             */

            private String conditionDay;
            private String conditionIdDay;
            private String conditionIdNight;
            private String conditionNight;
            private String moonphase;
            private String moonrise;
            private String moonset;
            private String predictDate;
            private String sunrise;
            private String sunset;
            private String tempDay;
            private String tempNight;
            private String updatetime;
            private String windDirDay;
            private String windDirNight;
            private String windLevelDay;
            private String windLevelNight;
            private String windSpeedDay;
            private String windSpeedNight;

            public String getConditionDay() {
                return conditionDay;
            }

            public void setConditionDay(String conditionDay) {
                this.conditionDay = conditionDay;
            }

            public String getConditionIdDay() {
                return conditionIdDay;
            }

            public void setConditionIdDay(String conditionIdDay) {
                this.conditionIdDay = conditionIdDay;
            }

            public String getConditionIdNight() {
                return conditionIdNight;
            }

            public void setConditionIdNight(String conditionIdNight) {
                this.conditionIdNight = conditionIdNight;
            }

            public String getConditionNight() {
                return conditionNight;
            }

            public void setConditionNight(String conditionNight) {
                this.conditionNight = conditionNight;
            }

            public String getMoonphase() {
                return moonphase;
            }

            public void setMoonphase(String moonphase) {
                this.moonphase = moonphase;
            }

            public String getMoonrise() {
                return moonrise;
            }

            public void setMoonrise(String moonrise) {
                this.moonrise = moonrise;
            }

            public String getMoonset() {
                return moonset;
            }

            public void setMoonset(String moonset) {
                this.moonset = moonset;
            }

            public String getPredictDate() {
                return predictDate;
            }

            public void setPredictDate(String predictDate) {
                this.predictDate = predictDate;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public String getTempDay() {
                return tempDay;
            }

            public void setTempDay(String tempDay) {
                this.tempDay = tempDay;
            }

            public String getTempNight() {
                return tempNight;
            }

            public void setTempNight(String tempNight) {
                this.tempNight = tempNight;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getWindDirDay() {
                return windDirDay;
            }

            public void setWindDirDay(String windDirDay) {
                this.windDirDay = windDirDay;
            }

            public String getWindDirNight() {
                return windDirNight;
            }

            public void setWindDirNight(String windDirNight) {
                this.windDirNight = windDirNight;
            }

            public String getWindLevelDay() {
                return windLevelDay;
            }

            public void setWindLevelDay(String windLevelDay) {
                this.windLevelDay = windLevelDay;
            }

            public String getWindLevelNight() {
                return windLevelNight;
            }

            public void setWindLevelNight(String windLevelNight) {
                this.windLevelNight = windLevelNight;
            }

            public String getWindSpeedDay() {
                return windSpeedDay;
            }

            public void setWindSpeedDay(String windSpeedDay) {
                this.windSpeedDay = windSpeedDay;
            }

            public String getWindSpeedNight() {
                return windSpeedNight;
            }

            public void setWindSpeedNight(String windSpeedNight) {
                this.windSpeedNight = windSpeedNight;
            }
        }
    }

    public static class RcBean {
        /**
         * c : 0
         * p : success
         */

        private int c;
        private String p;

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public String getP() {
            return p;
        }

        public void setP(String p) {
            this.p = p;
        }
    }
}
