package com.nanjing.tqlhl.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: Administrator
 * @date: 2020/8/2 0002
 */
public class AirIndicateAdapter extends RecyclerView.Adapter<AirIndicateAdapter.MyHolder> {

    private String[] mTitle;
    private Drawable[] mBg;


    public AirIndicateAdapter(String[] title,Drawable[] bg) {
        this.mTitle=title;
        this.mBg=bg;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_indicte_container, parent, false);
        return new MyHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.setItemData(position);
    }

    @Override
    public int getItemCount() {
        return mTitle.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_indicate_title)
        TextView mTitle_tv;

        @BindView(R.id.bt_indicate_bg)
        Button mBg_bt;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setItemData(int position) {
            mTitle_tv.setText(mTitle[position]);
            mBg_bt.setBackground(mBg[position]);
        }
    }



}
