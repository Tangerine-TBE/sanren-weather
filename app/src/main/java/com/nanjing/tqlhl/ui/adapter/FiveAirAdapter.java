package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.model.bean.AirBean;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: Administrator
 * @date: 2020/8/1 0001
 */
public class FiveAirAdapter extends RecyclerView.Adapter<FiveAirAdapter.MyHolder> {
    private List<AirBean> mList=new ArrayList<>();
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_five_air_container, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.setItemData(mList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<AirBean> list) {
            mList.clear();
            mList.addAll(list);
            notifyDataSetChanged();

    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_date)
        TextView mDate_tv;

        @BindView(R.id.tv_date_number)
        TextView mDate_number_tv;


        @BindView(R.id.tv_airLever)
        TextView mAirLever_tv;

        @BindView(R.id.bt_airLeverBg)
        Button mAirLeverBg_bt;

        @BindView(R.id.tv_airLeverTitle)
        TextView mArLeverTitle_tv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setItemData(AirBean day5Bean, int position) {
            String date = day5Bean.getTitle();
            if (position == 0) {
                mDate_tv.setText("今天");
            } else if (position == 1) {
                mDate_tv.setText("明天");
            } else {
                String week = DateUtil.getWeek(date);
                mDate_tv.setText(week);
            }
            mDate_number_tv.setText(DateUtil.StrToData2(date));

            String value = day5Bean.getValue();
            int chn = Integer.valueOf(value);
            mAirLever_tv.setText(value);
            mArLeverTitle_tv.setText(WeatherUtils.aqiType(chn));
            mAirLeverBg_bt.setBackground(WeatherUtils.aqiTypeBg(values,chn));

        }
    }
    private int[] values={0,50,100,150,200,300};
}
