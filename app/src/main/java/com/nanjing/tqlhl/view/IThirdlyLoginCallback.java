package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;

public interface IThirdlyLoginCallback extends IBaseCallback {

      void onThirdlyLoginSuccess(LoginBean bean);

      void onThirdlyLoginError();


      void onCheckThirdlyRegisterSuccess(RegisterBean bean);

      void onCheckError();


      void onThirdlyRegisterSuccess(ThirdlyRegisterBean bean);

      void onThirdlyRegisterError();
}
