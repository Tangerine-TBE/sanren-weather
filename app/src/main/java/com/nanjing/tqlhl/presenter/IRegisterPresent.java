package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.IRegisterCallback;

import java.util.Map;

public interface IRegisterPresent extends IBasePresent<IRegisterCallback> {

    void getVerificationCode(String phoneNumber);

    void registerNumber(Map<String, String> userInfo);


}
