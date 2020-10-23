package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_tool.utils.DeviceUtils;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseRecyclerViewAdapter;
import com.nanjing.tqlhl.model.bean.MjDesBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.adapter
 * @class describe
 * @time 2020/9/9 13:30
 * @class describe
 */
public class MjLifeAdapter  extends BaseRecyclerViewAdapter<MjDesBean,MjLifeAdapter.MyHolder> {


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_life_cotainer, parent, false);
        view.getLayoutParams().width= (DeviceUtils.getScreenWidth(parent.getContext()))/4;
        return new MyHolder(view);
    }

    @Override
    protected void setItemData(MyHolder holder, int position) {
        holder.setData(mList.get(position),position);
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_life_icon)
        ImageView iv_life_icon;
        @BindView(R.id.tv_life_title)
        TextView tv_life_title;
        @BindView(R.id.tv_life_values)
        TextView tv_life_values;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(MjDesBean mjDesBean, int position) {
            iv_life_icon.setImageResource(mjDesBean.getIcon());
            tv_life_title.setText(mjDesBean.getTitle());
            tv_life_values.setText(mjDesBean.getValue());

        }
    }
}
