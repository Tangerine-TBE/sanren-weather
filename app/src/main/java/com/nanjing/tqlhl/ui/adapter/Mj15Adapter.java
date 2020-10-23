package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_tool.utils.DeviceUtils;
import com.nanjing.tqlhl.base.BaseRecyclerViewAdapter;
import com.nanjing.tqlhl.model.bean.Mj15DayWeatherBean;
import com.nanjing.tqlhl.utils.ChangeBgUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.nanjing.tqlhl.R;
import com.xiasuhuei321.loadingdialog.view.SizeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.adapter
 * @class describe
 * @time 2020/9/9 10:45
 * @class describe
 */
public class Mj15Adapter extends BaseRecyclerViewAdapter<Mj15DayWeatherBean.DataBean.ForecastBean,Mj15Adapter.MyHolder> {


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mj15_layout, parent, false);
        view.getLayoutParams().width= (DeviceUtils.getScreenWidth(parent.getContext())- SizeUtils.dip2px(parent.getContext(),40f))/5;
        return new MyHolder(view);
    }

    @Override
    protected void setItemData(MyHolder holder, int position) {
        holder.setData(mList.get(position),position);
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.week)
        TextView mWeek;

        @BindView(R.id.day)
        TextView mDay;

        @BindView(R.id.five_wea_icon)
        ImageView mIcon;

        @BindView(R.id.five_tem_max)
        TextView mMax;

        @BindView(R.id.wind_des)
        TextView mWin_des;

        @BindView(R.id.wind_level)
        TextView mWind_level;

        @BindView(R.id.wind_orientation)
        TextView mWind_orientation;
        private String mWinType;
        private String mWindDir;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(Mj15DayWeatherBean.DataBean.ForecastBean forecastBean, int position) {

            mWin_des.setVisibility(position == 0 ? View.VISIBLE : View.INVISIBLE);
            mWin_des.setText("风力/风向");

            String date = forecastBean.getPredictDate();
            if (position == 0) {
                mWeek.setText("今天");
            } else if (position == 1) {
                mWeek.setText("明天");
            } else {
                String week = DateUtil.getWeek(date);
                mWeek.setText(week);
            }
            mMax.setText(WeatherUtils.addTemSymbol2(forecastBean.getTempDay())+"/"+WeatherUtils.addTemSymbol2(forecastBean.getTempNight()));
            mDay.setText(DateUtil.StrToData(date));


            if (ChangeBgUtil.selectIcon()) {

                mWinType = forecastBean.getWindLevelDay()+"级";
                mWindDir = forecastBean.getWindDirDay();
                mIcon.setImageResource(WeatherUtils.selectDayIcon(forecastBean.getConditionIdDay()).get(Contents.MJ_ICON));


            } else {
                mIcon.setImageResource(WeatherUtils.selectDayIcon(forecastBean.getConditionIdNight()).get(Contents.MJ_ICON));
                mWinType = forecastBean.getWindLevelNight()+"级";
                mWindDir = forecastBean.getWindDirNight();
            }
            mWind_level.setText(mWinType);
            mWind_orientation.setText(mWindDir);




        }
    }
}
