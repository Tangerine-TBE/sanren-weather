package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.IWeChatCallback;

import java.util.Map;

public interface IWeChatPresent extends IBasePresent<IWeChatCallback> {

    void toWxAccredit(Map<String, String> map);

    void checkWxRegister(Map<String, String> userInfo);

    void toWxRegister(Map<String, String> map);

    void toWxLogin(Map<String, String> map);
}
