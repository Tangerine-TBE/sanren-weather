package com.nanjing.tqlhl.calculator.weiget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nanjing.tqlhl.calculator.inter.OnStartingCityItemClickListenner;
import com.nanjing.tqlhl.calculator.ui.adapter.StartingCityAdapter;
import com.nanjing.tqlhl.R;

import java.util.List;

public class StartingRateCityDialog  extends Dialog {
    Context context;
    List<String> mList;

    OnStartingCityItemClickListenner listener;


    public StartingRateCityDialog(@NonNull Context context, int themeResId,List<String> list, OnStartingCityItemClickListenner listener) {
        super(context, themeResId);
        this.context = context;
        this.mList = list;

        this.listener = listener;
        init();
    }

    public void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.js_starting_city_dialog, null);
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

        StartingCityAdapter adapter = new StartingCityAdapter(R.layout.js_starting_city_adapter, mList, listener);
        adapter.setNewData(mList);
        countryRecycler.setAdapter(adapter);
//        Point point = new Point();
//        getWindow().getWindowManager().getDefaultDisplay().getSize(point);

    }



}
