package com.nanjing.tqlhl.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;
import com.example.module_ad.bean.AdBean;
import com.example.module_ad.utils.LogUtils;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseApplication;
import com.nanjing.tqlhl.base.BaseFragment;
import com.nanjing.tqlhl.presenter.Impl.AdPresentImpl;
import com.nanjing.tqlhl.ui.activity.AgreementActivity;
import com.nanjing.tqlhl.ui.activity.FirstLocationActivity;
import com.nanjing.tqlhl.ui.activity.PrivacyActivity;
import com.nanjing.tqlhl.utils.ColorUtil;
import com.nanjing.tqlhl.utils.Contents;
import com.nanjing.tqlhl.utils.ImmersionUtil;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.view.IAdCallback;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import com.permissionx.guolindev.callback.ForwardToSettingsCallback;
import com.permissionx.guolindev.callback.RequestCallback;
import com.permissionx.guolindev.request.ExplainScope;
import com.permissionx.guolindev.request.ForwardScope;
import com.tamsiree.rxkit.view.RxToast;
import com.umeng.commonsdk.UMConfigure;

import java.util.List;

import butterknife.BindView;


@RequiresApi(api = Build.VERSION_CODES.M)
public class PermissionFragment extends BaseFragment implements IAdCallback {


    @BindView(R.id.go_main)
    Button mGoMainBt;

    @BindView(R.id.user_agreement)
    TextView mAgreementTv;

    @BindView(R.id.permissions_title)
    TextView mTitle;

    @BindView(R.id.bt_try)
    TextView mTry;



    @BindView(R.id.permission_container)
    FrameLayout mAdContainer;

    private AdPresentImpl mAdPresent;



    @Override
    public int getChildLayout() {
        getActivity().getWindow().getDecorView().setBackgroundColor(ColorUtil.WHITE);
        return  R.layout.activity_permissions;
    }


    @Override
    protected void intView() {
        setViewState(ViewState.SUCCESS);
        mTitle.setText( PackageUtil.difPlatformName(getActivity(),R.string.welcome));
        String str = getResources().getString(R.string.user_agreement);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(str);
        TextViewSpan1 span1 = new TextViewSpan1();
        stringBuilder.setSpan(span1,10,18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextViewSpan2 span2 = new TextViewSpan2();
        stringBuilder.setSpan(span2,19,25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mAgreementTv.setText(stringBuilder);
        //一定要记得设置这个方法  不是不起作用
        mAgreementTv.setMovementMethod(LinkMovementMethod.getInstance());


    }

    @Override
    protected void intPresent() {
        mAdPresent = AdPresentImpl.getInstance();
        mAdPresent.registerCallback(this);
        IsHaveNetWork();

    }



    @Override
    public void onLoadAdMsgSuccess(AdBean adBean) {
        if (adBean != null) {
            AdBean.DataBean data = adBean.getData();
            String ad = JSON.toJSONString(data);
            BaseApplication.getAppContext().getSharedPreferences(Contents.AD_INFO_SP, Context.MODE_PRIVATE).edit().putString(Contents.AD_INFO, ad).apply();
        }
    }




    @Override
    public void onLoadAdMsgError() {
     //  ImmersionUtil.startActivity(getContext(),FirstLocationActivity.class,true);
    }

    private class TextViewSpan1 extends ClickableSpan {
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(ColorUtil.COLOR_SHENG_MING);
            //设置是否有下划线
            //  ds.setUnderlineText(true);
        }
        @Override
        public void onClick(View widget) {
            //点击事件
            LogUtils.i(this,"onClick------11111111111---------->");
            ImmersionUtil.startActivity(getActivity(), AgreementActivity.class,false);
        }
    }
    private class TextViewSpan2 extends ClickableSpan {
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(ColorUtil.COLOR_SHENG_MING);
            //设置是否有下划线
            //  ds.setUnderlineText(true);
        }
        @Override
        public void onClick(View widget) {
            //点击事件
            LogUtils.i(this,"onClick-------22222222--------->");
            ImmersionUtil.startActivity(getActivity(), PrivacyActivity.class,false);
        }
    }



    private  String[] permissions = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
    };



    private void IsHaveNetWork() {
            toRequestAd();
    }


    private void toRequestAd() {
        if (mAdPresent != null) {
            mAdPresent.toRequestAd();
        }
    }


    @Override
    protected void release() {
        if (mAdPresent!= null) {
            mAdPresent.unregisterCallback(this);
        }
    }

    @Override
    protected void intEvent() {
        mGoMainBt.setOnClickListener(view -> checkRuntimePermission());

        mTry.setOnClickListener(view -> RxToast.showToast("您需要同意后才能继续使用"+PackageUtil.getAppMetaData(getActivity(),"APP_NAME")+"提供的服务"));


    }

    private void checkRuntimePermission() {
        mSpUtils.putBoolean(Contents.SP_AGREE,true);

        UMConfigure.init(getActivity(),UMConfigure.DEVICE_TYPE_PHONE,"5f96c7712065791705f99284");


        PermissionX.init(getActivity())
                .permissions(permissions)
                .onExplainRequestReason(new ExplainReasonCallbackWithBeforeParam() {
                    @Override
                    public void onExplainReason(ExplainScope scope, List<String> deniedList, boolean beforeRequest) {
                        String msg="即将申请的权限是程序必须依赖的权限";
                        scope.showRequestReasonDialog(deniedList,msg,"开启","取消");

                    }
                })
                .onForwardToSettings(new ForwardToSettingsCallback() {
                    @Override
                    public void onForwardToSettings(ForwardScope scope, List<String> deniedList) {
                        String msg="您需要去应用程序设置当中手动开启权限";
                        scope.showForwardToSettingsDialog(deniedList,msg,"开启","取消");
                    }
                })
                .request(new RequestCallback() {
                    @Override
                    public void onResult(boolean allGranted, List<String> grantedList, List<String> deniedList) {
                        ImmersionUtil.startActivity(getActivity(), FirstLocationActivity.class,false);
                    }
                });

    }
}