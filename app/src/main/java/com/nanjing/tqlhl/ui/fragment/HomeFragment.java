package com.nanjing.tqlhl.ui.fragment;

import android.animation.ValueAnimator;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.example.module_ad.utils.LogUtils;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.example.module_ad.utils.SizeUtils;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.base.IMainTopCallback;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.db.newcache.present.CityCachePresentImpl;
import com.nanjing.tqlhl.db.newcache.present.view.ICityCacheCallback;
import com.nanjing.tqlhl.ui.activity.SettingActivity;
import com.nanjing.tqlhl.ui.adapter.SelectCityAdapter;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.utils.GaoDeHelper;
import com.nanjing.tqlhl.utils.ImmersionUtil;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.utils.TTSUtility;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.tamsiree.rxkit.view.RxToast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.fragment
 * @class describe
 * @time 2020/9/29 9:53
 * @class describe
 */
public class HomeFragment extends BaseFragment implements ICityCacheCallback, AMapLocationListener, IMainTopCallback {


    @BindView(R.id.vp_city_container)
    ViewPager vp_city_container;
    @BindView(R.id.tv_home_city)
    TextView tv_home_city;
    @BindView(R.id.tv_low_high)
    TextView tv_low_high;
    @BindView(R.id.tv_home_week)
    TextView tv_home_week;
    @BindView(R.id.indicator)
    LinearLayout mIndicator;
    @BindView(R.id.iv_home_set)
    ImageView iv_home_set;
    @BindView(R.id.iv_report)
    ImageView iv_report;
    @BindView(R.id.rl_home_top_toolbar)
    RelativeLayout rl_home_top_toolbar;

    private SelectCityAdapter mCityAdapter;
    private CityCachePresentImpl mCityCachePresent;
    private GaoDeHelper mGaoDeHelper;
    private double mLongitude;
    private double mLatitude;
    private String mCurrentCity;
    private int mPosition;
    private boolean mIsOne;
    private int mStatusBarHeight;
    private List<CityCacheBean> mCityCacheBeans=new ArrayList<>();
    private List<CityCacheBean> mCityList;
    private String mCity;
    private MyReceiver mMyReceiver;
    @Override
    public int getChildLayout() {
        return R.layout.activity_home;
    }



    @Override
    protected void intView() {
        setViewState(ViewState.SUCCESS);
        getActivity().getSharedPreferences(Contents.NO_BACK_SP, getActivity().MODE_PRIVATE).edit().putBoolean(Contents.NO_BACK, false).apply();
        EventBus.getDefault().register(this);
        mStatusBarHeight = MyStatusBarUtil.getStatusBarHeight( getActivity());
        RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) rl_home_top_toolbar.getLayoutParams();
        layoutParams1.topMargin=mStatusBarHeight;
        rl_home_top_toolbar.setLayoutParams(layoutParams1);

        mIsOne=true;
        LitePal.getDatabase();
        mGaoDeHelper = GaoDeHelper.getInstance();
        mGaoDeHelper.setListener(this);
        mGaoDeHelper.startLocation();

        mCityAdapter = new SelectCityAdapter(getChildFragmentManager());
        vp_city_container.setAdapter(mCityAdapter);
        vp_city_container.setOffscreenPageLimit(10);
        intTopAnimation();
        tv_home_week.setText(DateUtil.getWeekOfDate(new Date()));

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LocationManager.PROVIDERS_CHANGED_ACTION);
        mMyReceiver = new MyReceiver();
        getActivity().registerReceiver(mMyReceiver,intentFilter);
    }


    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            LocationManager lm = (LocationManager) context.getSystemService(Service.LOCATION_SERVICE);
            boolean isEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (isEnabled) {
                mGaoDeHelper.startLocation();
            }
        }
    }


    @Override
    protected void intPresent() {
        mCityCachePresent = CityCachePresentImpl.getInstance();
        mCityCachePresent.registerCallback(this);
        if (!SpUtils.getInstance().getBoolean(Contents.FIRST_ADD,false)) {
            CityCacheBean cityCacheBean = new CityCacheBean();
             cityCacheBean.setCity(SpUtils.getInstance().getString(Contents.CURRENT_CITY));
            cityCacheBean.setLongitude(SpUtils.getInstance().getString(Contents.CURRENT_LONG));
            cityCacheBean.setLatitude(SpUtils.getInstance().getString(Contents.CURRENT_LAT));
            cityCacheBean.setWindy("西北风");
            cityCacheBean.setLowHigh("26°/30°");
            cityCacheBean.setTeam("30°");
            cityCacheBean.setWea("多云");
            cityCacheBean.setDayIcon("0");
            cityCacheBean.setNightIcon("0");
            cityCacheBean.setAqi("20");
            mCityCacheBeans.add(cityCacheBean);
            mCityCachePresent.addCityCache(cityCacheBean);
            mCityAdapter.setData(mCityCacheBeans);
        }

        if (mCityCachePresent != null) {
            mCityCachePresent.queryCityCache();
        }

    }

    @Override
    protected void intEvent() {
        vp_city_container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPosition = position;
                CityCacheBean cityCacheBean = mCityList.get(position);
                updateIndicator(position);
                mCity = cityCacheBean.getCity();
                tv_home_city.setText(mCity);
                tv_low_high.setText(cityCacheBean.getLowHigh());
                SpUtils.getInstance().putString(Contents.CHANGE_CITY, mCity);
                if (mCityAdapter.getInstantFragment() instanceof CurrentCityFragment) {
                    ((CurrentCityFragment) mCityAdapter.getInstantFragment()).onNestedScrollView();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        iv_home_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImmersionUtil.startActivity(getActivity(), SettingActivity.class,false);
            }
        });

        //语音播报
        iv_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCityAdapter.getInstantFragment() instanceof CurrentCityFragment) {
                    CurrentCityFragment fragment = (CurrentCityFragment) mCityAdapter.getInstantFragment();

                    String report=mCityList.get(mPosition).getCity()+",今天天气%s,气温%s到%s摄氏度";
                TTSUtility ttsUtility = TTSUtility.getInstance(getActivity());
                ttsUtility .speaking(String.format(report,mCityList.get(mPosition).getWea(), fragment.mTempNight,fragment.mTempDay));
                AnimationDrawable drawable = (AnimationDrawable) iv_report.getDrawable();
                ttsUtility.setOnSpeechListener(new TTSUtility.OnSpeechListener() {
                    @Override
                    public void onStart() {
                        drawable.start();
                    }

                    @Override
                    public void onStop() {
                        drawable.selectDrawable(0);
                        drawable.stop();

                    }
                });
            }
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangeCityCache(CityCacheBean cacheBean) {
        if (mCityCachePresent != null) {
            mCityCachePresent.updateCityCache(cacheBean);
        }
    }


    //更新指示器
    private void updateIndicator(int index) {
        if (mIndicator == null) {
            return;
        }
        for (int i = 0; i < mIndicator.getChildCount(); i++) {
            View childAt = mIndicator.getChildAt(i);
            if (index == i) {
                childAt.setBackgroundResource(R.drawable.loop_action_point_select);
            } else {
                childAt.setBackgroundResource(R.drawable.loop_action_point_nomal);
            }
        }
    }
    //显示指示器
    private void showIndicator(List<CityCacheBean> locationBeanList) {
        mIndicator.removeAllViews();
        int size = SizeUtils.dip2px1(getActivity(), 5);
        for (int i = 0; i < locationBeanList.size(); i++) {
            View view = new View(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            params.leftMargin = SizeUtils.dip2px1(getActivity(), 3);
            params.rightMargin = SizeUtils.dip2px1(getActivity(), 3);
            view.setLayoutParams(params);
            if (i == 0) {
                view.setBackgroundResource(R.drawable.loop_action_point_select);
            } else {
                view.setBackgroundResource(R.drawable.loop_action_point_nomal);
            }
            mIndicator.addView(view);
        }
    }

    @Override
    protected void release() {
        if (mCityCachePresent != null) {
            mCityCachePresent.unregisterCallback(this);
        }


        if (mMyReceiver != null) {
            getActivity().unregisterReceiver(mMyReceiver);
        }

        if (mGaoDeHelper != null) {
            mGaoDeHelper.stopLocation();
        }

        EventBus.getDefault().unregister(this);


    }

    @Override
    public void onAddCityState(boolean b) {
        SpUtils.getInstance().putBoolean(Contents.FIRST_ADD,true);
    }

    @Override
    public void onDeleteCityState(boolean b) {

    }

    @Override
    public void onQueryCity(List<CityCacheBean> list) {
        if (list.size() ==0) {
            return;
        }
        this.mCityList=list;
        if (mIsOne) {
            CityCacheBean cacheBean = list.get(0);
            mCityAdapter.setData(list);
            vp_city_container.setCurrentItem(0, true);
            showIndicator(list);
            updateIndicator(0);
            tv_home_city.setText(cacheBean.getCity());
            tv_low_high.setText(cacheBean.getLowHigh());
            mIsOne = false;
            SpUtils.getInstance().putString(Contents.CHANGE_CITY,list.get(0).getCity());
        } else {
            if (!mCityCachePresent.isScroll()) {
                CityCacheBean cityCacheBean = list.get(list.size() - 1);
                mCityAdapter.setData(list);
                vp_city_container.setCurrentItem(list.size(), true);
                showIndicator(list);
                updateIndicator(list.size() - 1);
                tv_home_city.setText(cityCacheBean.getCity());
                tv_low_high.setText(cityCacheBean.getLowHigh());
                mCityCachePresent.setScroll(true);
                SpUtils.getInstance().putString(Contents.CHANGE_CITY,list.get(list.size() - 1).getCity());

            }

            int position = mCityCachePresent.getPosition();
            if (position != 0) {
                int realPosition = 0;
                if (position > mPosition) {
                    realPosition = mPosition;
                    LogUtils.i(this, list.size() + "大于现在为止删除---------------------->" + realPosition);
                }
                if (position < mPosition) {
                    realPosition = mPosition - 1;
                    LogUtils.i(this, list.size() + "小于现在为止删除---------------------->" + realPosition);
                }

                if (position == mPosition & position != list.size()) {
                    realPosition = mPosition;
                    LogUtils.i(this, position + "等于现在为止删除---------------------->" + realPosition);
                }

                if (position == list.size() + 1) {
                    realPosition = list.size() - 1;
                    LogUtils.i(this, list.size() + "删除最后一个---------------------->" + realPosition);
                }
                if (position == mPosition && position == list.size()) {
                    realPosition = list.size() - 1;
                    LogUtils.i(this, list.size() + "等于现在最后一个为止删除---------------------->" + realPosition);
                }
                CityCacheBean cityCacheBean = list.get(realPosition);
                mCityAdapter.setData(list);
                vp_city_container.setCurrentItem(realPosition, true);
                showIndicator(list);
                updateIndicator(realPosition);
                tv_home_city.setText(cityCacheBean.getCity());
                tv_low_high.setText(cityCacheBean.getLowHigh());
                mCityCachePresent.setPosition(0);
                SpUtils.getInstance().putString(Contents.CHANGE_CITY,list.get(realPosition).getCity());
            }
        }



    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation.getLatitude() != 0.0 || aMapLocation.getLongitude() != 0.0) {
            mCurrentCity = WeatherUtils.cityType(aMapLocation.getCity());
            mLongitude = aMapLocation.getLongitude();
            mLatitude = aMapLocation.getLatitude();
            boolean isFirstLocation = SpUtils.getInstance().getBoolean(Contents.FIRST_LOCATION, false);
            if (isFirstLocation) {
                RxToast.success("已自动定位到当前城市");
                SpUtils.getInstance().putBoolean(Contents.FIRST_LOCATION, false).commit();
            }
            if (!TextUtils.isEmpty(mCurrentCity)) {
                String lastCity = SpUtils.getInstance().getString(Contents.CURRENT_CITY);
                String lastLong = SpUtils.getInstance().getString(Contents.CURRENT_LONG);
                String lastLat = SpUtils.getInstance().getString(Contents.CURRENT_LAT);

                if (!TextUtils.isEmpty(lastCity) & !mCurrentCity.equals(lastCity) & mCityCachePresent != null) {
                    //更新当前城市
                    CityCacheBean cityCacheBean = new CityCacheBean();
                    cityCacheBean.setCity(mCurrentCity);
                    cityCacheBean.setLongitude(mLongitude + "");
                    cityCacheBean.setLatitude(mLatitude + "");
                    mCityCachePresent.updateLocationCity(cityCacheBean,lastCity,lastLong,lastLat);
                    mIsOne = true;
                     SpUtils.getInstance().putString(Contents.CURRENT_CITY, mCurrentCity)
                            .putString(Contents.CURRENT_LONG, mLongitude + "")
                            .putString(Contents.CURRENT_LAT, mLatitude + "")
                             .apply();
                }
            }
        }
    }

    private ValueAnimator mInTopAnimator;
    private ValueAnimator mOutTopAnimator;
    private void intTopAnimation() {
        mInTopAnimator = ValueAnimator.ofFloat(0f, 1f);
        mInTopAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });

        mOutTopAnimator = ValueAnimator.ofFloat(0f, 1f);
        mOutTopAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
    }

    @Override
    public void setTopType(Drawable drawable, int distance) {
        if (distance > 84) {
            rl_home_top_toolbar.setVisibility(View.GONE);
        } else {
            rl_home_top_toolbar.setVisibility(View.VISIBLE);
        }
    }

}
