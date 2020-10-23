package com.nanjing.tqlhl.calculator.ui.adapter;

import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nanjing.tqlhl.calculator.bean.TimePartBean;
import com.nanjing.tqlhl.calculator.inter.OnTimePartDialogItemClickListener;
import com.nanjing.tqlhl.R;

import java.util.List;

public class TimePartAdapter extends BaseQuickAdapter<TimePartBean, BaseViewHolder> {

    OnTimePartDialogItemClickListener listener;
    int clickId;
    @Override
    protected void convert(BaseViewHolder helper, final TimePartBean item) {

        helper.setText(R.id.tv_country , item.getContinentsCn()+"-"+item.getCityCn());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.ItemClick(item);
            }
        });

    }



    public TimePartAdapter(int layoutResId, @Nullable List<TimePartBean> data, OnTimePartDialogItemClickListener listener) {
        super(layoutResId, data);
        this.listener=listener;


    }
}


