package com.nanjing.tqlhl.model.bean;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.model.bean
 * @class describe
 * @time 2020/9/8 15:33
 * @class describe
 */
public class MjLifeBean {

    @Override
    public String toString() {
        return "MjLifeBean{" +
                "code=" + code +
                ", day='" + day + '\'' +
                ", desc='" + desc + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }

    /**
     * code : 21
     * day : 2020-09-09
     * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
     * level : 1
     * name : 紫外线指数
     * status : 最弱
     * updatetime : 2020-09-09 09:35:03
     */

    private int code;
    private String day;
    private String desc;
    private String level;
    private String name;
    private String status;
    private String updatetime;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
