package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.model.bean.WeatherCacheBean;

import java.util.List;

public interface IWeatherCacheCallback {

    void addCacheState(boolean state);

    void deleteCacheState(boolean state);


    void onLoadCacheSuccess(List<WeatherCacheBean> cacheBeanList);
}
