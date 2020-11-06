package com.nanjing.tqlhl.ui.activity;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.module_ad.advertisement.BanFeedHelper;
import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.db.newcache.bean.WeaCacheBean;
import com.nanjing.tqlhl.db.newcache.present.CityCachePresentImpl;
import com.nanjing.tqlhl.db.newcache.present.WeaCachePresentImpl;
import com.nanjing.tqlhl.db.newcache.present.view.ICityCacheCallback;
import com.nanjing.tqlhl.db.newcache.present.view.IWeaCallback;
import com.nanjing.tqlhl.model.bean.LocationBean;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj24WeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.model.bean.MjLifeBean;
import com.nanjing.tqlhl.model.bean.MjRealWeatherBean;
import com.nanjing.tqlhl.presenter.Impl.AddressPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.WeatherPresentImpl;
import com.nanjing.tqlhl.ui.adapter.CityListAdapter;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.PresentManager;
import com.nanjing.tqlhl.utils.RecyclerViewItemDistanceUtil;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.nanjing.tqlhl.view.IAddressCallback;
import com.nanjing.tqlhl.view.IWeatherCallback;
import com.tamsiree.rxkit.view.RxToast;
import com.nanjing.tqlhl.R;
import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.LocatedCity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;

public class CityManageActivity extends BaseMainActivity implements OnPickListener, IAddressCallback, SwipeMenuCreator, OnItemMenuClickListener, IWeaCallback, ICityCacheCallback, IWeatherCallback {


    @BindView(R.id.city_container)
    SwipeRecyclerView mSwipeRecyclerView;
    @BindView(R.id.banner_container)
    FrameLayout mBannerContainer;
    @BindView(R.id.feed_container)
    FrameLayout mFeedContainer;
    @BindView(R.id.iv_bar_add)
    ImageView iv_bar_add;
    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;
    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
    private AddressPresentImpl mAddressPresent;
    private CityListAdapter mCityListAdapter;
    private String mCity;
    private BanFeedHelper mBanFeedHelper;
    private WeaCachePresentImpl mWeaCachePresent;
    private String mCurrentCity;
    private LocatedCity mLocatedCity;
    private List<WeaCacheBean> mWeaCacheBeanList;
    private CityCachePresentImpl mCityCachePresent;
    private WeatherPresentImpl mWeatherPresent;
    private LocationBean mAddress;
    private Mj15DayWeatherBean.DataBean mResult15Bean;
    private Mj24WeatherBean mResultBean24;
    private List<CityCacheBean> mCityList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_city_manage;
    }

    @Override
    protected void intView() {
        visible(iv_bar_add, tv_bar_title);
        tv_bar_title.setText("城市管理");

        //侧滑删除
        mSwipeRecyclerView.setSwipeMenuCreator(this);
        mSwipeRecyclerView.setOnItemMenuClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerViewItemDistanceUtil.setDistance(mSwipeRecyclerView, this, 12f);
        mSwipeRecyclerView.setLayoutManager(manager);
        mCityListAdapter = new CityListAdapter();
        mSwipeRecyclerView.setAdapter(mCityListAdapter);


        //加载广告
        mBanFeedHelper = new BanFeedHelper(this, mBannerContainer, mFeedContainer);
         mBanFeedHelper.showAd(BanFeedHelper.AdType.CITY_MANAGER_PAGE);

        mCurrentCity = SpUtils.getInstance().getString(Contents.CURRENT_CITY);
        mLocatedCity = new LocatedCity(mCurrentCity, "", "");

    }


    @Override
    protected void intPresent() {
        mAddressPresent = PresentManager.getInstance().getAddressPresent();
        mAddressPresent.registerCallback(this);

        mCityCachePresent = CityCachePresentImpl.getInstance();
        mCityCachePresent.registerCallback(this);

        mWeatherPresent = new WeatherPresentImpl();
        mWeatherPresent.registerCallback(this);


        mWeaCachePresent = WeaCachePresentImpl.getInstance();
        mWeaCachePresent.registerCallback(this);
        if (mCityCachePresent != null) {
            mCityCachePresent.queryCityCache();
        }

    }


    @Override
    protected void intEvent() {
        //  LogUtils.i(this,"intEvent----------------------->"+mLocatedCity);
        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //添加城市
        iv_bar_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAdd = false;
                CityPicker.from(CityManageActivity.this)
                        .enableAnimation(false)
                        .setAnimationStyle(0)
                        .setLocatedCity(mLocatedCity)
                        .setHideBar(true)
                        .setOnPickListener(CityManageActivity.this).show();
            }
        });

        //刪除城市
        mCityListAdapter.setOnItemClickListener(new CityListAdapter.OnItemClickListener() {
            @Override
            public void deleteOnClick(CityCacheBean city, int position) {
                if (mWeaCachePresent != null && !TextUtils.isEmpty(mCurrentCity) && mCityCachePresent != null) {
                    if (city.getCity().equals(mCurrentCity)) {
                        RxToast.error(CityManageActivity.this, "当前所在城市不能移除").show();
                    } else {
                        mWeaCachePresent.deleteWeatherCache(city.getCity());
                        mCityCachePresent.deleteCityCache(city.getCity(), position);
                        EventBus.getDefault().post(city);
                    }
                }
            }

            @Override
            public void OnItemClick(CityCacheBean city, int position) {
                onLoadAddressSuccess(new LocationBean(city.getCity(), Double.parseDouble(city.getLongitude()), Double.parseDouble(city.getLatitude())));
            }
        });
    }


    @Override
    public void onPick(int position, City data) {
        if (mCityList.size() < 10) {
            if (mAddressPresent != null) {
                mCity = data.getName();
                mAddressPresent.getLocationAddress(mCity);
            }
        } else {
            RxToast.warning("最多只能添加十个城市");
        }

    }

    @Override
    public void onLocate() {

    }

    @Override
    public void onCancel() {
    }

    @Override
    public void onFail(int position, City data) {

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onLoadAddressSuccess(LocationBean addressBean) {
        this.mAddress = addressBean;
        LogUtils.i(this, "-onLoadAddressSuccess*------------------------>" + addressBean.getLatitude() + "-------" + addressBean.getLatitude());
        if (mWeatherPresent != null) {
            mWeatherPresent.getHourWeatherInfo(addressBean.getLongitude() + "", addressBean.getLatitude() + "");
            mWeatherPresent.getDayWeatherInfo(addressBean.getLongitude() + "", addressBean.getLatitude() + "");
        }

    }


    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {
        RxToast.error(this, "没有网络，请重新再试").show();
    }


    //添加右侧侧滑按钮
    @Override
    public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int position) {
        int width = getResources().getDimensionPixelSize(R.dimen.dp_70);
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        {
            SwipeMenuItem deleteItem = new SwipeMenuItem(CityManageActivity.this).setBackground(R.drawable.selector_red)
                    .setImage(R.mipmap.ic_action_delete)
                    .setText("删除")
                    .setTextColor(Color.WHITE)
                    .setWidth(width)
                    .setBackground(R.drawable.shape_city_delete_bg)
                    .setHeight(height);
            rightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。
        }
    }

    //侧滑监听
    @Override
    public void onItemClick(SwipeMenuBridge menuBridge, int adapterPosition) {
        menuBridge.closeMenu();
        int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
        if (direction == SwipeRecyclerView.RIGHT_DIRECTION) {
            mCityListAdapter.deleteCity(adapterPosition);

        }
    }

    @Override
    public void onLoadSave(boolean b) {

    }

    @Override
    public void onLoadCacheList(List<WeaCacheBean> weaCacheBeanList) {
        this.mWeaCacheBeanList = weaCacheBeanList;
    }

    @Override
    public void onDeleteCache(boolean b) {
        if (b) {
            LogUtils.i(this, "----------onDeleteCache--------------删除成功");
        } else {
            LogUtils.i(this, "----------onDeleteCache--------------失败");
        }
    }

    @Override
    public void onLoadCacheOneList(List<WeaCacheBean> weaCacheBeanList) {

    }


    @Override
    protected void release() {

        if (mAddressPresent != null) {
            mAddressPresent.unregisterCallback(this);
        }

        if (mWeaCachePresent != null) {
            mWeaCachePresent.unregisterCallback(this);
        }

        if (mCityCachePresent != null) {
            mCityCachePresent.unregisterCallback(this);
        }

        if (mBanFeedHelper != null) {
            mBanFeedHelper.releaseAd();
        }

    }

    @Override
    public void onAddCityState(boolean b) {

    }

    @Override
    public void onDeleteCityState(boolean b) {

    }

    @Override
    public void onQueryCity(List<CityCacheBean> list) {
        if (list != null) {
            this.mCityList = list;
            mCityListAdapter.setData(list);
        }
    }

    @Override
    public void onLoadRealtimeWeatherData(MjRealWeatherBean.DataBean resultBean) {

    }

    private void saveCityList() {

        if (mCityCachePresent != null & mResultBean24 != null & mResult15Bean != null) {
            if (!isAdd) {
                Mj24WeatherBean.DataBean.HourlyBean hourlyBean = mResultBean24.getData().getHourly().get(0);
                Mj15DayWeatherBean.DataBean.ForecastBean forecastBean = mResult15Bean.getForecast().get(1);
                CityCacheBean cityCacheBean = new CityCacheBean();
                cityCacheBean.setCity(mAddress.getCity());
                cityCacheBean.setLongitude(mAddress.getLongitude() + "");
                cityCacheBean.setLatitude(mAddress.getLatitude() + "");
                cityCacheBean.setTeam(WeatherUtils.addTemSymbol2(hourlyBean.getTemp()));
                cityCacheBean.setWea(hourlyBean.getCondition());
                cityCacheBean.setDayIcon(hourlyBean.getIconDay());
                cityCacheBean.setNightIcon(hourlyBean.getIconNight());
                cityCacheBean.setWindy(WeatherUtils.formatWindyDir(hourlyBean.getWindDir()) + "  " + WeatherUtils.winType(Double.parseDouble(hourlyBean.getWindSpeed()), true));
                cityCacheBean.setLowHigh(WeatherUtils.addTemSymbol2(forecastBean.getTempNight()) + "/" +WeatherUtils.addTemSymbol2(forecastBean.getTempDay()) );
                mCityCachePresent.addCityCache(cityCacheBean);
                isAdd = true;

            }
        }
    }

    private boolean isAdd = false;

    @Override
    public void onLoadDayWeatherData(Mj15DayWeatherBean.DataBean resultBean) {
        if (resultBean != null) {
            this.mResult15Bean = resultBean;
            saveCityList();

        }
    }

    @Override
    public void onLoadHourWeatherData(Mj24WeatherBean weatherBean) {
        if (weatherBean != null) {
            this.mResultBean24 = weatherBean;
            saveCityList();
        }
    }

    @Override
    public void onLoadLifeWeatherData(List<MjLifeBean> beanList) {

    }

    @Override
    public void onLoadAqiWeatherData(MjAqiBean weatherBean) {
        if (weatherBean==null||weatherBean.getData()==null||weatherBean.getData().getAqi()==null) {
            return;
        }
        if (mCityCachePresent != null) {
            CityCacheBean cityCacheBean = new CityCacheBean();
            cityCacheBean.setCity(mAddress.getCity());
            cityCacheBean.setAqi(weatherBean.getData().getAqi().getValue());
            mCityCachePresent.addCityCache(cityCacheBean);
        }
    }

    @Override
    public void onLoad5AqiWeatherData(Mj5AqiBean weatherBean) {

    }

    @Override
    public void onRefreshSuccess() {

    }

    @Override
    public void onRefreshError() {

    }
}