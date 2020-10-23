package com.nanjing.tqlhl.calculator.api;


import com.nanjing.tqlhl.calculator.bean.CityBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DatePartService {
  //没有URL就传/或者.
    @GET(".")
    Observable<String> getDatePartList(@Query("app") String app, @Query("appkey") String appkey, @Query("sign") String sign, @Query("format") String format);

  @GET(".")
  Observable<CityBean> getDateFromCity(@Query("app") String app, @Query("city_en") String city_en, @Query("appkey") String appkey, @Query("sign") String sign, @Query("format") String format);
}
