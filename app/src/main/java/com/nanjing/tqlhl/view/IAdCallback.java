package com.nanjing.tqlhl.view;


import com.example.module_ad.bean.AdBean;

public interface IAdCallback {
    void onLoadAdMsgSuccess(AdBean adBean);


    void onLoadAdMsgError();
}
