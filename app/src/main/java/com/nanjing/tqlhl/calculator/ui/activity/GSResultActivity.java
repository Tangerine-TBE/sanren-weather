package com.nanjing.tqlhl.calculator.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.nanjing.tqlhl.calculator.base.activity.BaseRxActivity;
import com.nanjing.tqlhl.calculator.bean.CalResultData;
import com.nanjing.tqlhl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GSResultActivity  extends BaseRxActivity {

    @BindView(R.id.title_left_text)
    TextView title_left_text;
    @BindView(R.id.title_content_text)
    TextView title_content_text;
    @BindView(R.id.include_title)
    LinearLayout include_title;

    @BindView(R.id.tv_final_esult)
    TextView tv_final_esult;
    @BindView(R.id.tv_beforeTaxSalary0)
    TextView tv_beforeTaxSalary0;
    @BindView(R.id.tv_currentPersonalTax0)
    TextView tv_currentPersonalTax0;
    @BindView(R.id.tv_insure0)
    TextView tv_insure0;
    @BindView(R.id.tv_totalTaxMoney0)
    TextView tv_totalTaxMoney0;
    @BindView(R.id.tv_rate)
    TextView tv_rate;
    @BindView(R.id.tv_cut)
    TextView tv_cut;
    @BindView(R.id.tv_result_already)
    TextView tv_result_already;
    @BindView(R.id.tv_wxyj_gjj)
    TextView tv_wxyj_gjj;
    @BindView(R.id.tv_wxyj_yiliao)
    TextView tv_wxyj_yiliao;
    @BindView(R.id.tv_wxyj_yanglao)
    TextView tv_wxyj_yanglao;
    @BindView(R.id.tv_wxyj_shiye)
    TextView tv_wxyj_shiye;
    @BindView(R.id.tv_wxyj_gongshang)
    TextView tv_wxyj_gongshang;
    @BindView(R.id.tv_wxyj_shengyu)
    TextView tv_wxyj_shengyu;


    private CalResultData calResultData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_activity_gs_result);
        ButterKnife.bind(this);
        title_content_text.setText("月薪清单");
        calResultData = (CalResultData) getIntent().getSerializableExtra("calculateData");
        tv_final_esult.setText(String.valueOf(calResultData.getFinalResult()));
        tv_beforeTaxSalary0.setText(String.valueOf(calResultData.getBeforeTaxSalary0()));
        tv_currentPersonalTax0.setText(String.valueOf(calResultData.getCurrentPersonalTax0()));
        tv_insure0.setText(String.valueOf(calResultData.getInsure0()));
        tv_totalTaxMoney0.setText(String.valueOf(calResultData.getTotalTaxMoney0()));
        tv_rate.setText(String.valueOf(calResultData.getRate()));
        tv_cut.setText(String.valueOf(calResultData.getCut()));
        tv_result_already.setText(String.valueOf(calResultData.getResult_already()));
        tv_wxyj_gjj.setText(String.valueOf(calResultData.getWxyj_gjj()));
        tv_wxyj_yiliao.setText(String.valueOf(calResultData.getWxyj_yiliao()));
        tv_wxyj_yanglao.setText(String.valueOf(calResultData.getWxyj_yanglao()));
        tv_wxyj_shiye.setText(String.valueOf(calResultData.getWxyj_shiye()));
        tv_wxyj_gongshang.setText(String.valueOf(calResultData.getWxyj_gongshang()));
        tv_wxyj_shengyu.setText(String.valueOf(calResultData.getWxyj_shengyu()));

    }

    @OnClick({R.id.title_left_text
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.title_left_text:
                finish();
                break;
        }
    }
}
