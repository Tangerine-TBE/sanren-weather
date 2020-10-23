package com.nanjing.tqlhl.utils;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherUtils {

    private static Map<String, Integer> map15Day = new HashMap<>();

    public Map<String, Integer> get15DayNightIcon(String iconId) {
        map15Day.put(Contents.MJ_Day, 0);
        map15Day.put(Contents.MJ_Night, 30);
        int value = Integer.valueOf(iconId);
        if (value == 1 || value == 2 || value == 3 || value == 4 || value == 5 || value == 6 || value == 7) {
            map15Day.put(Contents.MJ_Day, 0);
            map15Day.put(Contents.MJ_Night, 30);
        } else if (value == 8 || value == 9 || value == 10 || value == 11 || value == 12 || value == 80 || value == 81 || value == 82) {
            map15Day.put(Contents.MJ_Day, 1);
            map15Day.put(Contents.MJ_Night, 31);
        } else if (value == 14 || value == 13 || value == 36 || value == 85) {
            map15Day.put(Contents.MJ_Day, 2);
            map15Day.put(Contents.MJ_Night, 2);
        } else if (value == 15 || value == 16 || value == 17 || value == 18 || value == 19 || value == 20 || value == 21 || value == 22 || value == 23 || value == 86) {
            map15Day.put(Contents.MJ_Day, 3);
            map15Day.put(Contents.MJ_Night, 33);
        } else if (value == 24 || value == 25) {
            map15Day.put(Contents.MJ_Day, 13);
            map15Day.put(Contents.MJ_Night, 34);
        } else if (value == 26 || value == 27 || value == 28 || value == 83 || value == 84) {
            map15Day.put(Contents.MJ_Day, 18);
            map15Day.put(Contents.MJ_Night, 32);
        } else if (value == 29 || value == 33) {
            map15Day.put(Contents.MJ_Day, 20);
            map15Day.put(Contents.MJ_Night, 36);
        } else if (value == 30 || value == 31 || value == 32) {
            map15Day.put(Contents.MJ_Day, 29);
            map15Day.put(Contents.MJ_Night, 35);
        } else if (value == 34 || value == 35 || value == 79) {
            map15Day.put(Contents.MJ_Day, 45);
            map15Day.put(Contents.MJ_Night, 46);
        } else if (value == 37 || value == 38 || value == 39 || value == 40 || value == 41 || value == 42 || value == 43
                || value == 87 || value == 88 || value == 89 || value == 90) {
            map15Day.put(Contents.MJ_Day, 4);
            map15Day.put(Contents.MJ_Night, 4);
        } else if (value == 44 || value == 45 || value == 46 || value == 47 || value == 48) {
            map15Day.put(Contents.MJ_Day, 5);
            map15Day.put(Contents.MJ_Night, 5);
        } else if (value == 49 || value == 50) {
            map15Day.put(Contents.MJ_Day, 6);
            map15Day.put(Contents.MJ_Night, 6);
        } else if (value == 51 || value == 52 || value == 66 || value == 91) {
            map15Day.put(Contents.MJ_Day, 7);
            map15Day.put(Contents.MJ_Night, 7);
        } else if (value == 53 || value == 67 || value == 78) {
            map15Day.put(Contents.MJ_Day, 8);
            map15Day.put(Contents.MJ_Night, 8);
        } else if (value == 54 || value == 68 || value == 92) {
            map15Day.put(Contents.MJ_Day, 9);
            map15Day.put(Contents.MJ_Night, 9);
        } else if (value == 55 || value == 56 || value == 57 || value == 69 || value == 70 || value == 93) {
            map15Day.put(Contents.MJ_Day, 10);
            map15Day.put(Contents.MJ_Night, 10);
        } else if (value == 58 || value == 59 || value == 71 || value == 72 || value == 73) {
            map15Day.put(Contents.MJ_Day, 14);
            map15Day.put(Contents.MJ_Night, 14);
        } else if (value == 60 || value == 61 || value == 74 || value == 75 || value == 77 || value == 94) {
            map15Day.put(Contents.MJ_Day, 15);
            map15Day.put(Contents.MJ_Night, 15);
        } else if (value == 62 || value == 76) {
            map15Day.put(Contents.MJ_Day, 16);
            map15Day.put(Contents.MJ_Night, 16);
        } else if (value == 63) {
            map15Day.put(Contents.MJ_Day, 17);
            map15Day.put(Contents.MJ_Night, 17);
        } else if (value == 64 || value == 65) {
            map15Day.put(Contents.MJ_Day, 19);
            map15Day.put(Contents.MJ_Night, 19);
        }

        return map15Day;
    }


    private static Map<String, Integer> map = new HashMap<>();
    public static Map<String, Integer> selectDayIcon(String iconId) {
        map.put(Contents.MJ_BG, R.mipmap.home_top_bg_fine);
        map.put(Contents.MJ_ICON, R.mipmap.iocn_small_qingtian);
        map.put(Contents.MJ_LAGER_ICON, R.mipmap.iocn_large_qingtian);
        map.put(Contents.MJ_COLOR, ColorUtil.CEHENGSE);
        int value = Integer.valueOf(iconId);
        if (value == 0) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_fine);
            map.put(Contents.MJ_ICON, R.mipmap.iocn_small_qingtian);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.iocn_large_qingtian);
            map.put(Contents.MJ_COLOR, ColorUtil.CEHENGSE);
            return map;
        } else if (value == 1) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_duoyun);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_duoyun);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_duoyun);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 2) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_duoyun);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_yin);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_yin);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 3) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_largel_xiaoyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;
        } else if (value == 4) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_leiyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_leiyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;
        } else if (value == 5) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_bingbao);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_bingbao);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 6 || value == 19) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_yu_xue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_yu_xue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 7) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_largel_xiaoyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;

        } else if (value == 8) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_zhongyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_zhongyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;

        } else if (value == 9 || value == 10) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.iocn_small_dayu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.iocn_large_dayu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);

            return map;
        } else if (value == 13) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_xiaoxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;

        } else if (value == 14) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_xiaoxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 15) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_zhongxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_zhongxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 16 || value == 17) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_daxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_daxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 18) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_duoyun);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_wutian);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_wutian);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;

        } else if (value == 20 || value == 29) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_mai);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_shachen);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_shachen);
            map.put(Contents.MJ_COLOR, ColorUtil.MAI);
            return map;

        } else if (value == 45) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_mai);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_wumai);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_wumai);
            map.put(Contents.MJ_COLOR, ColorUtil.MAI);
            return map;
        }
        return map;

    }
    public static Map<String, Integer> selectNightIcon(String iconId) {
        map.put(Contents.MJ_BG, R.mipmap.home_top_bg_ye_qing);
        map.put(Contents.MJ_ICON, R.mipmap.icon_small_ye_duoyun);
        map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_ye_qing);
        map.put(Contents.MJ_COLOR, ColorUtil.SHENLAN);

        int value = Integer.valueOf(iconId);
        if (value == 30) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_ye_qing);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_ye_qing);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_ye_qing);
            map.put(Contents.MJ_COLOR, ColorUtil.SHENLAN);
            return map;
        } else if (value == 31) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_ye_qing);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_ye_duoyun);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_ye_duoyun);
            map.put(Contents.MJ_COLOR, ColorUtil.SHENLAN);
            return map;
        } else if (value == 2) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_ye_qing);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_yin);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_yin);
            map.put(Contents.MJ_COLOR, ColorUtil.SHENLAN);
            return map;
        } else if (value == 4) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_leiyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_leiyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;
        } else if (value == 5) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_bingbao);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_bingbao);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 6 || value == 19) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_yu_xue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_yu_xue);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;
        } else if (value == 7) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_largel_xiaoyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;
        } else if (value == 8) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_zhongyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_zhongyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;
        } else if (value == 9 || (value == 10)) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.iocn_small_dayu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.iocn_large_dayu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;

        } else if (value == 14) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_xiaoxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 15) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_zhongxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_zhongxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;

        } else if (value == 16 || value == 17) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_daxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_daxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 32) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_duoyun);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_wutian);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_wutian);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;
        } else if (value == 33) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_yu);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoyu);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_largel_xiaoyu);
            map.put(Contents.MJ_COLOR, ColorUtil.HUILAN);
            return map;
        } else if (value == 34) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_xue);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_xiaoxue);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_xiaoxue);
            map.put(Contents.MJ_COLOR, ColorUtil.LAN);
            return map;

        } else if (value == 35 || value == 36) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_mai);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_shachen);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_shachen);
            map.put(Contents.MJ_COLOR, ColorUtil.MAI);
            return map;

        } else if (value == 46) {
            map.put(Contents.MJ_BG, R.mipmap.home_top_bg_mai);
            map.put(Contents.MJ_ICON, R.mipmap.icon_small_wumai);
            map.put(Contents.MJ_LAGER_ICON, R.mipmap.icon_large_wumai);
            map.put(Contents.MJ_COLOR, ColorUtil.MAI);
            return map;

        }
        return map;

    }


    private static List<String> sWinType = new ArrayList<>();
    private static String[] sDirection = {"北风", "东北风", "东风", "东南风",
            "南风", "西南风",
            "西风", "西北风", "微风", "旋转风"};

    //天气状态
    public enum State {
        CLEAR_DAY, CLEAR_NIGHT, PARTLY_CLOUDY_DAY, PARTLY_CLOUDY_NIGHT, CLOUDY, LIGHT_HAZE,
        MODERATE_HAZE, HEAVY_HAZE, LIGHT_RAIN, MODERATE_RAIN, HEAVY_RAIN, STORM_RAIN, FOG,
        LIGHT_SNOW, MODERATE_SNOW, HEAVY_SNOW, STORM_SNOW, DUST, SAND, WIND
    }


    //格式化风向
    public static String formatWindyDir(String windy) {
        if (windy.equals("N")) {
            return sDirection[0];
        } else if (windy.equals("NNE") || windy.equals("NE") || windy.equals("ENE")) {
            return sDirection[1];
        } else if (windy.equals("E")) {
            return sDirection[2];
        } else if (windy.equals("ESE") || windy.equals("SE") || windy.equals("SSE")) {
            return sDirection[3];
        } else if (windy.equals("S")) {
            return sDirection[4];
        } else if (windy.equals("SSW") || windy.equals("SW") || windy.equals("WSW")) {
            return sDirection[5];
        } else if (windy.equals("W")) {
            return sDirection[6];
        } else if (windy.equals("WNW") || windy.equals("NW") || windy.equals("NNW")) {
            return sDirection[7];
        } else if (windy.equals("Calm")) {
            return sDirection[8];
        } else if (windy.equals("Whirlwind")) {
            return sDirection[9];
        }

        return "";
    }

    //格式化湿度
    public static String formatHumidity(String hum) {
        String realHum = hum + "%";
        return realHum;
    }


    //格式化湿度
    public static String addHumiditySymbol(double tem) {
        String realHum = (int) (tem * 100) + "%";
        return realHum;
    }

    //格式化城市
    public static String cityType(String city) {
        if (city.endsWith("市")) {
            String replaceStr = city.replace("市", "");

            return replaceStr;
        }
        return city;
    }


    //格式化气压
    public static String preType(double p) {
        int hPa = (int) p / 1000;

        return hPa + "kPa";
    }


    //格式化温度
    public static String addTemSymbol(int tem) {
        String realTem = tem + "°";
        return realTem;
    }


    //格式化时间
    public static String formatTime(String time) {
        String realTem = time + ":00";
        return realTem;
    }


    //格式化温度
    public static String addTemSymbol2(String tem) {
        String realTem = tem + "°";
        return realTem;
    }

    public static final String[] ALARM_LEVEL = {"优", "良", "轻度污染", "中度污染", "重度污染", "严重污染"};

    //格式化空气质量
    public static String aqiType(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return ALARM_LEVEL[0];
        }
        if (aqi > 50 && aqi <= 100) {
            return ALARM_LEVEL[1];
        }
        if (aqi > 100 && aqi <= 150) {
            return ALARM_LEVEL[2];
        }
        if (aqi > 150 && aqi <= 200) {
            return ALARM_LEVEL[3];
        }
        if (aqi > 200 && aqi <= 300) {
            return ALARM_LEVEL[4];
        }
        if (aqi > 300) {
            return ALARM_LEVEL[5];
        }

        return ALARM_LEVEL[0];
    }


    //格式化空气质量
    public static int aqiBg(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return ColorUtil.AQI_COLOR[0];
        }
        if (aqi > 50 && aqi <= 100) {
            return ColorUtil.AQI_COLOR[1];
        }
        if (aqi > 100 && aqi <= 150) {
            return ColorUtil.AQI_COLOR[2];
        }
        if (aqi > 150 && aqi <= 200) {
            return ColorUtil.AQI_COLOR[3];
        }
        if (aqi > 200 && aqi <= 300) {
            return ColorUtil.AQI_COLOR[4];
        }
        if (aqi > 300) {
            return ColorUtil.AQI_COLOR[5];
        }

        return ColorUtil.AQI_COLOR[0];
    }


    //格式化空气质量
    public static int aqiPoint(int aqi) {
        if (aqi >= 0 && aqi <= 50) {
            return 1;
        }
        if (aqi > 50 && aqi <= 100) {
            return 3;
        }
        if (aqi > 100 && aqi <= 150) {
            return 5;
        }
        if (aqi > 150 && aqi <= 200) {
            return 7;
        }
        if (aqi > 200 && aqi <= 300) {
            return 9;
        }
        if (aqi > 300) {
            return 11;
        }

        return 1;
    }


    public static Drawable aqiTypeBg(int[] values, int aqi) {
        Resources resources = BaseApplication.getAppContext().getResources();
        Drawable drawable = null;
        if (aqi >= values[0] && aqi <= values[1]) {
            return drawable = resources.getDrawable(R.drawable.shape_air_a_bg);
        }
        if (aqi > values[1] && aqi <= values[2]) {
            return drawable = resources.getDrawable(R.drawable.shape_air_b_bg);
        }
        if (aqi > values[2] && aqi <= values[3]) {
            return drawable = resources.getDrawable(R.drawable.shape_air_c_bg);
        }
        if (aqi > values[3] && aqi <= values[4]) {
            return drawable = resources.getDrawable(R.drawable.shape_air_d_bg);
        }
        if (aqi > values[4] && aqi <= values[5]) {
            return drawable = resources.getDrawable(R.drawable.shape_air_e_bg);
        }
        if (aqi > values[5]) {
            return drawable = resources.getDrawable(R.drawable.shape_air_f_bg);
        }

        return resources.getDrawable(R.drawable.shape_air_a_bg);
    }


    //格式化天气类型
    public static String weatherPhenomena(String type) {
        State state = State.valueOf(type);
        if (state == State.CLEAR_DAY) {
            return "晴";
        }
        if (state == State.CLEAR_NIGHT) {
            return "晴";
        }
        if (state == State.PARTLY_CLOUDY_DAY) {
            return "多云";
        }
        if (state == State.PARTLY_CLOUDY_NIGHT) {
            return "多云";
        }
        if (state == State.LIGHT_HAZE) {
            return "轻度雾霾";
        }
        if (state == State.MODERATE_HAZE) {
            return "中度雾霾";
        }
        if (state == State.HEAVY_HAZE) {
            return "重度雾霾";
        }
        if (state == State.LIGHT_RAIN) {
            return "小雨";
        }
        if (state == State.MODERATE_RAIN) {
            return "中雨";
        }
        if (state == State.HEAVY_RAIN) {
            return "大雨";
        }
        if (state == State.STORM_RAIN) {
            return "暴雨";
        }
        if (state == State.LIGHT_SNOW) {
            return "小雪";
        }
        if (state == State.MODERATE_SNOW) {
            return "中雪";
        }
        if (state == State.HEAVY_SNOW) {
            return "大雪";
        }
        if (state == State.STORM_SNOW) {
            return "暴雪";
        }
        if (state == State.DUST) {
            return "浮尘";
        }
        if (state == State.SAND) {
            return "沙尘";
        }
        if (state == State.WIND) {
            return "大风";
        }
        if (state == State.FOG) {
            return "雾";
        }
        if (state == State.CLOUDY) {
            return "阴";
        }
        return "暂无";
    }

    /*    风力等级 	风速范围 （km/h） 	自然语言描述
    0级 	<1 	无风
    1级 	1-5 	微风徐徐
    2级 	6-11 	清风
    3级 	12-19 	树叶摇摆
    4级 	20-28 	树枝摇动
    5级 	29-38 	风力强劲
    6级 	39-49 	风力强劲
    7级 	50-61 	风力超强
    8级 	62-74 	狂风大作
    9级 	75-88 	狂风呼啸
    10级 	89-102 	暴风毁树
    11级 	103-117 	暴风毁树
    12级 	118-133 	飓风
    13级 	134-149 	台风
    14级 	150-166 	强台风
    15级 	167-183 	强台风
    16级 	184-201 	超强台风
    17级 	202-220 	超强台风*/

    //格式化风力等级
    public static String winType(double speed, boolean isBight) {
        sWinType.clear();
        if (isBight) {
            for (int i = 0; i < 18; i++) {
                sWinType.add(i + "级");
            }
        } else {
            for (int i = 0; i < 18; i++) {
                sWinType.add(i + "");
            }
        }


        if (speed < 1) {
            return sWinType.get(1);
        } else if (speed >= 1 && speed < 6) {
            return sWinType.get(1);
        } else if (speed >= 6 && speed < 11) {
            return sWinType.get(2);
        } else if (speed >= 11 && speed < 20) {
            return sWinType.get(3);
        } else if (speed >= 20 && speed < 29) {
            return sWinType.get(4);
        } else if (speed >= 29 && speed < 39) {
            return sWinType.get(5);
        } else if (speed >= 39 && speed < 50) {
            return sWinType.get(6);
        } else if (speed >= 50 && speed < 62) {
            return sWinType.get(7);
        } else if (speed >= 62 && speed < 75) {
            return sWinType.get(8);
        } else if (speed >= 75 && speed < 89) {
            return sWinType.get(9);
        } else if (speed >= 89 && speed < 103) {
            return sWinType.get(10);
        } else if (speed >= 103 && speed < 118) {
            return sWinType.get(11);
        } else if (speed >= 118 && speed < 134) {
            return sWinType.get(12);
        } else if (speed >= 134 && speed < 150) {
            return sWinType.get(13);
        } else if (speed >= 150 && speed < 167) {
            return sWinType.get(14);
        } else if (speed >= 167 && speed < 184) {
            return sWinType.get(15);
        } else if (speed >= 184 && speed < 202) {
            return sWinType.get(16);
        } else if (speed >= 202 && speed < 221) {
            return sWinType.get(17);
        }

        return "暂无";
    }

        /*    风向 	符号 	中心角度 	角度
    北 	N 	0 	            348.76-11.25
    北东北 	NNE 	22.5 	11.26-33.75
    东北 	NE 	45 	        33.76-56.25
    东东北 	ENE 	67.5 	56.26-78.75
    东 	E 	90             	78.76-101.25
    东东南 	ESE 	112.5 	101.26-123.75
    东南 	SE 	135 	    123.76-146.25
    南东南 	SSE 	157.5 	146.26-168.75
    南 	S 	180 	         168.76-191.25
    南西南 	 SSW 	202.5 	 191.26-213.75
    西南 	SW 	225 	      213.76-236.25
    西西南 	WSW 	247.5 	 236.26-258.75
    西 	W 	270             	258.76-281.25
    西西北 	WNW 	295.5 	 281.26-303.75
    西北 	NW 	315 	     303.76-326.25
    北西北 	NNW 	337.5 	  326.26-348.75*/


    //格式化风向
    public static String winDirection(double direction) {
        if (direction <= 11.25) {
            return sDirection[0];
        }
        if (direction >= 11.26 && direction <= 33.75) {
            return sDirection[1];
        }
        if (direction >= 33.76 && direction <= 56.25) {
            return sDirection[2];
        }
        if (direction >= 56.26 && direction <= 78.75) {
            return sDirection[3];
        }
        if (direction >= 78.76 && direction <= 101.25) {
            return sDirection[4];
        }
        if (direction >= 101.26 && direction <= 123.75) {
            return sDirection[5];
        }
        if (direction >= 123.76 && direction <= 146.25) {
            return sDirection[6];
        }
        if (direction >= 146.26 && direction <= 168.75) {
            return sDirection[7];
        }
        if (direction >= 168.76 && direction <= 191.25) {
            return sDirection[8];
        }
        if (direction >= 191.26 && direction <= 213.75) {
            return sDirection[9];
        }
        if (direction >= 213.76 && direction <= 236.25) {
            return sDirection[10];
        }
        if (direction >= 236.26 && direction <= 258.75) {
            return sDirection[11];
        }
        if (direction >= 258.76 && direction <= 281.25) {
            return sDirection[12];
        }
        if (direction >= 281.26 && direction <= 303.75) {
            return sDirection[13];
        }
        if (direction >= 303.76 && direction <= 326.25) {
            return sDirection[14];
        }
        if (direction >= 326.26 && direction <= 348.75) {
            return sDirection[15];
        }
        if (direction >= 348.76) {
            return sDirection[0];
        }
        return "暂无";
    }


}
