package com.nanjing.tqlhl.model.bean;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.model.bean
 * @class describe
 * @time 2020/9/23 19:49
 * @class describe
 */
public class ad {


    /**
     * code : 0
     * message : 请求成功
     * data : {"start_page":{"spread_screen":{"status":true,"ad_origin":"gdt_toutiao","times":1,"change_times":300,"ad_percent":"0_100"}},"home_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}},"city_manager_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"tool_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"housingloan_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"setting_page":{"incentive_video":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"exit_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}},"Advertisement":{"kTouTiaoAppKey":"5107883","kTouTiaoKaiPing":"887384388","kTouTiaoBannerKey":"945503212","kTouTiaoChaPingKey":"945503213","kTouTiaoJiLiKey":"945503219","kTouTiaoSeniorKey":"945503208","kGDTMobSDKAppKey":"1111042634","kGDTMobSDKChaPingKey":"7011630405645959","kGDTMobSDKKaiPingKey":"6091431425240845","kGDTMobSDKBannerKey":"9081136485443914","kGDTMobSDKNativeKey":"4071435465141808","kGDTMobSDKJiLiKey":"6081139435845962"}}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * start_page : {"spread_screen":{"status":true,"ad_origin":"gdt_toutiao","times":1,"change_times":300,"ad_percent":"0_100"}}
         * home_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}}
         * city_manager_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * tool_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * housingloan_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * setting_page : {"incentive_video":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * exit_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}}
         * Advertisement : {"kTouTiaoAppKey":"5107883","kTouTiaoKaiPing":"887384388","kTouTiaoBannerKey":"945503212","kTouTiaoChaPingKey":"945503213","kTouTiaoJiLiKey":"945503219","kTouTiaoSeniorKey":"945503208","kGDTMobSDKAppKey":"1111042634","kGDTMobSDKChaPingKey":"7011630405645959","kGDTMobSDKKaiPingKey":"6091431425240845","kGDTMobSDKBannerKey":"9081136485443914","kGDTMobSDKNativeKey":"4071435465141808","kGDTMobSDKJiLiKey":"6081139435845962"}
         */

        private StartPageBean start_page;
        private HomePageBean home_page;
        private CityManagerPageBean city_manager_page;
        private ToolPageBean tool_page;
        private HousingloanPageBean housingloan_page;
        private SettingPageBean setting_page;
        private ExitPageBean exit_page;
        private AdvertisementBean Advertisement;

        public StartPageBean getStart_page() {
            return start_page;
        }

        public void setStart_page(StartPageBean start_page) {
            this.start_page = start_page;
        }

        public HomePageBean getHome_page() {
            return home_page;
        }

        public void setHome_page(HomePageBean home_page) {
            this.home_page = home_page;
        }

        public CityManagerPageBean getCity_manager_page() {
            return city_manager_page;
        }

        public void setCity_manager_page(CityManagerPageBean city_manager_page) {
            this.city_manager_page = city_manager_page;
        }

        public ToolPageBean getTool_page() {
            return tool_page;
        }

        public void setTool_page(ToolPageBean tool_page) {
            this.tool_page = tool_page;
        }

        public HousingloanPageBean getHousingloan_page() {
            return housingloan_page;
        }

        public void setHousingloan_page(HousingloanPageBean housingloan_page) {
            this.housingloan_page = housingloan_page;
        }

        public SettingPageBean getSetting_page() {
            return setting_page;
        }

        public void setSetting_page(SettingPageBean setting_page) {
            this.setting_page = setting_page;
        }

        public ExitPageBean getExit_page() {
            return exit_page;
        }

        public void setExit_page(ExitPageBean exit_page) {
            this.exit_page = exit_page;
        }

        public AdvertisementBean getAdvertisement() {
            return Advertisement;
        }

        public void setAdvertisement(AdvertisementBean Advertisement) {
            this.Advertisement = Advertisement;
        }

        public static class StartPageBean {
            /**
             * spread_screen : {"status":true,"ad_origin":"gdt_toutiao","times":1,"change_times":300,"ad_percent":"0_100"}
             */

            private SpreadScreenBean spread_screen;

            public SpreadScreenBean getSpread_screen() {
                return spread_screen;
            }

            public void setSpread_screen(SpreadScreenBean spread_screen) {
                this.spread_screen = spread_screen;
            }

            public static class SpreadScreenBean {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 1
                 * change_times : 300
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }
        }

        public static class HomePageBean {
            /**
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             */

            private NativeScreenBean native_screen;

            public NativeScreenBean getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBean native_screen) {
                this.native_screen = native_screen;
            }

            public static class NativeScreenBean {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 5
                 * change_times : 10
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }
        }

        public static class CityManagerPageBean {
            /**
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * banner_screen : {"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}
             */

            private NativeScreenBeanX native_screen;
            private BannerScreenBean banner_screen;

            public NativeScreenBeanX getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBeanX native_screen) {
                this.native_screen = native_screen;
            }

            public BannerScreenBean getBanner_screen() {
                return banner_screen;
            }

            public void setBanner_screen(BannerScreenBean banner_screen) {
                this.banner_screen = banner_screen;
            }

            public static class NativeScreenBeanX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 5
                 * change_times : 10
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }

            public static class BannerScreenBean {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 200
                 * change_times : 300
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }
        }

        public static class ToolPageBean {
            /**
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * banner_screen : {"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}
             */

            private NativeScreenBeanXX native_screen;
            private BannerScreenBeanX banner_screen;

            public NativeScreenBeanXX getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBeanXX native_screen) {
                this.native_screen = native_screen;
            }

            public BannerScreenBeanX getBanner_screen() {
                return banner_screen;
            }

            public void setBanner_screen(BannerScreenBeanX banner_screen) {
                this.banner_screen = banner_screen;
            }

            public static class NativeScreenBeanXX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 5
                 * change_times : 10
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }

            public static class BannerScreenBeanX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 200
                 * change_times : 300
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }
        }

        public static class HousingloanPageBean {
            /**
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * banner_screen : {"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}
             */

            private NativeScreenBeanXXX native_screen;
            private BannerScreenBeanXX banner_screen;

            public NativeScreenBeanXXX getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBeanXXX native_screen) {
                this.native_screen = native_screen;
            }

            public BannerScreenBeanXX getBanner_screen() {
                return banner_screen;
            }

            public void setBanner_screen(BannerScreenBeanXX banner_screen) {
                this.banner_screen = banner_screen;
            }

            public static class NativeScreenBeanXXX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 5
                 * change_times : 10
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }

            public static class BannerScreenBeanXX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 200
                 * change_times : 300
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }
        }

        public static class SettingPageBean {
            /**
             * incentive_video : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * banner_screen : {"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}
             */

            private IncentiveVideoBean incentive_video;
            private NativeScreenBeanXXXX native_screen;
            private BannerScreenBeanXXX banner_screen;

            public IncentiveVideoBean getIncentive_video() {
                return incentive_video;
            }

            public void setIncentive_video(IncentiveVideoBean incentive_video) {
                this.incentive_video = incentive_video;
            }

            public NativeScreenBeanXXXX getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBeanXXXX native_screen) {
                this.native_screen = native_screen;
            }

            public BannerScreenBeanXXX getBanner_screen() {
                return banner_screen;
            }

            public void setBanner_screen(BannerScreenBeanXXX banner_screen) {
                this.banner_screen = banner_screen;
            }

            public static class IncentiveVideoBean {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 5
                 * change_times : 10
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }

            public static class NativeScreenBeanXXXX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 5
                 * change_times : 10
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }

            public static class BannerScreenBeanXXX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 200
                 * change_times : 300
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }
        }

        public static class ExitPageBean {
            /**
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             */

            private NativeScreenBeanXXXXX native_screen;

            public NativeScreenBeanXXXXX getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBeanXXXXX native_screen) {
                this.native_screen = native_screen;
            }

            public static class NativeScreenBeanXXXXX {
                /**
                 * status : true
                 * ad_origin : gdt_toutiao
                 * times : 5
                 * change_times : 10
                 * ad_percent : 0_100
                 */

                private boolean status;
                private String ad_origin;
                private int times;
                private int change_times;
                private String ad_percent;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getAd_origin() {
                    return ad_origin;
                }

                public void setAd_origin(String ad_origin) {
                    this.ad_origin = ad_origin;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public int getChange_times() {
                    return change_times;
                }

                public void setChange_times(int change_times) {
                    this.change_times = change_times;
                }

                public String getAd_percent() {
                    return ad_percent;
                }

                public void setAd_percent(String ad_percent) {
                    this.ad_percent = ad_percent;
                }
            }
        }

        public static class AdvertisementBean {
            /**
             * kTouTiaoAppKey : 5107883
             * kTouTiaoKaiPing : 887384388
             * kTouTiaoBannerKey : 945503212
             * kTouTiaoChaPingKey : 945503213
             * kTouTiaoJiLiKey : 945503219
             * kTouTiaoSeniorKey : 945503208
             * kGDTMobSDKAppKey : 1111042634
             * kGDTMobSDKChaPingKey : 7011630405645959
             * kGDTMobSDKKaiPingKey : 6091431425240845
             * kGDTMobSDKBannerKey : 9081136485443914
             * kGDTMobSDKNativeKey : 4071435465141808
             * kGDTMobSDKJiLiKey : 6081139435845962
             */

            private String kTouTiaoAppKey;
            private String kTouTiaoKaiPing;
            private String kTouTiaoBannerKey;
            private String kTouTiaoChaPingKey;
            private String kTouTiaoJiLiKey;
            private String kTouTiaoSeniorKey;
            private String kGDTMobSDKAppKey;
            private String kGDTMobSDKChaPingKey;
            private String kGDTMobSDKKaiPingKey;
            private String kGDTMobSDKBannerKey;
            private String kGDTMobSDKNativeKey;
            private String kGDTMobSDKJiLiKey;

            public String getKTouTiaoAppKey() {
                return kTouTiaoAppKey;
            }

            public void setKTouTiaoAppKey(String kTouTiaoAppKey) {
                this.kTouTiaoAppKey = kTouTiaoAppKey;
            }

            public String getKTouTiaoKaiPing() {
                return kTouTiaoKaiPing;
            }

            public void setKTouTiaoKaiPing(String kTouTiaoKaiPing) {
                this.kTouTiaoKaiPing = kTouTiaoKaiPing;
            }

            public String getKTouTiaoBannerKey() {
                return kTouTiaoBannerKey;
            }

            public void setKTouTiaoBannerKey(String kTouTiaoBannerKey) {
                this.kTouTiaoBannerKey = kTouTiaoBannerKey;
            }

            public String getKTouTiaoChaPingKey() {
                return kTouTiaoChaPingKey;
            }

            public void setKTouTiaoChaPingKey(String kTouTiaoChaPingKey) {
                this.kTouTiaoChaPingKey = kTouTiaoChaPingKey;
            }

            public String getKTouTiaoJiLiKey() {
                return kTouTiaoJiLiKey;
            }

            public void setKTouTiaoJiLiKey(String kTouTiaoJiLiKey) {
                this.kTouTiaoJiLiKey = kTouTiaoJiLiKey;
            }

            public String getKTouTiaoSeniorKey() {
                return kTouTiaoSeniorKey;
            }

            public void setKTouTiaoSeniorKey(String kTouTiaoSeniorKey) {
                this.kTouTiaoSeniorKey = kTouTiaoSeniorKey;
            }

            public String getKGDTMobSDKAppKey() {
                return kGDTMobSDKAppKey;
            }

            public void setKGDTMobSDKAppKey(String kGDTMobSDKAppKey) {
                this.kGDTMobSDKAppKey = kGDTMobSDKAppKey;
            }

            public String getKGDTMobSDKChaPingKey() {
                return kGDTMobSDKChaPingKey;
            }

            public void setKGDTMobSDKChaPingKey(String kGDTMobSDKChaPingKey) {
                this.kGDTMobSDKChaPingKey = kGDTMobSDKChaPingKey;
            }

            public String getKGDTMobSDKKaiPingKey() {
                return kGDTMobSDKKaiPingKey;
            }

            public void setKGDTMobSDKKaiPingKey(String kGDTMobSDKKaiPingKey) {
                this.kGDTMobSDKKaiPingKey = kGDTMobSDKKaiPingKey;
            }

            public String getKGDTMobSDKBannerKey() {
                return kGDTMobSDKBannerKey;
            }

            public void setKGDTMobSDKBannerKey(String kGDTMobSDKBannerKey) {
                this.kGDTMobSDKBannerKey = kGDTMobSDKBannerKey;
            }

            public String getKGDTMobSDKNativeKey() {
                return kGDTMobSDKNativeKey;
            }

            public void setKGDTMobSDKNativeKey(String kGDTMobSDKNativeKey) {
                this.kGDTMobSDKNativeKey = kGDTMobSDKNativeKey;
            }

            public String getKGDTMobSDKJiLiKey() {
                return kGDTMobSDKJiLiKey;
            }

            public void setKGDTMobSDKJiLiKey(String kGDTMobSDKJiLiKey) {
                this.kGDTMobSDKJiLiKey = kGDTMobSDKJiLiKey;
            }
        }
    }
}
