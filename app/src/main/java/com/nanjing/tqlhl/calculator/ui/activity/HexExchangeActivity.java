package com.nanjing.tqlhl.calculator.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.nanjing.tqlhl.calculator.base.activity.BaseActivity2;
import com.nanjing.tqlhl.calculator.keyboard.NumberKeyBoradManager;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.nanjing.tqlhl.R;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HexExchangeActivity extends BaseActivity2 {

    @BindView(R.id.nine)
    Button nine;
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

    @BindView(R.id.a)
    Button a;
    @BindView(R.id.b)
    Button b;

    @BindView(R.id.c)
    Button c;
    @BindView(R.id.d)
    Button d;

    @BindView(R.id.zero)
    Button zero;
    @BindView(R.id.f)
    Button f;
    @BindView(R.id.bt_clear)
    Button bt_clear;
    @BindView(R.id.dot)
    Button dot;

    @BindView(R.id.title_left_text)
    TextView title_left_text;
    @BindView(R.id.title_content_text)
    TextView title_content_text;
    @BindView(R.id.include_title)
    LinearLayout include_title;

    @BindView(R.id.edit_two)
    MaterialEditText edit_two;

    @BindView(R.id.edit_ten)
    MaterialEditText edit_ten;
    @BindView(R.id.edit_eight)
    MaterialEditText edit_eight;
    @BindView(R.id.edit_sixteen)
    MaterialEditText edit_sixteen;

    List<MaterialEditText> editList = new ArrayList<>();
    MaterialEditText focusedView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_activity_hex);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);//禁止弹出软键盘最有效的方法
        ButterKnife.bind(this);


        bindView();
    }

    private void addEditView() {
        editList.add(edit_two);
        editList.add(edit_eight);
        editList.add(edit_ten);
        editList.add(edit_sixteen);
        for (MaterialEditText view : editList) {
            view.setOnFocusChangeListener(focusListener);
        }
    }

    private void bindView() {
        addEditView();
        include_title.setBackgroundResource(R.color.colorTheme);
        title_content_text.setText("进制转换");

        edit_two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int i1, int i2) {
                if (charSequence.toString().isEmpty()){
                     return;
                }
                String s = charSequence.toString().trim();
                    String isValid= s.substring(start,start+1);//取出最后一个输入的字符
                if ("ABCDEF.23456789".contains(isValid)) {
                    Toast.makeText(getApplicationContext(),"请输入0或1", Toast.LENGTH_LONG).show();
                    edit_two.setText("");
                    return;
                }
                if (s.length() > 0&&edit_two.hasFocus()) {//有焦点的时候才转换 否则进入递归

                    edit_ten.setText(Integer.valueOf(s, 2).toString());
                    edit_eight.setText(Integer.toOctalString(Integer.parseInt(s, 2)));
                    edit_sixteen.setText(Integer.toHexString(Integer.parseInt(s, 2)));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edit_eight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int i1, int i2) {
                if (charSequence.toString().isEmpty()){
                    return;
                }
                String s = charSequence.toString().trim();
                String isValid= s.substring(start,start+1);
                if ("ABCDEF.89".contains(isValid)) {
                    Toast.makeText(getApplicationContext(),"请输入0到7", Toast.LENGTH_LONG).show();

                    edit_eight.setText("");
                    return;
                }
                if (s.length() > 0&&edit_eight.hasFocus()) {

                    edit_ten.setText(Integer.valueOf(s, 8).toString());
                    edit_two.setText(Integer.toBinaryString(Integer.valueOf(s, 8)));
                    edit_sixteen.setText(Integer.toHexString(Integer.valueOf(s, 8)));

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edit_ten.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int i1, int i2) {
                if (charSequence.toString().isEmpty()){
                    return;
                }
                String s = charSequence.toString().trim();
                String isValid= s.substring(start,start+1);
                if ("ABCDEF.".contains(isValid)) {
                    Toast.makeText(getApplicationContext(),"请输入0到9", Toast.LENGTH_LONG).show();

                    edit_ten.setText("");
                    return;
                }
                if (s.length() > 0&&edit_ten.hasFocus()) {

                    edit_sixteen.setText(Integer.toHexString(Integer.parseInt(s)));
                    edit_eight.setText(Integer.toOctalString(Integer.parseInt(s)));
                    edit_two.setText(Integer.toBinaryString(Integer.parseInt(s)));

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edit_sixteen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int i1, int i2) {
                if (charSequence.toString().isEmpty()){
                    return;
                }
                String s = charSequence.toString().trim();
                String isValid= s.substring(start,start+1);
                if (".".contains(isValid)) {
                    Toast.makeText(getApplicationContext(),"无效字符", Toast.LENGTH_LONG).show();
                    edit_sixteen.setText("");
                    return;
                }
                if (s.length() > 0&&edit_sixteen.hasFocus()) {

                    edit_ten.setText(Integer.valueOf(s, 16).toString());
                    edit_two.setText(Integer.toBinaryString(Integer.valueOf(s, 16)));
                    edit_eight.setText(Integer.toOctalString(Integer.valueOf(s, 16)));


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edit_two.requestFocus();
    }


    private View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() {
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                focusedView = (MaterialEditText) v;
            } else {
                focusedView = null;
            }
        }
    };

    @OnClick({R.id.title_left_text, R.id.a, R.id.b, R.id.c, R.id.d, R.id.e, R.id.f,
            R.id.back, R.id.seven, R.id.eight, R.id.nine,
            R.id.four, R.id.five, R.id.six,
            R.id.one, R.id.two, R.id.three,
            R.id.zero, R.id.dot, R.id.bt_clear})
    public void onViewClicked(View view) {
        if (isclickKeyboard(view)) {
            String command;
            String inputStr;
            if (view.getId() == R.id.back) {
                command = "back";

            } else if (view.getId() == R.id.bt_clear) {
                command = "";
                focusedView.setText(command);
            } else {
                command = ((Button) view).getText().toString();//按键上的命令获取
            }
            inputStr = focusedView.getText().toString();//显示器上的字符串
            NumberKeyBoradManager.get().key(this, command, inputStr, focusedView);
        }
        switch (view.getId()) {

            case R.id.title_left_text:

                finish();
                break;

        }
    }


    private boolean isclickKeyboard(View v) {
        if (v.getId() == R.id.back | v.getId() == R.id.seven | v.getId() == R.id.eight | v.getId() == R.id.nine | v.getId() == R.id.four | v.getId() == R.id.five | v.getId() == R.id.six | v.getId() == R.id.one | v.getId() == R.id.two | v.getId() == R.id.three | v.getId() == R.id.zero | v.getId() == R.id.dot | v.getId() == R.id.bt_clear
                | v.getId() == R.id.a | v.getId() == R.id.b | v.getId() == R.id.c | v.getId() == R.id.d | v.getId() == R.id.e | v.getId() == R.id.f
        ) {
            return true;
        } else {

            return false;
        }
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
}
