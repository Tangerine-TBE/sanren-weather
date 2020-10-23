package com.nanjing.tqlhl.calculator.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.calculator.base.activity.BaseRxActivity;
import com.nanjing.tqlhl.calculator.bean.CalResultData;
import com.nanjing.tqlhl.calculator.inter.OnMoneyChangerListenner;
import com.nanjing.tqlhl.calculator.inter.OnStartingCityItemClickListenner;
import com.nanjing.tqlhl.calculator.weiget.FullDialog;
import com.nanjing.tqlhl.calculator.weiget.StartingRateCityDialog;
import com.nanjing.tqlhl.calculator.weiget.SwitchButton;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.SpUtils;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.nanjing.tqlhl.R;
import com.umeng.analytics.MobclickAgent;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;

public class GSActivity extends BaseRxActivity implements OnMoneyChangerListenner, OnStartingCityItemClickListenner {
    @BindView(R.id.switchButton)
    SwitchButton switchButton;
    @BindView(R.id.edit_fore_money)
    MaterialEditText edit_fore_money;
    @BindView(R.id.rel_ns_times)
    RelativeLayout rel_ns_times;
    @BindView(R.id.rel_city)
    RelativeLayout rel_city;
    @BindView(R.id.rel_starting)
    RelativeLayout rel_starting;
    @BindView(R.id.rel_zxfjkc)
    RelativeLayout rel_zxfjkc;
    @BindView(R.id.rel_wxyj)
    RelativeLayout rel_wxyj;

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.tv_pulltoselect_city)
    TextView tv_pulltoselect_city;
    @BindView(R.id.tv_pulltoselect_starting)
    TextView tv_pulltoselect_starting;
    @BindView(R.id.tv_pulltoselect_zxfjkc)
    TextView tv_pulltoselect_zxfjkc;
    @BindView(R.id.edit_gjj_personal)
    EditText edit_gjj_personal;
    @BindView(R.id.edit_gjj_company)
    EditText edit_gjj_company;
    @BindView(R.id.edit_yl_personal)
    EditText edit_yl_personal;
    @BindView(R.id.edit_yl_company)
    EditText edit_yl_company;
    @BindView(R.id.edit_yanglao_personal)
    EditText edit_yanglao_personal;
    @BindView(R.id.edit_yanglao_company)
    EditText edit_yanglao_company;
    @BindView(R.id.edit_sy_personal)
    EditText edit_sy_personal;
    @BindView(R.id.edit_sy_company)
    EditText edit_sy_company;
    @BindView(R.id.edit_gs_personal)
    EditText edit_gs_personal;
    @BindView(R.id.edit_gs_company)
    EditText edit_gs_company;
    @BindView(R.id.edit_shengyu_personal)
    EditText edit_shengyu_personal;
    @BindView(R.id.edit_shengyu_company)
    EditText edit_shengyu_company;
    @BindView(R.id.btn_caculate)
    Button btn_caculate;

    @BindView(R.id.title_left_text)
    TextView title_left_text;
    @BindView(R.id.title_content_text)
    TextView title_content_text;
    @BindView(R.id.include_title)
    LinearLayout include_title;
    @BindView(R.id.linear_wxyj_item)
    LinearLayout linear_wxyj_item;//五险一金详细

    @BindView(R.id.linear_jj)
    LinearLayout linear_jj;
    @BindView(R.id.scroll_sr)
    ScrollView scroll_sr;

    @BindView(R.id.edit_fore_money_jj)
    EditText edit_fore_money_jj;
    @BindView(R.id.tv_result_jj)
    TextView tv_result_jj;


    StartingRateCityDialog dialog1;
    FullDialog dialog2;

    private int anim = R.style.CustomAnim;// R.style.DefaultCityPickerAnimation;;
    private List<HotCity> hotCities;
    private List<String> startingCitys;
    private EditText[] editTexts = new EditText[12];//五险一金详细

    double totalZXFJMoney = 0;

    private int monthNumbers;//选择的月数
    private  double[] zxfjkcItems=new double[6];
    double[] wxyjMoney = new double[12];
    double[] currentMonth = new double[4];//税前金额,税前五险一金，单项附加扣除，起征点
    double[] totalMonth = new double[4];//累计税前金额,累计税前五险一金，累计单项附加扣除，累计起征点
    private CalResultData calResultData;
    String[] permissions = new String[]{ACCESS_COARSE_LOCATION};
    private int REQUEST_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.js_activity_gs);

        ButterKnife.bind(this);
        bindView();
        initData();
        askPermissions();
    }

    private void askPermissions() {
        if (Build.VERSION.SDK_INT >= 28) {
            requestPermissions(permissions
                    , 1001);
        } else {
            if (!(hasLocationPermission())) {
                sendRequest();
            }
        }

    }

    private void initData() {
        currentMonth[0] = 0;
        currentMonth[1] = 0;
        currentMonth[2] = 0;
        currentMonth[3] = 0;

        totalMonth[0] = 0;
        totalMonth[1] = 0;
        totalMonth[2] = 0;
        totalMonth[3] = 0;

        hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100"));
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        startingCitys = new ArrayList<>();
        startingCitys.add("内地 5000");
        startingCitys.add("外籍或港澳籍人员 6800");
    }

    private void bindView() {
        locate();
        include_title.setBackgroundResource(R.color.colorTheme);
        title_content_text.setText("个税计算");
        editTexts[0] = findViewById(R.id.edit_gjj_personal);
        editTexts[1] = findViewById(R.id.edit_gjj_company);
        editTexts[2] = findViewById(R.id.edit_yl_personal);
        editTexts[3] = findViewById(R.id.edit_yl_company);
        editTexts[4] = findViewById(R.id.edit_yanglao_personal);
        editTexts[5] = findViewById(R.id.edit_yanglao_company);
        editTexts[6] = findViewById(R.id.edit_sy_personal);
        editTexts[7] = findViewById(R.id.edit_sy_company);
        editTexts[8] = findViewById(R.id.edit_gs_personal);
        editTexts[9] = findViewById(R.id.edit_gs_company);
        editTexts[10] = findViewById(R.id.edit_shengyu_personal);
        editTexts[11] = findViewById(R.id.edit_shengyu_company);
        switchButton.setOnChangeListener(new SwitchButton.OnChangeListener() {
            @Override
            public void onChange(int position) {
                //年终奖
                if (position == 1) {
                    if (linear_jj.getVisibility() == View.GONE) {
                        linear_jj.setVisibility(View.VISIBLE);
                        scroll_sr.setVisibility(View.INVISIBLE);
                    }


                }
                //个税
                else {
                    if (scroll_sr.getVisibility() == View.INVISIBLE) {
                        linear_jj.setVisibility(View.GONE);
                        scroll_sr.setVisibility(View.VISIBLE);

                    }
                }
            }
        });
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i].addTextChangedListener(new TextWatcher() {
                private int index;



                @Override
                public void afterTextChanged(Editable s) {

                    String result = editTexts[index].getText().toString().trim();
                    if (result.length()==1&&result.equals(".")){
                        editTexts[index].setText("");
                        return;
                    }

                    result = deleteErrorChar(result);
                    if (result.equals(""))
                        result = "0";
                    wxyjMoney[index] = Double.parseDouble(result);

                }

                public TextWatcher setIndex(int index) {
                    this.index = index;
                    return this;
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {


                }

            }.setIndex(i));
        }

        edit_fore_money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String result = edit_fore_money.getText().toString().trim();
                if (result.length()==1&&result.equals(".")){
                    edit_fore_money.setText("");
                    return;
                }
                result = deleteErrorChar(result);
                if (result.equals(""))
                    result = "0";
                currentMonth[0] = Double.parseDouble(result);
                int monthNumbers = Integer.parseInt(spinner.getSelectedItem().toString().trim());
                totalMonth[0] = currentMonth[0] * monthNumbers;
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                monthNumbers = Integer.parseInt(spinner.getSelectedItem().toString());
                totalMonth[0] = currentMonth[0] * monthNumbers;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private double getWXYJTotalMoney() {
        double total = 0;
        for (double each : wxyjMoney)
            total = total + each;
        return total;
    }

    private double[] calculateTaxRate(double payRate) {
        double[] result = new double[3];
        if (payRate <= 36000) {
            result[0] = payRate * 0.03 - 0;
            result[1] = 0.03;//税率
            result[2] = 0;//速算扣除
        } else if (payRate <= 144000) {
            result[0] = payRate * 0.1 - 2520;
            result[1] = 0.1;
            result[2] = 2520;
        } else if (payRate <= 300000) {
            result[0] = payRate * 0.2 - 16920;
            result[1] = 0.2;
            result[2] = 16920;
        } else if (payRate <= 420000) {
            result[0] = payRate * 0.25 - 31920;
            result[1] = 0.25;
            result[2] = 31920;
        } else if (payRate <= 660000) {
            result[0] = payRate * 0.3 - 52920;
            result[1] = 0.3;
            result[2] = 52920;
        } else if (payRate <= 960000) {
            result[0] = payRate * 0.35 - 85920;
            result[1] = 0.35;
            result[2] = 85920;
        } else {
            result[0] = payRate * 0.45 - 181920;
            result[1] = 0.45;
            result[2] = 181920;
        }
        return result;
    }

    public static Double roundDouble(double val) {
        Double ret = null;
        try {
            double factor = Math.pow(10, 2);
            ret = Math.floor(val * factor + 0.5) / factor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    //专项附加扣除总额
    @Override
    public void OnMoneyChanged(double totalMoney,double[] moneys) {
        tv_pulltoselect_zxfjkc.setText(String.valueOf(totalMoney));
        zxfjkcItems=moneys;
    }

    @OnClick({R.id.title_left_text, R.id.btn_caculate, R.id.rel_wxyj, R.id.rel_city, R.id.rel_starting, R.id.rel_zxfjkc
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.title_left_text:
                finish();
                break;

            case R.id.btn_caculate:
                calculate();
                break;

            case R.id.rel_wxyj:
                if (linear_wxyj_item.getVisibility() == View.GONE) {
                    linear_wxyj_item.setVisibility(View.VISIBLE);
                } else {
                    linear_wxyj_item.setVisibility(View.GONE);
                }
                break;

            case R.id.rel_city:
               CityPicker.from(this)
                        .enableAnimation(true)
                        .setAnimationStyle(anim)
                        .setLocatedCity(mLocatedCity)
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {
                                tv_pulltoselect_city.setText(data.getName());

                            }

                            @Override
                            public void onCancel() {
                                Toast.makeText(getApplicationContext(), "取消选择", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFail(int position, City data) {

                            }


                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                if (mLocatedCity != null) {
                                    BaseApplication.getHandler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            CityPicker.from(GSActivity.this).locateComplete(mLocatedCity, LocateState.SUCCESS);
                                        }
                                    }, 1000);
                                }
                            }


                        }).show();

                break;
            case R.id.rel_starting:
                dialog1 = new StartingRateCityDialog(this, R.style.CenterDialog, startingCitys, this);
                if (!dialog1.isShowing()) {
                    dialog1.show();
                }
                break;
            case R.id.rel_zxfjkc:
                dialog2 = new FullDialog(this, this,zxfjkcItems);
                if (!dialog2.isShowing()) {
                    dialog2.show();
                }
                break;
        }
    }


    private String deleteErrorChar(String res) {
        for (int i = 0; i < res.length(); i++) {
            char tmp = res.charAt(i);
            if ((tmp < '0' && tmp != '.') || tmp > '9') {
                res = res.substring(0, i) + res.substring(i + 1);
                i--;
                Toast.makeText(this, "请输入0-9的数字或小数点", Toast.LENGTH_SHORT).show();
            }
        }
        return res;
    }


    public void calculate() {
        //个税
        if (scroll_sr.getVisibility() == View.VISIBLE) {
            String pulltoselect_city = tv_pulltoselect_city.getText().toString().trim();
            String pulltoselect_zxfjkc = tv_pulltoselect_zxfjkc.getText().toString().trim();
            String pulltoselect_starting = tv_pulltoselect_starting.getText().toString().trim();
            if (pulltoselect_city.length() <= 0 | pulltoselect_zxfjkc.length() <= 0 | pulltoselect_starting.length() <= 0|edit_fore_money.getText().toString().trim().length()<=0) {
                Toast.makeText(this, "还有未选择的项目", Toast.LENGTH_SHORT).show();
                return;
            }
            calResultData = new CalResultData();

            calResultData.setBeforeTaxSalary0(currentMonth[0]);

            currentMonth[1] = getWXYJTotalMoney();
            currentMonth[2] = roundDouble(Double.parseDouble(pulltoselect_zxfjkc));
            currentMonth[3] = roundDouble(Double.parseDouble(pulltoselect_starting));
            totalMonth[1] = currentMonth[1] * monthNumbers;//总五险一斤
            totalMonth[2] = currentMonth[2] * monthNumbers;//总单项附加
            totalMonth[3] = currentMonth[3] * monthNumbers;//总起征点


            double totalBeforeTaxSalary0 = totalMonth[0];
            double totalInsure0 = totalMonth[1];
            double totalSpecifieDeduction0 = totalMonth[2];
            double totalStartLevyPoint0 = totalMonth[3];

            double insure0 = currentMonth[1];//单月五险一金
            calResultData.setInsure0(insure0);

            double specifieDeduction0 = currentMonth[2];//单月单项附加
            double startLevyPoint0 = currentMonth[3];//单月齐整点
            double beforeTaxSalary0 = Double.parseDouble(edit_fore_money.getText().toString().trim());//本月税前工资
            double lastMonthTotalBeforeTaxSalary = totalBeforeTaxSalary0 - beforeTaxSalary0;
            double lastMonthTotalInsure = totalInsure0 - insure0;
            double lastMonthTotalSpecifieDeduction = totalSpecifieDeduction0 - specifieDeduction0;
            double lastMonthTotalStartLevyPoint = totalStartLevyPoint0 - startLevyPoint0;
            //应纳税所得额=累计收入-累计五险一金（个人缴纳部分）-累计专项附加扣除-累计减除费用
            double getTaxMoney0 = totalBeforeTaxSalary0 - totalInsure0 - totalSpecifieDeduction0 - totalStartLevyPoint0;


            if (getTaxMoney0 > 0) {

                //上月应纳税所得额=上月累计收入-上月累计五险一金（个人缴纳部分）-上月累计专项附加扣除-上月累计减除费用
                double lastMonthgetTaxMoney = lastMonthTotalBeforeTaxSalary - lastMonthTotalInsure - lastMonthTotalSpecifieDeduction - lastMonthTotalStartLevyPoint;

                double[] result;
                //累计应纳税额=应纳税所得额*预扣税率-速算扣除
                result = calculateTaxRate(getTaxMoney0);
                double totalTaxMoney0 = roundDouble(result[0]);//累计应纳税额
                calResultData.setTotalTaxMoney0(totalTaxMoney0);
                calResultData.setRate(result[1]);
                calResultData.setCut(result[2]);

                //累计已交纳税额=上月应纳税所得额*预扣税率-速算扣除
                result = calculateTaxRate(lastMonthgetTaxMoney);

                double totalAlreadyTaxMoney0 = roundDouble(result[0]);//累计已交纳税额
                calResultData.setResult_already(totalAlreadyTaxMoney0);
                //当月应纳税额=累计应纳税额-累计已交纳税额
                double currentPersonalTax0, afterTaxSalary0;
                currentPersonalTax0 = totalTaxMoney0 - totalAlreadyTaxMoney0;//当月应纳个税
                calResultData.setCurrentPersonalTax0(currentPersonalTax0);
                calResultData.setWxyj_gjj(wxyjMoney[0] + wxyjMoney[1]);
                calResultData.setWxyj_yiliao(wxyjMoney[2] + wxyjMoney[3]);
                calResultData.setWxyj_yanglao(wxyjMoney[4] + wxyjMoney[5]);
                calResultData.setWxyj_shiye(wxyjMoney[6] + wxyjMoney[7]);
                calResultData.setWxyj_gongshang(wxyjMoney[8] + wxyjMoney[9]);
                calResultData.setWxyj_shengyu(wxyjMoney[10] + wxyjMoney[11]);

                //本月税后工资=本月税前工资-五险一金-当月应纳税额
                afterTaxSalary0 = beforeTaxSalary0 - insure0 - currentPersonalTax0;
                calResultData.setFinalResult(afterTaxSalary0);
                if (calResultData != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("calculateData", calResultData);
//            bundle.putSerializable("calculateData",calResultData);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(this, GSResultActivity.class);
                    startActivity(intent);
                }

            } else {
                Toast.makeText(this, "未达到起征点，请重新输入数据", Toast.LENGTH_SHORT).show();
                calResultData = null;
            }
        }
        //年终奖
        else if (linear_jj.getVisibility() == View.VISIBLE) {

            String result = edit_fore_money_jj.getText().toString().trim();
            result = deleteErrorChar(result);
            if (result.equals(""))
                result = "0";
            double fore_money_jj = Double.parseDouble(result);
            if (fore_money_jj<=5000) {
                Toast.makeText(this, "未达到起征点，请重新输入数据", Toast.LENGTH_SHORT).show();
            }
            double[] result_jj = calculateTaxRate(fore_money_jj);
            double   final_result=fore_money_jj-result_jj[0];
            tv_result_jj.setText(String.valueOf(final_result));
        }
    }

    private LocatedCity mLocatedCity;
    private void locate() {
        String currentCity = SpUtils.getInstance().getString(Contents.CURRENT_CITY,"");
        if (!TextUtils.isEmpty(currentCity)) {

            mLocatedCity = new LocatedCity(currentCity, "", "");
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void OnStartingCityItemClick(int position) {
        if (position == 0) {
            tv_pulltoselect_starting.setText("5000");
        } else if (position == 1) {
            tv_pulltoselect_starting.setText("6800");
        }
        if (dialog1 != null && dialog1.isShowing()) {
            dialog1.dismiss();
        }
    }

    private boolean hasLocationPermission() {
        return AndPermission.hasPermission(this, ACCESS_COARSE_LOCATION);

    }

    private void sendRequest() {
        AndPermission.with(this).requestCode(REQUEST_PERMISSION_CODE).permission(
                ACCESS_COARSE_LOCATION
        ).callback(permissionListener).start();
    }

    //api<28 回掉
    private PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {


        }

        @Override
        public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
            if (requestCode == REQUEST_PERMISSION_CODE) {
                Toast.makeText(GSActivity.this, "权限不足", Toast.LENGTH_SHORT);

                boolean location = deniedPermissions.contains(ACCESS_COARSE_LOCATION);
                if (AndPermission.hasAlwaysDeniedPermission(GSActivity.this, deniedPermissions) && location) {

                    GSActivity.this.finish();

                    return;
                }

            }
        }
    };


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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1001) {

            boolean location = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;

            //拒绝了权限
            if (!location) {
                Toast.makeText(GSActivity.this, "权限不足", Toast.LENGTH_SHORT);
                finish();
            }
        }
    }

}
