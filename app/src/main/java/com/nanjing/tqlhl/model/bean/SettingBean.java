package com.nanjing.tqlhl.model.bean;

public class SettingBean {
    private int Image;

    private String title;

    public SettingBean(int image, String title) {
        Image = image;
        this.title = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
