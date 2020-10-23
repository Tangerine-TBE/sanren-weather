package com.nanjing.tqlhl.calculator.present;

import android.os.Handler;

import com.nanjing.tqlhl.calculator.api.ExchangeService;
import com.nanjing.tqlhl.calculator.base.BasePresenterImpl;
import com.nanjing.tqlhl.calculator.base.SimpleObserver;
import com.nanjing.tqlhl.calculator.bean.ExchangeActualBean;
import com.nanjing.tqlhl.calculator.bean.ExchangeListBean;
import com.nanjing.tqlhl.calculator.model.AliExchangeModel;
import com.nanjing.tqlhl.calculator.view.IExchangeView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ExchangePressenter extends BasePresenterImpl<IExchangeView> {
    public static final String TAG = "http://ali-waihui.showapi.com";
    public static final String TAG1 = "http://api.k780.com";
    @Override
    public void detachView() {

    }

    public  void getExchangeList(){
      AliExchangeModel.getInstance().getRetrofitGson(TAG).create(ExchangeService.class).getExchangeList()
        .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new SimpleObserver<ExchangeListBean>() {
                  @Override
                  public void onNext(final ExchangeListBean value) {
                      if (value.getShowapi_res_code() == 0) {
                          {
                              new Handler().postDelayed(new Runnable() {
                                  @Override
                                  public void run() {
                                      mView.refreshExchangeList(value);

                                  }
                              }, 100);
                          }
                      }
                      else {
                          mView.finishRefresh("网络异常");
                      }
                  }
                  @Override
                  public void onError(Throwable e) {
                      e.printStackTrace();
                      mView.finishRefresh("参数错误或网络异常");
                  }
              });

    }


    public  void getActualExchange(String fromCode,String money,String toCode,final int textId ){
        AliExchangeModel.getInstance().getRetrofitGson(TAG).create(ExchangeService.class).getActualExchange(fromCode,money,toCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<ExchangeActualBean>() {
                    @Override
                    public void onNext(final ExchangeActualBean value) {
                        if(value.getShowapi_res_code()==0) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mView.getActualExchange(value, textId);

                                }
                            }, 100);
                        }
                        else {
                            mView.finishRefresh("网络异常");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.finishRefresh("参数错误或网络异常");
                    }
                });

    }





}
