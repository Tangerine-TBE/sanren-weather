package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.model.bean.WeatherCacheBean;

import java.util.List;

public interface IWeaCacheDaoCallback {

    void addCacheSuccess(boolean isSuccess);

    void deleteCacheSuccess(boolean isSuccess);

    void onWeaCacheList(List<WeatherCacheBean> list);

}
