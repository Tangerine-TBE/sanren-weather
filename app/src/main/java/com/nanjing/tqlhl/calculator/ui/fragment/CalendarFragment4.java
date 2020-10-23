package com.nanjing.tqlhl.calculator.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.nanjing.tqlhl.calculator.base.impl.BaseFragment;
import com.nanjing.tqlhl.calculator.bean.CityBean;
import com.nanjing.tqlhl.calculator.bean.TimePartBean;
import com.nanjing.tqlhl.calculator.inter.OnTimePartDialogItemClickListener;
import com.nanjing.tqlhl.calculator.present.DatePressenter;
import com.nanjing.tqlhl.calculator.view.IDatePartView;
import com.nanjing.tqlhl.calculator.weiget.TimePartListDialog;
import com.nanjing.tqlhl.R;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CalendarFragment4 extends BaseFragment<DatePressenter> implements IDatePartView, OnTimePartDialogItemClickListener {


    @BindView(R.id.tv_pulltoselect)
    TextView tv_pulltoselect;
    @BindView(R.id.tv_our_time)
    TextView tv_our_time;
    @BindView(R.id.tv_other_time_base)
    TextView tv_other_time_base;
    @BindView(R.id.tv_other_time_xialing)
    TextView tv_other_time_xialing;


    List<TimePartBean> mList = new ArrayList<>();
    public static final int LOAD_SUCCESS = 1;
    public static final int LOAD_FAILED = 2;
    public static final int LOADING = 3;
    public static final int LOAD_WITHOUT_ANIM_SUCCESS = 4;
    public static final int LOAD_WITHOUT_ANIM_FAILED = 5;
    public static final int SAVE_YOU = 6;
    private int style = LoadingDialog.STYLE_LINE;
    private boolean isShow = false;

    TimePartListDialog dialog;
    LoadingDialog.Speed speed = LoadingDialog.Speed.SPEED_TWO;
    LoadingDialog ld;
    static FragmentManager mFragmentManager;

    public static CalendarFragment4 newInstance(FragmentManager param1) {
        CalendarFragment4 fragment = new CalendarFragment4();
        Bundle args = new Bundle();
        mFragmentManager = param1;
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void refreshDatePartList(String s) {
        mList.clear();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject result = jsonObject.getJSONObject("result");
            Iterator<String> it = result.keys();
            while (it.hasNext()) {
// 获得key
                String key = it.next();

                JSONObject obj = result.getJSONObject(key);
                TimePartBean t = new TimePartBean();
                t.setCityCn(obj.getString("cityCn"));
                t.setCityEn(obj.getString("cityEn"));
                t.setContinentsCn(obj.getString("continentsCn"));
                t.setContinentsEn(obj.getString("continentsEn"));
                t.setContryEn(obj.getString("contryEn"));
                t.setCityCn(obj.getString("contryCn"));
                mList.add(t);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        //在你代码中合适的位置调用反馈
        ld.loadSuccess();
        int a = 0;
    }

    @Override
    public void getDateFromCity(CityBean reslut) {


        tv_our_time.setText(reslut.getResult().getBjt_datetime());
        tv_other_time_base.setText(reslut.getResult().getDatetime_1());
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        ld.loadSuccess();
    }


    @Override
    public void finishRefresh(String msg) {
        ld.loadFailed();
        getActivity().finish();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.js_fragment_calendar_fourth;
    }

    @Override
    protected DatePressenter initInjector() {
        return new DatePressenter();
    }

    private void showLoading() {
        ld = new LoadingDialog(getActivity());
        ld.setLoadingText("加载中")
                .setSuccessText("加载成功")//显示加载成功时的文字
                .setFailedText("网络异常")
                .setInterceptBack(true)
                .setLoadSpeed(speed)
                .setRepeatCount(0)
                .setLoadStyle(style)
                .setShowTime(1000)
                .show();
    }

    @Override
    protected void firstRequest() {
        mPresenter.getDatePartList();
        showLoading();

    }

    @Override
    public void ItemClick(TimePartBean item) {

       showLoading();
        mPresenter.getDateFromCity(item.getCityEn());


    }


    private void showExchangeDialog() {

        dialog = new TimePartListDialog(getContext(), R.style.CenterDialog, mList, this);
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }


    @OnClick({R.id.tv_pulltoselect
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_pulltoselect:
                showExchangeDialog();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            // 相当于onResume()方法
        } else {
            // 相当于onpause()方法
        }
    }


}
