package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
 * @time 2020/9/8 19:44
 * @class describe
 */
public class MjDesAdapter extends BaseRecyclerViewAdapter<MjDesBean,MjDesAdapter.MyHolder> {


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mjdes_container, parent, false);
      //  view.getLayoutParams().width= (DeviceUtils.getScreenWidth(parent.getContext())- SizeUtils.dip2px(parent.getContext(),100f))/4;
        return new MyHolder(view);
    }

    @Override
    protected void setItemData(MyHolder holder, int position) {
            holder.setData(mList.get(position),position);
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_des_title)
        TextView tv_des_title;
        @BindView(R.id.iv_des_icon)
        ImageView iv_des_icon;
        @BindView(R.id.tv_des_value)
        TextView tv_des_value;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setData(MjDesBean bean, int position) {
            if (bean.getValue() != null) {
                tv_des_value.setText(bean.getValue());
            }
            tv_des_title.setText(bean.getTitle());
         //   iv_des_icon.setImageResource(bean.getIcon());
        }
    }
}
