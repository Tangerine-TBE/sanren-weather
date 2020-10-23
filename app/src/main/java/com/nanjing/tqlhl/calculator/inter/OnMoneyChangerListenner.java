package com.nanjing.tqlhl.calculator.inter;

public interface OnMoneyChangerListenner {
    //专项附加总额
    public void OnMoneyChanged(double totalMoney, double[] moneys);
}
