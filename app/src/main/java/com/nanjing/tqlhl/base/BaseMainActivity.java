package com.nanjing.tqlhl.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;

import androidx.fragment.app.FragmentActivity;

import com.example.module_ad.activity.BackActivity;
import com.example.module_ad.bean.AdBean;
import com.example.module_ad.utils.CommonUtil;
import com.example.module_ad.utils.LogUtils;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.feisukj.base.widget.loaddialog.LoadingDialog;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.SpUtil;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMainActivity extends FragmentActivity {

    private Unbinder mUnbinder;
    private boolean isShow=false;
    private CountDownTimer mStart;
    private LoadingDialog loadingDialog;
    private int mShowTime=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int id=getLayoutId();
        if (id!=0) {
            setContentView(id);
        }
        com.example.module_ad.utils.ActivityManager.addActivity(this);
        loadingDialog = new LoadingDialog(this);
        loadingDialog.setCancelable(true);
        setStatusBarColor();
        mUnbinder = ButterKnife.bind(this);
        intView();
        intPresent();
        initLoad();
        intEvent();


    }


    public void showLoading() {
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    public void dismissLoading() {
        if (loadingDialog != null) {
            if (loadingDialog.isShowing())
                loadingDialog.dismiss();
        }
    }


    protected  void initLoad() {

    }

    protected void intPresent() {

    }

    protected void setStatusBarColor() {
        MyStatusBarUtil.setColor(this,getResources().getColor(R.color.white));
    }


    public abstract int getLayoutId();

    protected void intView() {

    }


    protected void intEvent() {

    }


    public void visible(View... views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public void invisible(View... views) {
        for (View view : views) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    protected void gone(View... views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        AdBean.DataBean adState = SpUtil.getAdState();
        if (adState != null) {
            AdBean.DataBean.StartPageBean.SpreadScreenBean spread_screen = adState.getStart_page().getSpread_screen();
            int times = spread_screen.getTimes();
            mShowTime=times*1000;
            LogUtils.i(BaseMainActivity.this,"onStop: --------------------->"+mShowTime);

            if (!isAppOnForeground()) {
                mStart = new CountDownTimer(mShowTime, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        LogUtils.i(BaseMainActivity.this,mStart+"CountDownTimer: --------------------->"+millisUntilFinished / 1000);
                    }
                    @Override
                    public void onFinish() {
                        isShow = true;
                    }
                }.start();
            }
        }

    }

    public boolean isAppOnForeground() {
        // Returns a list of application processes that are running on the
        // device
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName) && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                LogUtils.i(this,": --------------------->在后台运行");
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
       // MobclickAgent.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    //   MobclickAgent.onResume(this);
        SharedPreferences no_back_sp = BaseApplication.getAppContext().getSharedPreferences(Contents.NO_BACK_SP, MODE_PRIVATE);
        boolean no_back = no_back_sp.getBoolean(Contents.NO_BACK, false);
        if (no_back) {
        }else {
            if (CommonUtil.isNetworkAvailable(this)) {
                AdBean.DataBean adState = SpUtil.getAdState();
                if (adState != null ) {
                    if (adState.getStart_page()!=null) {
                        if (adState.getStart_page().getSpread_screen().isStatus()) {
                            if (isShow) {
                                LogUtils.i(this,"onResume: --------------------->"+ isShow);
                                Intent intent = new Intent(this, BackActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                            if (mStart != null) {
                                mStart.cancel();
                            }
                            isShow=false;
                        }
                    }
                    // TODO: 2020/7/17

                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        com.example.module_ad.utils.ActivityManager.removeActivity(this);
        if (mUnbinder != null) {
            mUnbinder=null;
        }

        release();

    }

    protected void release() {

    }
}