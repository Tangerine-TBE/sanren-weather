package com.nanjing.tqlhl.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.base
 * @class describe
 * @time 2020/9/8 11:14
 * @class describe
 */
public abstract class BaseRecyclerViewAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>  {

    public List<T> mList=new ArrayList<>();
    public OnItemClickListener mOnItemClickListener=null;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }



    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        setItemData(holder,position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(mList.get(position),position);
                }
            }
        });


    }

    protected abstract void setItemData(VH holder, int position);



    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void setData(List<T> data) {
        mList.clear();
        mList.addAll(data);
        notifyDataSetChanged();
    }


    public void  setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener=listener;
    }

    public interface OnItemClickListener<T> {

        void onItemClick(T t,int position);
    }

}
