package com.nanjing.tqlhl.utils;

import com.nanjing.tqlhl.base.BaseApplication;

public class Contents {

    //天气图片
    public static final String MJ_BG = "mj_bg";
    public static final String MJ_ICON = "mj_icon";
    public static final String MJ_LAGER_ICON = "mj_lager_icon";
    public static final String MJ_COLOR= "mj_color";

    public static final String MJ_Day = "mj_day";
    public static final String MJ_Night = "mj_night";

    //---------------------SP------------------
    public static final String  SP_CACHE_TIME="SP_CACHE_TIME";

    public static final String  SP_AGREE="SP_AGREE";



    //黄历key
    public static final String HUANG_LI_KEY="5bc896feb96a91a619c72937e88c10a3";



    public static final String MJ_API = "mj_api";
    public static final String MJ_API5 = "mj_api5";
    public static final String MJ_DAY15 = "mj_day15";
    public static final String MJ_HOURS24 = "mj_hours24";
    public static final String HL_DATA = "hl_data";
    public static final String Mj_Real_DATA = "mj_real_data";
    public static final String MSTATUSZWX = "mstatuszwx";
    public static final String MAQITYPE = "mAqiType";
    public static final String MJ_LOW_HIGH = "mj_low_high";


    //支付参数
    public static final String TRADE = "trade";//订单号
    public static final String SUBJECT = "subject";//标题
    public static final String PRICE = "price";//价格
    public static final String BODY = "body";//内容

    //是否是购买页面
    public static final String BUY_PAGER_SP="buy_pager_sp";
    public static final String BUY_PAGER="buy_pager";

    //购买信息
    public static final String VIP13 = "VIP13";
    public static final String VIP12 = "VIP12";
    public static final String VIP3 = "VIP3";
    public static final String VIP1 = "VIP1";

    public static final String VIP_title_13 = "永久卡";
    public static final String VIP_title_12 = "年卡";
    public static final String VIP_title_3 = "季卡";
    public static final String VIP_title_1 = "月卡";

    public static final String VIP_hint_13 = "原价:￥30";
    public static final String VIP_hint_12 = "原价:￥20";
    public static final String VIP_hint_3 = "原价:￥10";
    public static final String VIP_hint_1 = "原价:￥5";



/*    public static final double VIP_price_13 = 18;
    public static final double VIP_price_12 = 17.99;
    public static final double VIP_price_3 = 16.99;
    public static final double VIP_price_1 = 19;*/

    //test
    public static final double VIP_price_13 = 0.01;
    public static final double VIP_price_12 = 0.01;
    public static final double VIP_price_3 = 0.01;
    public static final double VIP_price_1 = 0.01;

    //支付
    public static final String PAY_WX_URL = "http://www.aisou.club/pay/wxh5/dafa.php?";
    public static final String PAY_ALI_URL = "http://www.aisou.club/pay/aliv2/wappay/pay.php?";
    //ali_pay
    public static final String ALI_PAY = "ALI";
    //wx_pay
    public static final String WX_PAY = "WX";


    //包名
    public static final String APP_PACKAGE = PackageUtil.getAppProcessName(BaseApplication.getApplication());




    //App名称
    public static final String AppNAME =PackageUtil.getAppMetaData(BaseApplication.getApplication(),"APP_NAME");

    public static final String PLATFORM_KEY = "CHANNEL";


    //QQ  id
    public static final String QQ_ID = "1111029692";

    //微信
    public static final String WECHAT_APP_ID = "wxf26ff2197b2eae1e";
    public static final String WECHAT_SECRET = "25606995b0749edae27ef662a7ebf733";
    public static final String WXAPPID = "appid";
    public static final String WXSECRET = "secret";
    public static final String WXACODE = "code";
    public static final String WXTYPE = "grant_type";

    //广告接口
    public static final String AD_NAME = "name";
    public static final String AD_VERSION = "version";
    public static final String AD_VERSION_VALUES = PackageUtil.packageCode2(BaseApplication.getApplication());
    public static final String AD_CHANNEL = "channel";

    //广告接口缓存
    public static final String AD_INFO_SP = "ad_info";
    public static final String AD_INFO = "ad";


    //广告key
    //TT
    public static final String KT_OUTIAO_APPKEY = "kTouTiaoAppKey";
    public static final String KT_OUTIAO_KAIPING = "kTouTiaoKaiPing";
    public static final String KT_OUTIAO_BANNERKEY = "kTouTiaoBannerKey";
    public static final String KT_OUTIAO_CHAPINGKEY = "kTouTiaoChaPingKey";
    public static final String KT_OUTIAO_SENIORKEY = "kTouTiaoSeniorKey";
    public static final String KT_OUTIAO_JILIKEY = "kTouTiaoJiLiKey";

    //TX
    public static final String KGDT_MOBSDK_APPKEY = "kGDTMobSDKAppKey";
    public static final String KGDT_MOBSDK_CHAPINGKEY = "kGDTMobSDKChaPingKey";
    public static final String KGDT_MOBSDK_KAIPINGKEY = "kGDTMobSDKKaiPingKey";
    public static final String KGDT_MOBSDK_BANNERKEY = "kGDTMobSDKBannerKey";
    public static final String KGDT_MOBSDK_NATIVEKEY = "kGDTMobSDKNativeKey";
    public static final String KGDT_MOBSDK_JILIKEY = "kGDTMobSDKJiLiKey";


    //储存用户信息
    public static final String LOCAL_TYPE = "2";//本地登陆
    public static final String USER_INFO = "user_info";
    public static final String USER_ID = "id";
    public static final String USER_IS_LOGIN = "isLogin";
    public static final String USER_ID_TYPE= "id_type";
    public static final String USER_ACCOUNT= "user_account";
    public static final String USER_PWD= "user_pwd";
    public static final String USER_THIRDLY_OPENID= "user_thirdly_openid";
    public static final String USER_VIP_LEVEL = "vip_level";
    public static final String USER_VIP_TIME = "vip_time";
    public static final String USER_LOGIN_TIME = "user_login_time";

    public static final String LOCATION_CITY="ssfdfsa";
    //第一次启动
    public static final String IS_FIRST = "one";
    public static final String FIRST_LOCATION = "first_location";
    public static final String FIRST_ADD= "first_add";


    //存在当前位置信息
    public static final String CURRENT_CITY = "city";
    public static final String CURRENT_LONG = "longitude";
    public static final String CURRENT_LAT = "latitude";

    //是否开启后台信息
    public static final String NO_BACK_SP = "no_back_sp";
    public static final String NO_BACK = "no_back";



    public static final String SERVICE = "service";//接口名
    public static final String MOBILE = "mobile";//电话
    public static final String PACKAGE = "package";//包名
    public static final String SIGNATURE = "signature";//验证码
    public static final String NONCE = "nonce";//随机数
    public static final String TIMESTAMP = "timestamp";//时间戳
    public static final String TOKEN = "^x389fhfeahykge";//token值


    public static final String QQ_TYPE = "1";//QQ
    public static final String WECHAT_TYPE = "0";//微信
    public static final String OPENID = "openId";//openId
    public static final String TYPE = "type";//openId
    public static final String CODE = "code";//验证码
    public static final String VER = "ver";//软件版本
    public static final String PLATFORM = "platform";//平台
    public static final String PASSWORD = "password";//密码
    public static final String APP_NAME = "appname";//app名
    public static final String PACK_NAME = "packname";//包名
    public static final String CHANNEL_ID = "channelId";//渠道号




    public static final String HOURLY24="hourly24";
    public static final String HOURLYREAL = "hourlyreal";

    public static final String AQI_FORECAST = "maqiforecast";
    public static final String DATA_AQI = "mdataaqi";
    public static final String DAY15_WEATHER = "mday15weather";
    public static final String HUANGLI_DATA = "huangli_data";
    public static final String CHANGE_CITY = "change_city";

    public static final String SIMULATE_AQI = "simulate_aqi";
    public static final String SIMULATE_AQI15 = "simulate_aqi15";

}
