package com.nanjing.tqlhl.calculator.keyboard;

import android.content.Context;
import android.widget.EditText;

import com.nanjing.tqlhl.R;

import java.text.DecimalFormat;

public class NumberKeyBoradManager {

    private Cal mCal;
    private String str_old;
    private String str_new;
    private boolean vbegin = true;//输入控制，true为重新输入，false为接着输入
    private boolean drg_flag = true;//控制DRG按键，true为角度，false为弧度
    private boolean tip_lock = true;//true表示正确，可以继续输入；false表示有误，输入被锁定
    private boolean is_before_equals = true;//判断是否是按=之后的输入，true表示输入在=之前，false反之

    /*
     * 键盘命令捕捉
     */
    private String[] tipCommand = new String[500];//命令缓存，用于检测输入合法性
    private int tip_i = 0;//tipCommand的指针
    EditText mInput;
    Context context;

    public static NumberKeyBoradManager get() {

        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static NumberKeyBoradManager instance = new NumberKeyBoradManager();
    }

    public void key(Context context, String command, String inputStr, EditText mInput) {
        //显示器没有字符串了还点x或者小数点
        if (inputStr.length()==0&&(command=="back"|command==".")){
            return;
        }
        this.context = context;
        this.mInput = mInput;
        // 检测输入是否合法
        // 不在=之前&&字符串包含command
        if (!is_before_equals && context.getString(R.string.inputstr).contains(command)) {
            //检测显示器上的字符串是否合法
            if (right(inputStr)) {
                if ("+-×÷√^)".contains(command)) {//命令缓存
                    for (int i = 0; i < inputStr.length(); i++) {
                        tipCommand[tip_i] = String.valueOf(inputStr.charAt(i));
                        tip_i++;
                    }
                    vbegin = false;//不需要重新输入
                }
            } else {
                mInput.setText("0");
                vbegin = true;//需要重新输入
                tip_i = 0;
                tip_lock = true;//可以输入

            }

            is_before_equals = true;//true表示输入在=之前
        }
        if (tip_i > 0)
            TipChecker(tipCommand[tip_i - 1], command);
        else if (tip_i == 0) {
            TipChecker("#", command);
        }
        if (context.getString(R.string.inputstr2).contains(command) && tip_lock) {
            tipCommand[tip_i] = command;
            tip_i++;
        }
        //若输入正确，则将输入信息显示到显示器上
        if ("0123456789.()sincostanlnlogn!+-×÷√^".contains(command)
                && tip_lock) { //共25个按键
            print(command);
            //若果点击了“DRG”，则切换当前弧度角度制，并将切换后的结果显示到按键上方。
        } else if (command.compareTo("back") == 0 && is_before_equals) {
            //一次删除3个字符
            if (TTO(inputStr) == 3) {
                if (inputStr.length() > 3)
                    mInput.setText(inputStr.substring(0, inputStr.length() - 3));
                else if (inputStr.length() == 3) {
                    mInput.setText("0");
                    vbegin = true;
                    tip_i = 0;

                }
                //依次删除2个字符
            } else if (TTO(inputStr) == 2) {
                if (inputStr.length() > 2)
                    mInput.setText(inputStr.substring(0, inputStr.length() - 2));
                else if (inputStr.length() == 2) {
                    mInput.setText("0");
                    vbegin = true;
                    tip_i = 0;

                }
                //依次删除一个字符
            } else if (TTO(inputStr) == 1) {
                //若之前输入的字符串合法则删除一个字符
                if (right(inputStr)) {
                    if (inputStr.length() > 1)
                        mInput.setText(inputStr.substring(0, inputStr.length() - 1));
                    else if (inputStr.length() == 1) {
                        mInput.setText("0");
                        vbegin = true;
                        tip_i = 0;

                    }
                    //若之前输入的字符串不合法则删除全部字符
                } else {
                    mInput.setText("0");
                    vbegin = true;
                    tip_i = 0;

                }
            }
            if (mInput.getText().toString().compareTo("-") == 0 || !is_before_equals) {
                mInput.setText("0");
                vbegin = true;
                tip_i = 0;

            }
            tip_lock = true;
            if (tip_i > 0)
                tip_i--;
            //如果是在按=之后输入退格键
        } else if (command.compareTo("back") == 0 && !is_before_equals) {
            //将显示器内容设置为0
            mInput.setText("0");
            vbegin = true;
            tip_i = 0;
            tip_lock = true;

            //如果输入的是清除键
        } else if (command.compareTo("AC") == 0) {
            //将显示器内容设置为0
            mInput.setText("0");
            //重新输入标志置为true
            vbegin = true;
            //缓存命令位数清0
            tip_i = 0;
            //表明可以继续输入
            tip_lock = true;
            //表明输入=之前
            is_before_equals = true;


        } else if (command.compareTo("=") == 0 && tip_lock && right(inputStr) && is_before_equals) {
            tip_i = 0;
            //表明不可以继续输入
            tip_lock = false;
            //表明输入=之后
            is_before_equals = false;
            //保存原来算式样子
            str_old = inputStr;
            //替换算式中的运算符，便于计算
            inputStr = inputStr.replaceAll("sin", "s");
            inputStr = inputStr.replaceAll("cos", "c");
            inputStr = inputStr.replaceAll("tan", "t");
            inputStr = inputStr.replaceAll("log", "g");
            inputStr = inputStr.replaceAll("ln", "l");
            inputStr = inputStr.replaceAll("n!", "!");
            //重新输入标志设置true
            vbegin = true;
            //将-1x转换成-
            str_new = inputStr.replaceAll("-", "-1×");
            //计算算式结果
            mCal = new Cal(drg_flag);
            mCal.process(str_new);

        }
        //表明可以继续输入
        tip_lock = true;
    }


    private double FP(double n) {
        //NumberFormat format=NumberFormat.getInstance();  //创建一个格式化类f
        //format.setMaximumFractionDigits(18);    //设置小数位的格式
        DecimalFormat format = new DecimalFormat("0.#############");
        return Double.parseDouble(format.format(n));
    }

    //向input输出字符
    private void print(String inputStr) {
        //清屏后输出
        if (vbegin)
            mInput.setText(inputStr);
            //在屏幕原str后增添字符
        else
            mInput.append(inputStr);
        vbegin = false;
    }

    /*
     * 判断一个str是否是合法的，返回值为true、false
     * 只包含0123456789.()sincostanlnlogn!+-×÷√^的是合法的str，返回true
     * 包含了除0123456789.()sincostanlnlogn!+-×÷√^以外的字符的str为非法的，返回false
     * inputStr 显示器上的字符串
     */
    private boolean right(String inputStr) {
        int i;
        for (i = 0; i < inputStr.length(); i++) {//如果出现其他字符就break i不会等于str.length 返回false
            if (inputStr.charAt(i) != '0' && inputStr.charAt(i) != '1' && inputStr.charAt(i) != '2' &&
                    inputStr.charAt(i) != '3' && inputStr.charAt(i) != '4' && inputStr.charAt(i) != '5' &&
                    inputStr.charAt(i) != '6' && inputStr.charAt(i) != '7' && inputStr.charAt(i) != '8' &&
                    inputStr.charAt(i) != '9' && inputStr.charAt(i) != '.' && inputStr.charAt(i) != '-' &&
                    inputStr.charAt(i) != '+' && inputStr.charAt(i) != '×' && inputStr.charAt(i) != '÷' &&
                    inputStr.charAt(i) != '√' && inputStr.charAt(i) != '^' && inputStr.charAt(i) != 's' &&
                    inputStr.charAt(i) != 'i' && inputStr.charAt(i) != 'n' && inputStr.charAt(i) != 'c' &&
                    inputStr.charAt(i) != 'o' && inputStr.charAt(i) != 't' && inputStr.charAt(i) != 'a' &&
                    inputStr.charAt(i) != 'l' && inputStr.charAt(i) != 'g' && inputStr.charAt(i) != '(' &&
                    inputStr.charAt(i) != ')' && inputStr.charAt(i) != '!')
                break;
        }
        return i == inputStr.length();
    }

    /*
     * 检测函数，返回值为3、2、1  表示应当一次删除几个？  Three+Two+One = TTO
     * 为Bksp按钮的删除方式提供依据
     * 返回3，表示str尾部为sin、cos、tan、log中的一个，应当一次删除3个
     * 返回2，表示str尾部为ln、n!中的一个，应当一次删除2个
     * 返回1，表示为除返回3、2外的所有情况，只需删除一个（包含非法字符时要另外考虑：应清屏）
     */
    private int TTO(String inputStr) {
        if ((inputStr.charAt(inputStr.length() - 1) == 'n' &&
                inputStr.charAt(inputStr.length() - 2) == 'i' &&
                inputStr.charAt(inputStr.length() - 3) == 's') ||
                (inputStr.charAt(inputStr.length() - 1) == 's' &&
                        inputStr.charAt(inputStr.length() - 2) == 'o' &&
                        inputStr.charAt(inputStr.length() - 3) == 'c') ||
                (inputStr.charAt(inputStr.length() - 1) == 'n' &&
                        inputStr.charAt(inputStr.length() - 2) == 'a' &&
                        inputStr.charAt(inputStr.length() - 3) == 't') ||
                (inputStr.charAt(inputStr.length() - 1) == 'g' &&
                        inputStr.charAt(inputStr.length() - 2) == 'o' &&
                        inputStr.charAt(inputStr.length() - 3) == 'l')) {
            return 3;
        } else if ((inputStr.charAt(inputStr.length() - 1) == 'n' &&
                inputStr.charAt(inputStr.length() - 2) == 'l') ||
                (inputStr.charAt(inputStr.length() - 1) == '!' &&
                        inputStr.charAt(inputStr.length() - 2) == 'n')) {
            return 2;
        } else {
            return 1;
        }
    }

    /*
     * 检测函数，对str进行前后语法检测
     * 为Tip的提示方式提供依据，与TipShow()配合使用
     *  编号 字符    其后可以跟随的合法字符
     *   1  （                 数字|（|-|.|函数
     *   2   ）                算符|）|√ ^
     *   3  .      数字|算符|）|√ ^
     *   4   数字        .|数字|算符|）|√ ^
     *   5   算符             数字|（|.|函数
     *   6 √ ^     （ |. | 数字
     *   7  函数           数字|（|.
     *
     * 小数点前后均可省略，表示0
     * 数字第一位可以为0
     */
    private void TipChecker(String tipCommand1, String tipCommand2) {
        //tipCode1表示错误类型，tipCode2表示名词解释类型
        int tipCode1 = 0, tipCode2 = 0;
        //表示命令类型
        int tipType1 = 0, tipType2 = 0;
        //括号数
        int bracket = 0;
        //“+x÷√^)”不能作为第一位 +可以作为第一位吧
        if (tipCommand1.compareTo("#") == 0 && (tipCommand2.compareTo("÷") == 0 ||
                tipCommand2.compareTo("×") == 0 || tipCommand2.compareTo("+") == 0 ||
                tipCommand2.compareTo(")") == 0 || tipCommand2.compareTo("√") == 0 ||
                tipCommand2.compareTo("^") == 0)) {
            tipCode1 = -1;
        } else if (tipCommand1.compareTo("#") != 0) {//定义存储字符串中最后一位的类型
            if (tipCommand1.compareTo("(") == 0) {
                tipType1 = 1;
            } else if (tipCommand1.compareTo(")") == 0) {
                tipType1 = 2;
            } else if (tipCommand1.compareTo(".") == 0) {
                tipType1 = 3;
            } else if ("0123456789".contains(tipCommand1)) {
                tipType1 = 4;
            } else if ("+-×÷".contains(tipCommand1)) {
                tipType1 = 5;
            } else if ("√^".contains(tipCommand1)) {
                tipType1 = 6;
            } else if ("sincostanloglnn!".contains(tipCommand1)) {
                tipType1 = 7;
            }
            //定义欲输入的按键类型
            if (tipCommand2.compareTo("(") == 0) {
                tipType2 = 1;
            } else if (tipCommand2.compareTo(")") == 0) {
                tipType2 = 2;
            } else if (tipCommand2.compareTo(".") == 0) {
                tipType2 = 3;
            } else if ("0123456789".contains(tipCommand2)) {
                tipType2 = 4;
            } else if ("+-×÷".contains(tipCommand2)) {
                tipType2 = 5;
            } else if ("√^".contains(tipCommand2)) {
                tipType2 = 6;
            } else if ("sincostanloglnn!".contains(tipCommand2)) {
                tipType2 = 7;
            }

            switch (tipType1) {
                case 1:
                    //左括号后面直接接右括号,“+x÷”（负号“-”不算）,或者"√^"
                    if (tipType2 == 2 || (tipType2 == 5 && tipCommand2.compareTo("-") != 0) || tipType2 == 6)
                        tipCode1 = 1;
                    break;
                case 2:
                    //右括号后面接左括号，数字，“+-x÷sin^...”
                    if (tipType2 == 1 || tipType2 == 3 || tipType2 == 4 || tipType2 == 7)
                        tipCode1 = 2;
                    break;
                case 3:
                    //“.”后面接左括号或者“sincos...”
                    if (tipType2 == 1 || tipType2 == 7)
                        tipCode1 = 3;
                    //连续输入两个“.”
                    if (tipType2 == 3)
                        tipCode1 = 8;
                    break;
                case 4:
                    //数字后面直接接左括号或者“sincos...”
                    if (tipType2 == 1 || tipType2 == 7)
                        tipCode1 = 4;
                    break;
                case 5:
                    //“+-x÷”后面直接接右括号，“+-x÷√^”
                    if (tipType2 == 2 || tipType2 == 5 || tipType2 == 6)
                        tipCode1 = 5;
                    break;
                case 6:
                    //“√^”后面直接接右括号，“+-x÷√^”以及“sincos...”
                    if (tipType2 == 2 || tipType2 == 5 || tipType2 == 6 || tipType2 == 7)
                        tipCode1 = 6;
                    break;
                case 7:
                    //“sincos...”后面直接接右括号“+-x÷√^”以及“sincos...”
                    if (tipType2 == 2 || tipType2 == 5 || tipType2 == 6 || tipType2 == 7)
                        tipCode1 = 7;
                    break;
            }
        }
        //检测小数点的重复性，tipCode1=0,表明满足前面的规则
        if (tipCode1 == 0 && tipCommand2.compareTo(".") == 0) {
            int tip_point = 0;
            for (int i = 0; i < tip_i; i++) {
                //若之前出现一个小数点点，则小数点计数加1
                if (tipCommand[i].compareTo(".") == 0) {
                    tip_point++;
                }
                //若出现以下几个运算符之一，小数点计数清零
                if (tipCommand[i].compareTo("sin") == 0 || tipCommand[i].compareTo("cos") == 0 ||
                        tipCommand[i].compareTo("tan") == 0 || tipCommand[i].compareTo("log") == 0 ||
                        tipCommand[i].compareTo("ln") == 0 || tipCommand[i].compareTo("n!") == 0 ||
                        tipCommand[i].compareTo("√") == 0 || tipCommand[i].compareTo("^") == 0 ||
                        tipCommand[i].compareTo("÷") == 0 || tipCommand[i].compareTo("×") == 0 ||
                        tipCommand[i].compareTo("-") == 0 || tipCommand[i].compareTo("+") == 0 ||
                        tipCommand[i].compareTo("(") == 0 || tipCommand[i].compareTo(")") == 0) {
                    tip_point = 0;
                }
            }
            tip_point++;
            //若小数点计数大于1，表明小数点重复了
            if (tip_point > 1) {
                tipCode1 = 8;
            }
        }
        //检测右括号是否匹配
        if (tipCode1 == 0 && tipCommand2.compareTo(")") == 0) {
            int tip_right_bracket = 0;
            for (int i = 0; i < tip_i; i++) {
                //如果出现一个左括号，则计数加1
                if (tipCommand[i].compareTo("(") == 0) {
                    tip_right_bracket++;
                }
                //如果出现一个右括号，则计数减1
                if (tipCommand[i].compareTo(")") == 0) {
                    tip_right_bracket--;
                }
            }
            //如果右括号计数=0,表明没有响应的左括号与当前右括号匹配
            if (tip_right_bracket == 0) {
                tipCode1 = 10;
            }
        }
        //检查输入=的合法性
        if (tipCode1 == 0 && tipCommand2.compareTo("=") == 0) {
            //括号匹配数
            int tip_bracket = 0;
            for (int i = 0; i < tip_i; i++) {
                if (tipCommand[i].compareTo("(") == 0) {
                    tip_bracket++;
                }
                if (tipCommand[i].compareTo(")") == 0) {
                    tip_bracket--;
                }
            }
            //若大于0，表明左括号还有未匹配的
            if (tip_bracket > 0) {
                tipCode1 = 9;
                bracket = tip_bracket;
            } else if (tip_bracket == 0) {
                //若前一个字符是以下之一，表明=号不合法
                if ("√^sincostanloglnn!".contains(tipCommand1)) {
                    tipCode1 = 6;
                }
                //若前一个字符是以下之一，表明=号不合法
                if ("+-×÷".contains(tipCommand1)) {
                    tipCode1 = 5;
                }
            }
        }
        //若命令是以下之一，则显示相应的帮助信息
        if (tipCommand2.compareTo("MC") == 0) tipCode2 = 1;
        if (tipCommand2.compareTo("C") == 0) tipCode2 = 2;
        if (tipCommand2.compareTo("DRG") == 0) tipCode2 = 3;
        if (tipCommand2.compareTo("<") == 0) tipCode2 = 4;
        if (tipCommand2.compareTo("sin") == 0) tipCode2 = 5;
        if (tipCommand2.compareTo("cos") == 0) tipCode2 = 6;
        if (tipCommand2.compareTo("tan") == 0) tipCode2 = 7;
        if (tipCommand2.compareTo("log") == 0) tipCode2 = 8;
        if (tipCommand2.compareTo("ln") == 0) tipCode2 = 9;
        if (tipCommand2.compareTo("n!") == 0) tipCode2 = 10;
        if (tipCommand2.compareTo("√") == 0) tipCode2 = 11;
        if (tipCommand2.compareTo("^") == 0) tipCode2 = 12;
        //显示帮助和错误信息
        TipShow(bracket, tipCode1, tipCode2, tipCommand1, tipCommand2);
    }

    /*
     * 反馈Tip信息，加强人机交互，与TipChecker()配合使用
     */
    private void TipShow(int bracket, int tipCode1, int tipCode2,
                         String tipCommand1, String tipCommand2) {
        String tipMessage = "";
        if (tipCode1 != 0)
            tip_lock = false;//表明输入有误
        switch (tipCode1) {
            case -1:
                tipMessage = tipCommand2 + "  不能作为第一个算符\n";
                break;
            case 1:
                tipMessage = tipCommand1 + "  后应输入：数字/(/./-/函数 \n";
                break;
            case 2:
                tipMessage = tipCommand1 + "  后应输入：)/算符 \n";
                break;
            case 3:
                tipMessage = tipCommand1 + "  后应输入：)/数字/算符 \n";
                break;
            case 4:
                tipMessage = tipCommand1 + "  后应输入：)/./数字 /算符 \n";
                break;
            case 5:
                tipMessage = tipCommand1 + "  后应输入：(/./数字/函数 \n";
                break;
            case 6:
                tipMessage = tipCommand1 + "  后应输入：(/./数字 \n";
                break;
            case 7:
                tipMessage = tipCommand1 + "  后应输入：(/./数字 \n";
                break;
            case 8:
                tipMessage = "小数点重复\n";
                break;
            case 9:
                tipMessage = "不能计算，缺少 " + bracket + " 个 )";
                break;
            case 10:
                tipMessage = "不需要  )";
                break;
        }
        switch (tipCode2) {
            case 1:
                tipMessage = tipMessage + "[MC 用法: 清除记忆 MEM]";
                break;
            case 2:
                tipMessage = tipMessage + "[C 用法: 归零]";
                break;
            case 3:
                tipMessage = tipMessage + "[DRG 用法: 选择 DEG 或 RAD]";
                break;
            case 4:
                tipMessage = tipMessage + "[Bksp 用法: 退格]";
                break;
            case 5:
                tipMessage = tipMessage + "sin 函数用法示例：\n" +
                        "DEG：sin30 = 0.5      RAD：sin1 = 0.84\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "sin(cos45)，而不是sincos45";
                break;
            case 6:
                tipMessage = tipMessage + "cos 函数用法示例：\n" +
                        "DEG：cos60 = 0.5      RAD：cos1 = 0.54\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "cos(sin45)，而不是cossin45";
                break;
            case 7:
                tipMessage = tipMessage + "tan 函数用法示例：\n" +
                        "DEG：tan45 = 1      RAD：tan1 = 1.55\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "tan(cos45)，而不是tancos45";
                break;
            case 8:
                tipMessage = tipMessage + "log 函数用法示例：\n" +
                        "log10 = log(5+5) = 1\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "log(tan45)，而不是logtan45";
                break;
            case 9:
                tipMessage = tipMessage + "ln 函数用法示例：\n" +
                        "ln10 = le(5+5) = 2.3   lne = 1\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "ln(tan45)，而不是lntan45";
                break;
            case 10:
                tipMessage = tipMessage + "n! 函数用法示例：\n" +
                        "n!3 = n!(1+2) = 3×2×1 = 6\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "n!(log1000)，而不是n!log1000";
                break;
            case 11:
                tipMessage = tipMessage + "√ 用法示例：开任意次根号\n" +
                        "如：27开3次根为  27√3 = 3\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "(函数)√(函数) ， (n!3)√(log100) = 2.45";
                break;
            case 12:
                tipMessage = tipMessage + "^ 用法示例：开任意次平方\n" +
                        "如：2的3次方为  2^3 = 8\n" +
                        "注：与其他函数一起使用时要加括号，如：\n" +
                        "(函数)√(函数) ， (n!3)^(log100) = 36";
                break;
        }

    }

}
