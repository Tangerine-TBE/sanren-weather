package com.nanjing.tqlhl.model.bean;

public class LifeBean {

    private int Image;

    private String title;

    private String values;

    public LifeBean(int image, String title, String values) {
        Image = image;
        this.title = title;
        this.values = values;
    }

    public LifeBean() {

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

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
