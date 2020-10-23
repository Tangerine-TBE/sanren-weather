package com.nanjing.tqlhl.model.bean;

import android.graphics.drawable.Drawable;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/7 11:51
 * @class describe
 */
public class ToolBean {

    private String Title;
    private String des;
    private Drawable bg;

    public ToolBean(String title, String des, Drawable bg) {
        Title = title;
        this.des = des;
        this.bg = bg;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Drawable getBg() {
        return bg;
    }

    public void setBg(Drawable bg) {
        this.bg = bg;
    }
}
