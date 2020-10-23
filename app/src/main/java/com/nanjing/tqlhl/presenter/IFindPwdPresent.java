package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.IFindPwdCallback;

import java.util.Map;

public interface IFindPwdPresent extends IBasePresent<IFindPwdCallback> {

    void getVerificationCode(String phoneNumber);

    void findPwd(Map<String, String> userInfo);

}
