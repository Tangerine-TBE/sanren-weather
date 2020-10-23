package com.nanjing.tqlhl.calculator.keyboard;

import android.util.Log;

import java.util.StringTokenizer;

public class Cal {
    private double number;
    private double pi = 4 * Math.atan(1);
    private boolean drg_flag;
    private final int MAXLEN = 500;

    public Cal(boolean drg_flag) {
        this.drg_flag = drg_flag;
    }

    /*
     * 计算表达式
     * 从左向右扫描，数字入number栈，运算符入operator栈
     * +-基本优先级为1，×÷基本优先级为2，log ln sin cos tan n!基本优先级为3，√^基本优先级为4
     * 括号内层运算符比外层同级运算符优先级高4
     * 当前运算符优先级高于栈顶压栈，低于栈顶弹出一个运算符与两个数进行运算
     * 重复直到当前运算符大于栈顶
     * 扫描完后对剩下的运算符与数字依次计算
     */
    public void process(String inputStr) {
        int weightPlus = 0, topOp = 0, topNum = 0, flag = 1, weightTemp;
        //weightPlus为同一（）下的基本优先级，weightTemp临时记录优先级的变化
        //topOp为weight[]，operator[]的计数器；topNum为number[]的计数器
        //flag为正负数的计数器，1为正数，-1为负数
        int weight[];  //保存operator栈中运算符的优先级，以topOp计数
        char ch, ch_gai, operator[];//operator[]保存运算符，以topOp计数 ch_gai中间变量
        double number[];//保存数字，以topNum计数
        String num;//记录数字，str以+-×÷()sctgl!√^分段，+-×÷()sctgl!√^字符之间的字符串即为数字
        weight = new int[MAXLEN];
        number = new double[MAXLEN];
        operator = new char[MAXLEN];
        StringTokenizer expToken = new StringTokenizer(inputStr, "+-×÷()sctgl!√^%");
        int i = 0;
        int s = inputStr.length();
        while (i < s) {
            ch = inputStr.charAt(i);

            //1、判断正负数
            if (i == 0) {
                if (ch == '-')
                    flag = -1;//第一个数为负号乘以-1
            } else if (inputStr.charAt(i - 1) == '(' && ch == '-') //(-也等价于（-1x
                flag = -1;

            //2、取得数字，并将正负符号转移给数字
            if (ch <= '9' && ch >= '0' || ch == '.' || ch == 'E') {
                num = expToken.nextToken();
                Log.e("guojs", "num=" + num);
                ch_gai = ch;
                Log.e("guojs", "ch=" + ch + "--->" + "i=" + i);
                //取得整个数字
                while (i < inputStr.length() && (
                        ch_gai <= '9'
                        && ch_gai >= '0'
                        || ch_gai == '.' ||
                        ch_gai == 'E')) {
                    ch_gai = inputStr.charAt(i++);
                    Log.e("guojs", "ch_gai= " + ch_gai + "i的值为：" + i);
                }
                //将指针退回之前的位置
                if (i >= inputStr.length()) {
                    Log.e("guojs", "inputStr.length()=" + inputStr.length());
                    Log.e("guojs", "i=" + i);
                    i -= 1;
                    Log.e("guojs", "i=" + i);
                }
                else {
                    Log.e("guojs", "inputStr.length()=" + inputStr.length());
                    Log.e("guojs", "i=" + i);
                    i -= 2;//为什么减二 数字之间相差二
                    Log.e("guojs", "i=" + i);
                }
                if (num.compareTo(".") == 0)//相等返回0
                    number[topNum++] = 0;
                else {//将正负符号转移给数字
                    number[topNum++] = Double.parseDouble(num) * flag;
                    flag = 1;
                }
            }

            //3、计算运算符的优先级
            if (ch == '(') weightPlus += 4;
            if (ch == ')') weightPlus -= 4;
            //这里判断的是第一个字符例如11%则是1 s11则是s
            if (ch == '-' && flag == 1 || ch == '+' || ch == '×' || ch == '÷' || ch == 's' || ch == 'c' || ch == 't' || ch == 'g' || ch == 'l' || ch == '!' || ch == '√' || ch == '^'|| ch == '%') {
                switch (ch) {
                    //+-的优先级最低，为1
                    case '+':
                    case '-':
                        weightTemp = 1 + weightPlus;
                        break;
                    //x÷的优先级稍高，为2
                    case '×':
                    case '÷':
                        weightTemp = 2 + weightPlus;
                        break;
                    //sincos之类优先级为3
                    case 's':
                    case 'c':
                    case 't':
                    case 'g':
                    case 'l':
                    case '!':
                        weightTemp = 3 + weightPlus;
                        break;
                    //其余优先级为4
                    //case '^':
                    //case '√':
                    case  '%':
                        weightTemp = 5 + weightPlus;//百分号优先级高于阶乘小于括号（参考各类手机的飞速计算器）
                        break;
                    default:
                        weightTemp = 4 + weightPlus;
                        break;
                }
                //如果当前优先级大于堆栈顶部元素，则直接入栈
                if (topOp == 0 || weightTemp > weight[topOp - 1]) {
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch;
                    topOp++;
                } else {//否则将堆栈中运算符逐个取出，直到当前堆栈顶部运算符的优先级小于当前运算符
                    while (topOp > 0 && weight[topOp - 1] >= weightTemp) {
                        switch (operator[topOp - 1]) {
                            //取出数字数组的相应元素进行运算
                            case '+':
                                number[topNum - 2] += number[topNum - 1];
                                break;
                            case '-':
                                number[topNum - 2] -= number[topNum - 1];
                                break;
                            case '×':
                                number[topNum - 2] *= number[topNum - 1];
                                break;
                            //判断除数为0的情况
                            case '÷':
                                if (number[topNum - 1] == 0) {
                                    setError(1);
                                    return;
                                }
                                number[topNum - 2] /= number[topNum - 1];
                                break;
                            case '√':
                                if (number[topNum - 1] == 0 || (number[topNum - 2] < 0 &&
                                        number[topNum - 1] % 2 == 0)) {
                                    setError(2);
                                    return;
                                }
                                number[topNum - 2] =
                                        Math.pow(number[topNum - 2], 1 / number[topNum - 1]);
                                break;
                            case '^':
                                number[topNum - 2] =
                                        Math.pow(number[topNum - 2], number[topNum - 1]);
                                break;
                            //计算时进行角度弧度的判断及转换
                            //sin
                            case 's':
                                if (drg_flag) {
                                    number[topNum - 1] = Math.sin((number[topNum - 1] / 180) * pi);
                                } else {
                                    number[topNum - 1] = Math.sin(number[topNum - 1]);
                                }
                                topNum++;
                                break;
                            //cos
                            case 'c':
                                if (drg_flag) {
                                    number[topNum - 1] = Math.cos((number[topNum - 1] / 180) * pi);
                                } else {
                                    number[topNum - 1] = Math.cos(number[topNum - 1]);
                                }
                                topNum++;
                                break;
                            //tan
                            case 't':
                                if (drg_flag) {
                                    if ((Math.abs(number[topNum - 1]) / 90) % 2 == 1) {
                                        setError(2);
                                        return;
                                    }
                                    number[topNum - 1] = Math.tan((number[topNum - 1] / 180) * pi);
                                } else {
                                    if ((Math.abs(number[topNum - 1]) / (pi / 2)) % 2 == 1) {
                                        setError(2);
                                        return;
                                    }
                                    number[topNum - 1] = Math.tan(number[topNum - 1]);
                                }
                                topNum++;
                                break;
                            //log
                            case 'g':
                                if (number[topNum - 1] <= 0) {
                                    setError(2);
                                    return;
                                }
                                number[topNum - 1] = Math.log10(number[topNum - 1]);
                                topNum++;
                                break;
                            //ln
                            case 'l':
                                if (number[topNum - 1] <= 0) {
                                    setError(2);
                                    return;
                                }
                                number[topNum - 1] = Math.log(number[topNum - 1]);
                                topNum++;
                                break;
                            //阶乘
                            case '!':
                                if (number[topNum - 1] > 170) {
                                    setError(3);
                                    return;
                                } else if (number[topNum - 1] < 0) {
                                    setError(2);
                                    return;
                                }
                                number[topNum - 1] = N(number[topNum - 1]);
                                topNum++;
                                break;
                            case '%':
                                number[topNum - 1] = (number[topNum - 1]) / 100;
                                topNum++;
                                break;
                        }
                        //继续取堆栈的下一个元素进行判断
                        topNum--;
                        topOp--;
                    }
                    //将运算符入堆栈
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch;
                    topOp++;
                }
            }
            i++;
        }
        //依次取出堆栈的运算符进行运算
        while (topOp > 0) {
            //+-x直接将数组的后两位数取出运算
            switch (operator[topOp - 1]) {
                case '+':
                    number[topNum - 2] += number[topNum - 1];
                    break;
                case '-':
                    number[topNum - 2] -= number[topNum - 1];
                    break;
                case '×':
                    number[topNum - 2] *= number[topNum - 1];
                    break;
                //涉及到除法时要考虑除数不能为零的情况
                case '÷':
                    if (number[topNum - 1] == 0) {
                        setError(1);
                        return;
                    }
                    number[topNum - 2] /= number[topNum - 1];
                    break;
                case '√':
                    if (number[topNum - 1] == 0 || (number[topNum - 2] < 0 &&
                            number[topNum - 1] % 2 == 0)) {
                        setError(2);
                        return;
                    }
                    number[topNum - 2] =
                            Math.pow(number[topNum - 2], 1 / number[topNum - 1]);
                    break;
                case '^':
                    number[topNum - 2] =
                            Math.pow(number[topNum - 2], number[topNum - 1]);
                    break;
                //sin
                case 's':
                    if (drg_flag) {
                        number[topNum - 1] = Math.sin((number[topNum - 1] / 180) * pi);
                    } else {
                        number[topNum - 1] = Math.sin(number[topNum - 1]);
                    }
                    topNum++;
                    break;
                //cos
                case 'c':
                    if (drg_flag) {
                        number[topNum - 1] = Math.cos((number[topNum - 1] / 180) * pi);
                    } else {
                        number[topNum - 1] = Math.cos(number[topNum - 1]);
                    }
                    topNum++;
                    break;
                //tan
                case 't':
                    if (drg_flag) {
                        if ((Math.abs(number[topNum - 1]) / 90) % 2 == 1) {
                            setError(2);
                            return;
                        }
                        number[topNum - 1] = Math.tan((number[topNum - 1] / 180) * pi);
                    } else {
                        if ((Math.abs(number[topNum - 1]) / (pi / 2)) % 2 == 1) {
                            setError(2);
                            return;
                        }
                        number[topNum - 1] = Math.tan(number[topNum - 1]);
                    }
                    topNum++;
                    break;
                //对数log
                case 'g':
                    if (number[topNum - 1] <= 0) {
                        setError(2);
                        return;
                    }
                    number[topNum - 1] = Math.log10(number[topNum - 1]);
                    topNum++;
                    break;
                //自然对数ln
                case 'l':
                    if (number[topNum - 1] <= 0) {
                        setError(2);
                        return;
                    }
                    number[topNum - 1] = Math.log(number[topNum - 1]);
                    topNum++;
                    break;
                //阶乘
                case '!':
                    if (number[topNum - 1] > 170) {
                        setError(3);
                        return;
                    } else if (number[topNum - 1] < 0) {
                        setError(2);
                        return;
                    }
                    number[topNum - 1] = N(number[topNum - 1]);
                    topNum++;
                    break;
                case '%':
                    number[topNum - 2] = N(number[topNum - 1]) / 100;
                    topNum++;
                    break;
            }
            //取堆栈下一个元素计算
            topNum--;
            topOp--;
        }
        //如果是数字太大，提示错误信息
        if (number[0] > 7.3E306) {
            setError(3);
            return;
        }
        this.number = number[0];
    }

    /*
     * 阶乘算法
     */
    public double N(double n) {
        int i;
        double sum = 1;
        //依次将小于等于n的值相乘
        for (i = 1; i <= n; i++) {
            sum = sum * i;
        }
        return sum;
    }

    /*
     * 错误提示，按了"="之后，若计算式在process()过程中，出现错误，则进行提示
     */
    private String message = "";

    public void setError(int code) {
        switch (code) {
            case 1:
                message = "零不能作除数";
                break;
            case 2:
                message = "函数格式错误";
                break;
            case 3:
                message = "值太大了，超出范围";
        }
    }

    public double getResult() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}