package com.nanjing.tqlhl.ui.activity;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;

import com.amap.api.location.AMapLocationClient;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.ui.fragment.AdFragment;
import com.nanjing.tqlhl.ui.fragment.PermissionFragment;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.SpUtils;
import com.nanjing.tqlhl.R;


@RequiresApi(api = Build.VERSION_CODES.M)
public class BeginActivity extends BaseMainActivity {

    private PermissionFragment mPermissionFragment;
    private AdFragment mAdFragment;
    private FragmentManager mFragmentManager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_ad;
    }

    @Override
    protected void intView() {
        BaseApplication.getAppContext().getSharedPreferences("no_back_sp", Context.MODE_PRIVATE).edit().putBoolean("no_back",true).apply();
        mAdFragment = new AdFragment();
        mPermissionFragment = new PermissionFragment();
        mFragmentManager = getSupportFragmentManager();

        boolean one= SpUtils.getInstance().getBoolean(Contents.IS_FIRST, true);
        AMapLocationClient.updatePrivacyShow(this,true,true);
        if (!one) {
            AMapLocationClient.updatePrivacyAgree(this,true);
                mFragmentManager.beginTransaction().add(R.id.fragment_container, mAdFragment).commit();
            } else {
                mFragmentManager.beginTransaction().add(R.id.fragment_container, mPermissionFragment).commit();
            }

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        MyStatusBarUtil.fullScreenWindow(hasFocus,this);
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK)
            return true;//不执行父类点击事件
        return super.onKeyDown(keyCode, event);//继续执行父类其他点击事件
    }


}