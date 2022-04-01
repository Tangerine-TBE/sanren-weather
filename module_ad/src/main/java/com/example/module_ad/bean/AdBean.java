package com.example.module_ad.bean;

import com.example.module_ad.BuildConfig;
import com.example.module_ad.base.IBaseAdBean;
import com.example.module_ad.base.IBaseXXBean;

public class AdBean {


    /**
     * code : 0
     * message : 请求成功
     * data : {"start_page":{"spread_screen":{"status":true,"ad_origin":"gdt_toutiao","times":1,"change_times":300,"ad_percent":"0_100"}},"home_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}},"city_manager_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"airquality_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"temperature_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"housingloan_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"setting_page":{"incentive_video":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}},"exit_page":{"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}},"Advertisement":{"kTouTiaoAppKey":"5091408","kTouTiaoKaiPing":"887356266","kTouTiaoBannerKey":"945346625","kTouTiaoChaPingKey":"945346711","kTouTiaoJiLiKey":"945349182","kTouTiaoSeniorKey":"945348027","kGDTMobSDKAppKey":"1110657167","kGDTMobSDKChaPingKey":"3061624292821499","kGDTMobSDKKaiPingKey":"7011221282501342","kGDTMobSDKBannerKey":"8001721242218340","kGDTMobSDKNativeKey":"1041424292506364","kGDTMobSDKJiLiKey":"7021827242606462"}}
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
         * airquality_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * temperature_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * housingloan_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * setting_page : {"incentive_video":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"},"banner_screen":{"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}}
         * exit_page : {"native_screen":{"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}}
         * Advertisement : {"kTouTiaoAppKey":"5091408","kTouTiaoKaiPing":"887356266","kTouTiaoBannerKey":"945346625","kTouTiaoChaPingKey":"945346711","kTouTiaoJiLiKey":"945349182","kTouTiaoSeniorKey":"945348027","kGDTMobSDKAppKey":"1110657167","kGDTMobSDKChaPingKey":"3061624292821499","kGDTMobSDKKaiPingKey":"7011221282501342","kGDTMobSDKBannerKey":"8001721242218340","kGDTMobSDKNativeKey":"1041424292506364","kGDTMobSDKJiLiKey":"7021827242606462"}
         */

        private StartPageBean start_page;
        private HomePageBean home_page;
        private CityManagerPageBean city_manager_page;
        private AirqualityPageBean airquality_page;
        private TemperaturePageBean temperature_page;
        private HousingloanPageBean housingloan_page;
        private SettingPageBean setting_page;
        private ExitPageBean exit_page;
        private AdvertisementBean Advertisement;
        private ToolPageBean tools_page;


        public ToolPageBean getTool_page() {
            return tools_page;
        }

        public void setTool_page(ToolPageBean tool_page) {
            this.tools_page = tool_page;
        }

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

        public AirqualityPageBean getAirquality_page() {
            return airquality_page;
        }

        public void setAirquality_page(AirqualityPageBean airquality_page) {
            this.airquality_page = airquality_page;
        }

        public TemperaturePageBean getTemperature_page() {
            return temperature_page;
        }

        public void setTemperature_page(TemperaturePageBean temperature_page) {
            this.temperature_page = temperature_page;
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


        public static class ToolPageBean implements IBaseAdBean {
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

            @Override
            public IBaseXXBean getBaseBanner_screen() {
                return banner_screen;
            }

            @Override
            public IBaseXXBean getBaseNative_screen() {
                return native_screen;
            }

            public static class NativeScreenBeanXX implements IBaseXXBean{
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }

            public static class BannerScreenBeanX implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }
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
                    if (BuildConfig.DEBUG){
                        return false;
                    }
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

        public static class CityManagerPageBean  implements IBaseAdBean {
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

            @Override
            public IBaseXXBean getBaseBanner_screen() {
                return banner_screen;
            }

            @Override
            public IBaseXXBean getBaseNative_screen() {
                return native_screen;
            }

            public static class NativeScreenBeanX  implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }

            public static class BannerScreenBean  implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }
        }

        public static class AirqualityPageBean implements IBaseAdBean {
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

            @Override
            public IBaseXXBean getBaseBanner_screen() {
                return banner_screen;
            }

            @Override
            public IBaseXXBean getBaseNative_screen() {
                return native_screen;
            }

            public static class NativeScreenBeanXX implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }

            public static class BannerScreenBeanX implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }
        }

        public static class TemperaturePageBean  implements IBaseAdBean {
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

            @Override
            public IBaseXXBean getBaseBanner_screen() {
                return banner_screen;
            }

            @Override
            public IBaseXXBean getBaseNative_screen() {
                return native_screen;
            }

            public static class NativeScreenBeanXXX implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }

            public static class BannerScreenBeanXX implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                   return status;
                }
            }
        }

        public static class HousingloanPageBean  implements IBaseAdBean {
            /**
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * banner_screen : {"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}
             */

            private NativeScreenBeanXXXX native_screen;
            private BannerScreenBeanXXX banner_screen;

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

            @Override
            public IBaseXXBean getBaseBanner_screen() {
                return banner_screen;
            }

            @Override
            public IBaseXXBean getBaseNative_screen() {
                return native_screen;
            }

            public static class NativeScreenBeanXXXX  implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }

            public static class BannerScreenBeanXXX  implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }
        }

        public static class SettingPageBean implements IBaseAdBean {
            /**
             * incentive_video : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             * banner_screen : {"status":true,"ad_origin":"gdt_toutiao","times":200,"change_times":300,"ad_percent":"0_100"}
             */

            private IncentiveVideoBean incentive_video;
            private NativeScreenBeanXXXXX native_screen;
            private BannerScreenBeanXXXX banner_screen;

            public IncentiveVideoBean getIncentive_video() {
                return incentive_video;
            }

            public void setIncentive_video(IncentiveVideoBean incentive_video) {
                this.incentive_video = incentive_video;
            }

            public NativeScreenBeanXXXXX getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBeanXXXXX native_screen) {
                this.native_screen = native_screen;
            }

            public BannerScreenBeanXXXX getBanner_screen() {
                return banner_screen;
            }

            public void setBanner_screen(BannerScreenBeanXXXX banner_screen) {
                this.banner_screen = banner_screen;
            }

            @Override
            public IBaseXXBean getBaseBanner_screen() {
                return banner_screen;
            }

            @Override
            public IBaseXXBean getBaseNative_screen() {
                return native_screen;
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

            public static class NativeScreenBeanXXXXX implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }

            public static class BannerScreenBeanXXXX  implements IBaseXXBean {
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

                @Override
                public String getBaseAd_percent() {
                    return ad_percent;
                }

                @Override
                public boolean isBaseStatus() {
                    return status;
                }
            }
        }

        public static class ExitPageBean {
            /**
             * native_screen : {"status":true,"ad_origin":"gdt_toutiao","times":5,"change_times":10,"ad_percent":"0_100"}
             */

            private NativeScreenBeanXXXXXX native_screen;

            public NativeScreenBeanXXXXXX getNative_screen() {
                return native_screen;
            }

            public void setNative_screen(NativeScreenBeanXXXXXX native_screen) {
                this.native_screen = native_screen;
            }

            public static class NativeScreenBeanXXXXXX {
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
             * kTouTiaoAppKey : 5091408
             * kTouTiaoKaiPing : 887356266
             * kTouTiaoBannerKey : 945346625
             * kTouTiaoChaPingKey : 945346711
             * kTouTiaoJiLiKey : 945349182
             * kTouTiaoSeniorKey : 945348027
             * kGDTMobSDKAppKey : 1110657167
             * kGDTMobSDKChaPingKey : 3061624292821499
             * kGDTMobSDKKaiPingKey : 7011221282501342
             * kGDTMobSDKBannerKey : 8001721242218340
             * kGDTMobSDKNativeKey : 1041424292506364
             * kGDTMobSDKJiLiKey : 7021827242606462
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
