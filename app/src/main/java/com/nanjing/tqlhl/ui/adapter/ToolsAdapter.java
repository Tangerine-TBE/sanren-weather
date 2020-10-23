package com.nanjing.tqlhl.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.base.BaseRecyclerViewAdapter;
import com.nanjing.tqlhl.model.bean.ToolsBean;
import com.nanjing.tqlhl.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.adapter
 * @class describe
 * @time 2020/9/9 14:42
 * @class describe
 */
public class ToolsAdapter extends BaseRecyclerViewAdapter<ToolsBean,ToolsAdapter.MyHolder> {


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tools_container, parent, false);
        return new MyHolder(view);
    }

    @Override
    protected void setItemData(MyHolder holder, int position) {
        holder.setData(mList.get(position),position);
    }



    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_tools_icon)
        ImageView iv_tools_icon;

        @BindView(R.id.tv_tools_title)
        TextView tv_tools_title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(ToolsBean toolsBean, int position) {
            iv_tools_icon.setImageResource(toolsBean.getIcon());
            tv_tools_title.setText(toolsBean.getTitle());
        }
    }
}
