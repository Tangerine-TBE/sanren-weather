package com.nanjing.tqlhl.calculator.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.nanjing.tqlhl.calculator.base.BaseFragment;
import com.nanjing.tqlhl.calculator.utils.CalendarUtils;
import com.nanjing.tqlhl.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class CalendarFragment3 extends BaseFragment {
    @BindView(R.id.tv_pulltoselect)
    TextView tv_pulltoselect;
    @BindView(R.id.ed_day)
    EditText ed_day;
    @BindView(R.id.ed_hour)
    EditText ed_hour;
    @BindView(R.id.tv_result)
    TextView tv_result;

    Date fromDate;

    private String start_time;
    private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy年MM月dd日HH时");
    static FragmentManager mFragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.js_fragment_calendar_third;
    }

    @Override
    protected void initView() {
        ed_day.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    if (ed_hour.getText().toString().trim().length() > 0) {
                        caculate(fromDate);

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        ed_hour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    if (ed_day.getText().toString().trim().length() > 0) {
                        caculate(fromDate);

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public static CalendarFragment3 newInstance(FragmentManager param1) {
        CalendarFragment3 fragment = new CalendarFragment3();
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
            tv_pulltoselect.setText(start_time);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            fromDate = date;
            if (!ed_day.getText().toString().trim().isEmpty() && !ed_hour.getText().toString().trim().isEmpty()) {
                caculate(fromDate);
            }
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel() {

        }
    };

    private void caculate(Date date) {
        int day = Integer.parseInt(ed_day.getText().toString().trim());
        int hour = Integer.parseInt(ed_hour.getText().toString());

        String result = CalendarUtils.calFullDate(date, 0, 0, day, hour);
        tv_result.setText(result);

    }
}
