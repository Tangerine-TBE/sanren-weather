package com.nanjing.tqlhl.calculator.weiget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.calculator.bean.DWBean;
import com.nanjing.tqlhl.calculator.inter.OnDialogItemClickListener;
import com.nanjing.tqlhl.calculator.ui.adapter.AllExchangeAdapter;
import com.nanjing.tqlhl.R;

import java.util.HashMap;
import java.util.List;

//统一的单位转换对话框
public class AllExchangeDialog extends Dialog {
    Context context;
    List<HashMap<String, DWBean>> mList;
    TextView tv_title;
    OnDialogItemClickListener listener;
    int clickId;

    public AllExchangeDialog(@NonNull Context context, int themeResId, List<HashMap<String, DWBean>> list, int clickId, OnDialogItemClickListener listener) {
        super(context, themeResId);
        this.context = context;
        this.mList = list;
        this.clickId = clickId;
        this.listener=listener;
        init();
    }

    public void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.js_all_exchange_dilog, null);
        setContentView(view);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.width = context.getResources().getDisplayMetrics().widthPixels-200;
        layoutParams.rightMargin=100;
        layoutParams.leftMargin=100;
        view.setLayoutParams(layoutParams);
        getWindow().setGravity(Gravity.CENTER);
        setCanceledOnTouchOutside(true);

        RecyclerView countryRecycler = view.findViewById(R.id.country_list);
        tv_title = view.findViewById(R.id.tv_title);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        countryRecycler.setLayoutManager(linearLayoutManager);

        AllExchangeAdapter adapter = new AllExchangeAdapter(R.layout.js_all_exchange_adapter, mList, listener, clickId);
        adapter.setNewData(mList);
        countryRecycler.setAdapter(adapter);
//        Point point = new Point();
//        getWindow().getWindowManager().getDefaultDisplay().getSize(point);

    }



    public void setTitle(String title) {
        tv_title.setText(title);
    }
}

