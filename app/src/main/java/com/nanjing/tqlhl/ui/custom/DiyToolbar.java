package com.nanjing.tqlhl.ui.custom;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nanjing.tqlhl.R;


public class DiyToolbar extends RelativeLayout {

    private TextView mTitle;
    private ImageView mIcon;
    private ImageView mAdd;
    private  RelativeLayout mBackground;
    private OnClickListener mOnClickListener=null;

    public DiyToolbar(Context context) {
        this(context,null);
    }

    public DiyToolbar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DiyToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intView(context);

    }

    public void finishActivity(Activity activity) {
        mIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
    }

    public void setTitle(String msg) {
        mTitle.setText(msg);
    }

    private void intView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toolbar, this, true);
        mTitle=view.findViewById(R.id.toolbar_title);
        mIcon=view.findViewById(R.id.toolbar_icon);
        mAdd=view.findViewById(R.id.iv_bar_add);
        mBackground = view.findViewById(R.id.base_toolbar);
    }

    public void setAddVis() {
        mAdd.setVisibility(VISIBLE);
    }
    public void setColorBackground(int Color) {
        mBackground.setBackgroundColor(Color);
    }


    public void addOnClick(View.OnClickListener listener) {
        mAdd.setOnClickListener(listener);
    }
}
