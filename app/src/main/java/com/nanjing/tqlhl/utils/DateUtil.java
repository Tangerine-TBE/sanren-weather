package com.nanjing.tqlhl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    //格式化日期1
    public static String  StrToData(String time) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ft2 = new SimpleDateFormat("M月d日");
        try {
            Date date = ft.parse(time);
            return ft2.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "转换错误";
    }

    //格式化日期2
    public static String  StrToData2(String time) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ft2 = new SimpleDateFormat("MM/dd");
        try {
            Date date = ft.parse(time);
            return ft2.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "转换错误";
    }


    public  static String getDate2() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy年M月dd日");
        Date date = new Date();
        String format = ft.format(date);
        return format;
    }

    public  static String getDate() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String format = ft.format(date);
        return format;
    }



    //格式化星期
    public static String getWeek(String time) {
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(time));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int wek=c.get(Calendar.DAY_OF_WEEK);

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
