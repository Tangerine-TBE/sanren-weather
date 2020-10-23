package com.nanjing.tqlhl.calculator.present;

import android.os.Handler;

import com.nanjing.tqlhl.calculator.api.DatePartService;
import com.nanjing.tqlhl.calculator.base.BasePresenterImpl;
import com.nanjing.tqlhl.calculator.base.Constants;
import com.nanjing.tqlhl.calculator.base.SimpleObserver;
import com.nanjing.tqlhl.calculator.bean.CityBean;
import com.nanjing.tqlhl.calculator.model.AliExchangeModel;
import com.nanjing.tqlhl.calculator.view.IDatePartView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DatePressenter extends BasePresenterImpl<IDatePartView> {
    public static final String TAG = "https://sapi.k780.com";
  private  Handler handler= new Handler();

    @Override
    public void detachView() {




    }




    public  void getDatePartList(){
        AliExchangeModel.getInstance().getRetrofitString(TAG,"UTF-8").create(DatePartService.class).getDatePartList("time.world_city", Constants.appkey, Constants.sign,"json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<String>() {
                    @Override
                    public void onNext(final String value) {

                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mView.refreshDatePartList(value);

                                }
                            }, 100);

                        }


                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.finishRefresh("参数错误或网络异常");
                    }
                });
    }


    public  void getDateFromCity(String city_en){
        AliExchangeModel.getInstance().getRetrofitGson(TAG).create(DatePartService.class).getDateFromCity("time.world",city_en, Constants.appkey, Constants.sign,"json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<CityBean>() {
                    @Override
                    public void onNext(final CityBean value) {
                        if(value.getSuccess().equals("1")) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mView.getDateFromCity(value);

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
