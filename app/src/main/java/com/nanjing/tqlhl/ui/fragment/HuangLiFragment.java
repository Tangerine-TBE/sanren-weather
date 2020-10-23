package com.nanjing.tqlhl.ui.fragment;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.model.bean.HuangLiBean;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.DateUtil;
import com.nanjing.tqlhl.utils.SpUtils;

import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.fragment
 * @class describe
 * @time 2020/9/29 10:01
 * @class describe
 */
public class HuangLiFragment extends BaseFragment {


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
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.rl_hl_include)
    RelativeLayout rl_hl_include;
    @BindView(R.id.base_toolbar)
    RelativeLayout base_toolbar;
    @BindView(R.id.hl_toolbar)
    RelativeLayout hl_toolbar;


    @Override
    public int getChildLayout() {
        return R.layout.fragment_huangli;
    }

    @Override
    protected void intView() {
        setViewState(ViewState.SUCCESS);
        toolbar_title.setText("今日黄历");
        base_toolbar.setBackground(getResources().getDrawable(R.color.transparent,null));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hl_toolbar.getLayoutParams();
        layoutParams.topMargin = MyStatusBarUtil.getStatusBarHeight(getActivity());
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
        String nongli = resultBean.getNongli();
        tv_nongli.setText(nongli.substring(7, nongli.length()));
        tv_year_xx.setText(resultBean.getShengxiao() + "年");
        tv_week_xx.setText("星期" + resultBean.getWeek());
        tv_big_date.setText(resultBean.getDay());

        // 宜
        StringBuffer stringBuffer1 = new StringBuffer();
        List<String> yi = null;
        if (resultBean.getYi().size() >= 9) {
            yi = resultBean.getYi().subList(2, 9);
        } else {
            yi = resultBean.getYi().subList(2, resultBean.getYi().size());
        }
        for (String s : yi) {
            stringBuffer1.append(s + "  ");
        }
        tv_yi_hl_text.setText(stringBuffer1);


        //忌
        StringBuffer stringBuffer2 = new StringBuffer();
        List<String> ji = null;
        if (resultBean.getJi().size() >= 9) {
            ji = resultBean.getJi().subList(2, 9);
        } else {
            ji = resultBean.getJi().subList(2, resultBean.getJi().size());
        }
        for (String s : ji) {
            stringBuffer2.append(s + "  ");
        }
        tv_ji_hl_text.setText(stringBuffer2);

        tv_xx_hl_text.setText(resultBean.getShengxiao());
        tv_xz_hl_text.setText(resultBean.getStar());
        tv_wx_hl_text.setText(resultBean.getWuxing());

        tv_cs_hl_text.setText("喜神：" + resultBean.getXishen() + "\n" +
                "福神：" + resultBean.getFushen() + "\n" +
                "财神：" + resultBean.getCaishen() + "\n"
        );

        tv_ts_hl_text.setText(resultBean.getTaishen());

        tv_c_hl_text.setText(resultBean.getChong());
        tv_s_hl_text.setText(resultBean.getSha());

        tv_xiongshen.setText(resultBean.getXiongshen());
        tv_jishenyiqu.setText(resultBean.getJishenyiqu());

        StringBuffer stringBuffer = new StringBuffer();
        List<String> suici = resultBean.getSuici();
        for (String s : suici) {
            stringBuffer.append(s + "  ");
        }
        tv_suici.setText(stringBuffer);
        tv_jiri.setText(resultBean.getJiri());

    }

}
