package com.nanjing.tqlhl.calculator.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.module_tool.base.BaseBackstage;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public class BaseRxActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    @Override
    protected void onPause() {
        super.onPause();
    }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
