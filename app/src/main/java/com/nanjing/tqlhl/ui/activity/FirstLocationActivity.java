package com.nanjing.tqlhl.ui.activity;

import android.widget.FrameLayout;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.example.module_ad.advertisement.SplashHelper;
import com.example.module_ad.utils.CommonUtil;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.LocationBean;
import com.nanjing.tqlhl.presenter.Impl.AddressPresentImpl;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.GaoDeHelper;
import com.nanjing.tqlhl.utils.PresentManager;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.nanjing.tqlhl.view.IAddressCallback;
import com.tamsiree.rxkit.view.RxToast;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.activity
 * @class describe
 * @time 2020/9/11 18:00
 * @class describe
 */
public class FirstLocationActivity extends BaseMainActivity implements OnPickListener, AMapLocationListener, IAddressCallback {

    private GaoDeHelper mGaoDeHelper;
    private LocatedCity mLocatedCity;

    @BindView(R.id.fl_adContainer)
    FrameLayout  mSplashContainer;
    private SplashHelper mSplashHelper;
    private String mCity;
    private String NetCity;
    private AddressPresentImpl mAddressPresent;


    @Override
    public int getLayoutId() {
        return R.layout.activity_location;
    }

    @Override
    protected void intView() {
        //拿开屏广告
        mSplashHelper = new SplashHelper(this, mSplashContainer, MainActivity.class);

        CityPicker.from(FirstLocationActivity.this)
                .enableAnimation(false)
                .setAnimationStyle(0)
                .setHideBar(false)
                .setOnPickListener(FirstLocationActivity.this).show();
    }

    @Override
    protected void intPresent() {

        mAddressPresent = PresentManager.getInstance().getAddressPresent();
        mAddressPresent.registerCallback(this);

        mGaoDeHelper = GaoDeHelper.getInstance();
        mGaoDeHelper.setListener(this);
        mGaoDeHelper.startLocation();
    }


    @Override
    public void onPick(int position, City data) {
        selectCitySuccess();
    }

    private void selectCitySuccess() {
        MyStatusBarUtil.setFullScreen(this,true);
        SpUtils.getInstance().putBoolean(Contents.IS_FIRST, false).commit();
        SpUtils.getInstance().putBoolean(Contents.FIRST_LOCATION, true).commit();
        getSharedPreferences(Contents.NO_BACK_SP, MODE_PRIVATE).edit().putBoolean(Contents.NO_BACK, false).apply();
        //展示广告
        if (mSplashHelper != null) {
            mSplashHelper.showAd();
        }
        if (mGaoDeHelper!=null) {
            AMapLocationClient locationClient = mGaoDeHelper.getLocationClient();
            if (locationClient!=null) {
                locationClient.unRegisterLocationListener(this);
            }
        }

    }

    @Override
    public void onLocate() {
        mGaoDeHelper.startLocation();
    }

    @Override
    public void onCancel() {
        finish();
    }

    @Override
    public void onFail(int position, City data) {
        //  RxToast.warning("请先定位当前城市");
        if (!CommonUtil.isNetworkAvailable(this)){
            RxToast.warning(getString(R.string.connect_error));
        }else {
            if (mAddressPresent != null) {
                NetCity = data.getName();
                mAddressPresent.getLocationAddress(NetCity);
            }
        }
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        double latitude = aMapLocation.getLatitude();
        double longitude = aMapLocation.getLongitude();
        mCity = WeatherUtils.cityType(aMapLocation.getCity());
        mLocatedCity = new LocatedCity(mCity, "", "");
        if ( longitude!= 0.0 ||latitude  != 0.0) {
            CityPicker.from(this).locateComplete(mLocatedCity, LocateState.SUCCESS);
            SpUtils.getInstance().putString(Contents.CURRENT_CITY, mCity)
                    .putString(Contents.CURRENT_LONG, longitude + "")
                    .putString(Contents.CURRENT_LAT,latitude+"")
                    .apply();
        } else {

            BaseApplication.getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    CityPicker.from(FirstLocationActivity.this).locateComplete(mLocatedCity, LocateState.FAILURE);
                }
            },1500 );

        }

    }

    @Override
    protected void release() {
        if (mGaoDeHelper != null) {
            mGaoDeHelper.stopLocation();

        }

        if (mAddressPresent != null) {
            mAddressPresent.unregisterCallback(this);
        }

    }

    @Override
    public void onLoadAddressSuccess(LocationBean addressBean) {
        selectCitySuccess();
        SpUtils.getInstance().putString(Contents.CURRENT_CITY, NetCity)
                .putString(Contents.CURRENT_LONG, addressBean.getLongitude() + "")
                .putString(Contents.CURRENT_LAT,addressBean.getLatitude()+"")
                .apply();


    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }
}
