package com.nanjing.tqlhl.ui.fragment;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.db.newcache.bean.WeaCacheBean;
import com.nanjing.tqlhl.db.newcache.present.WeaCachePresentImpl;
import com.nanjing.tqlhl.db.newcache.present.view.IWeaCallback;
import com.nanjing.tqlhl.model.bean.AirBean;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.ui.adapter.AirAdapter;
import com.nanjing.tqlhl.ui.adapter.FiveAirAdapter;
import com.nanjing.tqlhl.ui.custom.AqiCircle;
import com.nanjing.tqlhl.utils.ChangeBgUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.utils.WeatherUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.fragment
 * @class describe
 * @time 2020/9/29 9:50
 * @class describe
 */
public class AirFragment extends BaseFragment implements IWeaCallback {


    @BindView(R.id.air_container)
    RecyclerView mContainer_rv;


    @BindView(R.id.air_five_container)
    RecyclerView mFiveContainer_rv;


    @BindView(R.id.banner_container)
    FrameLayout mBannerContainer;

    @BindView(R.id.feed_container)
    FrameLayout mFeedContainer;
    @BindView(R.id.tv_aqi_values)
    TextView tv_aqi_values;
    @BindView(R.id.tv_current_aqi)
    TextView tv_current_aqi;
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.aqiCircle)
    AqiCircle aqiCircle;
    @BindView(R.id.air_toolbar)
    RelativeLayout air_toolbar;
    @BindView(R.id.base_toolbar)
    RelativeLayout base_toolbar;

    private MjAqiBean.DataBean.AqiBean mMjAqiBean;
    private Mj5AqiBean mMj5AqiBean;
    private Mj15DayWeatherBean.DataBean mMj15DayWeatherBean;
    private String mAqiType="15";
    private WeaCachePresentImpl mWeaCachePresent;

    @Override
    public int getChildLayout() {
        return R.layout.fragment_air;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (mWeaCachePresent != null) {
            String city = SpUtils.getInstance().getString(Contents.CHANGE_CITY);
            mWeaCachePresent.queryWeatherCacheForOne(city);
        }

    }

    @Override
    protected void intView() {
        setViewState(ViewState.SUCCESS);
        base_toolbar.setBackground(getResources().getDrawable(R.color.transparent,null));
        toolbar_title.setVisibility(View.VISIBLE);
        toolbar_title.setText("空气质量");
        toolbar_title.setTextColor(Color.WHITE);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) air_toolbar.getLayoutParams();
        layoutParams.topMargin= MyStatusBarUtil.getStatusBarHeight(getActivity());
        air_toolbar.setLayoutParams(layoutParams);

    }


    @Override
    protected void intPresent() {
        mWeaCachePresent = WeaCachePresentImpl.getInstance();
        mWeaCachePresent.registerCallback(this);
        if (mWeaCachePresent != null) {
            String city = SpUtils.getInstance().getString(Contents.CHANGE_CITY);
            mWeaCachePresent.queryWeatherCacheForOne(city);
        }

    }

    private void showAqi() {
            //五天空气质量数据
            List<Mj5AqiBean.DataBean.AqiForecastBean> aqiForecast = mMj5AqiBean.getData().getAqiForecast();
            List<Mj15DayWeatherBean.DataBean.ForecastBean> mDay15 = mMj15DayWeatherBean.getForecast();
            if (aqiForecast.size() != 0) {
                //空气质量数据展示
                List<AirBean> list= new ArrayList<>();
                list.add(new AirBean("细颗粒物","PM2.5",mMjAqiBean.getPm25()));
                list.add(new AirBean("粗颗粒物","PM10",mMjAqiBean.getPm10()));
                list.add(new AirBean("二氧化硫","SO2",mMjAqiBean.getSo2()));
                list.add(new AirBean("二氧化氮","NO2",mMjAqiBean.getNo2()));
                list.add(new AirBean("一氧化碳","CO",mMjAqiBean.getCo()));
                list.add(new AirBean("臭氧","O3",mMjAqiBean.getO3()));


                GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
                mContainer_rv.setLayoutManager(manager);
                AirAdapter airAdapter = new AirAdapter();
                airAdapter.setData(list);
                mContainer_rv.setAdapter(airAdapter);


                List<Mj15DayWeatherBean.DataBean.ForecastBean> forecast = mDay15.subList(1, 6);

                List<AirBean> dayList5 = new ArrayList<>();
                String team = null;
                String data = null;
                String aqi = null;
                for (int i = 0; i < forecast.size(); i++) {
                    Mj15DayWeatherBean.DataBean.ForecastBean forecastBean = forecast.get(i);
                    team = ChangeBgUtil.selectIcon() ? forecastBean.getTempDay() : forecastBean.getTempNight();
                    data = forecastBean.getPredictDate();
                    aqi = String.valueOf(aqiForecast.get(i).getValue());
                    dayList5.add(new AirBean(data, team, aqi));
                }

                int aqiValue = aqiForecast.get(0).getValue();
                String currentAqi = String.valueOf(aqiValue);


                mAqiType = WeatherUtils.aqiType(aqiValue);

                int aqiBg = WeatherUtils.aqiBg(aqiValue);
                aqiCircle.setInnerRingColor(aqiBg);


                tv_aqi_values.setText(currentAqi);
                tv_current_aqi.setText("当前空气质量指数:" + currentAqi);

                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 5);
                mFiveContainer_rv.setLayoutManager(layoutManager);
                FiveAirAdapter fiveAirAdapter = new FiveAirAdapter();
                fiveAirAdapter.setData(dayList5);
                mFiveContainer_rv.setAdapter(fiveAirAdapter);

                aqiCircle.setMsgContext("当前空气质量:" + mAqiType);
                aqiCircle.invalidate();
            }

    }

    @Override
    public void onLoadCacheOneList(List<WeaCacheBean> weaCacheBeanList) {
        if (weaCacheBeanList.size()==0) {
            return;
        }
        WeaCacheBean weaCacheBean = weaCacheBeanList.get(0);
        //15天天气
        String dayWeather =weaCacheBean.getDayWeather();
        //空气质量
        String aqiIndex = weaCacheBean.getAqiIndex();
        //5天空气质量
        String aqi5Index = weaCacheBean.getQaiFiveIndex();

        if (!TextUtils.isEmpty(dayWeather)&!TextUtils.isEmpty(aqiIndex)&!TextUtils.isEmpty(aqi5Index)) {
            mMj15DayWeatherBean= JSON.parseObject(dayWeather, Mj15DayWeatherBean.DataBean.class);
            mMjAqiBean = JSON.parseObject(aqiIndex, MjAqiBean.DataBean.AqiBean.class);
            mMj5AqiBean = JSON.parseObject(aqi5Index, Mj5AqiBean.class);
            if (mMjAqiBean == null) {
                mMjAqiBean = JSON.parseObject(SpUtils.getInstance().getString(Contents.SIMULATE_AQI), MjAqiBean.DataBean.AqiBean.class);
            }
            if (mMj5AqiBean == null) {
                mMj5AqiBean = JSON.parseObject(SpUtils.getInstance().getString(Contents.SIMULATE_AQI15), Mj5AqiBean.class);
            }
            showAqi();
        }

    }


    @Override
    protected void release() {
        if (mWeaCachePresent != null) {
            mWeaCachePresent.unregisterCallback(this);
        }
    }


    @Override
    public void onLoadSave(boolean b) {

    }

    @Override
    public void onLoadCacheList(List<WeaCacheBean> weaCacheBeanList) {

    }

    @Override
    public void onDeleteCache(boolean b) {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }
}
