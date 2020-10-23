package com.nanjing.tqlhl.calculator.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nanjing.tqlhl.calculator.inter.OnDialogItemClickListener;
import com.nanjing.tqlhl.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//汇率转换
public class ExchangeAdapter extends BaseQuickAdapter<HashMap<String,String>, BaseViewHolder> {

    OnDialogItemClickListener listener;
    int clickId;
    @Override
    protected void convert(BaseViewHolder helper, final HashMap<String,String> item) {
        Set set = item.keySet();
        Iterator iter = set.iterator();
        String key="";
        while (iter.hasNext()) {
             key = (String) iter.next();
             if (key.length()<4){
                 break;
             }

        }
        helper.setText(R.id.tv_dw , key);
        helper.setText(R.id.tv_country , item.get(key));
         int resId=Integer.parseInt(item.get("image"));
        Glide.with(mContext).load(resId).into((ImageView) helper.getView(R.id.imageView));
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.ItemClick(item,clickId);
            }
        });

    }



    public ExchangeAdapter(int layoutResId, @Nullable List<HashMap<String,String>> data, OnDialogItemClickListener listener, int clickId) {
        super(layoutResId, data);
        this.listener=listener;
        this.clickId=clickId;

    }
}
