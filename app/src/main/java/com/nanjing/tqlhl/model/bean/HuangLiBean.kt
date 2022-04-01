package com.nanjing.tqlhl.model.bean

import java.text.SimpleDateFormat
import java.util.*

class HuangLiBean {
    /**
     * {status : 0
     * msg : ok
     * result : {"year":"2016","month":"10","day":"1","yangli":"公元2016年10月01日","nongli":"农历二〇一六年九月初一","star":"天枰座","taishen":"厨灶栖外正东","wuxing":"沙中土","chong":"冲（庚戌）狗","sha":"煞南","shengxiao":"猴","jiri":"天刑（黑道）危日","zhiri":"天刑（黑道凶日）","xiongshen":"月煞 月虚 四击 天刑","jishenyiqu":"母仓 六合 敬安","caishen":"西南","xishen":"西南","fushen":"正东","suici":["丙申年","丁酉月","丙辰日"],"yi":["订盟","纳采","祭祀","祈福","安香","出火","修造","动土","上梁","安门","起基","竖柱","上梁","定磉","开池","移徙","入宅","立券","破土"],"ji":["嫁娶","造庙","造桥","造船","作灶","安葬"],"eweek":"SATURDAY","emonth":"October","week":"六"}
     * }
     */
//    var reason = 0
    var reason: String? = null
    var result: ResultBean? = null

    class ResultBean {
        /**
         * year : 2016
         * month : 10
         * day : 1
         * yangli : 公元2016年10月01日
         * nongli : 农历二〇一六年九月初一
         * star : 天枰座
         * taishen : 厨灶栖外正东
         * wuxing : 沙中土
         * chong : 冲（庚戌）狗
         * sha : 煞南
         * shengxiao : 猴
         * jiri : 天刑（黑道）危日
         * zhiri : 天刑（黑道凶日）
         * xiongshen : 月煞 月虚 四击 天刑
         * jishenyiqu : 母仓 六合 敬安
         * caishen : 西南
         * xishen : 西南
         * fushen : 正东
         * suici : ["丙申年","丁酉月","丙辰日"]
         * yi : ["订盟","纳采","祭祀","祈福","安香","出火","修造","动土","上梁","安门","起基","竖柱","上梁","定磉","开池","移徙","入宅","立券","破土"]
         * ji : ["嫁娶","造庙","造桥","造船","作灶","安葬"]
         * eweek : SATURDAY
         * emonth : October
         * week : 六
         */

        /**
         * {
        "reason": "successed",
        "result": {
        "id": "2416",
        "yangli": "2016-10-01",
        "yinli": "丙申(猴)年九月初一",
        "wuxing": "沙中土 危执位",
        "chongsha": "冲狗(庚戍)煞南",
        "baiji": "丙不修灶必见灾殃 辰不哭泣必主重丧",
        "jishen": "母仓 六合 敬安",
        "yi": "订盟 纳采 祭祀 祈福 安香 出火 修造 动土 上梁 安门 起基 竖柱 上梁 定磉 开池 移徙 入宅 立券 破土",
        "xiongshen": "月煞 月虚 四击 天刑",
        "ji": "嫁娶 造庙 造桥 造船 作灶 安葬"
        },
        "error_code": 0
        }
         */
//        var year: String? = null
//        var month: String? = null
//        var day: String? = null
        var yangli: String? = null
        var yinli: String? = null
//        var star: String? = null
//        var taishen: String? = null
        var wuxing: String? = null
        var chongsha: String? = null
//        var sha: String? = null
//        var shengxiao: String? = null
//        var jiri: String? = null
//        var zhiri: String? = null
        var xiongshen: String? = null
        var jishen: String? = null
//        var caishen: String? = null
//        var xishen: String? = null
//        var fushen: String? = null
//        var eweek: String? = null
//        var emonth: String? = null
//        var week: String? = null
//        var suici: List<String>? = null

        //["订盟","纳采","祭祀","祈福","安香","出火","修造","动土","上梁","安门","起基","竖柱","上梁","定磉","开池","移徙","入宅","立券","破土"]
        //"订盟 纳采 祭祀 祈福 安香 出火 修造 动土 上梁 安门 起基 竖柱 上梁 定磉 开池 移徙 入宅 立券 破土"
        var yi: String? = null
        fun getYiList():List<String>{
            return yi?.split(" ")?: emptyList()
        }

        //["嫁娶","造庙","造桥","造船","作灶","安葬"]
        //"嫁娶 造庙 造桥 造船 作灶 安葬"
        var ji: String? = null
        fun getJiList():List<String>{
            return ji?.split(" ")?: emptyList()
        }

        companion object{
            private val shengxiaoList = arrayOf("鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪")
            private val simpleDateFormat by lazy {
                SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
            }
        }
        fun getShengxiao():String{
            return shengxiaoList.find {
                yinli?.contains(it)==true
            }?:"未知"
        }
        fun getWeek():String{
            return yangli?.let {
                val cal=Calendar.getInstance()
                val date=simpleDateFormat.parse(it)
                if (date!=null) {
                    cal.time = date
                    when(cal.get(Calendar.DAY_OF_WEEK)){
                        Calendar.SUNDAY->{
                            "日"
                        }
                        Calendar.MONDAY->{
                            "一"
                        }
                        Calendar.TUESDAY->{
                            "二"
                        }
                        Calendar.WEDNESDAY->{
                            "三"
                        }
                        Calendar.THURSDAY->{
                            "四"
                        }
                        Calendar.FRIDAY->{
                            "五"
                        }
                        Calendar.SATURDAY->{
                            "六"
                        }
                        else->{
                            "未知"
                        }
                    }
                }else{
                    null
                }
            }?:"未知"
        }
        fun getDay():String{
            return yangli?.let {
                val cal=Calendar.getInstance()
                val date=simpleDateFormat.parse(it)
                if (date!=null) {
                    cal.time = date
                    cal.get(Calendar.DAY_OF_MONTH).toString()
                }else{
                    null
                }
            }?:"未知"
        }
        fun getSha():String{
            return chongsha?.let {
                it.substring(it.indexOf('煞'))
            }?:"未知"
        }
    }
}