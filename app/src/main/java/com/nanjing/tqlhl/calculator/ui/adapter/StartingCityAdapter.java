package com.nanjing.tqlhl.calculator.ui.adapter;

import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nanjing.tqlhl.calculator.inter.OnStartingCityItemClickListenner;
import com.nanjing.tqlhl.R;

import java.util.List;

public class StartingCityAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    OnStartingCityItemClickListenner listener;

    @Override
    protected void convert(BaseViewHolder helper, final String item) {


        helper.setText(R.id.tv_name ,item);
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnStartingCityItemClick(mData.indexOf(item));
            }
        });

    }



    public StartingCityAdapter(int layoutResId, @Nullable List<String> data, OnStartingCityItemClickListenner listener) {
        super(layoutResId, data);
        this.listener=listener;


    }
}
