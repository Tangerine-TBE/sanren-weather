package com.nanjing.tqlhl.ui.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.module_ad.advertisement.BanFeedHelper;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.ui.AirActivity_KT;
import com.nanjing.tqlhl.ui.custom.AqiLineView;
import com.nanjing.tqlhl.ui.custom.mj15day.MyToolbar;
import com.nanjing.tqlhl.ui.custom.mj15day.ZzWeatherView;
import com.nanjing.tqlhl.utils.ColorUtil;

import butterknife.BindView;

public class AirActivity extends BaseMainActivity  {
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
    private AirActivity_KT airActivity_kt;

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
        airActivity_kt=new AirActivity_KT(this);
        airActivity_kt.initView(this);
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
                startActivity(Day15Activity.Companion.getIntent(AirActivity.this,airActivity_kt.getDailyWeather()));
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
