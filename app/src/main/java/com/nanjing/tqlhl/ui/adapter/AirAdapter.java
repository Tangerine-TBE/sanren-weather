package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.model.bean.AirBean;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AirAdapter extends RecyclerView.Adapter<AirAdapter.MyHolder> {
    private  List<AirBean> mList=new ArrayList<>();


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_air_container, parent, false);


        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.setItemData(mList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData( List<AirBean> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_airTitle)
        TextView mTitle;

        @BindView(R.id.tv_airHint)
        TextView mHint;

        @BindView(R.id.tv_airValue)
        TextView mValue;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setItemData(AirBean airBean, int position) {
            mTitle.setText(airBean.getTitle());
            mHint.setText(airBean.getHint());
            mValue.setText(airBean.getValue());
        }
    }

}
