package com.nanjing.tqlhl.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_ad.utils.SizeUtils;

/**
 * @author: Administrator
 * @date: 2020/7/5 0005
 */
public class RecyclerViewItemDistanceUtil {
    public static void setDistance(RecyclerView recyclerView, Context context,float size) {
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = SizeUtils.dip2px1(context, size);
            }
        });
    }
}
