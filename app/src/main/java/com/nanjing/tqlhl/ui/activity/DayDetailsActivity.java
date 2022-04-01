package com.nanjing.tqlhl.ui.activity;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_ad.advertisement.BanFeedHelper;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.ui.DayDetailsActivity_KT;
import com.nanjing.tqlhl.ui.adapter.Mj24Adapter;
import com.nanjing.tqlhl.ui.custom.mj15day.MyToolbar;
import com.nanjing.tqlhl.utils.DateUtil;

import java.util.Date;

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
    @BindView(R.id.tv_sun_down)
    TextView tv_sun_down;
    @BindView(R.id.tv_det_wea)
    TextView tv_det_wea;
    @BindView(R.id.iv_det_wea)
    ImageView iv_det_wea;
    @BindView(R.id.rv_day24)
    RecyclerView rv_day24;
    @BindView(R.id.details_bar)
    MyToolbar details_bar;
    @BindView(R.id.tv_hint1)
    TextView tv_hint1;
    private BanFeedHelper mBanFeedHelper;
    private DayDetailsActivity_KT dayDetailsActivity_kt;


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
        dayDetailsActivity_kt=new DayDetailsActivity_KT(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) details_bar.getLayoutParams();
        layoutParams.topMargin = MyStatusBarUtil.getStatusBarHeight(this);
        details_bar.setLayoutParams(layoutParams);
        //加载广告
        mBanFeedHelper = new BanFeedHelper(this, mBannerContainer, mFeedContainer);
        mBanFeedHelper.showAd(BanFeedHelper.AdType.AIRQUALITY_PAGE);
        LinearLayoutManager day24manager = new LinearLayoutManager( this, RecyclerView.HORIZONTAL, false);
        rv_day24.setLayoutManager(day24manager);
        Mj24Adapter mj24Adapter = new Mj24Adapter(true);
        mj24Adapter.setData(dayDetailsActivity_kt.getHourlyWeather().getData());
        rv_day24.setAdapter(mj24Adapter);
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
