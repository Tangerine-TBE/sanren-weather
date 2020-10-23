package com.nanjing.tqlhl.calculator.bean;

import java.io.Serializable;

public class FxBean implements Serializable {
    String title;
    String fx;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }
}
