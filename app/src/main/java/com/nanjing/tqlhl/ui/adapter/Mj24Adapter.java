package com.nanjing.tqlhl.ui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.module_ad.utils.SizeUtils;
import com.example.module_tool.utils.ColorUtil;
import com.example.module_tool.utils.DeviceUtils;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseRecyclerViewAdapter;
import com.nanjing.tqlhl.caiyun.HourlyWeather;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.adapter
 * @class describe
 * @time 2020/9/8 17:56
 * @class describe
 */
public class Mj24Adapter extends BaseRecyclerViewAdapter<HourlyWeather.HourlyNeedData,Mj24Adapter.MyHolder> {
    private boolean isWhite;
    public  Mj24Adapter(boolean isWhite) {
        this.isWhite=isWhite;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mj24_container, parent, false);
        view.getLayoutParams().width= (DeviceUtils.getScreenWidth(parent.getContext())- SizeUtils.dip2px(parent.getContext(),72f))/5;
        return new MyHolder(view);
    }

    @Override
    protected void setItemData(MyHolder holder, int position) {
        holder.setData(mList.get(position));
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item24_team)
        TextView tv_item24_team;
        @BindView(R.id.tv_item24_date)
        TextView tv_item24_date;
        @BindView(R.id.iv_item24_icon)
        ImageView iv_item24_icon;
        @BindView(R.id.tv_item24_speed)
        TextView tv_item24_speed;
        @BindView(R.id.iv_item24_direction)
        TextView iv_item24_direction;
        @BindView(R.id.tv_item_wea)
        TextView tv_item_wea;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
        public void setData(HourlyWeather.HourlyNeedData hourlyBean) {
            tv_item24_team.setText(hourlyBean.getTem());
            tv_item24_date.setText(hourlyBean.getTime());
            tv_item24_speed.setText(hourlyBean.getWindDegree());
            iv_item24_direction.setText(hourlyBean.getWindDirection());
            tv_item_wea.setText(hourlyBean.getSkyconDes());

            iv_item24_icon.setImageResource(hourlyBean.getSkyconIcon());

            tv_item24_date.setTextColor(isWhite?Color.WHITE:Color.BLACK);
            tv_item24_team.setTextColor(isWhite?Color.WHITE:Color.BLACK);
            tv_item_wea.setTextColor(isWhite?Color.WHITE:Color.BLACK);
//            int hour = Integer.valueOf(hourlyBean.getHour());
//            if (hour >= 6 & hour < 18) {
//                iv_item24_icon.setImageResource(WeatherUtils.selectDayIcon(hourlyBean.getIconDay()).get(Contents.MJ_ICON));
//            } else {
//                iv_item24_icon.setImageResource(WeatherUtils.selectNightIcon(hourlyBean.getIconNight()).get(Contents.MJ_ICON));
//            }
        }
    }

}
