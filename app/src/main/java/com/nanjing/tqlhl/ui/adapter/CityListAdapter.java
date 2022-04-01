package com.nanjing.tqlhl.ui.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.utils.ChangeBgUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.WeatherUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: Administrator
 * @date: 2020/7/5 0005
 */
public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.MyHolder> {

    private List<CityCacheBean> mLocationBeans=new ArrayList<>();
    private OnItemClickListener mOnItemClickListener=null;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city_container, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.setItemData(mLocationBeans.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mLocationBeans.size();
    }

    public void setData(List<CityCacheBean> cityList) {
        mLocationBeans.clear();
        mLocationBeans.addAll(cityList);
        notifyDataSetChanged();
    }

    public void deleteCity(int adapterPosition) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.deleteOnClick(mLocationBeans.get(adapterPosition),adapterPosition);
        }
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener=listener;
    }

    public interface OnItemClickListener {
        void deleteOnClick(CityCacheBean city,int position);

        void  OnItemClick(CityCacheBean city,int position);
    }



    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.city_name)
        TextView mCityName;
        @BindView(R.id.city_wea)
        TextView mCityWea;
        @BindView(R.id.city_tem)
        TextView mCityTem;
        @BindView(R.id.tv_city_speed)
        TextView tv_city_speed;
        @BindView(R.id.tv_item_currentTeam)
        TextView tv_item_currentTeam;
        @BindView(R.id.city_weaIcon)
        ImageView city_weaIcon;
        @BindView(R.id.city_aqi)
        TextView city_aqi;



        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setItemData(CityCacheBean bean, int position) {

                mCityName.setText(bean.getCity());
                mCityTem.setText(bean.getLowHigh());
                mCityWea.setText(bean.getWea());
                tv_city_speed.setText(bean.getWindy());
                tv_item_currentTeam.setText("当前温度  "+bean.getTeam());
            city_weaIcon.setImageResource(bean.getSkyIcon());
            String aqi = bean.getAqi();
            if (!TextUtils.isEmpty(aqi)) {
                city_aqi.setText("空气  "+bean.getAqi());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.OnItemClick(bean, position);
                }
            });
        }
    }
}
