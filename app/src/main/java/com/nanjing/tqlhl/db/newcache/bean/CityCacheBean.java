package com.nanjing.tqlhl.db.newcache.bean;

import org.litepal.crud.LitePalSupport;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.db.newcache.bean
 * @class describe
 * @time 2020/9/17 14:03
 * @class describe
 */
public class CityCacheBean extends LitePalSupport {
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

    private String city;
    private String longitude;
    private String latitude;
    private String wea;
    private String windy;
    private String team;
    private String lowHigh;
    private String aqi;
    private String dayIcon;
    private String nightIcon;


    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getDayIcon() {
        return dayIcon;
    }

    public void setDayIcon(String dayIcon) {
        this.dayIcon = dayIcon;
    }

    public String getNightIcon() {
        return nightIcon;
    }

    public void setNightIcon(String nightIcon) {
        this.nightIcon = nightIcon;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public String getWindy() {
        return windy;
    }

    public void setWindy(String windy) {
        this.windy = windy;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getLowHigh() {
        return lowHigh;
    }

    public void setLowHigh(String lowHigh) {
        this.lowHigh = lowHigh;
    }

    public CityCacheBean() {

    }



}
