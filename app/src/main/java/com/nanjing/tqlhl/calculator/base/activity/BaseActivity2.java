package com.nanjing.tqlhl.calculator.base.activity;

import android.app.Activity;

import com.example.module_tool.base.BaseBackstage;

public class BaseActivity2 extends Activity {


    @Override
    protected void onStop() {
        super.onStop();
        BaseBackstage.setStop(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //  MobclickAgent.onResume(this);
        BaseBackstage.setBackstage(this);

    }
}
