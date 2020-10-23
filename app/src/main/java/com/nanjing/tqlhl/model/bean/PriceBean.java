package com.nanjing.tqlhl.model.bean;

public class PriceBean {

    private String title;
    private String hint;
    private String vipLevel;
    private double price;

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public PriceBean(String title, String hint, String vipLevel, double price) {
        this.title = title;
        this.hint = hint;
        this.vipLevel = vipLevel;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
