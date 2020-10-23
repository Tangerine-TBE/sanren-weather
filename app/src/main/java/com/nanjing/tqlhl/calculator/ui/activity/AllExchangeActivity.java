package com.nanjing.tqlhl.calculator.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.calculator.base.activity.BaseActivity2;
import com.nanjing.tqlhl.calculator.bean.DWBean;
import com.nanjing.tqlhl.calculator.inter.OnDialogItemClickListener;
import com.nanjing.tqlhl.calculator.keyboard.NumberKeyBoradManager;
import com.nanjing.tqlhl.calculator.utils.NumToUpperUtil;
import com.nanjing.tqlhl.calculator.weiget.AllExchangeDialog;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.umeng.analytics.MobclickAgent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllExchangeActivity extends BaseActivity2 implements OnDialogItemClickListener {


    @BindView(R.id.text_pulltoselect_center)
    TextView tv_center;
    @BindView(R.id.text_pulltoselect_bottom)
    TextView tv_bottom;
    @BindView(R.id.title_left_text)
    TextView title_left_text;
    @BindView(R.id.edit_base_center)
    MaterialEditText edit_base_center;
    @BindView(R.id.edit_base_bottom)
    MaterialEditText edit_base_bottom;


    @BindView(R.id.text_base_bottom)
    TextView text_base_bottom;
    @BindView(R.id.text_center)
    TextView text_center;
    @BindView(R.id.text_dw_center)
    TextView text_dw_center;
    @BindView(R.id.text_dw_bottom)
    TextView text_dw_bottom;
    @BindView(R.id.title_content_text)
    TextView tv_title;

    @BindView(R.id.zero)
    Button zero;
    @BindView(R.id.nine)
    Button nine;
    @BindView(R.id.AC)
    Button AC;
    @BindView(R.id.four)
    Button four;
    @BindView(R.id.five)
    Button five;
    @BindView(R.id.six)
    Button six;
    @BindView(R.id.one)
    Button one;
    @BindView(R.id.two)
    Button two;
    @BindView(R.id.three)
    Button three;
    @BindView(R.id.back)
    ImageButton back;
    @BindView(R.id.seven)
    Button seven;
    @BindView(R.id.eight)
    Button eight;

    AllExchangeDialog dialog;
    List<HashMap<String, DWBean>> mList = new ArrayList<>();

    DWBean currentBaseBean;
    DWBean currentExchangeBean;
    String title, tvSelectTop, tvSelectbottom, tvDwtop, tvDwbottom;
    TextWatcher textWather1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);//禁止弹出软键盘最有效的方法
        setContentView(R.layout.js_activity_area_exchange);
        ButterKnife.bind(this);
        title = getIntent().getStringExtra("title");
        tvSelectTop = getIntent().getStringExtra("tvSelectTop");
        tvSelectbottom = getIntent().getStringExtra("tvSelectbottom");
        tvDwtop = getIntent().getStringExtra("tvDwtop");
        tvDwbottom = getIntent().getStringExtra("tvDwbottom");
        initData();
        bindView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
    private void initData() {
        switch (title) {
            case "面积转换":
                initAreaData();
                break;
            case "长度转换":
                initLenthData();
                break;
            case "时间转换":
                initTimeData();
                break;
            case "体积转换":
                initCubeData();
                break;
            case "速度转换":
                initSpeedData();
                break;
            case "重量转换":
                initWeightData();
                break;
            case "温度转换":
                initTemparatureData();
                break;
            case "大写数字":
                toUpper();
            case "压强转换":
                initPressData();
                break;
            case "容量转换":
                initCubeData();
                break;
            case "功率转换":
                initPowerData();
                break;
            case "热量转换":
                initHeatData();
                break;
            case "力转换":
                initStrenthData();
                break;
        }
    }


    private void bindView() {
        tv_center.setText(tvSelectTop);
        tv_bottom.setText(tvSelectbottom);
        text_dw_center.setText(tvDwtop);
        text_dw_bottom.setText(tvDwbottom);

        textWather1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {

                    String command = s.toString().trim();
                    String isValid = command.substring(start, start + 1);//取出最后一个输入的字符
                    if (".".equals(isValid)&&s.length()==1) {
                        Toast.makeText(getApplicationContext(), "第一位不能是小数点", Toast.LENGTH_LONG).show();
                        edit_base_center.setText("");
                        return;
                    }
                    if (title.equals("大写数字"))
                        edit_base_bottom.setText(NumToUpperUtil.moneyToChinese(new BigDecimal(s.toString())));
                    else
                        edit_base_bottom.setText(convertToDw(Double.valueOf(s.toString()), currentBaseBean.getRate(), currentExchangeBean.getRate()));
                }




            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        edit_base_center.addTextChangedListener(textWather1);
        tv_title.setText(title);
    }

    /**
     * dw基准单位倍率
     * todw转换的单位倍率
     * num基准单位数值
     * double直接相除不准可通过BigDecimal包装double后分别调用乘除方法
     */
    public String convertToDw(double num, double dw, double todw) {
        if (todw < 0) {
            throw new IllegalArgumentException("rate_error");
        }
        BigDecimal dw1 = new BigDecimal(Double.toString(dw));
        BigDecimal todw1 = new BigDecimal(Double.toString(todw));
        BigDecimal num1 = new BigDecimal(Double.toString(num));
        double rate;
        try {
            rate = todw1.divide(dw1).doubleValue();//得到倍数
        } catch (Exception e) {
            //有除不尽的时候会抛出异常，此时保留两位小数，不能直接用此方法，因为两单位差距太大四舍五入保留小数后也是0.0
            rate = todw1.divide(dw1, 2, BigDecimal.ROUND_HALF_UP).doubleValue();//得到倍数,保留两位小鼠，四舍五入
        }
        //    double rate = todw1.divide(dw1, 5, BigDecimal.ROUND_HALF_UP).doubleValue();//得到倍数,保留两位小鼠，四舍五入
        //double rate = dw1.divide(todw1, 2, BigDecimal.ROUND_HALF_UP).doubleValue();//dw除以todw
        BigDecimal rate1 = new BigDecimal(Double.toString(rate));
        num1.multiply(rate1).doubleValue();//num乘以倍数
        return num1.multiply(rate1).doubleValue() + "";
    }

    private void showExchangeDialog(int clickId) {

        dialog = new AllExchangeDialog(this, R.style.CenterDialog, mList, clickId, this);
        dialog.setTitle("请选择");

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void ItemClick(HashMap<String, String> item, int clickId) {

    }

    @Override
    public void ItemClick(int clickId, HashMap<String, DWBean> item) {

        if (clickId == R.id.text_pulltoselect_center) {

            tv_center.setText(item.get("key").getDw_name());
            text_dw_center.setText(item.get("key").getDw_code());
            currentBaseBean.setDw_code(item.get("key").getDw_code());
            currentBaseBean.setRate(item.get("key").getRate());
        } else if (clickId == R.id.text_pulltoselect_bottom) {
            tv_bottom.setText(item.get("key").getDw_name());
            text_dw_bottom.setText(item.get("key").getDw_code());
            currentExchangeBean.setDw_code(item.get("key").getDw_code());
            currentExchangeBean.setRate(item.get("key").getRate());
        }
        edit_base_center.setText("0");
        edit_base_bottom.setText("0");
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @OnClick({R.id.text_pulltoselect_center, R.id.text_pulltoselect_bottom, R.id.title_left_text, R.id.edit_base_center, R.id.edit_base_bottom,
            R.id.back, R.id.seven, R.id.eight, R.id.nine,
            R.id.four, R.id.five, R.id.six,
            R.id.one, R.id.two, R.id.three,
            R.id.zero, R.id.dot, R.id.AC
    })
    public void onViewClicked(View view) {

        if (isclickKeyboard(view)) {
            String command;
            String inputStr;
            if (view.getId() == R.id.back) {
                command = "back";

            } else {
                command = ((Button) view).getText().toString();//按键上的命令获取
            }
            inputStr = edit_base_center.getText().toString();//显示器上的字符串
            NumberKeyBoradManager.get().key(this, command, inputStr, edit_base_center);
        }
        switch (view.getId()) {
            case R.id.text_pulltoselect_center:
                showExchangeDialog(R.id.text_pulltoselect_center);
                break;
            case R.id.text_pulltoselect_bottom:
                showExchangeDialog(R.id.text_pulltoselect_bottom);
                break;
            case R.id.title_left_text:
                finish();
                break;

        }
    }

    private boolean isclickKeyboard(View v) {
        if (v.getId() == R.id.back | v.getId() == R.id.seven | v.getId() == R.id.eight | v.getId() == R.id.nine | v.getId() == R.id.four | v.getId() == R.id.five | v.getId() == R.id.six | v.getId() == R.id.one | v.getId() == R.id.two | v.getId() == R.id.three | v.getId() == R.id.zero | v.getId() == R.id.dot | v.getId() == R.id.AC) {
            return true;
        } else {

            return false;
        }
    }

    private void initAreaData() {
        mList.clear();
        currentBaseBean = new DWBean("平方米", getString(R.string.area_pfm), 1.0);

        currentExchangeBean = new DWBean("平方厘米", getString(R.string.area_pflm), 10000.0);


        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("平方米", getString(R.string.area_pfm), 1.0));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("平方厘米", getString(R.string.area_pflm), 10000.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("公亩", getString(R.string.area_gm), 0.01));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("平方千米", getString(R.string.area_pfqm), 0.000001));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("平方毫米", getString(R.string.area_pfhm), 1000000.0));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("平方分米", getString(R.string.area_pffm), 100.0));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("公顷", getString(R.string.area_gq), 0.0001));
        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("英亩", getString(R.string.area_ym), 0.0002471));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("平方英里", getString(R.string.area_pfyl), 3.8610e-7));
        HashMap<String, DWBean> item10 = new HashMap<>();

        item10.put("key", new DWBean("平方码", getString(R.string.area_pfma), 1.19599));
        HashMap<String, DWBean> item11 = new HashMap<>();
        item11.put("key", new DWBean("平方英寸", getString(R.string.area_pfycun), 1550.0031));
        HashMap<String, DWBean> item12 = new HashMap<>();
        item12.put("key", new DWBean("平方英尺", getString(R.string.area_pfychi), 10.7639104));
        HashMap<String, DWBean> item13 = new HashMap<>();
        item13.put("key", new DWBean("平方竿", getString(R.string.area_pfg), 0.0395369));
        HashMap<String, DWBean> item14 = new HashMap<>();
        item14.put("key", new DWBean("顷", getString(R.string.area_qun), 0.000015));
        HashMap<String, DWBean> item15 = new HashMap<>();
        item15.put("key", new DWBean("分", getString(R.string.area_fen), 0.015));
        HashMap<String, DWBean> item16 = new HashMap<>();
        item16.put("key", new DWBean("平方尺", getString(R.string.area_pfchi), 9.0));
        HashMap<String, DWBean> item17 = new HashMap<>();
        item17.put("key", new DWBean("平方寸", getString(R.string.area_pfcun), 900.0));
        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);
        mList.add(item10);
        mList.add(item11);
        mList.add(item12);
        mList.add(item13);
        mList.add(item14);
        mList.add(item15);
        mList.add(item16);
        mList.add(item17);
    }

    private void initLenthData() {
        mList.clear();

        currentBaseBean = new DWBean("米", getString(R.string.lenth_m), 1.0);
        currentExchangeBean = new DWBean("厘米", getString(R.string.lenth_lm), 100.0);

        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("米", getString(R.string.lenth_m), 1.0));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("厘米", getString(R.string.lenth_lm), 100.0));

        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("分米", getString(R.string.lenth_fm), 10.0));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("千米", getString(R.string.lenth_qm), 0.001));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("毫米", getString(R.string.lenth_hm), 1000.0));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("微米", getString(R.string.lenth_wm), 1000000.0));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("纳米", getString(R.string.lenth_nm), 1000000000.0));
        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("皮米", getString(R.string.lenth_pm), 1000000000000.0));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("海里", getString(R.string.lenth_hl), 0.00054));

        HashMap<String, DWBean> item10 = new HashMap<>();
        item10.put("key", new DWBean("光年", getString(R.string.lenth_gn), 1.0570e-16));
        HashMap<String, DWBean> item11 = new HashMap<>();
        item11.put("key", new DWBean("天文单位", getString(R.string.lenth_twdw), 6.6846e-12));
        HashMap<String, DWBean> item12 = new HashMap<>();
        item12.put("key", new DWBean("英寸", getString(R.string.lenth_ycun), 39.3700787));
        HashMap<String, DWBean> item13 = new HashMap<>();
        item13.put("key", new DWBean("inch", getString(R.string.lenth_inch), 39.3700787));
        HashMap<String, DWBean> item14 = new HashMap<>();
        item14.put("key", new DWBean("英里", getString(R.string.lenth_yl), 0.0006214));
        HashMap<String, DWBean> item15 = new HashMap<>();
        item15.put("key", new DWBean("英尺", getString(R.string.lenth_ychi), 3.2808399));
        HashMap<String, DWBean> item16 = new HashMap<>();
        item16.put("key", new DWBean("尺", getString(R.string.lenth_chi), 3.0));
        HashMap<String, DWBean> item17 = new HashMap<>();
        item17.put("key", new DWBean("码", getString(R.string.lenth_ma), 1.0936133));
        HashMap<String, DWBean> item18 = new HashMap<>();
        item18.put("key", new DWBean("英寻", getString(R.string.lenth_yxun), 0.5468066));
        HashMap<String, DWBean> item19 = new HashMap<>();
        item19.put("key", new DWBean("弗隆", getString(R.string.lenth_flong), 0.004971));
        HashMap<String, DWBean> item20 = new HashMap<>();
        item20.put("key", new DWBean("里", getString(R.string.lenth_li_three), 0.002));
        HashMap<String, DWBean> item21 = new HashMap<>();
        item21.put("key", new DWBean("丈", getString(R.string.lenth_zhang), 0.3));
        HashMap<String, DWBean> item22 = new HashMap<>();
        item22.put("key", new DWBean("寸", getString(R.string.lenth_cun), 30.0));
        HashMap<String, DWBean> item23 = new HashMap<>();
        item23.put("key", new DWBean("分", getString(R.string.lenth_fen), 300.0));
        HashMap<String, DWBean> item24 = new HashMap<>();
        item24.put("key", new DWBean("厘", getString(R.string.lenth_li_second), 3000.0));
        HashMap<String, DWBean> item25 = new HashMap<>();
        item25.put("key", new DWBean("毫", getString(R.string.lenth_hao), 30000.0));

        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);
        mList.add(item10);
        mList.add(item11);
        mList.add(item12);
        mList.add(item13);
        mList.add(item14);
        mList.add(item15);
        mList.add(item16);
        mList.add(item17);
        mList.add(item18);
        mList.add(item19);
        mList.add(item20);
        mList.add(item21);
        mList.add(item22);
        mList.add(item23);
        mList.add(item24);
        mList.add(item25);
    }


    private void initCubeData() {

        mList.clear();

        currentBaseBean = new DWBean("立方米", getString(R.string.cube_lfm), 1.0);
        currentExchangeBean = new DWBean("立方厘米", getString(R.string.cube_lflm), 1000000.0);

        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("立方米", getString(R.string.cube_lfm), 1.0));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("立方厘米", getString(R.string.cube_lflm), 1000000.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("立方分米", getString(R.string.cube_lffm), 1000.0));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("立方毫米", getString(R.string.cube_lfhm), 1000000000.0));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("公石", getString(R.string.cube_gs), 10.0));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("升", getString(R.string.cube_sheng), 1000.0));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("分升", getString(R.string.cube_fsheng), 10000.0));
        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("厘升", getString(R.string.cube_lsheng), 100000.0));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("毫升", getString(R.string.cube_hsheng), 1000000.0));

        HashMap<String, DWBean> item10 = new HashMap<>();
        item10.put("key", new DWBean("微升", getString(R.string.cube_wsheng), 1000000000.0));
        HashMap<String, DWBean> item11 = new HashMap<>();
        item11.put("key", new DWBean("立方英寸", getString(R.string.cube_lfycun), 61023.8445022));
        HashMap<String, DWBean> item12 = new HashMap<>();
        item12.put("key", new DWBean("立方码", getString(R.string.cube_lfma), 1.3079528));
        HashMap<String, DWBean> item13 = new HashMap<>();
        item13.put("key", new DWBean("立方英尺", getString(R.string.cube_lfychi), 35.3147248));
        HashMap<String, DWBean> item14 = new HashMap<>();
        item14.put("key", new DWBean("亩英尺", getString(R.string.cube_mychi), 0.0008107));
        HashMap<String, DWBean> item15 = new HashMap<>();
        item15.put("key", new DWBean("英制加仑", getString(R.string.cube_yzjl), 219.9691573));
        HashMap<String, DWBean> item16 = new HashMap<>();
        item16.put("key", new DWBean("美制加仑", getString(R.string.cube_mzjl), 264.1720524));
        HashMap<String, DWBean> item17 = new HashMap<>();
        item17.put("key", new DWBean("英制液体盎司", getString(R.string.cube_yzytzs), 35198.873636));
        HashMap<String, DWBean> item18 = new HashMap<>();
        item18.put("key", new DWBean("美制液体盎司", getString(R.string.cube_mzytzs), 33818.0588434));
        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);
        mList.add(item10);
        mList.add(item11);
        mList.add(item12);
        mList.add(item13);
        mList.add(item14);
        mList.add(item15);
        mList.add(item16);
        mList.add(item17);
        mList.add(item18);
    }


    private void initTimeData() {

        mList.clear();

        currentBaseBean = new DWBean("分钟", getString(R.string.time_f), 1.0);
        currentExchangeBean = new DWBean("秒", getString(R.string.time_m), 60.0);

        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("分钟", getString(R.string.time_f), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("秒", getString(R.string.time_m), 60.0));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("小时", getString(R.string.time_s), 0.0166667));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("微秒", getString(R.string.time_wm), 60000000.0));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("周", getString(R.string.time_z), 0.0000992));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("天", getString(R.string.time_t), 0.0006944));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("年", getString(R.string.time_n), 1.9026e-6));
        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("纳秒", getString(R.string.time_nm), 60000000000.0));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("毫秒", getString(R.string.time_hm), 60000.0));


        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);

    }

    private void initSpeedData() {

        mList.clear();

        currentBaseBean = new DWBean("米/秒", getString(R.string.speed_m_m), 1.0);
        currentExchangeBean = new DWBean("千米/时", getString(R.string.speed_qm_s), 3.6);


        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("米/秒", getString(R.string.speed_m_m), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("千米/时", getString(R.string.speed_qm_s), 3.6));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("英寸/秒", getString(R.string.speed_yc_m), 39.370079));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("马赫", getString(R.string.speed_mh), 0.0029386));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("光速", getString(R.string.speed_gs), 3.3356e-9));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("英里/时", getString(R.string.speed_yl_s), 2.236936));


        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);


    }

    private void initWeightData() {

        mList.clear();

        currentBaseBean = new DWBean("千克", getString(R.string.weight_qk), 1.0);
        currentExchangeBean = new DWBean("克", getString(R.string.weight_k), 1000.0);


        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("千克", getString(R.string.weight_qk), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("克", getString(R.string.weight_k), 1000.0));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("毫克", getString(R.string.weight_hk), 1000000.0));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("斤", getString(R.string.weight_j), 2.0));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("两", getString(R.string.weight_l), 20.0));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("吨", getString(R.string.weight_d), 0.001));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("磅", getString(R.string.weight_b), 2.2046226));
        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("盎司", getString(R.string.weight_zs), 35.2739619));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("公担", getString(R.string.weight_gd), 0.01));

        HashMap<String, DWBean> item10 = new HashMap<>();
        item10.put("key", new DWBean("微克", getString(R.string.weight_wk), 1000000000.0));
        HashMap<String, DWBean> item11 = new HashMap<>();
        item11.put("key", new DWBean("克拉", getString(R.string.weight_kl), 5000.0));
        HashMap<String, DWBean> item12 = new HashMap<>();
        item12.put("key", new DWBean("分", getString(R.string.weight_f), 500000.0));
        HashMap<String, DWBean> item13 = new HashMap<>();
        item13.put("key", new DWBean("格令", getString(R.string.weight_gl), 15432.3583529));
        HashMap<String, DWBean> item14 = new HashMap<>();
        item14.put("key", new DWBean("长吨", getString(R.string.weight_cd), 0.0009842));
        HashMap<String, DWBean> item15 = new HashMap<>();
        item15.put("key", new DWBean("短吨", getString(R.string.weight_dd), 0.0011023));
        HashMap<String, DWBean> item16 = new HashMap<>();
        item16.put("key", new DWBean("英担", getString(R.string.weight_yd), 0.0196841));
        HashMap<String, DWBean> item17 = new HashMap<>();
        item17.put("key", new DWBean("美担", getString(R.string.weight_md), 0.0220462));
        HashMap<String, DWBean> item18 = new HashMap<>();
        item18.put("key", new DWBean("英石", getString(R.string.weight_ys), 0.157473));
        HashMap<String, DWBean> item19 = new HashMap<>();
        item19.put("key", new DWBean("打兰", getString(R.string.weight_dl), 564.3833912));
        HashMap<String, DWBean> item20 = new HashMap<>();
        item20.put("key", new DWBean("担", getString(R.string.weight_dan), 0.02));
        HashMap<String, DWBean> item21 = new HashMap<>();
        item21.put("key", new DWBean("钱", getString(R.string.weight_q), 200.0));


        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);
        mList.add(item10);
        mList.add(item11);
        mList.add(item12);
        mList.add(item13);
        mList.add(item14);
        mList.add(item15);
        mList.add(item16);
        mList.add(item17);
        mList.add(item18);
        mList.add(item19);
        mList.add(item20);
        mList.add(item21);

    }

    private void initTemparatureData() {

        mList.clear();

        currentBaseBean = new DWBean("摄氏度", getString(R.string.temp_ssd), 1.0);
        currentExchangeBean = new DWBean("华氏度", getString(R.string.temp_hsd), 33.8);


        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("摄氏度", getString(R.string.temp_ssd), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("华氏度", getString(R.string.temp_hsd), 33.8));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("开氏度", getString(R.string.temp_ksd), 274.15));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("列氏度", getString(R.string.temp_liesd), 0.8));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("兰氏度", getString(R.string.temp_lansd), 493.47));


        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);


    }


    private void initPressData() {

        mList.clear();

        currentBaseBean = new DWBean("标准大气压", getString(R.string.press_base), 1.0);
        currentExchangeBean = new DWBean("帕斯卡", getString(R.string.press_psk), 101325.0);


        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("标准大气压", getString(R.string.press_base), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("帕斯卡", getString(R.string.press_psk), 101325.0));
        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("千帕", getString(R.string.press_qp), 101.325));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("兆帕", getString(R.string.press_zp), 0.101325));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("巴", getString(R.string.press_bar), 1.01325));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("磅力/平方英寸", getString(R.string.press_psi), 14.6959494));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("公斤力/平方厘米", getString(R.string.press_gjl), 1.0332275));

        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("百帕", getString(R.string.press_bp), 1013.25));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("毫米汞柱", getString(R.string.press_hmgz), 760.0));
        HashMap<String, DWBean> item10 = new HashMap<>();
        item10.put("key", new DWBean("英寸汞柱", getString(R.string.press_ycgz), 29.9212598));
        HashMap<String, DWBean> item11 = new HashMap<>();
        item11.put("key", new DWBean("毫巴", getString(R.string.press_hb), 1013.25));
        HashMap<String, DWBean> item12 = new HashMap<>();
        item12.put("key", new DWBean("毫米水柱", getString(R.string.press_hmsz), 10332.3129));
        HashMap<String, DWBean> item13 = new HashMap<>();
        item13.put("key", new DWBean("磅力/平方英尺", getString(R.string.press_bl_pfyc), 2116.2167137));
        HashMap<String, DWBean> item14 = new HashMap<>();
        item14.put("key", new DWBean("公斤力/平方米", getString(R.string.press_gjl_pfm), 10332.274528));


        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);
        mList.add(item10);
        mList.add(item11);
        mList.add(item12);
        mList.add(item13);
        mList.add(item14);


    }

    private void initPowerData() {
        mList.clear();

        currentBaseBean = new DWBean("瓦", getString(R.string.power_w), 1.0);
        currentExchangeBean = new DWBean("焦耳", getString(R.string.power_jr), 1.0);

        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("瓦", getString(R.string.power_w), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("焦耳", getString(R.string.power_jr), 1.0));

        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("牛顿·米/秒", getString(R.string.power_nd), 1.0));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("千瓦", getString(R.string.power_qw), 0.001));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("英制马力", getString(R.string.power_yzml), 0.001341));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("米制马力", getString(R.string.power_mzml), 0.0013596));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("千卡/秒", getString(R.string.power_qk), 0.000239));

        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("英尺·磅/秒", getString(R.string.power_ychib), 0.7375621));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("英热单位/秒", getString(R.string.power_yrdw), 0.0009478));
        HashMap<String, DWBean> item10 = new HashMap<>();
        item10.put("key", new DWBean("公斤·米/秒", getString(R.string.power_gjm), 0.1019716));


        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);
        mList.add(item10);

    }


    private void initHeatData() {
        mList.clear();

        currentBaseBean = new DWBean("焦耳", getString(R.string.heat_jr), 1.0);
        currentExchangeBean = new DWBean("千焦", getString(R.string.heat_qj), 0.001);

        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("焦耳", getString(R.string.heat_jr), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("千焦", getString(R.string.heat_qj), 0.001));

        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("卡", getString(R.string.heat_k), 0.2389));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("千卡", getString(R.string.heat_qk), 0.0002389));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("千瓦·时", getString(R.string.heat_qws), 2.7778e-7));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("度", getString(R.string.heat_du), 2.7778e-7));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("公斤·米", getString(R.string.heat_gjm), 0.102));

        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("英制马力·时", getString(R.string.heat_yzml), 3.7251e-7));
        HashMap<String, DWBean> item9 = new HashMap<>();
        item9.put("key", new DWBean("米制马力·时", getString(R.string.heat_mzml), 3.7767e-7));
        HashMap<String, DWBean> item10 = new HashMap<>();
        item10.put("key", new DWBean("英热单位", getString(R.string.heat_yrdw), 0.0009478));
        HashMap<String, DWBean> item11 = new HashMap<>();
        item11.put("key", new DWBean("英尺·磅", getString(R.string.heat_ycb), 0.7376));


        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);
        mList.add(item9);
        mList.add(item10);
        mList.add(item11);

    }


    private void initStrenthData() {
        mList.clear();

        currentBaseBean = new DWBean("牛", getString(R.string.strenth_n), 1.0);
        currentExchangeBean = new DWBean("千克力", getString(R.string.strenth_qkl), 0.1019716);

        HashMap<String, DWBean> item1 = new HashMap<>();
        item1.put("key", new DWBean("牛", getString(R.string.strenth_n), 1.0));
        HashMap<String, DWBean> item2 = new HashMap<>();
        item2.put("key", new DWBean("千克力", getString(R.string.strenth_qkl), 0.1019716));

        HashMap<String, DWBean> item3 = new HashMap<>();
        item3.put("key", new DWBean("千牛", getString(R.string.strenth_qn), 0.001));
        HashMap<String, DWBean> item4 = new HashMap<>();
        item4.put("key", new DWBean("克力", getString(R.string.strenth_kl), 101.971621));
        HashMap<String, DWBean> item5 = new HashMap<>();
        item5.put("key", new DWBean("磅力", getString(R.string.strenth_bl), 0.2248089));
        HashMap<String, DWBean> item6 = new HashMap<>();
        item6.put("key", new DWBean("千磅力", getString(R.string.strenth_qbl), 0.0002248));
        HashMap<String, DWBean> item7 = new HashMap<>();
        item7.put("key", new DWBean("达因", getString(R.string.strenth_dy), 100000.0));

        HashMap<String, DWBean> item8 = new HashMap<>();
        item8.put("key", new DWBean("公吨力", getString(R.string.strenth_gdl), 0.000102));

        mList.add(item1);
        mList.add(item2);
        mList.add(item3);
        mList.add(item4);
        mList.add(item5);
        mList.add(item6);
        mList.add(item7);
        mList.add(item8);

    }

    private void toUpper() {

        tv_center.setVisibility(View.GONE);
        tv_bottom.setVisibility(View.GONE);
        text_dw_center.setVisibility(View.GONE);
        text_dw_bottom.setVisibility(View.GONE);
        text_base_bottom.setVisibility(View.GONE);
        text_center.setVisibility(View.GONE);
    }

}