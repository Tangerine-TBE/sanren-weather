package com.nanjing.tqlhl.ui.custom.mj15day;


import com.nanjing.tqlhl.R;

/**
 * Created by zz on 2016/12/28.
 */

public class PicUtil {

    public static int getDayWeatherPic(String weatherName) {
        switch (weatherName) {
            case "晴":
                return R.mipmap.iocn_small_qingtian;
            case "多云":
                return R.mipmap.icon_small_duoyun;
            case "阴":
                return R.mipmap.icon_small_duoyun;
            case "雷阵雨":
                return R.mipmap.icon_small_leiyu;
            case "雨夹雪":
                return R.mipmap.icon_small_xiaoxue;
            case "小雨":
                return R.mipmap.icon_small_xiaoyu;
            case "中雨":
                return R.mipmap.icon_small_zhongyu;
            case "大雨":
                return R.mipmap.iocn_small_dayu;
            case "暴雨":
                return R.mipmap.iocn_small_dayu;
            case "大雪":
                return R.mipmap.icon_small_daxue;
            case "中雪":
                return R.mipmap.icon_small_zhongxue;
            case "冰雹":
                return R.mipmap.icon_small_bingbao;
        }
        return R.mipmap.icon_small_duoyun;
    }

    public static int getNightWeatherPic(String weatherName) {
        switch (weatherName) {
            case "晴":
                return R.mipmap.icon_small_yewan;
            case "多云":
                return R.mipmap.icon_small_ye_duoyun;
            case "阴":
                return R.mipmap.icon_small_duoyun;
            case "雷阵雨":
                return R.mipmap.icon_small_leiyu;
            case "雨夹雪":
                return R.mipmap.icon_small_xiaoxue;
            case "小雨":
                return R.mipmap.icon_small_xiaoyu;
            case "中雨":
                return R.mipmap.icon_small_zhongyu;
            case "大雨":
                return R.mipmap.iocn_small_dayu;
            case "暴雨":
                return R.mipmap.iocn_small_dayu;
            case "大雪":
                return R.mipmap.icon_small_daxue;
            case "中雪":
                return R.mipmap.icon_small_zhongxue;
            case "冰雹":
                return R.mipmap.icon_small_bingbao;
        }
        return R.mipmap.icon_small_duoyun;
    }
}
