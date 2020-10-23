package com.example.module_ad.advertisement;

import com.example.module_ad.base.IAdWatcher;
import com.example.module_ad.base.IShowAdCallback;

public class AdWatcher implements IAdWatcher<IShowAdCallback> {

    public IShowAdCallback mIShowAdCallback=null;

    @Override
    public void showAd() {

    }


    @Override
    public void releaseAd() {

    }

    @Override
    public void setOnShowError(IShowAdCallback iShowAdCallback) {
        this.mIShowAdCallback=iShowAdCallback;
    }
}
