package com.nanjing.tqlhl.db.newcache.present.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;

import java.util.List;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.db.newcache.present.view
 * @class describe
 * @time 2020/9/17 14:08
 * @class describe
 */
public interface ICityCacheCallback extends IBaseCallback {

    void onAddCityState(boolean b);

    void onDeleteCityState(boolean b);

    void onQueryCity(List<CityCacheBean> list);
}
