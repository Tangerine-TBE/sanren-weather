package com.nanjing.tqlhl.model.bean;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/8 14:49
 * @class describe
 */
public class MjRealWeatherBean {

    /**
     * code : 0
     * data : {"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"},"condition":{"condition":"晴","conditionId":"5","humidity":"42","icon":"30","pressure":"999","realFeel":"18","sunRise":"2016-09-01 05:42:00","sunSet":"2016-09-01 18:45:00","temp":"24","tips":"冷热适宜，感觉很舒适。","updatetime":"2016-09-01 22:03:00","uvi":"0","windDir":"东北风","windLevel":"2","windSpeed":"2.45"}}
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
         * condition : {"condition":"晴","conditionId":"5","humidity":"42","icon":"30","pressure":"999","realFeel":"18","sunRise":"2016-09-01 05:42:00","sunSet":"2016-09-01 18:45:00","temp":"24","tips":"冷热适宜，感觉很舒适。","updatetime":"2016-09-01 22:03:00","uvi":"0","windDir":"东北风","windLevel":"2","windSpeed":"2.45"}
         */

        private CityBean city;
        private ConditionBean condition;

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public ConditionBean getCondition() {
            return condition;
        }

        public void setCondition(ConditionBean condition) {
            this.condition = condition;
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

        public static class ConditionBean {
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

            private String condition;
            private String conditionId;
            private String humidity;
            private String icon;
            private String pressure;
            private String realFeel;
            private String sunRise;
            private String sunSet;
            private String temp;
            private String tips;
            private String updatetime;
            private String uvi;
            private String windDir;
            private String windLevel;
            private String windSpeed;

            public String getCondition() {
                return condition;
            }

            public void setCondition(String condition) {
                this.condition = condition;
            }

            public String getConditionId() {
                return conditionId;
            }

            public void setConditionId(String conditionId) {
                this.conditionId = conditionId;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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

            public String getSunRise() {
                return sunRise;
            }

            public void setSunRise(String sunRise) {
                this.sunRise = sunRise;
            }

            public String getSunSet() {
                return sunSet;
            }

            public void setSunSet(String sunSet) {
                this.sunSet = sunSet;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
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

            public String getWindLevel() {
                return windLevel;
            }

            public void setWindLevel(String windLevel) {
                this.windLevel = windLevel;
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
