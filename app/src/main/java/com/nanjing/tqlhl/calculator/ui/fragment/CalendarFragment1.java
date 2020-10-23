package com.nanjing.tqlhl.calculator.ui.fragment;


import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.nanjing.tqlhl.calculator.base.BaseFragment;
import com.nanjing.tqlhl.calculator.utils.CalendarUtils;
import com.nanjing.tqlhl.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class CalendarFragment1 extends BaseFragment {

    private SimpleDateFormat mFormatter1 = new SimpleDateFormat("yyyyMMddHHmmss");
    private SimpleDateFormat mFormatter2 = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat mFormatter3 = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat mFormatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String start_week, end_week;
    private long start_time = 0;
    private long end_time = 0;
    Date fromDate, toDate;

    @BindView(R.id.tv_pulltoselect_start)
    TextView tv_pulltoselect_start;
    @BindView(R.id.tv_pulltoselect_end)
    TextView tv_pulltoselect_end;

    @BindView(R.id.tv_day)
    TextView tv_day;
    @BindView(R.id.tv_day_weekend)
    TextView tv_day_weekend;
    @BindView(R.id.tv_week)
    TextView tv_week;
    @BindView(R.id.tv_month)
    TextView tv_month;
    @BindView(R.id.tv_year)
    TextView tv_year;
    @BindView(R.id.tv_hour)
    TextView tv_hour;
    @BindView(R.id.tv_minute)
    TextView tv_minute;

    static FragmentManager mFragmentManager;

    public static CalendarFragment1 newInstance(FragmentManager param1) {
        CalendarFragment1 fragment = new CalendarFragment1();
        Bundle args = new Bundle();
        mFragmentManager = param1;
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.js_fragment_calendar_first;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.tv_pulltoselect_start, R.id.tv_pulltoselect_end
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_pulltoselect_start:
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
            case R.id.tv_pulltoselect_end:
                new SlideDateTimePicker.Builder(getActivity().getSupportFragmentManager())
                        .setListener(listener2)
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
            start_time = Long.parseLong(mFormatter1.format(date));

            String date_left = mFormatter2.format(date);
            start_week = getWeek(mFormatter4.format(date));
            String date_right = mFormatter3.format(date);
            tv_pulltoselect_start.setText(date_left + start_week + date_right);
            fromDate = date;
            if (!checkTime(start_time, end_time)) {
                return;
            }
            caculate();
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel() {

        }
    };

    private boolean checkTime(long start, long end) {

        if (end == 0 | start == 0) {

            return false;
        } else if (end != 0 && start != 0 && start > end) {
            Toast.makeText(getContext(), "开始时间不能大于结束时间", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }


    private SlideDateTimeListener listener2 = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date) {
            end_time = Long.parseLong(mFormatter1.format(date));

            String date_left = mFormatter2.format(date);
            end_week = getWeek(mFormatter4.format(date));
            String date_right = mFormatter3.format(date);
            tv_pulltoselect_end.setText(date_left + end_week + date_right);
            toDate = date;
            if (!checkTime(start_time, end_time)) {
                return;
            }

            caculate();

        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel() {

        }
    };


    private void caculate() {
        long day = CalendarUtils.getTimeDistance(fromDate, toDate);
        long hour = day * 24;
        long minute = hour * 60;
        tv_day.setText(String.valueOf(day));
        tv_day_weekend.setText(String.valueOf(CalendarUtils.getWeekends(fromDate, toDate)));


        tv_week.setText(String.valueOf(CalendarUtils.getDifferWeek(fromDate, toDate)));


        tv_month.setText(CalendarUtils.dayComparePreciseMonth(fromDate, toDate));
        tv_year.setText(CalendarUtils.dayComparePrecise(fromDate, toDate));
        tv_hour.setText(String.valueOf(hour));
        tv_minute.setText(String.valueOf(minute));
    }

    public static String getWeek(String time) {
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            Date d = format.parse(time);
            c.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int wek = c.get(Calendar.DAY_OF_WEEK);

        if (wek == 1) {
            Week += "周日";
        }
        if (wek == 2) {
            Week += "周一";
        }
        if (wek == 3) {
            Week += "周二";
        }
        if (wek == 4) {
            Week += "周三";
        }
        if (wek == 5) {
            Week += "周四";
        }
        if (wek == 6) {
            Week += "周五";
        }
        if (wek == 7) {
            Week += "周六";
        }
        return Week;
    }


}
