package com.nanjing.tqlhl.calculator.view;


import com.nanjing.tqlhl.calculator.base.IView;
import com.nanjing.tqlhl.calculator.bean.CityBean;

public interface IDatePartView extends IView {
    /**
     * 获取城市列表
     */
    void refreshDatePartList(String reslut);

    /**
     * 根据城市查询区时间
     */
    void getDateFromCity(CityBean reslut);

    /**
     * 完成更新
     */
    void finishRefresh(String msg);
}
