package com.nanjing.tqlhl.base;

public interface IBasePresent<T> {

    void registerCallback(T t);

    void unregisterCallback(T t);

}
