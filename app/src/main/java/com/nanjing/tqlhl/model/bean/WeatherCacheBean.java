package com.nanjing.tqlhl.model.bean;

public class WeatherCacheBean {



    private String city;
    private String describe;
    private String tfData;


    private String TfWindy;
    private String tfQuality;
    private String fiveWea;
    private String lifeIndex;

    public WeatherCacheBean(String city, String describe, String tfdata,String tfSpeed,String tfQuality, String fiveWea, String lifeIndex) {
        this.city = city;
        this.describe = describe;
        this.tfData=tfdata;
        this.TfWindy=tfSpeed;
        this.tfQuality=tfQuality;
        this.fiveWea = fiveWea;
        this.lifeIndex = lifeIndex;
    }





    public String getTfData() {
        return tfData;
    }

    public void setTfData(String tfData) {
        this.tfData = tfData;
    }

    public String getTfWindy() {
        return TfWindy;
    }

    public void setTfWindy(String tfWindy) {
        TfWindy = tfWindy;
    }

    public String getTfQuality() {
        return tfQuality;
    }

    public void setTfQuality(String tfQuality) {
        this.tfQuality = tfQuality;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getFiveWea() {
        return fiveWea;
    }

    public void setFiveWea(String fiveWea) {
        this.fiveWea = fiveWea;
    }

    public String getLifeIndex() {
        return lifeIndex;
    }

    public void setLifeIndex(String lifeIndex) {
        this.lifeIndex = lifeIndex;
    }
}
