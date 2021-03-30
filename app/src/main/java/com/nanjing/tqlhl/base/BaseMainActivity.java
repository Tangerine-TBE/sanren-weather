package com.nanjing.tqlhl.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.fragment.app.FragmentActivity;

import com.example.module_ad.utils.MyStatusBarUtil;
import com.example.module_tool.base.BaseBackstage;
import com.feisukj.base.widget.loaddialog.LoadingDialog;
import com.nanjing.tqlhl.R;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMainActivity extends FragmentActivity {

    private Unbinder mUnbinder;
    private LoadingDialog loadingDialog;

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
    protected void onPause() {
        super.onPause();
       MobclickAgent.onPause(this);
        BaseBackstage.setStop(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
      MobclickAgent.onResume(this);
        BaseBackstage.setBackstage(this);
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