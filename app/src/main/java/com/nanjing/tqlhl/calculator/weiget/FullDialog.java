package com.nanjing.tqlhl.calculator.weiget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nanjing.tqlhl.calculator.inter.OnMoneyChangerListenner;
import com.nanjing.tqlhl.R;


public class FullDialog extends Dialog {
    OnMoneyChangerListenner mOnMoneyChangedListener;
    private EditText[] editTexts = new EditText[6];
    private SmoothCheckBox[] checkBoxes = new SmoothCheckBox[6];
    double[] money = new double[6];

    Context mContext;
    TextView back;

    public FullDialog(Context context,OnMoneyChangerListenner onMoneyChangedListener,double[] items) {
        super(context, R.style.FullDialog);
        mContext = context;
        mOnMoneyChangedListener=onMoneyChangedListener;
        setOwnerActivity((Activity) context);
        setContentView(R.layout.js_zxfjkc_dialog);
        money=items;
        initView();

    }

    private void initView() {
        setCanceledOnTouchOutside(false);
        back = findViewById(R.id.dialog_title_left);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnMoneyChangedListener.OnMoneyChanged(getTotal(),money);
                dismiss();
            }
        });
        editTexts[0] = findViewById(R.id.edit_znjy);
        editTexts[1] = findViewById(R.id.edit_jxjy);
        editTexts[2] = findViewById(R.id.edit_dbyl);
        editTexts[3] = findViewById(R.id.edit_zfdklx);
        editTexts[4] = findViewById(R.id.edit_zfzj);
        editTexts[5] = findViewById(R.id.edit_sylr);
        editTexts[0].setText(money[0]+"");
        editTexts[1].setText(money[1]+"");
        editTexts[2].setText(money[2]+"");
        editTexts[3].setText(money[3]+"");
        editTexts[4].setText(money[4]+"");
        editTexts[5].setText(money[5]+"");

        checkBoxes[0] = findViewById(R.id.checkbox_znjy);
        checkBoxes[1] = findViewById(R.id.checkbox_jxjy);
        checkBoxes[2] = findViewById(R.id.checkbox_dbyl);
        checkBoxes[3] = findViewById(R.id.checkbox_zfdklx);
        checkBoxes[4] = findViewById(R.id.checkbox_zfzj);
        checkBoxes[5] = findViewById(R.id.checkbox_sylr);



        for (int i = 0; i < 6; i++) {
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
                    money[index] = Double.parseDouble(result);

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
    }

    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;

        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        getWindow().setAttributes(layoutParams);
    }

    private String deleteErrorChar(String res) {
        for (int i = 0; i < res.length(); i++) {
            char tmp = res.charAt(i);
            if ((tmp < '0' && tmp != '.') || tmp > '9') {
                res = res.substring(0, i) + res.substring(i + 1);
                i--;
                Toast.makeText(mContext, "请输入0-9的数字或小数点", Toast.LENGTH_SHORT).show();
            }
        }
        return res;
    }

    private double getTotal() {
        double total = 0;
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isChecked()) {
                total = total + money[i];
            }
        }

        return total;
    }


}