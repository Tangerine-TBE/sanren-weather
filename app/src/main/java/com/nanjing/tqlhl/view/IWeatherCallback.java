package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj24WeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.model.bean.MjLifeBean;
import com.nanjing.tqlhl.model.bean.MjRealWeatherBean;

import java.util.List;

public interface IWeatherCallback extends IBaseCallback {

    void onLoadRealtimeWeatherData(MjRealWeatherBean.DataBean resultBean);

    void onLoadDayWeatherData(Mj15DayWeatherBean.DataBean resultBean);

    void onLoadHourWeatherData(Mj24WeatherBean weatherBean);

    void onLoadLifeWeatherData(List<MjLifeBean> beanList);

    void onLoadAqiWeatherData(MjAqiBean weatherBean);

    void onLoad5AqiWeatherData(Mj5AqiBean weatherBean);

    void onRefreshSuccess();

    void onRefreshError();
}
