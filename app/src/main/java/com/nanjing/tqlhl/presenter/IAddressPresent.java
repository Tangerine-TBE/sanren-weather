package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.IAddressCallback;

/**
 * @author: Administrator
 * @date: 2020/7/4 0004
 */
public interface IAddressPresent extends IBasePresent<IAddressCallback> {
    void getLocationAddress(String city);

}
