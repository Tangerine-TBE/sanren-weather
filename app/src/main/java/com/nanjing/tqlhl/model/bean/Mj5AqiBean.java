package com.nanjing.tqlhl.model.bean;

import java.util.List;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/10 15:55
 * @class describe
 */
public class Mj5AqiBean {


    /**
     * code : 0
     * data : {"aqiForecast":[{"date":"2016-08-31","publishTime":"2016-08-31 00:00:00","value":39},{"date":"2016-09-01","publishTime":"2016-09-01 00:00:00","value":18},{"date":"2016-09-02","publishTime":"2016-09-01 21:20:00","value":67},{"date":"2016-09-03","publishTime":"2016-09-01 21:20:00","value":65},{"date":"2016-09-04","publishTime":"2016-09-01 21:20:00","value":134},{"date":"2016-09-05","publishTime":"2016-09-01 21:20:00","value":128}],"city":{"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}}
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
         * aqiForecast : [{"date":"2016-08-31","publishTime":"2016-08-31 00:00:00","value":39},{"date":"2016-09-01","publishTime":"2016-09-01 00:00:00","value":18},{"date":"2016-09-02","publishTime":"2016-09-01 21:20:00","value":67},{"date":"2016-09-03","publishTime":"2016-09-01 21:20:00","value":65},{"date":"2016-09-04","publishTime":"2016-09-01 21:20:00","value":134},{"date":"2016-09-05","publishTime":"2016-09-01 21:20:00","value":128}]
         * city : {"cityId":284609,"counname":"中国","name":"东城区","pname":"北京市"}
         */

        private CityBean city;
        private List<AqiForecastBean> aqiForecast;

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public List<AqiForecastBean> getAqiForecast() {
            return aqiForecast;
        }

        public void setAqiForecast(List<AqiForecastBean> aqiForecast) {
            this.aqiForecast = aqiForecast;
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

        public static class AqiForecastBean {
            /**
             * date : 2016-08-31
             * publishTime : 2016-08-31 00:00:00
             * value : 39
             */

            private String date;
            private String publishTime;
            private int value;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
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
