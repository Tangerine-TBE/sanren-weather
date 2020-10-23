package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.IThirdlyLoginCallback;

import java.util.Map;

public interface IThirdlyLoginPresent extends IBasePresent<IThirdlyLoginCallback> {

    void toThirdlyRegister(Map<String, String> userInfo);

    void checkRegister(Map<String, String> userInfo);

    void toThirdlyLogin(Map<String, String> userInfo);



}
