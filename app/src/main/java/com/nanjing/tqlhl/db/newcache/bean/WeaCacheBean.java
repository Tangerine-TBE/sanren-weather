package com.nanjing.tqlhl.db.newcache.bean;

import org.litepal.crud.LitePalSupport;

/**
 * @author: 铭少
 * @date: 2020/9/12 0012
 * @description：
 */
public class WeaCacheBean extends LitePalSupport {

    private String city;
    private String longitude;
    private String latitude;
    private String realWeather;
    private String hoursWeather;
    private String dayWeather;
    private String lifeIndex;
    private String aqiIndex;
    private String qaiFiveIndex;
    private String huangLi;

    public WeaCacheBean() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRealWeather() {
        return realWeather;
    }

    public void setRealWeather(String realWeather) {
        this.realWeather = realWeather;
    }

    public String getHoursWeather() {
        return hoursWeather;
    }

    public void setHoursWeather(String hoursWeather) {
        this.hoursWeather = hoursWeather;
    }

    public String getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(String dayWeather) {
        this.dayWeather = dayWeather;
    }

    public String getLifeIndex() {
        return lifeIndex;
    }

    public void setLifeIndex(String lifeIndex) {
        this.lifeIndex = lifeIndex;
    }

    public String getAqiIndex() {
        return aqiIndex;
    }

    public void setAqiIndex(String aqiIndex) {
        this.aqiIndex = aqiIndex;
    }

    public String getQaiFiveIndex() {
        return qaiFiveIndex;
    }

    public void setQaiFiveIndex(String qaiFiveIndex) {
        this.qaiFiveIndex = qaiFiveIndex;
    }

    public String getHuangLi() {
        return huangLi;
    }

    public void setHuangLi(String huangLi) {
        this.huangLi = huangLi;
    }
}
