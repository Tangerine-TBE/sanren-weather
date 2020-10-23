package com.nanjing.tqlhl.utils;

import com.nanjing.tqlhl.presenter.Impl.AddressPresentImpl;

public class PresentManager {

    private static PresentManager  sInstance;
    private final AddressPresentImpl mAddressPresent;


    public static PresentManager getInstance() {
        if (sInstance == null) {
            sInstance = new PresentManager();
        }
        return sInstance;
    }

    public AddressPresentImpl getAddressPresent() {
        return mAddressPresent;
    }

    private PresentManager() {
         mAddressPresent = new AddressPresentImpl();

     }


}
