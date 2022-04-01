package com.nanjing.tqlhl.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
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
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.base.IMainTopCallback;
import com.nanjing.tqlhl.caiyun.DailyWeather;
import com.nanjing.tqlhl.caiyun.HourlyWeather;
import com.nanjing.tqlhl.caiyun.RealTimeWeather;
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
import com.nanjing.tqlhl.presenter.Impl.HuangLiPresentImpl;
import com.nanjing.tqlhl.ui.AirActivity_KT;
import com.nanjing.tqlhl.ui.CurrentCityFragment_KT;
import com.nanjing.tqlhl.ui.DayDetailsActivity_KT;
import com.nanjing.tqlhl.ui.activity.AirActivity;
import com.nanjing.tqlhl.ui.activity.Day15Activity;
import com.nanjing.tqlhl.ui.activity.DayDetailsActivity;
import com.nanjing.tqlhl.ui.activity.HuangLiActivity;
import com.nanjing.tqlhl.ui.activity.ToolActivity;
import com.nanjing.tqlhl.ui.adapter.Mj24Adapter;
import com.nanjing.tqlhl.ui.adapter.MjDesAdapter;
import com.nanjing.tqlhl.ui.adapter.MjLifeAdapter;
import com.nanjing.tqlhl.ui.custom.mj15day.ZzWeatherView;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.ImmersionUtil;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.utils.UtilsKt;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.nanjing.tqlhl.view.IHuangLiCallback;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.fragment
 * @class describe
 * @time 2020/9/17 11:32
 * @class describe
 */
public class CurrentCityFragment extends BaseFragment implements IHuangLiCallback, View.OnClickListener, IWeaCallback, CurrentCityFragment_KT.CaiyunDataCall {

    private CurrentCityFragment_KT currentCityFragment_kt;
    private HuangLiPresentImpl mHuangLiPresent;
    @BindView(R.id.tv_home_details)
    TextView tv_home_details;
    @BindView(R.id.SmartRefreshLayout)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.NestedScrollView)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.rv_24Container)
    RecyclerView m24Container;
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
    private String mLatitude;
    private String mLongitude;
    private String mLocationCity;
    public String mTempNight;
    public String mTempDay;
    private HuangLiBean.ResultBean mHuangLiResult;
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
            requestOldWeather();
            requestNewWeather();
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

        mParentFragment = getParentFragment();
    }

    @Override
    protected void intPresent() {
        mWeaCachePresent = WeaCachePresentImpl.getInstance();
        mWeaCachePresent.registerCallback(this);

        mHuangLiPresent = HuangLiPresentImpl.getInstance();
        mHuangLiPresent.registerCallback(this);

        currentCityFragment_kt=new CurrentCityFragment_KT(this);
        currentCityFragment_kt.setCaiyunCall(this);
    }


    //请求天气数据
    private void requestNewWeather() {
        if ( mHuangLiPresent != null) {
            currentCityFragment_kt.requestData(mLongitude,mLatitude,mLocationCity);
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
                    if (realTimeWeather!=null) {
                        ((IMainTopCallback) mParentFragment).setTopType(setBarColor(), scrollY);
                    }
                }

            }
        });


        //下拉刷新
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (mLongitude!=null&mLatitude!=null) {
                    currentCityFragment_kt.pullToRefresh(mLongitude, mLatitude, mLocationCity, new Function0<Unit>() {
                        @Override
                        public Unit invoke() {
                            RxToast.normal("刷新成功");
                            mSmartRefreshLayout.finishRefresh(true);
                            return null;
                        }
                    }, new Function0<Unit>() {
                        @Override
                        public Unit invoke() {
                            RxToast.warning(getResources().getString(R.string.connect_error));
                            mSmartRefreshLayout.finishRefresh(false);
                            return null;
                        }
                    });
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
                startActivity(Day15Activity.Companion.getIntent(requireContext(),dailyWeather));
                break;
            case R.id.rl_hl:
                if (mHuangLiResult != null) {
                    ImmersionUtil.startActivity(getActivity(), HuangLiActivity.class,false);
                }
                break;
            case R.id.tv_home_details:
                startActivity(DayDetailsActivity_KT.Companion.getIntent(requireContext(),realTimeWeather,hourlyWeather,dailyWeather));
                break;
            case R.id.rl_kq:
                startActivity(AirActivity_KT.Companion.getIntent(requireContext(),mLocationCity,realTimeWeather,hourlyWeather,dailyWeather));
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
    @Override
    public void dailyDataCall(@NotNull DailyWeather dailyWeather) {
        this.dailyWeather=dailyWeather;
        updateCityList();
    }

    @Override
    public void hourlyDataCall(@NotNull HourlyWeather hourlyWeather) {
        this.hourlyWeather=hourlyWeather;
        mMj24Adapter.setData(hourlyWeather.getData());
        doAddSQLit();
        updateCityList();
    }

    @Override
    public void realtimeDataCall(@NotNull RealTimeWeather realTimeWeather) {
        this.realTimeWeather=realTimeWeather;
        doAddSQLit();
        mDesList.clear();
        mDesList.add(new MjDesBean("紫外线强度", R.mipmap.home_icon_wendu,realTimeWeather.getUltraviolet()));
        mDesList.add(new MjDesBean("空气质量", R.mipmap.home_icon_wendu, realTimeWeather.getAqiDes()));
        mDesList.add(new MjDesBean(realTimeWeather.getWindDirection(), R.mipmap.home_icon_feng, realTimeWeather.getWindDegree()));
        mDesList.add(new MjDesBean("舒适度", R.mipmap.home_icon_shushi, realTimeWeather.getComfort()));
        mDesAdapter.setData(mDesList);
        updateCityList();
    }

    private DailyWeather dailyWeather;
    private HourlyWeather hourlyWeather;
    private RealTimeWeather realTimeWeather;

    //更新城市列表数据
    private void updateCityList() {
        if (realTimeWeather!=null&&hourlyWeather!=null&&dailyWeather!=null) {
            CityCacheBean cityCacheBean = new CityCacheBean();
            cityCacheBean.setCity(mLocationCity);//城市
            DailyWeather.DailyNeedData firstDay=dailyWeather.getNeedData().get(0);
            cityCacheBean.setLowHigh(""+(int)firstDay.getTemperature().getMin()+"°"+"/"+(int)firstDay.getTemperature().getMax()+"°");
            cityCacheBean.setTeam(realTimeWeather.getTemperature());;
            cityCacheBean.setWea(realTimeWeather.getSkycon());
            cityCacheBean.setSkyIcon(realTimeWeather.getSkyconIcon());
            cityCacheBean.setWindy(realTimeWeather.getWindDirection()+"   "+realTimeWeather.getWindDegree());
            cityCacheBean.setAqi(realTimeWeather.getAqiDes());
            EventBus.getDefault().post(cityCacheBean);
        }
    }

    private List<MjDesBean> mDesList = new ArrayList<>();

    private Drawable  setBarColor() {
        Drawable drawable =null;
        if (realTimeWeather==null){
            return null;
        }
        int color= realTimeWeather.getSkyconColor();
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
        return drawable;
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
//        weaCacheBean.setRealWeather(gson.toJson(mRealWeather));
//        weaCacheBean.setDayWeather(gson.toJson(mDay15Weather));
//        weaCacheBean.setHoursWeather(gson.toJson(mHours24Weather));
//        weaCacheBean.setLifeIndex(gson.toJson(mLifeList));
        weaCacheBean.setHuangLi(gson.toJson(mHuangLiResult));
        if (mWeaCachePresent != null) {
            mWeaCachePresent.saveWeatherCache(weaCacheBean);
            mSpUtils.putLong(Contents.SP_CACHE_TIME,System.currentTimeMillis());
        }

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
