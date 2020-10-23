package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nanjing.tqlhl.model.bean.SettingBean;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.MyHolder> {
    private   List<SettingBean> mSettingList=new ArrayList<>();
    private OnItemClickListener mOnItemClickListener=null;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.setItemData(mSettingList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mSettingList.size();
    }

    public void setData(List<SettingBean> settingBeanList) {
        mSettingList.clear();
        mSettingList.addAll(settingBeanList);
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mTitle;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mTitle=itemView.findViewById(R.id.set_title);
            mIcon= itemView.findViewById(R.id.set_icon);
        }

        public void setItemData(SettingBean settingBean, int position) {
            mTitle.setText(settingBean.getTitle());
            Glide.with(mIcon.getContext()).load(settingBean.getImage()).into(mIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(position);
                    }
                }
            });

        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener=listener;
    }


    public interface OnItemClickListener {

        void onItemClick(int position);
    }

}
