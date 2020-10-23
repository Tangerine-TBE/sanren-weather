package com.nanjing.tqlhl.db.newcache.present;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.db.newcache.bean.WeaCacheBean;
import com.nanjing.tqlhl.db.newcache.present.view.IWeaCallback;

/**
 * @author: 铭少
 * @date: 2020/9/12 0012
 * @description：
 */
public interface IWeatherPresent extends IBasePresent<IWeaCallback> {

    void saveWeatherCache(WeaCacheBean weaCacheBean);

    void  queryWeatherCache();

    void deleteWeatherCache(String city);


    void queryWeatherCacheForOne(String city);



}
