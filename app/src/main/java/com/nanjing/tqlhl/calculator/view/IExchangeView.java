package com.nanjing.tqlhl.calculator.view;


import com.nanjing.tqlhl.calculator.base.IView;
import com.nanjing.tqlhl.calculator.bean.ExchangeActualBean;
import com.nanjing.tqlhl.calculator.bean.ExchangeListBean;

public interface    IExchangeView extends IView {
   /**
    * 获取可查汇率币种列表
    */
     void refreshExchangeList(ExchangeListBean reslut);

    /**
     * 查询实时汇率
     */
    void getActualExchange(ExchangeActualBean reslut, int textId);



   /**
    * 完成更新
    */
   void finishRefresh(String msg);
}
