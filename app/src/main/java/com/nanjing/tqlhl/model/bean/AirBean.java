package com.nanjing.tqlhl.model.bean;

public class AirBean {

    private String title;
    private String hint;
    private String value;


    public AirBean(String title, String hint, String value) {
        this.title = title;
        this.hint = hint;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
