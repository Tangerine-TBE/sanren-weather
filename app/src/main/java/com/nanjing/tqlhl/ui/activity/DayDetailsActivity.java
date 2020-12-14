package com.nanjing.tqlhl.ui.activity;

import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.advertisement.BanFeedHelper;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.DescribeBean;
import com.nanjing.tqlhl.model.bean.Mj24WeatherBean;
import com.nanjing.tqlhl.model.bean.MjRealWeatherBean;
import com.nanjing.tqlhl.ui.adapter.Mj24Adapter;
import com.nanjing.tqlhl.ui.adapter.WeatherDescribeAdapter;
import com.nanjing.tqlhl.ui.custom.mj15day.MyToolbar;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.WeatherUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.activity
 * @class describe
 * @time 2020/9/11 14:32
 * @class describe
 */
public class DayDetailsActivity extends BaseMainActivity {

    @BindView(R.id.banner_container)
    FrameLayout mBannerContainer;
    @BindView(R.id.feed_container)
    FrameLayout mFeedContainer;
    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
    @BindView(R.id.tv_sun_up)
    TextView tv_sun_up;
    @BindView(R.id.tv_det_team)
    TextView tv_det_team;
    @BindView(R.id.tv_det_title)
    TextView tv_det_title;
    @BindView(R.id.tv_sun_down)
    TextView tv_sun_down;
    @BindView(R.id.tv_det_wea)
    TextView tv_det_wea;
    @BindView(R.id.iv_det_wea)
    ImageView iv_det_wea;
    @BindView(R.id.rv_det_container)
    RecyclerView rv_det_container;
    @BindView(R.id.rv_day24)
    RecyclerView rv_day24;
    @BindView(R.id.details_bar)
    MyToolbar details_bar;
    private BanFeedHelper mBanFeedHelper;


    @Override
    protected void setStatusBarColor() {
           MyStatusBarUtil.setTransparent(this);
        MyStatusBarUtil.setFullWindow(this);
    }

    @Override
    public int getLayoutId() {

        return R.layout.activity_details;
    }

    @Override
    protected void intView() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) details_bar.getLayoutParams();
        layoutParams.topMargin = MyStatusBarUtil.getStatusBarHeight(this);
        details_bar.setLayoutParams(layoutParams);
        String realWeather = getIntent().getStringExtra(Contents.Mj_Real_DATA);
        String zwx = getIntent().getStringExtra(Contents.MSTATUSZWX);
        String aqiType = getIntent().getStringExtra(Contents.MAQITYPE);
        String lowAndHigh = getIntent().getStringExtra(Contents.MJ_LOW_HIGH);
        String hours24 = getIntent().getStringExtra(Contents.MJ_HOURS24);

        //加载广告
        mBanFeedHelper = new BanFeedHelper(this, mBannerContainer, mFeedContainer);
        mBanFeedHelper.showAd(BanFeedHelper.AdType.AIRQUALITY_PAGE);

        if (!TextUtils.isEmpty(realWeather)&!TextUtils.isEmpty(zwx)&!TextUtils.isEmpty(hours24)) {
            MjRealWeatherBean.DataBean.ConditionBean conditionBean = JSON.parseObject(realWeather, MjRealWeatherBean.DataBean.ConditionBean.class);
            Mj24WeatherBean.DataBean dataBean = JSON.parseObject(hours24, Mj24WeatherBean.DataBean.class);
            if (conditionBean!=null&dataBean != null) {
            Mj24WeatherBean.DataBean.HourlyBean hourlyBean = dataBean.getHourly().get(0);
            tv_det_wea.setText(hourlyBean.getCondition());
            tv_det_title.setText(WeatherUtils.addTemSymbol2(hourlyBean.getCondition()));
            tv_det_team.setText(lowAndHigh);
            tv_sun_up.setText("日出："+conditionBean.getSunRise().substring(10).substring(0,6));
            tv_sun_down.setText("日落："+conditionBean.getSunSet().substring(10,conditionBean.getSunRise().length()).substring(0,6));


            int hour = Integer.valueOf(hourlyBean.getHour());
            if (hour >= 6 & hour < 18) {
                iv_det_wea.setImageResource(WeatherUtils.selectDayIcon(hourlyBean.getIconDay()).get(Contents.MJ_LAGER_ICON));


            } else {
                iv_det_wea.setImageResource(WeatherUtils.selectNightIcon(hourlyBean.getIconNight()).get(Contents.MJ_LAGER_ICON));
            }
            List<DescribeBean.Des> desList=new ArrayList<>();
            desList.add(new DescribeBean.Des("紫外线",zwx));
            desList.add(new DescribeBean.Des("体感温度", WeatherUtils.addTemSymbol2(conditionBean.getRealFeel())));
            desList.add(new DescribeBean.Des("空气质量",aqiType));
            desList.add(new DescribeBean.Des(conditionBean.getWindDir(),conditionBean.getWindLevel()+"级"));
            desList.add(new DescribeBean.Des("能见度",conditionBean.getUvi()+"公里"));
            desList.add(new DescribeBean.Des("气压",conditionBean.getPressure()+"hPa"));

            GridLayoutManager manager = new GridLayoutManager(this, 3);
            rv_det_container.setLayoutManager(manager);
            WeatherDescribeAdapter describeAdapter = new WeatherDescribeAdapter();
            describeAdapter.setData(desList);
            rv_det_container.setAdapter(describeAdapter);


            LinearLayoutManager day24manager = new LinearLayoutManager( this, RecyclerView.HORIZONTAL, false);
            rv_day24.setLayoutManager(day24manager);
            Mj24Adapter mj24Adapter = new Mj24Adapter(true);
            mj24Adapter.setData(dataBean.getHourly());
            rv_day24.setAdapter(mj24Adapter);

        }
        }

    }

    @Override
    protected void intEvent() {
        details_bar.setOnBackClickListener(() -> finish());
    }

    @Override
    protected void release() {
        if (mBanFeedHelper != null) {
            mBanFeedHelper.releaseAd();
        }
    }
}
