package com.nanjing.tqlhl.ui.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nanjing.tqlhl.base.BaseAdapter;
import com.nanjing.tqlhl.model.bean.ToolBean;
import com.nanjing.tqlhl.R;

import java.util.List;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.adapter
 * @class describe
 * @time 2020/9/7 13:47
 * @class describe
 */
public class ToolAdapter extends BaseAdapter {

    private List<ToolBean> mToolBeanList;
    private OnItemClickListener mOnItemClickListener=null;

    public ToolAdapter(List<ToolBean> list) {
        mToolBeanList=list;
    }

    @Override
    protected int getAdapterLayout() {
        return R.layout.item_tool_container;
    }

    @Override
    protected int getDataItemCount() {
        return mToolBeanList.size();
    }


    @Override
    protected void setItemData(BaseViewHolder holder, int position) {

        rl_toolBg.setBackground(mToolBeanList.get(position).getBg());
        tv_toolTitle.setText(mToolBeanList.get(position).getTitle());
        tv_TitleDes.setText(mToolBeanList.get(position).getDes());

        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mOnItemClickListener != null) {
                            mOnItemClickListener.onItemClick(position);
                        }
                    }
                });

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener=listener;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }



    private RelativeLayout rl_toolBg;
    private TextView tv_toolTitle;
    private TextView tv_TitleDes;
    @Override
    protected void getLayoutId(View view) {
        rl_toolBg= view.findViewById(R.id.rl_toolBg);
        tv_toolTitle= view.findViewById(R.id.tv_toolTitle);
        tv_TitleDes= view.findViewById(R.id.tv_TitleDes);

    }

}
