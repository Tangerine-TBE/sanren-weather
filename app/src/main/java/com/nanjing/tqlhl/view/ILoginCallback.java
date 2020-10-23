package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.LoginBean;

public interface ILoginCallback extends IBaseCallback {

    void onLoginSuccess(LoginBean loginBean);

    void onLoginError();
}
