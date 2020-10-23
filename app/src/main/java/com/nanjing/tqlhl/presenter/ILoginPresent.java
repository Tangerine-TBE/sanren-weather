package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.ILoginCallback;

import java.util.Map;

public interface ILoginPresent extends IBasePresent<ILoginCallback> {

    void toLogin(Map<String, String> userInfo);

}
