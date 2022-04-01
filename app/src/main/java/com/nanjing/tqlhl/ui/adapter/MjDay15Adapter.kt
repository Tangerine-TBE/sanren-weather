package com.nanjing.tqlhl.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.nanjing.tqlhl.R
import com.nanjing.tqlhl.caiyun.DailyWeather
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean
import com.nanjing.tqlhl.utils.Contents
import com.nanjing.tqlhl.utils.DateUtil
import com.nanjing.tqlhl.utils.WeatherUtils

import kotlinx.android.synthetic.main.item_day15_container.view.*

/**
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.adapter
 * @class describe
 * @author wujinming QQ:1245074510
 * @time 2020/10/20 14:01
 * @class describe
 */
class MjDay15Adapter : BaseQuickAdapter<DailyWeather.DailyNeedData, BaseViewHolder>(R.layout.item_day15_container) {
    override fun convert(helper: BaseViewHolder?, item: DailyWeather.DailyNeedData?) {
        item?.let {
            helper?.itemView?.apply {
                mDate.text = it.date
                mWeek.text = it.week
                mTep.text = ""+it.getMinTem()+"°" + "~" + it.getMaxTem()+"°"

                    mWea.setImageResource(it.getSkyconIcon())
                    mTvWea.text=it.getSkyconDes()

            }
        }

    }
}