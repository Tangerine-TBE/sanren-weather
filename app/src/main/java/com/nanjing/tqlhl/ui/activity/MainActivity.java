package com.nanjing.tqlhl.ui.activity;

import android.animation.ValueAnimator;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.SeleIcons;
import com.jpeng.jptabbar.anno.Titles;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.ui.custom.ExitPoPupWindow;
import com.nanjing.tqlhl.ui.fragment.AirFragment;
import com.nanjing.tqlhl.ui.fragment.CityMangerFragment;
import com.nanjing.tqlhl.ui.fragment.HomeFragment;
import com.nanjing.tqlhl.ui.fragment.HuangLiFragment;
import com.nanjing.tqlhl.utils.ImmersionUtil;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.activity
 * @class describe
 * @time 2020/9/29 10:11
 * @class describe
 */
public class MainActivity extends BaseMainActivity {

    @BindView(R.id.JPTabBar)
    JPTabBar mJPTabBar;
    @BindView(R.id.main_container)
    FrameLayout mFrameLayout;
    private ExitPoPupWindow mExitPoPupWindow;
    private ValueAnimator mInValueAnimator;
    private ValueAnimator mOutValueAnimator;

    @Titles
    private static final String[] mTitles = {"天气", "空气质量","今日黄历","城市管理"};
    @SeleIcons
    private static final int[] mSeleIcons = {R.mipmap.icon_home_tq_select, R.mipmap.icon_home_aqi_select, R.mipmap.icon_home_hl_select,R.mipmap.icon_home_city_select};
    @NorIcons
    private static final int[] mNormalIcons = {R.mipmap.icon_home_tq_normal, R.mipmap.icon_home_aqi_normal, R.mipmap.icon_home_hl_normal,R.mipmap.icon_home_city_normal};
    private HomeFragment mHomeFragment;
    private AirFragment mAirFragment;
    private HuangLiFragment mHuangLiFragment;
    private CityMangerFragment mCityMangerFragment;
    private FragmentManager mFragmentManager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void intView() {
        ImmersionUtil.setImmersion(this);
        mExitPoPupWindow = new ExitPoPupWindow(this);
        intBgAnimation();
        mHomeFragment = new HomeFragment();
        mAirFragment = new AirFragment();
        mHuangLiFragment = new HuangLiFragment();
        mCityMangerFragment = new CityMangerFragment();
        mFragmentManager = getSupportFragmentManager();
        showFragment(mHomeFragment);

    }





    private BaseFragment mLastFragment=null;
    private void showFragment(BaseFragment baseFragment) {
        if (mLastFragment==baseFragment) {
            return;
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (!baseFragment.isAdded()) {
            transaction.add(R.id.main_container, baseFragment);
        } else {
            transaction.show(baseFragment);
        }
        if (mLastFragment!=null) {
            transaction.hide(mLastFragment);
        }

        mLastFragment=baseFragment;
        transaction.commitAllowingStateLoss();
    }

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

    @Override
    protected void intEvent() {
        mExitPoPupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mOutValueAnimator.start();
            }
        });


        mJPTabBar.setTabListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int index) {
                switch (index) {
                    case 0:
                        showFragment(mHomeFragment);
                        break;
                    case 1:
                        showFragment(mAirFragment);
                        break;
                    case 2:
                        showFragment(mHuangLiFragment);
                        break;
                    case 3:
                        showFragment(mCityMangerFragment);
                        break;
                }
            }

            @Override
            public boolean onInterruptSelect(int index) {
                return false;
            }
        });


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//如果返回键按下
            //此处写退向后台的处理
            mInValueAnimator.start();
            mExitPoPupWindow.popupShowAd(this);
            mExitPoPupWindow.showAtLocation(mFrameLayout, Gravity.BOTTOM, 0, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //设置窗口渐变
    private void updateBgWindowAlpha(float alpha) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = alpha;
        window.setAttributes(attributes);
    }
}
