package com.nanjing.tqlhl.ui.activity;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.R;


public class UserFeedbackActivity extends BaseMainActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_user_feedback;
    }

    @Override
    protected void intView() {
        FeedbackAPI.openFeedbackActivity();
        finish();
    }

}