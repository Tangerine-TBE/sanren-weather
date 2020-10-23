package com.nanjing.tqlhl.db.newcache.present;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.db.newcache.present.view.ICityCacheCallback;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.db.newcache.present
 * @class describe
 * @time 2020/9/17 14:06
 * @class describe
 */
public interface ICityCachePresent extends IBasePresent<ICityCacheCallback> {

    void addCityCache(CityCacheBean cacheBean);

    void deleteCityCache(String city,int position);

    void updateCityCache(CityCacheBean cacheBean)
            ;
    void updateLocationCity(CityCacheBean cacheBean,String lastCity,String log,String lat);


    void queryCityCache();

}
