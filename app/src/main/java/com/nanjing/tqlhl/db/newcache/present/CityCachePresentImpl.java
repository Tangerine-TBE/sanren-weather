package com.nanjing.tqlhl.db.newcache.present;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.example.module_ad.utils.Contents;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.db.newcache.present.view.ICityCacheCallback;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.db.newcache.present
 * @class describe
 * @time 2020/9/17 14:11
 * @class describe
 */
public class CityCachePresentImpl implements ICityCachePresent {

    private static CityCachePresentImpl sInstance;
    private int mPosition;
    private boolean mScroll = true;

    public static CityCachePresentImpl getInstance() {
        if (sInstance == null) {
            sInstance = new CityCachePresentImpl();
        }
        return sInstance;
    }

    private CityCachePresentImpl() {
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public boolean isScroll() {
        return mScroll;
    }

    public void setScroll(boolean scroll) {
        mScroll = scroll;
    }

    @Override
    public void addCityCache(CityCacheBean cacheBean) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                if (TextUtils.isEmpty(cacheBean.getCity())) {
                    return;
                }
                List<CityCacheBean> city = LitePal.where(Contents.CITY+"=?", cacheBean.getCity()).find(CityCacheBean.class);
                if (city.size() == 1) {
                    cacheBean.updateAll(Contents.CITY+"=?", cacheBean.getCity());
                } else if (city.size() == 0) {
                    cacheBean.save();
                    mScroll = false;
                    queryCityCache();
                    BaseApplication.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            for (ICityCacheCallback callback : mCallbacks) {
                                callback.onAddCityState(true);
                            }
                        }
                    });

                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    private boolean mIsDelete;

    @Override
    public void deleteCityCache(String city, int position) {
        this.mPosition = position;
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                mIsDelete = false;
                int i = LitePal.deleteAll(CityCacheBean.class, Contents.CITY+"=?", city);
                if (i > 0) {
                    mIsDelete = true;
                    queryCityCache();
                } else {
                    mIsDelete = false;
                }

                BaseApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        for (ICityCacheCallback callback : mCallbacks) {
                            callback.onDeleteCityState(mIsDelete);
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override
    public void updateCityCache(CityCacheBean cacheBean) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                if (TextUtils.isEmpty(cacheBean.getCity())) {
                    return;
                }
                cacheBean.updateAll(Contents.CITY+"=?", cacheBean.getCity());
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }


    @Override
    public void updateLocationCity(CityCacheBean cacheBean, String lastCity, String log, String lat) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                if (TextUtils.isEmpty(cacheBean.getCity()) || TextUtils.isEmpty(lastCity)) {
                    return;
                }
                try {
                List<CityCacheBean> cities = LitePal.where(Contents.CITY+"=?", cacheBean.getCity()).find(CityCacheBean.class);
                if (cities.size() == 1) {
                    CityCacheBean cityCacheBean = new CityCacheBean();
                    cityCacheBean.setCity(lastCity);
                    cityCacheBean.setLongitude(log);
                    cityCacheBean.setLatitude(lat);
                    cityCacheBean.updateAll(Contents.CITY+"=?", cacheBean.getCity());

                }

                    ContentValues values = new ContentValues();
                    values.put(Contents.CITY, cacheBean.getCity());
                    values.put(Contents.LONGITUDE, cacheBean.getLongitude());
                    values.put(Contents.LATITUDE, cacheBean.getLatitude());
                    Cursor query = LitePal.getDatabase().query(Contents.LOCATION_TABLE, null, null, null, null, null, null);
                    if (query.moveToNext()) {
                        int id = query.getInt(0);
                        LitePal.getDatabase().update(Contents.LOCATION_TABLE, values, Contents.ID + "=?", new String[]{id + ""});
                    }
                    query.close();
                } catch (Exception e) {
                } finally {
                    queryCityCache();
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }


    @Override
    public void queryCityCache() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                List<CityCacheBean> cacheBeanList = LitePal.findAll(CityCacheBean.class);
                BaseApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        for (ICityCacheCallback callback : mCallbacks) {
                            callback.onQueryCity(cacheBeanList);
                        }
                    }
                });

            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    private List<ICityCacheCallback> mCallbacks = new ArrayList<>();

    @Override
    public void registerCallback(ICityCacheCallback iCityCacheCallback) {
        if (!mCallbacks.contains(iCityCacheCallback)) {
            mCallbacks.add(iCityCacheCallback);
        }
    }

    @Override
    public void unregisterCallback(ICityCacheCallback iCityCacheCallback) {
        mCallbacks.remove(iCityCacheCallback);
    }
}
