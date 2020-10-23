package com.nanjing.tqlhl.calculator.bean;

import java.io.Serializable;

public class CalResultData implements Serializable {
    double beforeTaxSalary0;//睡前收入
    double currentPersonalTax0;//个人所得税
    double insure0;//五险一金
    double totalTaxMoney0;//累计应纳税所得额
    double rate;//税率
    double cut;//速算扣除
    double result_already;//累计已缴纳额
    double wxyj_gjj;
    double wxyj_yiliao;
    double wxyj_yanglao;
    double wxyj_shiye;
    double wxyj_gongshang;
    double wxyj_shengyu;

    double finalResult;

    public double getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(double finalResult) {
        this.finalResult = finalResult;
    }

    public double getBeforeTaxSalary0() {
        return beforeTaxSalary0;
    }

    public void setBeforeTaxSalary0(double beforeTaxSalary0) {
        this.beforeTaxSalary0 = beforeTaxSalary0;
    }

    public double getCurrentPersonalTax0() {
        return currentPersonalTax0;
    }

    public void setCurrentPersonalTax0(double currentPersonalTax0) {
        this.currentPersonalTax0 = currentPersonalTax0;
    }

    public double getInsure0() {
        return insure0;
    }

    public void setInsure0(double insure0) {
        this.insure0 = insure0;
    }

    public double getTotalTaxMoney0() {
        return totalTaxMoney0;
    }

    public void setTotalTaxMoney0(double totalTaxMoney0) {
        this.totalTaxMoney0 = totalTaxMoney0;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getCut() {
        return cut;
    }

    public void setCut(double cut) {
        this.cut = cut;
    }

    public double getResult_already() {
        return result_already;
    }

    public void setResult_already(double result_already) {
        this.result_already = result_already;
    }

    public double getWxyj_gjj() {
        return wxyj_gjj;
    }

    public void setWxyj_gjj(double wxyj_gjj) {
        this.wxyj_gjj = wxyj_gjj;
    }

    public double getWxyj_yiliao() {
        return wxyj_yiliao;
    }

    public void setWxyj_yiliao(double wxyj_yiliao) {
        this.wxyj_yiliao = wxyj_yiliao;
    }

    public double getWxyj_yanglao() {
        return wxyj_yanglao;
    }

    public void setWxyj_yanglao(double wxyj_yanglao) {
        this.wxyj_yanglao = wxyj_yanglao;
    }

    public double getWxyj_shiye() {
        return wxyj_shiye;
    }

    public void setWxyj_shiye(double wxyj_shiye) {
        this.wxyj_shiye = wxyj_shiye;
    }

    public double getWxyj_gongshang() {
        return wxyj_gongshang;
    }

    public void setWxyj_gongshang(double wxyj_gongshang) {
        this.wxyj_gongshang = wxyj_gongshang;
    }

    public double getWxyj_shengyu() {
        return wxyj_shengyu;
    }

    public void setWxyj_shengyu(double wxyj_shengyu) {
        this.wxyj_shengyu = wxyj_shengyu;
    }


}
