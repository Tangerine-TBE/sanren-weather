package com.nanjing.tqlhl.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.base
 * @class describe
 * @time 2020/9/7 13:35
 * @class describe
 */
public abstract class  BaseAdapter extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {



    protected abstract int getAdapterLayout();
    protected abstract int getDataItemCount();
    protected abstract void getLayoutId(View view);
    protected abstract void setItemData(BaseViewHolder holder, int position);


    @NonNull
    @Override
    public BaseAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getAdapterLayout(), parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
        setItemData(holder,position);
    }

    @Override
    public int getItemCount() {
        return  getDataItemCount();
    }




    public class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            getLayoutId(itemView);
        }
    }
}
