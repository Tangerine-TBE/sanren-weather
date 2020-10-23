package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.RegisterBean;

public interface ILogoutCallback extends IBaseCallback {

    void onLogoutSuccess(RegisterBean registerBean);

    void onLogoutError();
}
