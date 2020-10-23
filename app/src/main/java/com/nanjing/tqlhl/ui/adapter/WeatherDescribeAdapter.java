package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.model.bean.DescribeBean;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.nanjing.tqlhl.utils.WeatherUtils;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.List;

public class WeatherDescribeAdapter extends RecyclerView.Adapter<WeatherDescribeAdapter.MyHolder>  {
    private   List<DescribeBean.Des> mDescribeBeanList=new ArrayList<>();

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_describe, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.setItemData(mDescribeBeanList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mDescribeBeanList.size();
    }

    public void setData( List<DescribeBean.Des> data) {
        mDescribeBeanList.clear();
        mDescribeBeanList.addAll(data);
        notifyDataSetChanged();
    }

    public class MyHolder  extends RecyclerView.ViewHolder {

        private TextView mValue;
        private TextView mTitle;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mValue= itemView.findViewById(R.id.values);
            mTitle= itemView.findViewById(R.id.title);
        }

        public void setItemData(DescribeBean.Des des, int position) {
            if (position == 2) {
                for (int i = 0; i < WeatherUtils.ALARM_LEVEL.length; i++) {
                    if (des.getValues().equals( WeatherUtils.ALARM_LEVEL[i])) {
                        mValue.setTextColor(ColorUtil.AQI_COLOR[i]);
                    }
                }

            }
            mTitle.setText(des.getTitle());
            mValue.setText(des.getValues());

        }
    }


}
