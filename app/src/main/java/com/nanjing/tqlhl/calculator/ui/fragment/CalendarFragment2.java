package com.nanjing.tqlhl.calculator.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.nanjing.tqlhl.calculator.base.BaseFragment;
import com.nanjing.tqlhl.calculator.utils.Lunar;
import com.nanjing.tqlhl.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class CalendarFragment2 extends BaseFragment {


    @BindView(R.id.tv_pulltoselect)
    TextView tv_pulltoselect;
    @BindView(R.id.tv_nongli)
    TextView tv_nongli;


    private String start_time;
    private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy年MM月dd日");
    static FragmentManager mFragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.js_fragment_calendar_second;
    }

    @Override
    protected void initView() {

    }


    public static CalendarFragment2 newInstance(FragmentManager param1) {
        CalendarFragment2 fragment = new CalendarFragment2();
        Bundle args = new Bundle();
        mFragmentManager = param1;
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.tv_pulltoselect
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_pulltoselect:
                FragmentManager fm;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    fm = getActivity().getSupportFragmentManager();
                } else {

                    fm = getActivity().getSupportFragmentManager();
                }
                new SlideDateTimePicker.Builder(mFragmentManager)
                        .setListener(listener1)
                        .setInitialDate(new Date())
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        //.setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        //.setIndicatorColor(Color.parseColor("#990000"))
                        .build()
                        .show();
                break;

        }
    }

    private SlideDateTimeListener listener1 = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date) {
            start_time = mFormatter.format(date);
            tv_pulltoselect.setText("公历" + start_time);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            String nongli = new Lunar(ca).toString();
            tv_nongli.setText("农历" + nongli);
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel() {

        }
    };
}
