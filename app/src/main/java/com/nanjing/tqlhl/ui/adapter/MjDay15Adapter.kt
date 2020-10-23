package com.nanjing.tqlhl.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.nanjing.tqlhl.R
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean
import com.nanjing.tqlhl.utils.ChangeBgUtil
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
class MjDay15Adapter : BaseQuickAdapter<Mj15DayWeatherBean.DataBean.ForecastBean, BaseViewHolder>(R.layout.item_day15_container) {
    override fun convert(helper: BaseViewHolder?, item: Mj15DayWeatherBean.DataBean.ForecastBean?) {
        item?.let {
            val date = it.predictDate
            helper?.itemView?.apply {
                mDate.text = DateUtil.StrToData2(date)
                mWeek.text = DateUtil.getWeek(date)
                mTep.text = (WeatherUtils.addTemSymbol2(it.tempDay) + "~" + WeatherUtils.addTemSymbol2(it.tempNight))

                    mWea.setImageResource(WeatherUtils.selectDayIcon(it.conditionIdDay)[Contents.MJ_ICON]!!)
                    mTvWea.text=it.conditionDay

            }
        }

    }
}