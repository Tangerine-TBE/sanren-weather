package com.nanjing.tqlhl.utils;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.nanjing.tqlhl.ui.custom.DiyToolbar;
import com.tamsiree.rxkit.RxBarTool;
import com.nanjing.tqlhl.R;

import java.util.Calendar;

public class ChangeBgUtil {

    public static void selectBg(ImageView imageView,int day,int night) {
        Calendar cal = Calendar.getInstance();// 当前日期
        int hour = cal.get(Calendar.HOUR_OF_DAY);// 获取小时
        int minute = cal.get(Calendar.MINUTE);// 获取分钟
        int minuteOfDay = hour * 60 + minute;// 从0:00分开是到目前为止的分钟数
        final int start = 6 * 60;// 起始时间 8:30的分钟数
        final int end = 18 * 60;// 结束时间 18:00的分钟数
        imageView.setImageResource(minuteOfDay >= start && minuteOfDay <= end? day:night);
    }

    public static int selectColorBg() {
        Calendar cal = Calendar.getInstance();// 当前日期
        int hour = cal.get(Calendar.HOUR_OF_DAY);// 获取小时
        int minute = cal.get(Calendar.MINUTE);// 获取分钟
        int minuteOfDay = hour * 60 + minute;// 从0:00分开是到目前为止的分钟数
        final int start = 6 * 60;// 起始时间 8:30的分钟数
        final int end = 18 * 60;// 结束时间 18:00的分钟数
        return minuteOfDay >= start && minuteOfDay <= end? R.drawable.shape_day_permission_bg: R.drawable.shape_night_permission_bg;
    }

    public static boolean selectIcon() {
        Calendar cal = Calendar.getInstance();// 当前日期
        int hour = cal.get(Calendar.HOUR_OF_DAY);// 获取小时
        int minute = cal.get(Calendar.MINUTE);// 获取分钟
        int minuteOfDay = hour * 60 + minute;// 从0:00分开是到目前为止的分钟数
        final int start = 6 * 60;// 起始时间 8:30的分钟数
        final int end = 18 * 60;// 结束时间 18:00的分钟数
       return minuteOfDay >= start && minuteOfDay <= end? true:false;
    }


    public static void setToolBar(Context context,DiyToolbar diyToolbar, String title,boolean conTore) {
        ViewGroup.LayoutParams layoutParams=null;
        int statusBarHeight = RxBarTool.getStatusBarHeight(context);
        if (conTore) {
            layoutParams = (ConstraintLayout.LayoutParams) diyToolbar.getLayoutParams();
            ((ConstraintLayout.LayoutParams) layoutParams).topMargin = statusBarHeight;
        } else {
         layoutParams = (RelativeLayout.LayoutParams) diyToolbar.getLayoutParams();
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = statusBarHeight;
        }
        diyToolbar.setLayoutParams(layoutParams);
        diyToolbar.setTitle(title);
        diyToolbar.setColorBackground(ColorUtil.TRANSPARENT);

    }
}
