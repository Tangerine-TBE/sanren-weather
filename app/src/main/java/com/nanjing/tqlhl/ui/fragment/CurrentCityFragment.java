package com.nanjing.tqlhl.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.advertisement.FeedHelper;
import com.example.module_ad.utils.CommonUtil;
import com.example.module_ad.utils.LogUtils;
import com.google.gson.Gson;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.base.IMainTopCallback;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.db.newcache.bean.WeaCacheBean;
import com.nanjing.tqlhl.db.newcache.present.WeaCachePresentImpl;
import com.nanjing.tqlhl.db.newcache.present.view.IWeaCallback;
import com.nanjing.tqlhl.model.bean.HuangLiBean;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj24WeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.model.bean.MjDesBean;
import com.nanjing.tqlhl.model.bean.MjLifeBean;
import com.nanjing.tqlhl.model.bean.MjRealWeatherBean;
import com.nanjing.tqlhl.presenter.Impl.HuangLiPresentImpl;
import com.nanjing.tqlhl.presenter.Impl.WeatherPresentImpl;
import com.nanjing.tqlhl.ui.activity.AirActivity;
import com.nanjing.tqlhl.ui.activity.Day15Activity;
import com.nanjing.tqlhl.ui.activity.DayDetailsActivity;
import com.nanjing.tqlhl.ui.activity.HuangLiActivity;
import com.nanjing.tqlhl.ui.activity.ToolActivity;
import com.nanjing.tqlhl.ui.adapter.Mj24Adapter;
import com.nanjing.tqlhl.ui.adapter.MjDesAdapter;
import com.nanjing.tqlhl.ui.adapter.MjLifeAdapter;
import com.nanjing.tqlhl.ui.custom.mj15day.AirLevel;
import com.nanjing.tqlhl.ui.custom.mj15day.WeatherModel;
import com.nanjing.tqlhl.ui.custom.mj15day.ZzWeatherView;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.utils.ImmersionUtil;
import com.nanjing.tqlhl.utils.KtUtil;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.utils.UtilsKt;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.nanjing.tqlhl.view.IHuangLiCallback;
import com.nanjing.tqlhl.view.IWeatherCallback;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.tamsiree.rxkit.view.RxToast;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.fragment
 * @class describe
 * @time 2020/9/17 11:32
 * @class describe
 */
public class CurrentCityFragment extends BaseFragment implements IWeatherCallback, IHuangLiCallback, View.OnClickListener, IWeaCallback{

    private WeatherPresentImpl mWeatherPresent;
    private HuangLiPresentImpl mHuangLiPresent;
    @BindView(R.id.tv_home_team)
    TextView mTeam;  //温度
    @BindView(R.id.tv_home_wea)
    TextView mWea;//天气
    @BindView(R.id.tv_home_details)
    TextView tv_home_details;
    @BindView(R.id.iv_top_bg)
    ImageView iv_top_bg;
    @BindView(R.id.iv_icon_weather)
    ImageView iv_icon_wea;
    @BindView(R.id.SmartRefreshLayout)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.NestedScrollView)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.rv_24Container)
    RecyclerView m24Container;
    @BindView(R.id.rv_life_des)
    RecyclerView mLifeContainer;
    @BindView(R.id.feedAd_container)
    FrameLayout mFeedAdContainer;
    @BindView(R.id.weather15_view)
    ZzWeatherView weatherView;
    @BindView(R.id.tv_future15)
    TextView tv_future15;
    @BindView(R.id.rl_hl)
    RelativeLayout rl_hl;
    @BindView(R.id.rl_gj)
    RelativeLayout rl_gj;
    @BindView(R.id.rl_kq)
    RelativeLayout rl_kq;

    //描述
    @BindView(R.id.rv_weather_des)
    RecyclerView rv_weather_des;
    private Mj24Adapter mMj24Adapter;
    private MjLifeAdapter mLifeAdapter;
    private String mLatitude;
    private String mLongitude;
    private String mLocationCity;
    private String mTemp;
    public String mTempNight;
    public String mTempDay;
    private String mAqiValue;
    private String mCurrentWea;
    private MjAqiBean.DataBean.AqiBean mDataAqi;
    private Mj5AqiBean mAqiForecast;
    private Mj15DayWeatherBean.DataBean mDay15Weather;
    private HuangLiBean.ResultBean mHuangLiResult;
    private MjRealWeatherBean.DataBean.ConditionBean mRealWeather;
    private String mStatusZWX;
    private String mAqiType;
    private Mj24WeatherBean.DataBean mHours24Weather;
    private WeaCachePresentImpl mWeaCachePresent;
    private int mPos;
    private FragmentActivity mActivity;
    private FeedHelper mFeedHelper;
    private Fragment mParentFragment;
    private MjDesAdapter mDesAdapter;

    public static CurrentCityFragment getInstance(CityCacheBean cacheBean) {
        CurrentCityFragment currentCityFragment = new CurrentCityFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contents.CURRENT_CITY,cacheBean.getCity());
        bundle.putString(Contents.CURRENT_LONG,cacheBean.getLongitude());
        bundle.putString(Contents.CURRENT_LAT,cacheBean.getLatitude());
        currentCityFragment.setArguments(bundle);
        return currentCityFragment;
    }

    private static final int REQUEST_NEW__DATA_TIME=10;
    @Override
    protected void intLoad() {
        Bundle arguments = getArguments();
        mLocationCity =arguments.getString(Contents.CURRENT_CITY);
        mLongitude = arguments.getString(Contents.CURRENT_LONG);
        mLatitude =arguments.getString(Contents.CURRENT_LAT);


        if (!CommonUtil.isNetworkAvailable(getContext())) {
            requestOldWeather();
            RxToast.warning(getResources().getString(R.string.connect_error));
        } else {
            long cacheTime = mSpUtils.getLong(Contents.SP_CACHE_TIME, 0L);
            long cacheLastTime = UtilsKt.calLastedTime(new Date(), new Date(cacheTime));
            if (cacheTime != 0L) {
                if (cacheLastTime > REQUEST_NEW__DATA_TIME) {
                    requestNewWeather();
                } else {
                    if (WeaCachePresentImpl.getInstance().mList.contains(mLocationCity)) {
                        requestOldWeather();
                        LogUtils.i(this, "-----rqbTime-----------requestOldWeather----------------"+cacheLastTime);
                    } else {
                        requestNewWeather();
                        LogUtils.i(this, "-----rqbTime----------requestNewWeather-----------------"+cacheLastTime);
                    }
                }
                LogUtils.i(this, "-----rqbTime---------------------------"+cacheLastTime);
            } else {

                requestNewWeather();
            }
        }



    }

    private void requestOldWeather() {
        if (mWeaCachePresent != null) {
            mWeaCachePresent.queryWeatherCache();
        }
    }

    @Override
    public int getChildLayout() {
        return R.layout.fragment_current_city;
    }



    public void onNestedScrollView() {
        mNestedScrollView.scrollTo(0, 0);
    }

    @Override
    protected void intView() {
        setViewState(ViewState.SUCCESS);

        init15DayWeather();
        //设置刷新头
        MaterialHeader materialHeader = new MaterialHeader(getActivity());
        mSmartRefreshLayout.setRefreshHeader(materialHeader);
        setAdapter();
        mActivity = getActivity();

        mFeedHelper = new FeedHelper(getActivity(), mFeedAdContainer);
        mFeedHelper.showAd();
    }

    private void init15DayWeather() {
        //设置白天和晚上线条的颜色
        weatherView.setDayAndNightLineColor(ColorUtil.HIGH15, ColorUtil.LOW15);
        //画折线
        weatherView.setLineType(ZzWeatherView.LINE_TYPE_CURVE);
        //设置线宽
        weatherView.setLineWidth(6f);
        //设置一屏幕显示几列(最少3列)
        try {
            weatherView.setColumnNumber(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL, false);
        m24Container.setLayoutManager(manager);
        mMj24Adapter = new Mj24Adapter(false);
        m24Container.setAdapter(mMj24Adapter);

        LinearLayoutManager desManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        rv_weather_des.setLayoutManager(desManager);
        mDesAdapter = new MjDesAdapter();
        rv_weather_des.setAdapter(mDesAdapter);


        //提前加载缓存
        String hourly24 = SpUtils.getInstance().getString(Contents.HOURLY24);
        String realWeather = SpUtils.getInstance().getString(Contents.HOURLYREAL);
        if (!TextUtils.isEmpty(hourly24)&!TextUtils.isEmpty(realWeather)) {
            Mj24WeatherBean.DataBean dataBean=new Gson().fromJson(hourly24, Mj24WeatherBean.DataBean.class);
            mMj24Adapter.setData(dataBean.getHourly());
            MjRealWeatherBean.DataBean.ConditionBean realDataBean=new Gson().fromJson(realWeather,MjRealWeatherBean.DataBean.ConditionBean.class);
            showRealWeather(realDataBean);
        }


        LinearLayoutManager managerLife = new LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL, false);
        mLifeContainer.setLayoutManager(managerLife);
        mLifeAdapter = new MjLifeAdapter();
        mLifeContainer.setAdapter(mLifeAdapter);

        mParentFragment = getParentFragment();
    }

    @Override
    protected void intPresent() {
        mWeaCachePresent = WeaCachePresentImpl.getInstance();
        mWeaCachePresent.registerCallback(this);

        mHuangLiPresent = HuangLiPresentImpl.getInstance();
        mHuangLiPresent.registerCallback(this);

        mWeatherPresent = new WeatherPresentImpl();
        mWeatherPresent.registerCallback(this);



    }


    //请求天气数据
    private void requestNewWeather() {
        if (mWeatherPresent != null & mHuangLiPresent != null) {
            mWeatherPresent.getRealTimeWeatherInfo(mLongitude, mLatitude);
            mWeatherPresent.getHourWeatherInfo(mLongitude, mLatitude);
            mWeatherPresent.getDayWeatherInfo(mLongitude, mLatitude);
            mWeatherPresent.getAqiWeatherInfo(mLongitude, mLatitude);
            mWeatherPresent.get5AqiWeatherInfo(mLongitude, mLatitude);
            mWeatherPresent.getLifeWeatherInfo(mLongitude, mLatitude);
            mHuangLiPresent.getHuangLi();
        }
    }

    @Override
    protected void intEvent() {
        tv_home_details.setOnClickListener(this);
        tv_future15.setOnClickListener(this);
        rl_hl.setOnClickListener(this);
        rl_gj.setOnClickListener(this);
        rl_kq.setOnClickListener(this);

        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if (mParentFragment instanceof HomeFragment) {
                        ((IMainTopCallback) mParentFragment).setTopType(setBarColor(),scrollY);
                    }

            }
        });


        //下拉刷新
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (mWeatherPresent != null&mLongitude!=null&mLatitude!=null) {
                    mWeatherPresent.pullToRefresh(mLongitude,mLatitude);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rl_gj:
                startActivity(new Intent( getActivity(), ToolActivity.class));
                break;
            case R.id.tv_future15:
                    if ( mDay15Weather != null) {
                        Intent intent = new Intent(getActivity(), Day15Activity.class);
                        intent.putExtra(Contents.MJ_DAY15, JSON.toJSONString(mDay15Weather));
                        startActivity(intent);
                }
                break;
            case R.id.rl_hl:
                if (mHuangLiResult != null) {
                    ImmersionUtil.startActivity(getActivity(), HuangLiActivity.class,false);
                }
                break;
            case R.id.tv_home_details:
                if (mRealWeather != null & mStatusZWX != null & mAqiType != null) {
                    Intent intent = new Intent( getActivity(), DayDetailsActivity.class);
                    intent.putExtra(Contents.Mj_Real_DATA, JSON.toJSONString(mRealWeather));
                    intent.putExtra(Contents.MSTATUSZWX, mStatusZWX);
                    intent.putExtra(Contents.MAQITYPE, mAqiType);
                    intent.putExtra(Contents.MJ_LOW_HIGH, WeatherUtils.addTemSymbol2(mTempNight)+"/"+WeatherUtils.addTemSymbol2(mTempDay));
                    intent.putExtra(Contents.MJ_HOURS24, JSON.toJSONString(mHours24Weather));
                    startActivity(intent);
                }
                break;
            case R.id.rl_kq:
                if (mAqiForecast == null || mAqiForecast.getData() == null) {
                    RxToast.warning("暂时无法获取当城市前空气质量");
                } else {
                    if (mDataAqi != null & mDay15Weather != null) {
                        Intent intent = new Intent(getActivity(), AirActivity.class);
                        intent.putExtra(Contents.MJ_API, JSON.toJSONString(mDataAqi));
                        intent.putExtra(Contents.MJ_API5, JSON.toJSONString(mAqiForecast));
                        intent.putExtra(Contents.MJ_DAY15, JSON.toJSONString(mDay15Weather));
                        startActivity(intent);
                    }
                }
                break;

        }
    }


    @Override
    public void onLoadCacheOneList(List<WeaCacheBean> weaCacheBeanList) {
    }

    //拿缓存
    @Override
    public void onLoadCacheList(List<WeaCacheBean> weaCacheBeanList) {
        if (weaCacheBeanList.size()!=0) {
            if (mPos>=weaCacheBeanList.size()) {
                return;
            }
            if (mPos>=0) {
                WeaCacheBean weaCacheBean = weaCacheBeanList.get(mPos);
            //实时天气
            String realWeather = weaCacheBean.getRealWeather();
            if (!TextUtils.isEmpty(realWeather)) {
                MjRealWeatherBean.DataBean.ConditionBean resultBeanReal = JSON.parseObject(realWeather, MjRealWeatherBean.DataBean.ConditionBean.class);
                if (resultBeanReal==null) {
                    return;
                }
                showRealWeather(resultBeanReal);
            }
            //15天天气
            String dayWeather = weaCacheBean.getDayWeather();
            if (!TextUtils.isEmpty(dayWeather)) {
                Mj15DayWeatherBean.DataBean resultBean15Day = JSON.parseObject(dayWeather, Mj15DayWeatherBean.DataBean.class);
                if (resultBean15Day==null||resultBean15Day.getForecast()==null||resultBean15Day.getForecast().size()==0) {
                 return;
                }
                show15DayWeather(resultBean15Day);
            }
            //24小时天气
            String hoursWeather = weaCacheBean.getHoursWeather();
            if (!TextUtils.isEmpty(hoursWeather)){
                Mj24WeatherBean.DataBean resultBean24Hours = JSON.parseObject(hoursWeather, Mj24WeatherBean.DataBean.class);
                if (resultBean24Hours==null||resultBean24Hours.getHourly()==null||resultBean24Hours.getHourly().size()==0) {
                    return;
                }
                show24HoursWeather(resultBean24Hours);
            }

            //生活指数
            String lifeIndex = weaCacheBean.getLifeIndex();
            if (!TextUtils.isEmpty(lifeIndex)){
                List<MjDesBean> mjDesBeanList = JSON.parseArray(lifeIndex, MjDesBean.class);
                if (mjDesBeanList.size()==0) {
                    return;
                }
                showLifeIndex(mjDesBeanList);
            }

            //空气质量
            String aqiIndex = weaCacheBean.getAqiIndex();
            if (!TextUtils.isEmpty(aqiIndex)){
                MjAqiBean.DataBean.AqiBean aqiBean = JSON.parseObject(aqiIndex, MjAqiBean.DataBean.AqiBean.class);
                if (aqiBean==null||aqiBean.getValue()==null) {
                    return;
                }
                showAqi(aqiBean);
            }
            //5天空气质量
            String aqi5Index = weaCacheBean.getQaiFiveIndex();
            if (!TextUtils.isEmpty(aqi5Index)){
                Mj5AqiBean mj5AqiBean = JSON.parseObject(aqi5Index, Mj5AqiBean.class);
                if (mj5AqiBean==null||mj5AqiBean.getData()==null||mj5AqiBean.getData().getAqiForecast().size()==0) {
                    return;
                }
                showAqi(mj5AqiBean);

            }

            //黄历
            String huangLi = weaCacheBean.getHuangLi();
            if (!TextUtils.isEmpty(huangLi)){
                HuangLiBean.ResultBean resultBeanHl = JSON.parseObject(huangLi, HuangLiBean.ResultBean.class);
                if (resultBeanHl==null) {
                    return;
                }
                showHuangLi(resultBeanHl);
            }

            }

        }
    }

    private List<MjDesBean> mDesList = new ArrayList<>();
    /*天气回调---------------------------------------------------------------*/
    //实时天气
    @Override
    public void onLoadRealtimeWeatherData(MjRealWeatherBean.DataBean resultBean) {
        LogUtils.i(this,"onSuccess--------1---------->");
        if (mTeam == null || resultBean == null||resultBean.getCondition()==null) {
            return;
        }
        SpUtils.getInstance().putString(Contents.HOURLYREAL,new Gson().toJson(resultBean.getCondition())).commit();
        showRealWeather(resultBean.getCondition());
        doAddSQLit();
    }
    private void showRealWeather(MjRealWeatherBean.DataBean.ConditionBean resultBean) {
        mRealWeather = resultBean;

        mTemp = resultBean.getTemp();
        mTeam.setText(mTemp + "℃");


        showDes();

    }

    //15天天气
    @Override
    public void onLoadDayWeatherData(Mj15DayWeatherBean.DataBean resultBean) {
        LogUtils.i(this,"onSuccess--------2---------->");
        if (resultBean == null||resultBean.getForecast().size()==0) {
            return;
        }
        show15DayWeather(resultBean);
        doAddSQLit();
        CityCacheBean cityCacheBean = new CityCacheBean();
        cityCacheBean.setCity(mLocationCity);
        cityCacheBean.setLowHigh(WeatherUtils.addTemSymbol2(resultBean.getForecast().get(1).getTempNight()) + "/" + WeatherUtils.addTemSymbol2(resultBean.getForecast().get(1).getTempDay()));
        EventBus.getDefault().post(cityCacheBean);
    }
    private List<WeatherModel>  m15DayWeatherList = new ArrayList<>();
    private void show15DayWeather(Mj15DayWeatherBean.DataBean resultBean) {
        m15DayWeatherList.clear();
        mDay15Weather = resultBean;
        SpUtils.getInstance().putString(Contents.DAY15_WEATHER,JSON.toJSONString(mDay15Weather));
        List<Mj15DayWeatherBean.DataBean.ForecastBean> forecast = resultBean.getForecast();
        LogUtils.i(this, "onLoadLifeWeatherData--------------->" + forecast.get(1).getPredictDate());
        Mj15DayWeatherBean.DataBean.ForecastBean forecastBeanTd = forecast.get(1);


        //今天
        mTempNight = forecastBeanTd.getTempNight();
        mTempDay = forecastBeanTd.getTempDay();
        String week=null;
        List<Mj15DayWeatherBean.DataBean.ForecastBean> day15List = forecast.subList(1, 6);
        for (int i = 0; i <day15List.size(); i++) {
            String date = day15List.get(i).getPredictDate();
            String tempDay = day15List.get(i).getTempDay();
            String tempNight = day15List.get(i).getTempNight();

            if (i == 0) {
                week = "今天";
            } else if (i == 1) {
                week = "明天";
            } else {
                week = DateUtil.getWeek(date);
            }
            WeatherModel weather15 = new WeatherModel();
            weather15.setDate(DateUtil.StrToData(date));
            weather15.setWeek(week);
            weather15.setDayTemp(Integer.valueOf(tempDay));
            weather15.setNightTemp(Integer.valueOf(tempNight));

            weather15.setDayWeather("晴");
            weather15.setDayPic(R.mipmap.iocn_small_qingtian);
            weather15.setNightPic(R.mipmap.iocn_small_qingtian);
            weather15.setNightWeather("晴");
            weather15.setAirLevel(AirLevel.EXCELLENT);
            m15DayWeatherList.add(weather15);
        }
        weatherView.setList(m15DayWeatherList);
        weatherView.setVisibility(View.VISIBLE);

    }

    //24小时天气
    @Override
    public void onLoadHourWeatherData(Mj24WeatherBean weatherBean) {
        LogUtils.i(this,"onSuccess--------3---------->");
        if (weatherBean == null||weatherBean.getData()==null) {
            return;
        }
        SpUtils.getInstance().putString(Contents.HOURLY24,new Gson().toJson(weatherBean.getData())).commit();
        show24HoursWeather(weatherBean.getData());
        doAddSQLit();
            Mj24WeatherBean.DataBean.HourlyBean hourlyBean = weatherBean.getData().getHourly().get(0);
            CityCacheBean cityCacheBean = new CityCacheBean();
            cityCacheBean.setCity(mLocationCity);
            cityCacheBean.setTeam(WeatherUtils.addTemSymbol2(hourlyBean.getTemp()));
            cityCacheBean.setWea(hourlyBean.getCondition());
            cityCacheBean.setDayIcon(hourlyBean.getIconDay());
             cityCacheBean.setNightIcon(hourlyBean.getIconNight());
            cityCacheBean.setWindy(WeatherUtils.formatWindyDir(hourlyBean.getWindDir()) + "  " + WeatherUtils.winType(Double.parseDouble(hourlyBean.getWindSpeed()), true));
            EventBus.getDefault().post(cityCacheBean);

    }
    private void show24HoursWeather( Mj24WeatherBean.DataBean weatherBean) {
        mHours24Weather = weatherBean;
        List<Mj24WeatherBean.DataBean.HourlyBean> hourly = weatherBean.getHourly();
        Mj24WeatherBean.DataBean.HourlyBean hourlyBean = hourly.get(0);
        mCurrentWea = hourlyBean.getCondition();
        mWea.setText(mCurrentWea);
        int hour = Integer.valueOf(hourlyBean.getHour());
        if (hour >= 6 & hour < 18) {
            iv_top_bg.setImageResource(WeatherUtils.selectDayIcon(hourlyBean.getIconDay()).get(Contents.MJ_BG));
            iv_icon_wea.setImageResource(WeatherUtils.selectDayIcon(hourlyBean.getIconDay()).get(Contents.MJ_LAGER_ICON));
        } else {
            iv_top_bg.setImageResource(WeatherUtils.selectNightIcon(hourlyBean.getIconNight()).get(Contents.MJ_BG));
            iv_icon_wea.setImageResource(WeatherUtils.selectNightIcon(hourlyBean.getIconNight()).get(Contents.MJ_LAGER_ICON));
        }

        mMj24Adapter.setData(hourly);
    }

    private Drawable  setBarColor() {
        Drawable drawable =null;
        if (mHours24Weather!=null) {
        int hour = Integer.valueOf( mHours24Weather.getHourly().get(0).getHour());
        int color= hour >= 6 & hour < 18?WeatherUtils.selectDayIcon(mHours24Weather.getHourly().get(0).getIconDay()).get(Contents.MJ_COLOR):
                WeatherUtils.selectNightIcon(mHours24Weather.getHourly().get(0).getIconNight()).get(Contents.MJ_COLOR);

        if (color == ColorUtil.CEHENGSE) {
            drawable=getResources().getDrawable(R.color.bg_a, null);
        } else if(color==ColorUtil.SHENLAN){
            drawable=getResources().getDrawable(R.color.bg_b, null);
        } else if (color == ColorUtil.LAN) {
            drawable=getResources().getDrawable(R.color.bg_c, null);

        }else if (color == ColorUtil.HUILAN) {
            drawable=getResources().getDrawable(R.color.bg_d, null);
        } else if (color == ColorUtil.MAI) {
            drawable=getResources().getDrawable(R.color.bg_e, null);
        }
        }
        return drawable;
    }

    private List<MjDesBean> mLifeList = new ArrayList<>();
    //生活指数
    @Override
    public void onLoadLifeWeatherData(List<MjLifeBean> lifeBeans) {
        if (lifeBeans == null) {
            return;
        }
        mLifeList.clear();
        if (lifeBeans!=null) {
            for (MjLifeBean lifeBean : lifeBeans) {
                if (lifeBean.getName().equals("紫外线指数")) {
                    mLifeList.add(new MjDesBean("紫外线", R.mipmap.home_icon_zwx, lifeBean.getStatus()));
                } else if (lifeBean.getName().equals("穿衣指数")) {
                    mLifeList.add(new MjDesBean("舒适度", R.mipmap.home_icon_ssd,lifeBean.getStatus()));
                }else if (lifeBean.getName().equals("洗车指数")) {
                    mLifeList.add(new MjDesBean("洗车", R.mipmap.home_icon_xc,lifeBean.getStatus()));
                }else if (lifeBean.getName().equals("感冒指数")) {
                    mLifeList.add(new MjDesBean("感冒", R.mipmap.home_icon_gm,lifeBean.getStatus()));
                }
            }
        }
        showLifeIndex(mLifeList);

        doAddSQLit();
    }
    private void showLifeIndex(List<MjDesBean> lifeBeans) {
        mLifeList=lifeBeans;
        for (MjDesBean lifeBean : lifeBeans) {
            if (lifeBean.getTitle().equals("紫外线")) {
                mStatusZWX = lifeBean.getValue();
            }
        }
        mLifeAdapter.setData(mLifeList);
    }

    //空气质量
    @Override
    public void onLoadAqiWeatherData(MjAqiBean weatherBean) {
        if (weatherBean==null||weatherBean.getData()==null||weatherBean.getData().getAqi()==null) {
            mSmartRefreshLayout.finishRefresh();
            return;
        }

        showAqi(weatherBean.getData().getAqi());
        doAddSQLit();
        CityCacheBean cityCacheBean = new CityCacheBean();
        cityCacheBean.setCity(mLocationCity);
        cityCacheBean.setAqi((weatherBean.getData().getAqi().getValue()));
        EventBus.getDefault().post(cityCacheBean);
    }
    private void showAqi(MjAqiBean.DataBean.AqiBean AqiBean) {
        mDataAqi =AqiBean;
        SpUtils.getInstance().putString(Contents.SIMULATE_AQI,JSON.toJSONString(AqiBean));
        mAqiValue = AqiBean.getValue();
        int value = Integer.valueOf(mAqiValue);
        mAqiType = WeatherUtils.aqiType(value);

        showDes();

    }

    private void showDes() {
        mDesList.clear();
        if (mRealWeather != null) {
            double speed = Double.parseDouble(mRealWeather.getWindSpeed());
            //添加适配器数据
            mDesList.add(new MjDesBean("紫外线强度", R.mipmap.home_icon_wendu, KtUtil.ultravioletIndex(Integer.valueOf(mRealWeather.getUvi()))));
            mDesList.add(new MjDesBean("空气质量", R.mipmap.home_icon_wendu,mAqiType));
            mDesList.add(new MjDesBean(mRealWeather.getWindDir(), R.mipmap.home_icon_feng, WeatherUtils.winType(speed, true)));
            mDesList.add(new MjDesBean("舒适度", R.mipmap.home_icon_shushi, mRealWeather.getRealFeel()));
            mDesAdapter.setData(mDesList);
        }
    }

    //空气质量5天
    @Override
    public void onLoad5AqiWeatherData(Mj5AqiBean weatherBean) {
        showAqi(weatherBean);
        doAddSQLit();
    }

    private void showAqi(Mj5AqiBean weatherBean) {
        mAqiForecast = weatherBean;
        if (weatherBean!=null&weatherBean.getData()!=null&weatherBean.getData().getAqiForecast().size()!=0) {
            Mj5AqiBean.DataBean.AqiForecastBean aqiForecastBean = weatherBean.getData().getAqiForecast().get(0);
            int value = aqiForecastBean.getValue();
            SpUtils.getInstance().putString(Contents.SIMULATE_AQI15, JSON.toJSONString(weatherBean));
        }
    }

    //刷新成功
    @Override
    public void onRefreshSuccess() {
        RxToast.normal("刷新成功");
        mSmartRefreshLayout.finishRefresh(true);
    }

    //刷新失败
    @Override
    public void onRefreshError() {
        RxToast.warning(getResources().getString(R.string.connect_error));
        mSmartRefreshLayout.finishRefresh(false);
    }

    //请求中
    @Override
    public void onLoading() {
        mSmartRefreshLayout.autoRefresh(0,500,1.5f,true);
    }

    //请求失败
    @Override
    public void onError() {
      //  RxToast.warning(getResources().getString(R.string.connect_error));
        mSmartRefreshLayout.finishRefresh();
    }
    //end----------------------------------------------------------->


    //黄历回调------------------------------------------------------------------》
    @Override
    public void onLoadHuangLi(HuangLiBean huangLiBean) {
        showHuangLi(huangLiBean.getResult());
        doAddSQLit();
    }
    private void showHuangLi(HuangLiBean.ResultBean huangLiBean) {
        mHuangLiResult = huangLiBean;
        SpUtils.getInstance().putString(Contents.HUANGLI_DATA,JSON.toJSONString(huangLiBean));
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    //添加缓存
    private void doAddSQLit() {
        mSmartRefreshLayout.finishRefresh();
            Gson gson = new Gson();
            WeaCacheBean weaCacheBean = new WeaCacheBean();
            weaCacheBean.setCity(mLocationCity);
            weaCacheBean.setLongitude(mLongitude);
            weaCacheBean.setLatitude(mLatitude);
            weaCacheBean.setRealWeather(gson.toJson(mRealWeather));
            weaCacheBean.setDayWeather(gson.toJson(mDay15Weather));
            weaCacheBean.setHoursWeather(gson.toJson(mHours24Weather));
            weaCacheBean.setLifeIndex(gson.toJson(mLifeList));
            weaCacheBean.setAqiIndex(gson.toJson(mDataAqi));
            weaCacheBean.setQaiFiveIndex(gson.toJson(mAqiForecast));
            weaCacheBean.setHuangLi(gson.toJson(mHuangLiResult));
            if (mWeaCachePresent != null) {
                mWeaCachePresent.saveWeatherCache(weaCacheBean);
                mSpUtils.putLong(Contents.SP_CACHE_TIME,System.currentTimeMillis());
            }

    }

    @NotNull
    private StringBuffer getYiJiData(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> realList=null;
        if (list.size()>= 9) {
            realList=  list.subList(2, 9);
        } else {
            realList= list.subList(2, list.size());
        }

        for (String s : realList) {
            stringBuffer.append(s + "  ");
        }
        return stringBuffer;
    }

    @Override
    public void onLoadHuangLiError() {

    }
    //end-----------------------------------------------------------------------》

    //添加城市回调--------------------------------------------------------------》
    @Override
    public void onLoadSave(boolean b) {
    }


    @Override
    public void onDeleteCache(boolean b) {

    }

    //end-----------------------------------------------------------------------》




    //释放资源
    @Override
    protected void release() {
        if (mWeatherPresent != null) {
            mWeatherPresent.unregisterCallback(this);
        }

        if (mHuangLiPresent != null) {
            mHuangLiPresent.unregisterCallback(this);
        }

        if (mWeaCachePresent != null) {
            mWeaCachePresent.unregisterCallback(this);
        }

        if (mFeedHelper != null) {
            mFeedHelper.releaseAd();
        }

    }



    public void updateArguments(int position) {
        this.mPos = position;
    }


}
