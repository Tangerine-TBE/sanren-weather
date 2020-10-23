package com.nanjing.tqlhl.calculator.bean;

public class DWBean {
    public String getDw_name() {
        return dw_name;
    }

    public void setDw_name(String dw_name) {
        this.dw_name = dw_name;
    }

    public String getDw_code() {
        return dw_code;
    }

    public DWBean(String dw_name, String dw_code, Double rate) {
        this.dw_name = dw_name;
        this.dw_code = dw_code;
        this.rate = rate;
    }

    public void setDw_code(String dw_code) {
        this.dw_code = dw_code;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    String dw_name;//单位名称
    String dw_code;//单位
    Double rate;//倍率


}
