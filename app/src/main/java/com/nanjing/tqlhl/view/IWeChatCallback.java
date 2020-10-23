package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.LoginBean;
import com.nanjing.tqlhl.model.bean.RegisterBean;
import com.nanjing.tqlhl.model.bean.ThirdlyRegisterBean;
import com.nanjing.tqlhl.model.bean.WeiXinBean;

public interface IWeChatCallback extends IBaseCallback {

  void onWxAccreditSuccess(WeiXinBean weiXinBean);

  void onWxAccreditError();

  void onCheckWxRegisterSuccess(RegisterBean bean);

  void onCheckWxError();

  void onWxRegisterSuccess(ThirdlyRegisterBean thirdlyRegisterBean);

  void onWxRegisterError();

  void onWxLoginSuccess(LoginBean loginBean);

  void onWxLoginError();


}
