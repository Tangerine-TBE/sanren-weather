package com.nanjing.tqlhl.utils;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.nanjing.tqlhl.base.BaseApplication;

import static com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.utils
 * @class describe
 * @time 2020/9/8 13:16
 * @class describe
 */
public class GaoDeHelper {

    private  AMapLocationClient mLocationClient=null;
    private static GaoDeHelper  sInstance;

    public static GaoDeHelper getInstance() {
        if (sInstance == null) {
            sInstance = new GaoDeHelper();
        }
        return sInstance;
    }



    private GaoDeHelper() {
        mLocationClient = new AMapLocationClient(BaseApplication.getAppContext());
        initLocation();

    }

    private void initLocation() {
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(Hight_Accuracy);
        option.setOnceLocation(true);
        mLocationClient.setLocationOption(option);
    }

    public void setListener(AMapLocationListener listener) {
        if (mLocationClient != null) {
            mLocationClient.setLocationListener(listener);
        }
    }


    public void startLocation() {
        if (mLocationClient != null) {
            mLocationClient.startLocation();
        }
    }

    public AMapLocationClient getLocationClient() {
        if (mLocationClient != null) {
            return mLocationClient;
        }
        return null;
    }


    public void stopLocation() {
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
            //  mLocationClient.onDestroy();
        }
    }

}
