package com.nanjing.tqlhl.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.R;

import butterknife.BindView;

public class PrivacyActivity extends BaseMainActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_privacy;
    }

    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;

    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
    @BindView(R.id.text)
    TextView mWordAlignTextView;
    @BindView(R.id.privacy_toolbar)
    RelativeLayout privacy_toolbar;


    @Override
    protected void intView() {
        tv_bar_title.setVisibility(View.VISIBLE);
        tv_bar_title.setText(getString(R.string.user_Privacy));
        mWordAlignTextView.setText(PackageUtil.difPlatformName(this,R.string.privacy));
        mWordAlignTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setPrimaryClip(ClipData.newPlainText("隐私政策",mWordAlignTextView.getText()));
                Toast.makeText(PrivacyActivity.this,"复制成功",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
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
}