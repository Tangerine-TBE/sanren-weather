package com.nanjing.tqlhl.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.model.bean.HuangLiBean;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.utils.SpUtils;

import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.activity
 * @class describe
 * @time 2020/9/30 11:12
 * @class describe
 */
public class HuangLiActivity extends BaseMainActivity {

    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.tv_nongli)
    TextView tv_nongli;
    @BindView(R.id.tv_year_xx)
    TextView tv_year_xx;
    @BindView(R.id.tv_week_xx)
    TextView tv_week_xx;
    @BindView(R.id.tv_ji_hl_text)
    TextView tv_ji_hl_text;
    @BindView(R.id.tv_yi_hl_text)
    TextView tv_yi_hl_text;
    @BindView(R.id.tv_xx_hl_text)
    TextView tv_xx_hl_text;
    @BindView(R.id.tv_xz_hl_text)
    TextView tv_xz_hl_text;
    @BindView(R.id.tv_wx_hl_text)
    TextView tv_wx_hl_text;
    @BindView(R.id.tv_cs_hl_text)
    TextView tv_cs_hl_text;
    @BindView(R.id.tv_ts_hl_text)
    TextView tv_ts_hl_text;
    @BindView(R.id.tv_s_hl_text)
    TextView tv_s_hl_text;
    @BindView(R.id.tv_c_hl_text)
    TextView tv_c_hl_text;
    @BindView(R.id.tv_xiongshen)
    TextView tv_xiongshen;
    @BindView(R.id.tv_jishenyiqu)
    TextView tv_jishenyiqu;
    @BindView(R.id.tv_suici)
    TextView tv_suici;
    @BindView(R.id.tv_jiri)
    TextView tv_jiri;
    @BindView(R.id.tv_big_date)
    TextView tv_big_date;
    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
    @BindView(R.id.rl_hl_include)
    RelativeLayout rl_hl_include;
    @BindView(R.id.hl_toolbar)
    RelativeLayout hl_toolbar;
    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;


    @Override
    protected void setStatusBarColor() {
        MyStatusBarUtil.setFullWindow(this);
    }

    @Override
    public int getLayoutId() {

        return R.layout.activity_huangli;
    }

    @Override
    protected void intView() {
        tv_bar_title.setVisibility(View.VISIBLE);
        tv_bar_title.setText("今日黄历");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hl_toolbar.getLayoutParams();
        layoutParams.topMargin = MyStatusBarUtil.getStatusBarHeight(this);
        hl_toolbar .setLayoutParams(layoutParams);

        String huangLiData = SpUtils.getInstance().getString(Contents.HUANGLI_DATA,"");
        if (!TextUtils.isEmpty(huangLiData)) {
            HuangLiBean.ResultBean resultBean = JSON.parseObject(huangLiData, HuangLiBean.ResultBean.class);
            if (resultBean != null) {
                showHuangLi(resultBean);

            }
        }
    }

    private void showHuangLi(HuangLiBean.ResultBean resultBean) {
        tv_date.setText(DateUtil.getDate2());
        String nongli = resultBean.getYinli();
        tv_nongli.setText(nongli.substring(7, nongli.length()));
        tv_year_xx.setText(resultBean.getShengxiao() + "年");
        tv_week_xx.setText("星期" + resultBean.getWeek());
        tv_big_date.setText(resultBean.getDay());

        // 宜
        StringBuffer stringBuffer1 = new StringBuffer();
        List<String> yi = resultBean.getYiList();
        if (yi.size() >= 9) {
            yi = yi.subList(2, 9);
        } else {
            yi = yi.subList(2, yi.size());
        }
        for (String s : yi) {
            stringBuffer1.append(s + "  ");
        }
        tv_yi_hl_text.setText(stringBuffer1);


        //忌
        StringBuffer stringBuffer2 = new StringBuffer();
        List<String> ji = resultBean.getJiList();

        if (ji.size() >= 9) {
            ji = ji.subList(2, 9);
        } else if (ji.size() >= 2){
            ji = ji.subList(2, ji.size());
        }
        for (String s : ji) {
            stringBuffer2.append(s + "  ");
        }
        tv_ji_hl_text.setText(stringBuffer2);

        tv_xx_hl_text.setText(resultBean.getShengxiao());
//        tv_xz_hl_text.setText(resultBean.getStar());
        tv_wx_hl_text.setText(resultBean.getWuxing());

//        tv_cs_hl_text.setText("喜神：" + resultBean.getXishen() + "\n" +
//                "福神：" + resultBean.getFushen() + "\n" +
//                "财神：" + resultBean.getCaishen() + "\n"
//        );

//        tv_ts_hl_text.setText(resultBean.getTaishen());

        tv_c_hl_text.setText(resultBean.getChongsha());
        tv_s_hl_text.setText(resultBean.getSha());

        tv_xiongshen.setText(resultBean.getXiongshen());
        tv_jishenyiqu.setText(resultBean.getJishen());

//        StringBuffer stringBuffer = new StringBuffer();
//        List<String> suici = resultBean.getSuici();
//        for (String s : suici) {
//            stringBuffer.append(s + "  ");
//        }
//        tv_suici.setText(stringBuffer);
//        tv_jiri.setText(resultBean.getJiri());

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
