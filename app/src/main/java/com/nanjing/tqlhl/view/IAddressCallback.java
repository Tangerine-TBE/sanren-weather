package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.LocationBean;

/**
 * @author: Administrator
 * @date: 2020/7/4 0004
 */
public interface IAddressCallback extends IBaseCallback {
    void onLoadAddressSuccess(LocationBean addressBean);
}
