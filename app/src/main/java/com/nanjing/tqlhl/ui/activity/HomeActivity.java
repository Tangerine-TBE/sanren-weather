package com.nanjing.tqlhl.ui.activity;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.example.module_ad.utils.LogUtils;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.example.module_ad.utils.SizeUtils;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.base.IMainTopCallback;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.db.newcache.present.CityCachePresentImpl;
import com.nanjing.tqlhl.db.newcache.present.view.ICityCacheCallback;
import com.nanjing.tqlhl.ui.adapter.SelectCityAdapter;
import com.nanjing.tqlhl.ui.custom.ExitPoPupWindow;
import com.nanjing.tqlhl.ui.fragment.CurrentCityFragment;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.GaoDeHelper;
import com.nanjing.tqlhl.utils.ImmersionUtil;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.tamsiree.rxkit.view.RxToast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.activity
 * @class describe
 * @time 2020/9/8 11:41
 * @class describe
 */
public class HomeActivity extends BaseMainActivity implements ICityCacheCallback, AMapLocationListener, IMainTopCallback {


    @BindView(R.id.vp_city_container)
    ViewPager vp_city_container;
    @BindView(R.id.tv_home_city)
    TextView tv_home_city;
    @BindView(R.id.indicator)
    LinearLayout mIndicator;
    @BindView(R.id.iv_home_set)
    ImageView iv_home_set;
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

    @Override
    protected void setStatusBarColor() {

    }

    @Override
    public int getLayoutId() {
        MyStatusBarUtil.setFullWindow(this);
        return R.layout.activity_home;
    }



    @Override
    protected void intView() {
        getSharedPreferences(Contents.NO_BACK_SP, MODE_PRIVATE).edit().putBoolean(Contents.NO_BACK, false).apply();
        EventBus.getDefault().register(this);
        mStatusBarHeight = MyStatusBarUtil.getStatusBarHeight( this);
        RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) rl_home_top_toolbar.getLayoutParams();
        layoutParams1.topMargin=mStatusBarHeight;
        rl_home_top_toolbar.setLayoutParams(layoutParams1);

        mIsOne=true;
        LitePal.getDatabase();
        mGaoDeHelper = GaoDeHelper.getInstance();
        mGaoDeHelper.setListener(this);
        mGaoDeHelper.startLocation();

        mExitPoPupWindow = new ExitPoPupWindow(this);
        intBgAnimation();

        mCityAdapter = new SelectCityAdapter(getSupportFragmentManager());
        vp_city_container.setAdapter(mCityAdapter);
        vp_city_container.setOffscreenPageLimit(10);
        intTopAnimation();


    }


    @Override
    protected void intPresent() {

        mCityCachePresent = CityCachePresentImpl.getInstance();
        mCityCachePresent.registerCallback(this);

        CityCacheBean cityCacheBean = new CityCacheBean();
        cityCacheBean.setCity(SpUtils.getInstance().getString(Contents.CURRENT_CITY));
        cityCacheBean.setLongitude(SpUtils.getInstance().getString(Contents.CURRENT_LONG));
        cityCacheBean.setLatitude(SpUtils.getInstance().getString(Contents.CURRENT_LAT));
        cityCacheBean.setWindy("西北风");
        cityCacheBean.setLowHigh("26°/30°");
        cityCacheBean.setTeam("30°");
        cityCacheBean.setWea("多云");
        mCityCacheBeans.add(cityCacheBean);
        mCityCachePresent.addCityCache(cityCacheBean);
        mCityAdapter.setData(mCityCacheBeans);

        if (mCityCachePresent != null) {
            mCityCachePresent.queryCityCache();
        }

    }

    @Override
    protected void intEvent() {
        mExitPoPupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mOutValueAnimator.start();
            }
        });

        vp_city_container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPosition = position;
                updateIndicator(position);
                tv_home_city.setText(mCityList.get(position).getCity());
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
                ImmersionUtil.startActivity(HomeActivity.this,SettingActivity.class,false);
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
        int size = SizeUtils.dip2px1(this, 5);
        for (int i = 0; i < locationBeanList.size(); i++) {
            View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            params.leftMargin = SizeUtils.dip2px1(this, 3);
            params.rightMargin = SizeUtils.dip2px1(this, 3);
            view.setLayoutParams(params);
            if (i == 0) {
                view.setBackgroundResource(R.drawable.loop_action_point_select);
            } else {
                view.setBackgroundResource(R.drawable.loop_action_point_nomal);
            }
            mIndicator.addView(view);
        }
    }






    //退出窗口动画--------------------------------------------------start》
    private ValueAnimator mInValueAnimator;
    private ValueAnimator mOutValueAnimator;

    private void intBgAnimation() {
        mInValueAnimator = ValueAnimator.ofFloat(1.0f, 0.5f);
        mInValueAnimator.setDuration(300);
        mInValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                updateBgWindowAlpha((Float) animation.getAnimatedValue());
            }
        });

        mOutValueAnimator = ValueAnimator.ofFloat(0.5f, 1.0f);
        mOutValueAnimator.setDuration(300);
        mOutValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                updateBgWindowAlpha((Float) animation.getAnimatedValue());
            }
        });
    }

    //设置窗口渐变
    private void updateBgWindowAlpha(float alpha) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = alpha;
        window.setAttributes(attributes);
    }
    //退出窗口动画--------------------------------------------------end》

    private ExitPoPupWindow mExitPoPupWindow;

    //物理键盘监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//如果返回键按下
            //此处写退向后台的处理
            mInValueAnimator.start();
            mExitPoPupWindow.popupShowAd(this);
            mExitPoPupWindow.showAtLocation(vp_city_container, Gravity.BOTTOM, 0, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void release() {

        if (mCityCachePresent != null) {
            mCityCachePresent.unregisterCallback(this);
        }

        EventBus.getDefault().unregister(this);


    }

    @Override
    public void onAddCityState(boolean b) {

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
            mCityAdapter.setData(list);
            vp_city_container.setCurrentItem(0, true);
            showIndicator(list);
            updateIndicator(0);
            tv_home_city.setText(list.get(0).getCity());
            mIsOne = false;
        } else {
            if (!mCityCachePresent.isScroll()) {
                mCityAdapter.setData(list);
                vp_city_container.setCurrentItem(list.size(), true);
                showIndicator(list);
                updateIndicator(list.size() - 1);
                tv_home_city.setText(list.get(list.size() - 1).getCity());
                mCityCachePresent.setScroll(true);
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
                mCityAdapter.setData(list);
                vp_city_container.setCurrentItem(realPosition, true);
                showIndicator(list);
                updateIndicator(realPosition);
                tv_home_city.setText(list.get(realPosition).getCity());
                mCityCachePresent.setPosition(0);
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
        mCurrentCity = WeatherUtils.cityType(aMapLocation.getCity());
        mLongitude = aMapLocation.getLongitude();
        mLatitude = aMapLocation.getLatitude();

        LogUtils.i( this, "LocationListener-------------------------->" + mCurrentCity + mLatitude + "-----------------" + mLongitude);
        //定位失败那 没网拿缓存  or  拿SP中存的当前位置经纬度拿数据
        if (aMapLocation.getLatitude() == 0.0 || aMapLocation.getLongitude() == 0.0) {

        }
        //定位成功 没网拿缓存  or  当前位置经纬度拿数据
        else {
            boolean isFirstLocation = SpUtils.getInstance().getBoolean(Contents.FIRST_LOCATION, false);
            if (isFirstLocation) {
                RxToast.success("已自动定位到当前城市");
                SpUtils.getInstance().putBoolean(Contents.FIRST_LOCATION, false).commit();
            }
                SpUtils.getInstance().putString(Contents.CURRENT_CITY, mCurrentCity)
                        .putString(Contents.CURRENT_LONG, mLongitude + "")
                        .putString(Contents.CURRENT_LAT, mLatitude + "")
                        .commit();

            }
        }


    private ValueAnimator mInTopAnimator;
    private ValueAnimator mOutTopAnimator;
    private void intTopAnimation() {
        mInTopAnimator = ValueAnimator.ofFloat(0f, 1f);
        mInTopAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
               // top_include.setAlpha((Float) animation.getAnimatedValue());
            }
        });

        mOutTopAnimator = ValueAnimator.ofFloat(0f, 1f);
        mOutTopAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
            //    top_include.setAlpha((Float) animation.getAnimatedValue());
            }
        });
    }


    @Override
    public void setTopType(Drawable drawable, int distance) {
      /*  if (top_include != null) {
            int dis= top_include.getHeight() + mStatusBarHeight;
            if (distance >=dis) {
                if (drawable == null) {
                    top_include.setBackground(getResources().getDrawable(R.color.color_rv_text, null));
                } else {
                    top_include.setBackground(drawable);

                }
            } else if (distance<dis){
                top_include.setBackground(getResources().getDrawable(R.color.transparent, null));
                setShowAnimation();
            }*/

    }


   private AlphaAnimation mShowAnimation;
    private  void setShowAnimation()
    {
        if (mShowAnimation == null) {
            mShowAnimation = new AlphaAnimation(0.0f, 1.0f);

        }
        mShowAnimation.setDuration(1000);
        mShowAnimation.setFillAfter(true);
     //   top_include.startAnimation(mShowAnimation);
    }


}
