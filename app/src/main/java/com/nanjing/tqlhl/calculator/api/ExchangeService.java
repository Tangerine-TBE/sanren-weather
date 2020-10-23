package com.nanjing.tqlhl.calculator.api;


import com.nanjing.tqlhl.calculator.bean.ExchangeActualBean;
import com.nanjing.tqlhl.calculator.bean.ExchangeListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ExchangeService {

    /**
     * 得到支持查询汇率的币种列表
     *
     */
    @GET("/list")
    @Headers("Authorization:APPCODE 52ce58f29858415596449874e5555eec")
    Observable<ExchangeListBean> getExchangeList();


    /**
     * 查询实时汇率
     *
     */
    @GET("/waihui-transform")
    @Headers("Authorization:APPCODE 52ce58f29858415596449874e5555eec")
    Observable<ExchangeActualBean> getActualExchange(@Query("fromCode") String fromCode, @Query("money") String money, @Query("toCode") String toCode);


}
