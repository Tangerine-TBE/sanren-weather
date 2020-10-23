package com.nanjing.tqlhl.model.bean;

public class LocationBean {

    @Override
    public String toString() {
        return "LocationBean{" +
                "city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", wea='" + wea + '\'' +
                ", highTeam=" + highTeam +
                ", lowTeam=" + lowTeam +
                '}';
    }

    public LocationBean(String city, String wea, double highTeam, double lowTeam) {
        this.city = city;
        this.wea = wea;
        this.highTeam = highTeam;
        this.lowTeam = lowTeam;
    }

    public LocationBean(String city, double longitude, double latitude) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public LocationBean(String city, double longitude , double latitude, String wea, double highTeam, double lowTeam) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.wea = wea;
        this.highTeam = highTeam;
        this.lowTeam = lowTeam;
    }





    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private String city;

    //纬度
    private double latitude;


    //经度
    private double longitude;


    //天气
    private String wea;

    //高温
    private double highTeam;
    private String teamHigh;
    //低温
    private double lowTeam;
    private String teamLow;

    //风力风向
    private String windyDir;
    private String windySpeed;

    //空气质量
    private String aqi;

    public LocationBean(String city, double latitude, double longitude, String wea, String teamHigh, String teamLow, String windyDir, String windySpeed, String aqi) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.wea = wea;
        this.teamHigh = teamHigh;
        this.teamLow = teamLow;
        this.windyDir = windyDir;
        this.windySpeed = windySpeed;
        this.aqi = aqi;
    }

    public String getTeamHigh() {
        return teamHigh;
    }

    public void setTeamHigh(String teamHigh) {
        this.teamHigh = teamHigh;
    }

    public String getTeamLow() {
        return teamLow;
    }

    public void setTeamLow(String teamLow) {
        this.teamLow = teamLow;
    }

    public String getWindyDir() {
        return windyDir;
    }

    public void setWindyDir(String windyDir) {
        this.windyDir = windyDir;
    }

    public String getWindySpeed() {
        return windySpeed;
    }

    public void setWindySpeed(String windySpeed) {
        this.windySpeed = windySpeed;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public double getHighTeam() {
        return highTeam;
    }

    public void setHighTeam(double highTeam) {
        this.highTeam = highTeam;
    }

    public double getLowTeam() {
        return lowTeam;
    }

    public void setLowTeam(double lowTeam) {
        this.lowTeam = lowTeam;
    }




}
