package com.nanjing.tqlhl.model.bean;

import java.util.List;

public class HuangLiBean {


    /**
     * status : 0
     * msg : ok
     * result : {"year":"2016","month":"10","day":"1","yangli":"公元2016年10月01日","nongli":"农历二〇一六年九月初一","star":"天枰座","taishen":"厨灶栖外正东","wuxing":"沙中土","chong":"冲（庚戌）狗","sha":"煞南","shengxiao":"猴","jiri":"天刑（黑道）危日","zhiri":"天刑（黑道凶日）","xiongshen":"月煞 月虚 四击 天刑","jishenyiqu":"母仓 六合 敬安","caishen":"西南","xishen":"西南","fushen":"正东","suici":["丙申年","丁酉月","丙辰日"],"yi":["订盟","纳采","祭祀","祈福","安香","出火","修造","动土","上梁","安门","起基","竖柱","上梁","定磉","开池","移徙","入宅","立券","破土"],"ji":["嫁娶","造庙","造桥","造船","作灶","安葬"],"eweek":"SATURDAY","emonth":"October","week":"六"}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {

        @Override
        public String toString() {
            return "ResultBean{" +
                    "year='" + year + '\'' +
                    ", month='" + month + '\'' +
                    ", day='" + day + '\'' +
                    ", yangli='" + yangli + '\'' +
                    ", nongli='" + nongli + '\'' +
                    ", star='" + star + '\'' +
                    ", taishen='" + taishen + '\'' +
                    ", wuxing='" + wuxing + '\'' +
                    ", chong='" + chong + '\'' +
                    ", sha='" + sha + '\'' +
                    ", shengxiao='" + shengxiao + '\'' +
                    ", jiri='" + jiri + '\'' +
                    ", zhiri='" + zhiri + '\'' +
                    ", xiongshen='" + xiongshen + '\'' +
                    ", jishenyiqu='" + jishenyiqu + '\'' +
                    ", caishen='" + caishen + '\'' +
                    ", xishen='" + xishen + '\'' +
                    ", fushen='" + fushen + '\'' +
                    ", eweek='" + eweek + '\'' +
                    ", emonth='" + emonth + '\'' +
                    ", week='" + week + '\'' +
                    ", suici=" + suici +
                    ", yi=" + yi +
                    ", ji=" + ji +
                    '}';
        }

        /**
         * year : 2016
         * month : 10
         * day : 1
         * yangli : 公元2016年10月01日
         * nongli : 农历二〇一六年九月初一
         * star : 天枰座
         * taishen : 厨灶栖外正东
         * wuxing : 沙中土
         * chong : 冲（庚戌）狗
         * sha : 煞南
         * shengxiao : 猴
         * jiri : 天刑（黑道）危日
         * zhiri : 天刑（黑道凶日）
         * xiongshen : 月煞 月虚 四击 天刑
         * jishenyiqu : 母仓 六合 敬安
         * caishen : 西南
         * xishen : 西南
         * fushen : 正东
         * suici : ["丙申年","丁酉月","丙辰日"]
         * yi : ["订盟","纳采","祭祀","祈福","安香","出火","修造","动土","上梁","安门","起基","竖柱","上梁","定磉","开池","移徙","入宅","立券","破土"]
         * ji : ["嫁娶","造庙","造桥","造船","作灶","安葬"]
         * eweek : SATURDAY
         * emonth : October
         * week : 六
         */

        private String year;
        private String month;
        private String day;
        private String yangli;
        private String nongli;
        private String star;
        private String taishen;
        private String wuxing;
        private String chong;
        private String sha;
        private String shengxiao;
        private String jiri;
        private String zhiri;
        private String xiongshen;
        private String jishenyiqu;
        private String caishen;
        private String xishen;
        private String fushen;
        private String eweek;
        private String emonth;
        private String week;
        private List<String> suici;
        private List<String> yi;
        private List<String> ji;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getYangli() {
            return yangli;
        }

        public void setYangli(String yangli) {
            this.yangli = yangli;
        }

        public String getNongli() {
            return nongli;
        }

        public void setNongli(String nongli) {
            this.nongli = nongli;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }

        public String getTaishen() {
            return taishen;
        }

        public void setTaishen(String taishen) {
            this.taishen = taishen;
        }

        public String getWuxing() {
            return wuxing;
        }

        public void setWuxing(String wuxing) {
            this.wuxing = wuxing;
        }

        public String getChong() {
            return chong;
        }

        public void setChong(String chong) {
            this.chong = chong;
        }

        public String getSha() {
            return sha;
        }

        public void setSha(String sha) {
            this.sha = sha;
        }

        public String getShengxiao() {
            return shengxiao;
        }

        public void setShengxiao(String shengxiao) {
            this.shengxiao = shengxiao;
        }

        public String getJiri() {
            return jiri;
        }

        public void setJiri(String jiri) {
            this.jiri = jiri;
        }

        public String getZhiri() {
            return zhiri;
        }

        public void setZhiri(String zhiri) {
            this.zhiri = zhiri;
        }

        public String getXiongshen() {
            return xiongshen;
        }

        public void setXiongshen(String xiongshen) {
            this.xiongshen = xiongshen;
        }

        public String getJishenyiqu() {
            return jishenyiqu;
        }

        public void setJishenyiqu(String jishenyiqu) {
            this.jishenyiqu = jishenyiqu;
        }

        public String getCaishen() {
            return caishen;
        }

        public void setCaishen(String caishen) {
            this.caishen = caishen;
        }

        public String getXishen() {
            return xishen;
        }

        public void setXishen(String xishen) {
            this.xishen = xishen;
        }

        public String getFushen() {
            return fushen;
        }

        public void setFushen(String fushen) {
            this.fushen = fushen;
        }

        public String getEweek() {
            return eweek;
        }

        public void setEweek(String eweek) {
            this.eweek = eweek;
        }

        public String getEmonth() {
            return emonth;
        }

        public void setEmonth(String emonth) {
            this.emonth = emonth;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public List<String> getSuici() {
            return suici;
        }

        public void setSuici(List<String> suici) {
            this.suici = suici;
        }

        public List<String> getYi() {
            return yi;
        }

        public void setYi(List<String> yi) {
            this.yi = yi;
        }

        public List<String> getJi() {
            return ji;
        }

        public void setJi(List<String> ji) {
            this.ji = ji;
        }
    }
}
