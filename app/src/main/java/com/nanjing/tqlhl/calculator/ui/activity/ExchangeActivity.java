package com.nanjing.tqlhl.calculator.ui.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nanjing.tqlhl.calculator.base.activity.ModelBaseActivity;
import com.nanjing.tqlhl.calculator.bean.DWBean;
import com.nanjing.tqlhl.calculator.bean.ExchangeActualBean;
import com.nanjing.tqlhl.calculator.bean.ExchangeBean;
import com.nanjing.tqlhl.calculator.bean.ExchangeListBean;
import com.nanjing.tqlhl.calculator.inter.OnDialogItemClickListener;
import com.nanjing.tqlhl.calculator.keyboard.NumberKeyBoradManager;
import com.nanjing.tqlhl.calculator.present.ExchangePressenter;
import com.nanjing.tqlhl.calculator.view.IExchangeView;
import com.nanjing.tqlhl.calculator.weiget.ExchangeDialog;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.nanjing.tqlhl.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class ExchangeActivity extends ModelBaseActivity<ExchangePressenter> implements IExchangeView, OnDialogItemClickListener, View.OnClickListener {


    TextView tv_title, text_dw, text_dw_center, text_dw_bottom;
    MaterialEditText edit_base, edit_base_center, edit_base_bottom;
    ExchangeBean exchangeBean = new ExchangeBean();
    ExchangeDialog dialog;
    List<HashMap<String, String>> country_list = new ArrayList<>();


    ImageButton back;

    TextView title_left_text;
    TextView tv_top;
    TextView tv_center;
    TextView tv_bottom;
    ImageView img_base;
    ImageView img_center;
    ImageView img_base_bottom;

    Button dot;
    Button AC;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;




    @Override
    protected ExchangePressenter initInjector() {
        return new ExchangePressenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // MobclickAgent.onResume(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
      //  MobclickAgent.onPause(this);
    }

    @Override
    protected void onCreateActivity() {
        setContentView(R.layout.js_activity_exchange);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);//禁止弹出软键盘最有效的方法
        intiView();
        initEvent();
    }




    @Override
    protected void initData() {

    }


    @Override
    protected void bindView() {

        text_dw = findViewById(R.id.text_dw);
        text_dw_center = findViewById(R.id.text_dw_center);
        text_dw_bottom = findViewById(R.id.text_dw_bottom);
        tv_title = findViewById(R.id.title_content_text);
        edit_base = findViewById(R.id.edit_base);
        edit_base_center = findViewById(R.id.edit_base_center);
        edit_base_bottom = findViewById(R.id.edit_base_bottom);
        edit_base.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    mPresenter.getActualExchange(tv_top.getText().toString().trim(), s.toString(), tv_center.getText().toString().trim(), R.id.edit_base_center);
                    mPresenter.getActualExchange(tv_top.getText().toString().trim(), s.toString(), tv_bottom.getText().toString().trim(), R.id.edit_base_bottom);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tv_title.setText("汇率转换");

    }

    @Override
    protected void firstRequest() {
        mPresenter.getExchangeList();
    }


    @Override
    public void ItemClick(int clickId, HashMap<String, DWBean> item) {

    }

    @Override
    public void refreshExchangeList(ExchangeListBean reslut) {
        country_list.clear();
        exchangeBean = reslut.getShowapi_res_body();
        HashMap<String, String> item1 = new HashMap<>();
        item1.put(exchangeBean.getCNY(), "人民币");
        item1.put("image",R.drawable.flag_cn+"");
        HashMap<String, String> item2 = new HashMap<>();
        item2.put(exchangeBean.getUSD(), "美元");
        item2.put("image",R.drawable.flag_us+"");
        HashMap<String, String> item3 = new HashMap<>();
        item3.put(exchangeBean.getEUR(), "欧元");
        item3.put("image",R.drawable.flag_de+"");
        HashMap<String, String> item4 = new HashMap<>();
        item4.put(exchangeBean.getGBP(), "英镑");
        item4.put("image",R.drawable.flag_gb+"");
        HashMap<String, String> item5 = new HashMap<>();
        item5.put(exchangeBean.getJPY(), "日元");
        item5.put("image",R.drawable.flag_jp+"");
        HashMap<String, String> item6 = new HashMap<>();
        item6.put(exchangeBean.getIDR(), "印尼卢比");
        item6.put("image",R.drawable.flag_id+"");
        HashMap<String, String> item7 = new HashMap<>();
        item7.put(exchangeBean.getNZD(), "新西兰元");
        item7.put("image",R.drawable.flag_nz+"");
        HashMap<String, String> item8 = new HashMap<>();
        item8.put(exchangeBean.getSGD(), "新加坡元");
        item8.put("image",R.drawable.flag_sg+"");
        HashMap<String, String> item9 = new HashMap<>();
        item9.put(exchangeBean.getTHB(), "泰国铢");
        item9.put("image",R.drawable.flag_th+"");
        HashMap<String, String> item10 = new HashMap<>();
        item10.put(exchangeBean.getSEK(), "瑞典克朗");
        item10.put("image",R.drawable.flag_se+"");
        HashMap<String, String> item11 = new HashMap<>();
        item11.put(exchangeBean.getCHF(), "瑞士法郎");
        item11.put("image",R.drawable.flag_ch+"");
        HashMap<String, String> item12 = new HashMap<>();
        item12.put(exchangeBean.getRUB(), "卢布");
        item12.put("image",R.drawable.flag_ru+"");
        HashMap<String, String> item13 = new HashMap<>();
        item13.put(exchangeBean.getPHP(), "菲律宾比索");
        item13.put("image",R.drawable.flag_ph+"");
        HashMap<String, String> item14 = new HashMap<>();
        item14.put(exchangeBean.getHKD(), "港币");
        item14.put("image",R.drawable.flag_hk+"");
        HashMap<String, String> item15 = new HashMap<>();
        item15.put(exchangeBean.getMYR(), "林吉特");
        item15.put("image",R.drawable.flag_my+"");
        HashMap<String, String> item16 = new HashMap<>();
        item16.put(exchangeBean.getINR(), "印度卢比");
        item16.put("image",R.drawable.flag_in+"");
        HashMap<String, String> item17 = new HashMap<>();
        item17.put(exchangeBean.getDKK(), "丹麦克朗");
        item17.put("image",R.drawable.flag_dk+"");
        HashMap<String, String> item18 = new HashMap<>();
        item18.put(exchangeBean.getCAD(), "加拿大元");
        item18.put("image",R.drawable.flag_ca+"");
        HashMap<String, String> item19 = new HashMap<>();
        item19.put(exchangeBean.getNOK(), "挪威克朗");
        item19.put("image",R.drawable.flag_no+"");
        HashMap<String, String> item20 = new HashMap<>();
        item20.put(exchangeBean.getAED(), "阿联酋迪拉姆");
        item20.put("image",R.drawable.flag_ae+"");
        HashMap<String, String> item21 = new HashMap<>();
        item21.put(exchangeBean.getAED(), "阿联酋迪拉姆");
        item21.put("image",R.drawable.flag_ae+"");
        HashMap<String, String> item22 = new HashMap<>();
        item22.put(exchangeBean.getSAR(), "沙特里亚尔");
        item22.put("image",R.drawable.flag_sa+"");
        HashMap<String, String> item23 = new HashMap<>();
        item23.put(exchangeBean.getBRL(), "巴西里亚尔");
        item23.put("image",R.drawable.flag_br+"");
        HashMap<String, String> item24 = new HashMap<>();
        item24.put(exchangeBean.getMOP(), "澳门元");
        item24.put("image",R.drawable.flag_mo+"");
        HashMap<String, String> item25 = new HashMap<>();
        item25.put(exchangeBean.getZAR(), "南非兰特");
        item25.put("image",R.drawable.flag_za+"");
        HashMap<String, String> item26 = new HashMap<>();
        item26.put(exchangeBean.getTRY(), "土耳其里拉");
        item26.put("image",R.drawable.flag_tr+"");
        HashMap<String, String> item27 = new HashMap<>();
        item27.put(exchangeBean.getKRW(), "韩国元");
        item27.put("image",R.drawable.flag_kr+"");
        HashMap<String, String> item28 = new HashMap<>();
        item28.put(exchangeBean.getTWD(), "新台币");
        item28.put("image",R.drawable.flag_tw+"");
        HashMap<String, String> item29 = new HashMap<>();
        item29.put(exchangeBean.getAUD(), "澳大利亚元");
        item29.put("image",R.drawable.flag_au+"");
        country_list.add(item1);
        country_list.add(item2);
        country_list.add(item3);
        country_list.add(item4);
        country_list.add(item5);
        country_list.add(item6);
        country_list.add(item7);
        country_list.add(item8);
        country_list.add(item9);
        country_list.add(item10);
        country_list.add(item11);
        country_list.add(item12);
        country_list.add(item13);
        country_list.add(item14);
        country_list.add(item15);
        country_list.add(item16);
        country_list.add(item17);
        country_list.add(item18);
        country_list.add(item19);
        country_list.add(item20);
        country_list.add(item21);
        country_list.add(item22);
        country_list.add(item23);
        country_list.add(item24);
        country_list.add(item25);
        country_list.add(item26);
        country_list.add(item27);
        country_list.add(item28);
        country_list.add(item29);


    }

    @Override
    public void getActualExchange(ExchangeActualBean reslut, int textId) {
        if (textId == R.id.edit_base_center) {
            edit_base_center.setText(reslut.getShowapi_res_body().getMoney());
        } else if (textId == R.id.edit_base_bottom) {

            edit_base_bottom.setText(reslut.getShowapi_res_body().getMoney());
        }

    }



    @Override
    public void finishRefresh(String s) {
        edit_base_center.setText("0");
        edit_base_bottom.setText("0");
        Toast.makeText(this, s, Toast.LENGTH_SHORT);

    }


    @Override
    public void ItemClick(HashMap<String, String> item, int clickId) {
        Set set = item.keySet();
        Iterator iter = set.iterator();
        String key = ""; //只有一个
        while (iter.hasNext()) {
            key = (String) iter.next();

        }
        int resId=Integer.parseInt(item.get("image"));
        if (clickId == R.id.text_pulltoselect) {
            tv_top.setText(key);
            text_dw.setText(item.get(key));
            Glide.with(this).load(resId).into(img_base);
        } else if (clickId == R.id.text_pulltoselect_center) {

            tv_center.setText(key);
            text_dw_center.setText(item.get(key));
            Glide.with(this).load(resId).into(img_center);
        } else if (clickId == R.id.text_pulltoselect_bottom) {

            tv_bottom.setText(key);
            text_dw_bottom.setText(item.get(key));
            Glide.with(this).load(resId).into(img_base_bottom);
        }


        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private void showExchangeDialog(int clickId) {

        dialog = new ExchangeDialog(getContext(), R.style.CenterDialog, country_list, clickId, this);
        dialog.setTitle("请选择");

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }


    private void initEvent() {
        tv_top.setOnClickListener(this);
        tv_center.setOnClickListener(this);
        tv_bottom.setOnClickListener(this);
        title_left_text.setOnClickListener(this);
        back.setOnClickListener(this);
        dot.setOnClickListener(this);
        AC.setOnClickListener(this);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        six.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);


    }
    private void intiView() {
        back= findViewById(R.id.back);
        seven= findViewById(R.id.seven);
        eight= findViewById(R.id.eight);
        title_left_text= findViewById(R.id.title_left_text);
        tv_top= findViewById(R.id.text_pulltoselect);
        tv_center= findViewById(R.id.text_pulltoselect_center);
        tv_bottom= findViewById(R.id.text_pulltoselect_bottom);
        img_base= findViewById(R.id.img_base);
        img_center= findViewById(R.id.img_center);
        img_base_bottom= findViewById(R.id.img_base_bottom);
        nine= findViewById(R.id.nine);
        AC= findViewById(R.id.AC);
        four= findViewById(R.id.four);
        five= findViewById(R.id.five);
        six= findViewById(R.id.six);
        one= findViewById(R.id.one);
        two= findViewById(R.id.two);
        three= findViewById(R.id.three);
        dot= findViewById(R.id.dot);
        zero= findViewById(R.id.zero);
    }

    private boolean isclickKeyboard(View v) {
        if (v.getId() == R.id.back | v.getId() == R.id.seven | v.getId() == R.id.eight | v.getId() == R.id.nine | v.getId() == R.id.four | v.getId() == R.id.five | v.getId() == R.id.six | v.getId() == R.id.one | v.getId() == R.id.two | v.getId() == R.id.three | v.getId() == R.id.zero | v.getId() == R.id.dot | v.getId() == R.id.AC) {
            return true;
        } else {

            return false;
        }
    }

    @Override
    public void onClick(View view) {
        if (isclickKeyboard(view)) {
            String command;
            String inputStr;
            if (view.getId() == R.id.back) {
                command = "back";

            } else {
                command = ((Button) view).getText().toString();//按键上的命令获取
            }
            inputStr = edit_base.getText().toString();//显示器上的字符串
            NumberKeyBoradManager.get().key(this, command, inputStr, edit_base);
        }
        int i = view.getId();
        if (i == R.id.text_pulltoselect) {
            showExchangeDialog(R.id.text_pulltoselect);
        } else if (i == R.id.text_pulltoselect_center) {
            showExchangeDialog(R.id.text_pulltoselect_center);
        } else if (i == R.id.text_pulltoselect_bottom) {
            showExchangeDialog(R.id.text_pulltoselect_bottom);
        } else if (i == R.id.title_left_text) {
            finish();
        }
    }
}
