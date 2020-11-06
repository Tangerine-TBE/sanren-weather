package com.nanjing.tqlhl.ui.fragment;


import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;

import com.nanjing.tqlhl.base.BaseFragment;
import com.tamsiree.rxkit.RxBarTool;
import com.nanjing.tqlhl.R;


import butterknife.BindView;


public class HeadLineFragment extends BaseFragment {




    @BindView(R.id.toolbar2)
    Toolbar mToolbar;

    @Override
    public int getChildLayout() {
        return R.layout.fragment_head_line;
    }

    @Override
    protected void intView() {
        setViewState(ViewState.SUCCESS);
        int height = RxBarTool.getStatusBarHeight(getContext());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.topMargin=height;
        mToolbar.setLayoutParams(layoutParams);

    }

}