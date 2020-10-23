package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.ILogoutCallback;

public interface ILogoutPresent extends IBasePresent<ILogoutCallback> {

    void toLogout(String id);
}
