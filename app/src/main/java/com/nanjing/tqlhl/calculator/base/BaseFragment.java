package com.nanjing.tqlhl.calculator.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.nanjing.tqlhl.R;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;





public abstract class BaseFragment extends RxFragment {
    protected View rootView;
    protected abstract int getLayoutId();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.js_fragment_base, container, false);

        ((ViewGroup) rootView.findViewById(R.id.fl_content)).addView(getLayoutInflater().inflate(getLayoutId(), null));
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    /**
     * 初始化View
     */
    protected  abstract  void initView();
}
