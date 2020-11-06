package com.nanjing.tqlhl.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.advertisement.BanFeedHelper;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.AirBean;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.model.bean.Mj5AqiBean;
import com.nanjing.tqlhl.model.bean.MjAqiBean;
import com.nanjing.tqlhl.ui.adapter.AirAdapter;
import com.nanjing.tqlhl.ui.custom.AqiLineView;
import com.nanjing.tqlhl.ui.custom.mj15day.AirLevel;
import com.nanjing.tqlhl.ui.custom.mj15day.MyToolbar;
import com.nanjing.tqlhl.ui.custom.mj15day.WeatherModel;
import com.nanjing.tqlhl.ui.custom.mj15day.ZzWeatherView;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.utils.WeatherUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AirActivity extends BaseMainActivity  {



    @BindView(R.id.air_container)
    RecyclerView mContainer_rv;
    @BindView(R.id.banner_container)
    FrameLayout mBannerContainer;
    @BindView(R.id.feed_container)
    FrameLayout mFeedContainer;
    @BindView(R.id.air_toolbar)
    MyToolbar air_toolbar;
    @BindView(R.id.weather15_view)
    ZzWeatherView weatherView;
    @BindView(R.id.tv_future15)
    TextView tv_future15;
    @BindView(R.id.tv_aqi_value)
    TextView tv_aqi_value;
    @BindView(R.id.av_line)
    AqiLineView av_line;
    private BanFeedHelper mBanFeedHelper;
    private MjAqiBean.DataBean.AqiBean mMjAqiBean;
    private Mj5AqiBean mMj5AqiBean;
    private Mj15DayWeatherBean.DataBean mMj15DayWeatherBean;
    private String mAqiType="15";

    @Override
    public int getLayoutId() {
        return R.layout.activity_air;
    }

    @Override
    protected void intView() {
        //加载广告
        mBanFeedHelper = new BanFeedHelper(this, mBannerContainer, mFeedContainer);
        mBanFeedHelper.showAd(BanFeedHelper.AdType.AIRQUALITY_PAGE);


        init15DayWeather();
        Intent intent = getIntent();
        String aqiData= intent.getStringExtra(Contents.MJ_API);
        String aqi5Data = intent.getStringExtra(Contents.MJ_API5);
        String fifteenData = intent.getStringExtra(Contents.MJ_DAY15);


        if (!TextUtils.isEmpty(aqiData)) {
            mMjAqiBean = JSON.parseObject(aqiData, MjAqiBean.DataBean.AqiBean.class);
            mMj5AqiBean = JSON.parseObject(aqi5Data, Mj5AqiBean.class);
            mMj15DayWeatherBean = JSON.parseObject(fifteenData, Mj15DayWeatherBean.DataBean.class);


            //五天空气质量数据
            List<Mj5AqiBean.DataBean.AqiForecastBean> aqiForecast = mMj5AqiBean.getData().getAqiForecast();

            List<Mj15DayWeatherBean.DataBean.ForecastBean> mDay15 = mMj15DayWeatherBean.getForecast();
            if (aqiForecast.size() != 0&mMjAqiBean!=null) {
                if (!TextUtils.isEmpty(mMjAqiBean.getValue())) {
                    int aqiValue = Integer.valueOf(mMjAqiBean.getValue());
                    av_line.setAqiValue(aqiValue);
                    mAqiType = WeatherUtils.aqiType(aqiValue);
                    tv_aqi_value.setText(mAqiType);
                    tv_aqi_value.setTextColor( WeatherUtils.aqiBg(aqiValue));
                }

                //空气质量数据展示
                List<AirBean> list= new ArrayList<>();
                list.add(new AirBean("细颗粒物","PM2.5",mMjAqiBean.getPm25()));
                list.add(new AirBean("粗颗粒物","PM10",mMjAqiBean.getPm10()));
                list.add(new AirBean("二氧化硫","SO2",mMjAqiBean.getSo2()));
                list.add(new AirBean("二氧化氮","NO2",mMjAqiBean.getNo2()));
                list.add(new AirBean("一氧化碳","CO",mMjAqiBean.getCo()));
                list.add(new AirBean("臭氧","O3",mMjAqiBean.getO3()));
                LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
                mContainer_rv.setLayoutManager(manager);
                AirAdapter airAdapter = new AirAdapter();
                airAdapter.setData(list);
                mContainer_rv.setAdapter(airAdapter);

                //15天天气
                List<Mj15DayWeatherBean.DataBean.ForecastBean> forecast = mDay15.subList(1, 6);
                List<WeatherModel>  m15DayWeatherList = new ArrayList<>();
                String week=null;
                for (int i = 0; i <forecast.size(); i++) {
                    String date = forecast.get(i).getPredictDate();
                    String tempDay = forecast.get(i).getTempDay();
                    String tempNight = forecast.get(i).getTempNight();

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
        }
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
    @Override
    protected void intPresent() {}

    @Override
    protected void intEvent() {
        air_toolbar.setOnBackClickListener(new MyToolbar.OnBackClickListener() {
            @Override
            public void onBack() {
                finish();
            }
        });

        tv_future15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMj15DayWeatherBean != null) {
                        Intent intent = new Intent(AirActivity.this, Day15Activity.class);
                        intent.putExtra(Contents.MJ_DAY15, JSON.toJSONString(mMj15DayWeatherBean));
                        startActivity(intent);
                }
            }
        });
    }


    @Override
    protected void release() {
        if (mBanFeedHelper != null) {
            mBanFeedHelper.releaseAd();
        }
    }


}
