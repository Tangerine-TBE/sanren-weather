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
public class Mj24WeatherBean {

    /**
     * code : 0
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"hourly":[{"condition":"阴","date":"2016-09-01","hour":"20","humidity":"51","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"23","uvi":"0","windDir":"N","windSpeed":"12"},{"condition":"阴","date":"2016-09-01","hour":"21","humidity":"56","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"22","humidity":"60","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"20","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"23","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"0","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"1","humidity":"63","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"2","humidity":"66","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"3","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"4","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"5","humidity":"72","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"6","humidity":"71","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"7","humidity":"65","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"20","temp":"21","uvi":"1","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"8","humidity":"57","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"22","uvi":"2","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"9","humidity":"49","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"25","temp":"24","uvi":"3","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"10","humidity":"44","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"25","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"11","humidity":"42","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"26","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"12","humidity":"39","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"28","temp":"27","uvi":"4","windDir":"N","windSpeed":"11"},{"condition":"阴","date":"2016-09-02","hour":"13","humidity":"38","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"27","uvi":"3","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"14","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"15","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"16","humidity":"36","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"27","temp":"28","uvi":"1","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"17","humidity":"39","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"26","temp":"27","uvi":"0","windDir":"SSW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"18","humidity":"45","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"25","temp":"26","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"19","humidity":"53","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"24","temp":"25","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"20","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"24","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"21","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"23","uvi":"0","windDir":"S","windSpeed":"6"}]}
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
         * hourly : [{"condition":"阴","date":"2016-09-01","hour":"20","humidity":"51","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"23","uvi":"0","windDir":"N","windSpeed":"12"},{"condition":"阴","date":"2016-09-01","hour":"21","humidity":"56","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"21","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"22","humidity":"60","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"20","temp":"22","uvi":"0","windDir":"NNW","windSpeed":"11"},{"condition":"阴","date":"2016-09-01","hour":"23","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"0","humidity":"62","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"1","humidity":"63","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"21","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"2","humidity":"66","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"3","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"4","humidity":"68","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"5","humidity":"72","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"18","temp":"19","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"6","humidity":"71","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"19","temp":"20","uvi":"0","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"7","humidity":"65","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"20","temp":"21","uvi":"1","windDir":"NNW","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"8","humidity":"57","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"22","uvi":"2","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"9","humidity":"49","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"25","temp":"24","uvi":"3","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"10","humidity":"44","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"25","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"11","humidity":"42","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"27","temp":"26","uvi":"4","windDir":"NNW","windSpeed":"11"},{"condition":"少云","date":"2016-09-02","hour":"12","humidity":"39","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"28","temp":"27","uvi":"4","windDir":"N","windSpeed":"11"},{"condition":"阴","date":"2016-09-02","hour":"13","humidity":"38","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"27","uvi":"3","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"14","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"15","humidity":"37","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"28","temp":"28","uvi":"2","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"16","humidity":"36","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"27","temp":"28","uvi":"1","windDir":"N","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"17","humidity":"39","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"26","temp":"27","uvi":"0","windDir":"SSW","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"18","humidity":"45","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"25","temp":"26","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"阴","date":"2016-09-02","hour":"19","humidity":"53","iconDay":"2","iconNight":"2","pressure":"0","realFeel":"24","temp":"25","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"20","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"24","uvi":"0","windDir":"S","windSpeed":"9"},{"condition":"少云","date":"2016-09-02","hour":"21","humidity":"62","iconDay":"1","iconNight":"31","pressure":"0","realFeel":"23","temp":"23","uvi":"0","windDir":"S","windSpeed":"6"}]
         */

        private CityBean city;
        private List<HourlyBean> hourly;

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
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

        public static class HourlyBean {
            /**
             * condition : 阴
             * date : 2016-09-01
             * hour : 20
             * humidity : 51
             * iconDay : 2
             * iconNight : 2
             * pressure : 0
             * realFeel : 21
             * temp : 23
             * uvi : 0
             * windDir : N
             * windSpeed : 12
             */

            private String condition;
            private String date;
            private String hour;
            private String humidity;
            private String iconDay;
            private String iconNight;
            private String pressure;
            private String realFeel;
            private String temp;
            private String uvi;
            private String windDir;
            private String windSpeed;

            public String getCondition() {
                return condition;
            }

            public void setCondition(String condition) {
                this.condition = condition;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHour() {
                return hour;
            }

            public void setHour(String hour) {
                this.hour = hour;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getIconDay() {
                return iconDay;
            }

            public void setIconDay(String iconDay) {
                this.iconDay = iconDay;
            }

            public String getIconNight() {
                return iconNight;
            }

            public void setIconNight(String iconNight) {
                this.iconNight = iconNight;
            }

            public String getPressure() {
                return pressure;
            }

            public void setPressure(String pressure) {
                this.pressure = pressure;
            }

            public String getRealFeel() {
                return realFeel;
            }

            public void setRealFeel(String realFeel) {
                this.realFeel = realFeel;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getUvi() {
                return uvi;
            }

            public void setUvi(String uvi) {
                this.uvi = uvi;
            }

            public String getWindDir() {
                return windDir;
            }

            public void setWindDir(String windDir) {
                this.windDir = windDir;
            }

            public String getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(String windSpeed) {
                this.windSpeed = windSpeed;
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
