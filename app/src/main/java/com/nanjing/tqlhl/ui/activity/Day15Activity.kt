package com.nanjing.tqlhl.ui.activity

import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.fastjson.JSON
import com.nanjing.tqlhl.R
import com.nanjing.tqlhl.base.BaseMainActivity
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean
import com.nanjing.tqlhl.ui.adapter.MjDay15Adapter
import com.nanjing.tqlhl.ui.custom.mj15day.MyToolbar
import com.nanjing.tqlhl.utils.Contents
import kotlinx.android.synthetic.main.activity_day15.*

/**
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.activity
 * @class describe
 * @author wujinming QQ:1245074510
 * @time 2020/10/20 13:51
 * @class describe
 */
class Day15Activity:BaseMainActivity() {
    override fun getLayoutId(): Int= R.layout.activity_day15


    override fun intView() {
        val day15Data = intent.getStringExtra(Contents.MJ_DAY15)
        if (!TextUtils.isEmpty(day15Data)) {
            val data = JSON.parseObject(day15Data, Mj15DayWeatherBean.DataBean::class.java)
            rv_day15_container.layoutManager=LinearLayoutManager(this)
            val mjDay15Adapter = MjDay15Adapter()
            mjDay15Adapter.setNewData(data.forecast.subList(1,data.forecast.size))
            rv_day15_container.adapter=mjDay15Adapter

        }
    }

    override fun intEvent() {
        day15_bar.setOnBackClickListener(object:MyToolbar.OnBackClickListener{
            override fun onBack() {
                finish()
            }
        })
    }

}