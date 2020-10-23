package com.nanjing.tqlhl.model.bean;

import java.util.List;

public class DescribeBean  {


    private String tem;

    private String sky;



    private   RealtimeWeatherBean.ResultBean.RealtimeBean.AirQualityBean airQuality;

    private List<Des> mDes;



    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public List<Des> getDes() {
        return mDes;
    }

    public void setDes(List<Des> des) {
        mDes = des;
    }


    public RealtimeWeatherBean.ResultBean.RealtimeBean.AirQualityBean getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(RealtimeWeatherBean.ResultBean.RealtimeBean.AirQualityBean airQuality) {
        this.airQuality = airQuality;
    }

    public static class Des   {


        private int icon;
        private String title;
        private String values;

        public Des(int icon, String title, String values) {
            this.icon = icon;
            this.title = title;
            this.values = values;
        }

        public Des(String title, String values) {
            this.title = title;
            this.values = values;
        }

        public Des() {

        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValues() {
            return values;
        }

        public void setValues(String values) {
            this.values = values;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

    }



}
