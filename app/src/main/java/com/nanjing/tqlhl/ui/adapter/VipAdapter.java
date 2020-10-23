package com.nanjing.tqlhl.ui.adapter;

import android.graphics.Paint;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.model.bean.PriceBean;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.activity
 * @class describe
 * @time 2020/9/11 10:30
 * @class describe
 */
public class VipAdapter extends RecyclerView.Adapter<VipAdapter.MyHolder> {

    private List<PriceBean> mList=new ArrayList<>();
    private int mPosition;
    private OnItemClickListener mItemClickListener=null;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vip_container, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.setData(mList.get(position),position);

        holder.rl_vip_bg.setBackground(mPosition == position?holder.itemView.getContext().getResources().getDrawable(R.drawable.shape_vip_bg):
                holder.itemView.getContext().getResources().getDrawable(R.drawable.shape_vip_bg_normal));

        holder.tv_vip_title.setTextColor(mPosition == position? ColorUtil.WHITE:ColorUtil.COLOR_vip_title_normal);
        holder.tv_vip_hint.setTextColor(mPosition == position?ColorUtil.WHITE:ColorUtil.COLOR_vip_title_normal);


        holder.tv_vip_price.setTextColor(mPosition == position?ColorUtil.COLOR_vip_price_select:ColorUtil.COLOR_vip_price_normal);
        holder.tv_vip_price.setTextSize(TypedValue.COMPLEX_UNIT_SP, mPosition == position?16:14);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<PriceBean> priceBeanList) {
        mList.clear();
        mList.addAll(priceBeanList);
        notifyDataSetChanged();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_vip_title)
        TextView tv_vip_title;
        @BindView(R.id.tv_vip_hint)
        TextView tv_vip_hint;
        @BindView(R.id.tv_vip_price)
        TextView tv_vip_price;
        @BindView(R.id.rl_vip_bg)
        RelativeLayout rl_vip_bg;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(PriceBean priceBean, int position) {
            tv_vip_title.setText(priceBean.getTitle());

            tv_vip_price.setText(priceBean.getPrice()+"元");
            tv_vip_hint.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tv_vip_hint.setText(priceBean.getHint());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(priceBean,position);
                        mPosition =position;
                        notifyDataSetChanged();
                    }
                }
            });

        }

    }


    public void setItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener=listener;
    }

    public interface OnItemClickListener {
       void onItemClick(PriceBean priceBean,int position);
    }

}
