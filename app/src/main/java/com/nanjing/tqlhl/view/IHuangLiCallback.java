package com.nanjing.tqlhl.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.model.bean.HuangLiBean;

public interface IHuangLiCallback extends IBaseCallback {

    void onLoadHuangLi(HuangLiBean huangLiBean);

    void onLoadHuangLiError();
}
