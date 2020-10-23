package com.nanjing.tqlhl.db.newcache.present;

import android.text.TextUtils;

import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.db.newcache.bean.WeaCacheBean;
import com.nanjing.tqlhl.db.newcache.present.view.IWeaCallback;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: 铭少
 * @date: 2020/9/12 0012
 * @description：
 */
public class WeaCachePresentImpl implements IWeatherPresent {

    private static volatile WeaCachePresentImpl singleton = null;
    private boolean mIsDelete;

    private WeaCachePresentImpl() {}

    public static WeaCachePresentImpl getInstance() {
                if (singleton == null) {
                    singleton = new WeaCachePresentImpl();
                }
        return singleton;
    }

    @Override
    public void saveWeatherCache(WeaCacheBean weaCacheBean) {
        saveCache(weaCacheBean);
    }


    private void saveCache(WeaCacheBean weaCacheBean) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                if (TextUtils.isEmpty(weaCacheBean.getCity())) {
                    return;
                }
                List<WeaCacheBean> city = LitePal.where("city=?",weaCacheBean.getCity()).find(WeaCacheBean.class);
                for (WeaCacheBean cacheBean : city) {
                    LogUtils.i(WeaCachePresentImpl.this,city.size()+"weaCacheBean-----------66666---------->"+cacheBean.getCity());
                }

                if (city.size() >=1) {
                    WeaCacheBean newCache = new WeaCacheBean();
                    if (weaCacheBean.getRealWeather()!=null) {
                        newCache.setRealWeather(weaCacheBean.getRealWeather());
                    }
                    if (weaCacheBean.getHoursWeather()!=null) {
                        newCache.setHoursWeather(weaCacheBean.getHoursWeather());
                    }
                    if (weaCacheBean.getDayWeather()!=null) {
                        newCache.setDayWeather(weaCacheBean.getDayWeather());
                    }
                    if (weaCacheBean.getLifeIndex()!=null) {
                        newCache.setLifeIndex(weaCacheBean.getLifeIndex());
                    }
                    if (weaCacheBean.getQaiFiveIndex()!=null) {
                        newCache.setQaiFiveIndex(weaCacheBean.getQaiFiveIndex());
                    }
                    if (weaCacheBean.getAqiIndex()!=null) {
                        newCache.setAqiIndex(weaCacheBean.getAqiIndex());
                    }
                    if (weaCacheBean.getHuangLi()!=null) {
                        newCache.setHuangLi(weaCacheBean.getHuangLi());
                    }

                    newCache.updateAll("city=?",weaCacheBean.getCity());
                }
                else if(city.size()==0) {
                    weaCacheBean.save();
                }
                LogUtils.i(WeaCachePresentImpl.this,"saveCache--------------------->"+city.size());

            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override
    public void queryWeatherCache() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                List<WeaCacheBean> cacheBeanList = LitePal.findAll(WeaCacheBean.class);

                LogUtils.i(WeaCachePresentImpl.this,"size-------------->"+cacheBeanList.size());
                for (WeaCacheBean weaCacheBean : cacheBeanList) {
                    LogUtils.i(WeaCachePresentImpl.this,"mAllCache-------------->"+  weaCacheBean.getCity());
                }
                BaseApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        for (IWeaCallback callback : mCallbacks) {
                            callback.onLoadCacheList(cacheBeanList);
                        }
                    }
                });

            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override
    public void deleteWeatherCache(String city) {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                mIsDelete = false;
                int i = LitePal.deleteAll(WeaCacheBean.class, "city=?", city);
                if (i > 0) {
                    mIsDelete = true;
                } else {
                    mIsDelete =false;
                }
                BaseApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        for (IWeaCallback callback : mCallbacks) {
                            callback.onDeleteCache(mIsDelete);
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override
    public void queryWeatherCacheForOne(String currentCity) {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
              List<WeaCacheBean> city = LitePal.where("city=?",currentCity).find(WeaCacheBean.class);

                BaseApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        for (IWeaCallback callback : mCallbacks) {
                            callback.onLoadCacheOneList(city);
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io()).subscribe();


    }

    private List<IWeaCallback> mCallbacks=new ArrayList<>();
    @Override
    public void registerCallback(IWeaCallback iWeaCallback) {
        if (!mCallbacks.contains(iWeaCallback)) {
            mCallbacks.add(iWeaCallback);
        }

    }

    @Override
    public void unregisterCallback(IWeaCallback iWeaCallback) {
        mCallbacks.remove(iWeaCallback);
    }
}
