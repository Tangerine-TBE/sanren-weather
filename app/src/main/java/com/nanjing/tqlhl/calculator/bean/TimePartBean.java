package com.nanjing.tqlhl.calculator.bean;

import java.io.Serializable;

public class TimePartBean implements Serializable {
    String continentsEn;
    String continentsCn;
    String contryEn;
    String contryCn;
    String cityEn;

    public String getContinentsEn() {
        return continentsEn;
    }

    public void setContinentsEn(String continentsEn) {
        this.continentsEn = continentsEn;
    }

    public String getContinentsCn() {
        return continentsCn;
    }

    public void setContinentsCn(String continentsCn) {
        this.continentsCn = continentsCn;
    }

    public String getContryEn() {
        return contryEn;
    }

    public void setContryEn(String contryEn) {
        this.contryEn = contryEn;
    }

    public String getContryCn() {
        return contryCn;
    }

    public void setContryCn(String contryCn) {
        this.contryCn = contryCn;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCityCn() {
        return cityCn;
    }

    public void setCityCn(String cityCn) {
        this.cityCn = cityCn;
    }

    String cityCn;
}
