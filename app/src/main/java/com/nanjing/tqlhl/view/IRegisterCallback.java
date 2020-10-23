package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.RegisterBean;

public interface IRegisterCallback extends IBaseCallback {

    void onLoadCode();

    void onRegisterSuccess(RegisterBean registerBean);

}
