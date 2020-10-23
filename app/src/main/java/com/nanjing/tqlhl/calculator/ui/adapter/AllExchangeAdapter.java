package com.nanjing.tqlhl.calculator.ui.adapter;

import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nanjing.tqlhl.calculator.bean.DWBean;
import com.nanjing.tqlhl.calculator.inter.OnDialogItemClickListener;
import com.nanjing.tqlhl.R;

import java.util.HashMap;
import java.util.List;

public class AllExchangeAdapter extends BaseQuickAdapter<HashMap<String, DWBean>, BaseViewHolder> {

    OnDialogItemClickListener listener;
    int clickId;
    @Override
    protected void convert(BaseViewHolder helper, final HashMap<String, DWBean> item) {

        helper.setText(R.id.tv_dw , item.get("key").getDw_code());
        helper.setText(R.id.tv_name , item.get("key").getDw_name());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.ItemClick(clickId,item);
            }
        });

    }



    public AllExchangeAdapter(int layoutResId, @Nullable List<HashMap<String, DWBean>> data, OnDialogItemClickListener listener, int clickId) {
        super(layoutResId, data);
        this.listener=listener;
        this.clickId=clickId;

    }
}
