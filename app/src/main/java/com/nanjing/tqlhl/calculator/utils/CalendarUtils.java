package com.nanjing.tqlhl.calculator.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static android.icu.text.DateTimePatternGenerator.DAY;


public class CalendarUtils {
    /**
     * 获得两个日期间距多少天
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long getTimeDistance(Date beginDate, Date endDate) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(beginDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endDate);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

    /**
     * 获取两个日期的周数差
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getDifferWeek(Date startTime, Date endTime) {
        return getTimeDistance(startTime,endTime)/DAY;
    }

    /**
     * 获取两个日期的月数差
     * @param fromDate
     * @param toDate
     * @return
     */
    public static long getDifferMonth(Date fromDate, Date toDate) {
        Calendar fromDateCal = Calendar.getInstance();
        Calendar toDateCal = Calendar.getInstance();
        fromDateCal.setTime(fromDate);
        toDateCal.setTime(toDate);

        int fromYear =  fromDateCal.get(Calendar.YEAR);
        int toYear = toDateCal.get((Calendar.YEAR));
        if (fromYear == toYear) {
            return Math.abs(fromDateCal.get(Calendar.MONTH) - toDateCal.get(Calendar.MONTH));
        } else {
            int fromMonth = 12 - (fromDateCal.get(Calendar.MONTH) + 1);
            int toMonth = toDateCal.get(Calendar.MONTH) + 1;
            return Math.abs(toYear - fromYear - 1) * 12 + fromMonth + toMonth;
        }
    }

    /**
     * 求任意两个日期间的休息日
     * @param d1 第一个日期
     * @param d2 第二个日期
     * @return
     */
    public static int getWeekends(Date d1, Date d2){
        if(d1 == null || d2 == null){
            return 0;
        }
        int count = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
// 保证第二个时间一定大于第一个时间
        if (c1.after(c2)) {
            c2.setTime(d1);
            c1.setTime(d2);
        }
// 当日期c2在日期c1之后退出循环
        while(c2.after(c1)){
            if(c1.get(Calendar.DAY_OF_WEEK) == 1 || c1.get(Calendar.DAY_OF_WEEK) == 7){
                System.out.println(c1.getTime());
                count++ ;
            }
// 天数加1
            c1.set(Calendar.DAY_OF_YEAR, (c1.get(Calendar.DAY_OF_YEAR) + 1));
        }
        return count;
    }



    /**
     * 获取2个日期之间周六，周日的天数
     * @param startDate
     * @param endDate
     * @param format
     * @return
     * @author zhaigx
     * @date 2013-3-13
     */
    public static int getSundayNum(String startDate, String endDate, String format) {
        List yearMonthDayList = new ArrayList();
        Date start = null, stop = null;
        try {
            start = new SimpleDateFormat(format).parse(startDate);
            stop = new SimpleDateFormat(format).parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (start.after(stop)) {
            Date tmp = start;
            start = stop;
            stop = tmp;
        }
//将起止时间中的所有时间加到List中
        Calendar calendarTemp = Calendar.getInstance();
        calendarTemp.setTime(start);
        while (calendarTemp.getTime().getTime() <= stop.getTime()) {
            yearMonthDayList.add(new SimpleDateFormat(format)
                    .format(calendarTemp.getTime()));
            calendarTemp.add(Calendar.DAY_OF_YEAR, 1);
        }
        Collections.sort(yearMonthDayList);
        int num=0;//周六，周日的总天数
        int size=yearMonthDayList.size();
        int week=0;
        for (int i = 0; i < size; i++) {
            String day=(String)yearMonthDayList.get(i);
            System.out.println(day);
            week=getWeek(day, format);
            if (week==6||week==0) {//周六，周日
                num++;
            }
        }
        return num;
    }
    /**
     * 获取某个日期是星期几
     * @param date
     * @param format
     * @return 0-星期日
     * @author zhaigx
     * @date 2013-3-13
     */
    public static int getWeek(String date, String format) {
        Calendar calendarTemp = Calendar.getInstance();
        try {
            calendarTemp.setTime(new SimpleDateFormat(format).parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = calendarTemp.get(Calendar.DAY_OF_WEEK);
        int value=i-1;//0-星期日
// System.out.println(value);
        return value;
    }
//    public static void main(String[] args) {
//        int i=getSundayNum("2013-03-01", "2013-03-20", "yyyy-MM-dd");
//        System.out.println(i);
//    }




    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * @param fromDate
     * @param toDate
     * @return
     */
    public static String dayComparePrecise(Date fromDate,Date toDate){

        Calendar  from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);

        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);
        long year = toYear  -  fromYear;
        long month = toMonth  - fromMonth;
        long day = toDay  - fromDay;
      return year+"年"+month+"月"+day+"日";

    }


    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * @param fromDate
     * @param toDate
     * @return
     */
    public static String dayComparePreciseMonth(Date fromDate,Date toDate){

        Calendar  from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);


        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);


        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);

        long month = toMonth  - fromMonth;
        long day = toDay  - fromDay;
        return month+"月"+day+"日";

    }


    /**
     * 计算2个日期之间相差的  相差多少年月日小时分钟个是多少
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * @param fromDate
     * @param toDate
     * @return
     */
    public static long[] dayCompare(Date fromDate,Date toDate){
        long[] result=new long[5];
        Calendar  from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);
        //只要年月
        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int year = toYear  -  fromYear;
        int month = toYear *  12  + toMonth  -  (fromYear  *  12  +  fromMonth);
        int day = (int) ((to.getTimeInMillis()  -  from.getTimeInMillis())  /  (24  *  3600  *  1000));
        result[0]=day*24;
        result[1]=result[0]*60;

        return result;
    }


    public static String calFullDate(Date date, int yearNum, int monthNum, int dateNum,int hourNum) {
        String result = "";
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日HH时");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            cal.add(Calendar.HOUR, hourNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {

        }
        return result;
    }

}
