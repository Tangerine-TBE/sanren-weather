package com.nanjing.tqlhl.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.R;

import butterknife.BindView;

public class AgreementActivity extends BaseMainActivity {

    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;

    @BindView(R.id.user_text)
    TextView mTextView;


    @Override
    protected void intView() {
        tv_bar_title.setText(getString(R.string.user_Agreement));
        String platformName = PackageUtil.difPlatformName(this,R.string.user);
        mTextView.setText(platformName);
    }

    @Override
    protected void intEvent() {
        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_agreement;
    }
}