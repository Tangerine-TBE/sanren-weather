package com.nanjing.tqlhl.calculator.weiget;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.calculator.bean.TimePartBean;
import com.nanjing.tqlhl.calculator.inter.OnTimePartDialogItemClickListener;
import com.nanjing.tqlhl.calculator.ui.adapter.TimePartAdapter;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.List;

public class TimePartListDialog extends Dialog {
    Context context;
    List<TimePartBean> mList;
    List<TimePartBean> lockItems=new ArrayList<>();
    EditText ed_time_part;
    OnTimePartDialogItemClickListener listener;
    TimePartAdapter adapter;

    public TimePartListDialog(@NonNull Context context, int themeResId, List<TimePartBean> list, OnTimePartDialogItemClickListener listener) {
        super(context, themeResId);
        this.context = context;
        this.mList = list;
        this.lockItems.addAll(list);
        this.listener = listener;
        init();
    }

    public void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.js_time_part_dialog, null);
        setContentView(view);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.width = context.getResources().getDisplayMetrics().widthPixels - 200;
        layoutParams.rightMargin = 100;
        layoutParams.leftMargin = 100;
        view.setLayoutParams(layoutParams);
        getWindow().setGravity(Gravity.CENTER);
        setCanceledOnTouchOutside(true);

        RecyclerView countryRecycler = view.findViewById(R.id.country_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        countryRecycler.setLayoutManager(linearLayoutManager);

        adapter = new TimePartAdapter(R.layout.js_time_part_adapter, mList, listener);
        adapter.setNewData(mList);
        countryRecycler.setAdapter(adapter);

        ed_time_part = view.findViewById(R.id.ed_time_part);
        ed_time_part.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchResetData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        Point point = new Point();
//        getWindow().getWindowManager().getDefaultDisplay().getSize(point);

    }

    /**
     * 搜索数据
     *
     * @param s 搜索字符
     */
    public void searchResetData(String s) {
        mList.clear();
        //如果为null，直接使用全部数据
        if (s.equals("")) {
            mList.addAll(lockItems);
        } else {
            //否则，匹配相应的数据
            for (int i = 0; i < lockItems.size(); i++) {
                if (lockItems.get(i).getContinentsCn().indexOf(s) >= 0 || lockItems.get(i).getCityCn().indexOf(s) >= 0) {//这里可拓展自己想要的，甚至可以拆分搜索汉字来匹配
                    mList.add(lockItems.get(i));
                }
            }
        }

        //刷新数据
        adapter.notifyDataSetChanged();
    }


}

