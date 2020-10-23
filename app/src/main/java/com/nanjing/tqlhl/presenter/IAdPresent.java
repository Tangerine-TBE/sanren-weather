package com.nanjing.tqlhl.presenter;

import com.nanjing.tqlhl.base.IBasePresent;
import com.nanjing.tqlhl.view.IAdCallback;

public interface IAdPresent extends IBasePresent<IAdCallback> {

    void toRequestAd();
}
