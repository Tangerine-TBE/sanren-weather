package com.nanjing.tqlhl.ui.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.ui.custom.ExitPoPupWindow;
import com.nanjing.tqlhl.ui.fragment.HomeFragment;
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


    @BindView(R.id.main_container)
    FrameLayout mFrameLayout;
    private ExitPoPupWindow mExitPoPupWindow;
    private ValueAnimator mInValueAnimator;
    private ValueAnimator mOutValueAnimator;


    private HomeFragment mHomeFragment;

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
        mFragmentManager = getSupportFragmentManager();
        showFragment(mHomeFragment);
    }



    @Override
    protected void onResume() {
        BaseApplication.getAppContext().getSharedPreferences("no_back_sp", Context.MODE_PRIVATE).edit().putBoolean("no_back",true).apply();
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
       BaseApplication.getAppContext().getSharedPreferences("no_back_sp", Context.MODE_PRIVATE).edit().putBoolean("no_back",false).apply();
    }



    private void showFragment(BaseFragment baseFragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (!baseFragment.isAdded()) {
            transaction.add(R.id.main_container, baseFragment);
        }
        transaction.commit();
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
