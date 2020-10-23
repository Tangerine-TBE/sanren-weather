package com.nanjing.tqlhl.calculator.base.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.nanjing.tqlhl.calculator.base.IPresenter;
import com.nanjing.tqlhl.calculator.base.IView;
import com.nanjing.tqlhl.R;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;


public abstract class BaseFragment<T extends IPresenter> extends RxFragment implements IView {
    protected View rootView;
    protected Bundle savedInstanceState;
    public T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        initSDK();
        rootView = inflater.inflate(R.layout.js_fragment_base, container, false);

        ((ViewGroup) rootView.findViewById(R.id.fl_content)).addView(inflater.inflate(getLayoutId(), null));
        ButterKnife.bind(this, rootView);
        mPresenter = initInjector();
        attachView();
        initData();
        bindView();
        bindEvent();
        firstRequest();
        return rootView;
    }

    /**
     * 事件触发绑定
     */
    protected void bindEvent() {

    }

    /**
     * 控件绑定
     */
    protected void bindView() {

    }

    /**
     * 数据初始化
     */
    protected void initData() {

    }

    /**
     * 首次逻辑操作
     */
    protected void firstRequest() {

    }


    /**
     * 第三方SDK初始化
     */
    protected void initSDK() {

    }

    protected abstract int getLayoutId();


    /**
     * P层绑定   若无则返回null;
     *
     * @return
     */
    protected abstract T initInjector();

    /**
     * P层绑定V层
     */
    private void attachView() {
        if (null != mPresenter) {
            mPresenter.attachView(this);
        }
    }

    /**
     * P层解绑V层
     */
    private void detachView() {
        if (null != mPresenter) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detachView();

    }
}
