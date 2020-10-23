package com.nanjing.tqlhl.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_ad.advertisement.BanFeedHelper;
import com.example.module_ad.utils.MyStatusBarUtil;
import com.example.module_tool.activity.CycleRulerActivity;
import com.example.module_tool.activity.DistanceActivity;
import com.example.module_tool.activity.HorizontalActivity;
import com.example.module_tool.activity.MirrorActivity;
import com.example.module_tool.activity.RulerActivity2;
import com.example.module_tool.fangdai.HomeActivity_loan;
import com.nanjing.tqlhl.R;
import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.base.BaseRecyclerViewAdapter;
import com.nanjing.tqlhl.calculator.ui.activity.AllExchangeActivity;
import com.nanjing.tqlhl.calculator.ui.activity.CarlendarCaculateActivity;
import com.nanjing.tqlhl.calculator.ui.activity.ExchangeActivity;
import com.nanjing.tqlhl.calculator.ui.activity.GSActivity;
import com.nanjing.tqlhl.calculator.ui.activity.HexExchangeActivity;
import com.nanjing.tqlhl.calculator.ui.activity.RelationActivity;
import com.nanjing.tqlhl.model.bean.ToolsBean;
import com.nanjing.tqlhl.ui.adapter.ToolsAdapter;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import com.permissionx.guolindev.callback.ForwardToSettingsCallback;
import com.permissionx.guolindev.callback.RequestCallback;
import com.permissionx.guolindev.request.ExplainScope;
import com.permissionx.guolindev.request.ForwardScope;
import com.tamsiree.rxkit.view.RxToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.example.tianqi.ui.activity
 * @class describe
 * @time 2020/9/9 14:36
 * @class describe
 */
public class ToolActivity extends BaseMainActivity implements BaseRecyclerViewAdapter.OnItemClickListener<ToolsBean> {

    @BindView(R.id.rv_setContainer)
    RecyclerView rv_setContainer;
    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;
    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
    @BindView(R.id.banner_container)
    FrameLayout banner_container;
    @BindView(R.id.feed_container)
    FrameLayout feed_container;
    private BanFeedHelper mBanFeedHelper;

    private ToolsAdapter mToolsAdapter;

    @Override
    protected void setStatusBarColor() {
        MyStatusBarUtil.setColor(this, Color.WHITE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_tool;
    }

    @Override
    protected void intView() {
        tv_bar_title.setVisibility(View.VISIBLE);
        tv_bar_title.setText("工具箱");
        List<ToolsBean> list=new ArrayList<>();
        list.add(new ToolsBean(R.mipmap.tool_icon_fangdai,"房贷计算"));
        list.add(new ToolsBean(R.mipmap.tool_icon_changdu,"长度转换"));
        list.add(new ToolsBean(R.mipmap.tool_icon_huilv,"汇率换算"));
        list.add(new ToolsBean(R.mipmap.tool_icon_geshui,"个税计算"));
        list.add(new ToolsBean(R.mipmap.tool_icon_daxie,"大写数字"));
        list.add(new ToolsBean(R.mipmap.tool_icon_qinqi,"亲戚称呼计算"));
        list.add(new ToolsBean(R.mipmap.tool_icon_liangjiaoqi,"量角器"));
        list.add(new ToolsBean(R.mipmap.tool_icon_jinzhi,"进制转换"));
        list.add(new ToolsBean(R.mipmap.tool_icon_juli,"距离测量"));
        list.add(new ToolsBean(R.mipmap.tool_icon_shuipingyi,"水平仪"));
        list.add(new ToolsBean(R.mipmap.tool_icon_riqi,"日期计算"));
        list.add(new ToolsBean(R.mipmap.tool_icon_jingzi,"高清镜子"));
        list.add(new ToolsBean(R.mipmap.tool_icon_chizi,"尺子"));

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        rv_setContainer.setLayoutManager(manager);
        mToolsAdapter = new ToolsAdapter();
        mToolsAdapter.setData(list);
        rv_setContainer.setAdapter(mToolsAdapter);

        //加载广告
        mBanFeedHelper = new BanFeedHelper(this, banner_container, feed_container);
        mBanFeedHelper.showAd(BanFeedHelper.AdType.TOOL_PAGE);

    }

    @Override
    protected void intEvent() {
        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mToolsAdapter.setOnItemClickListener(this);


    }

    @Override
    protected void release() {
        if (mBanFeedHelper != null) {
            mBanFeedHelper.releaseAd();
        }
    }


    private  String[] permissions = new String[]{
            Manifest.permission.CAMERA,
    };


    private void checkRuntimePermission(Class aClass) {

        PermissionX.init(this)
                .permissions(permissions)
                .onExplainRequestReason(new ExplainReasonCallbackWithBeforeParam() {
                    @Override
                    public void onExplainReason(ExplainScope scope, List<String> deniedList, boolean beforeRequest) {
                        RxToast.normal(ToolActivity.this,"该功能必须开启此权限").show();
                        //   scope.showRequestReasonDialog(deniedList, "即将申请的权限是程序必须依赖的权限", "我已明白");
                    }
                })
                .onForwardToSettings(new ForwardToSettingsCallback() {
                    @Override
                    public void onForwardToSettings(ForwardScope scope, List<String> deniedList) {
                        RxToast.normal(ToolActivity.this,"您需要去应用程序设置当中手动开启权限").show();
                        //  scope.showForwardToSettingsDialog(deniedList, "您需要去应用程序设置当中手动开启权限", "我已明白");
                    }
                })
                .request(new RequestCallback() {
                    @Override
                    public void onResult(boolean allGranted, List<String> grantedList, List<String> deniedList) {
                        if (allGranted) {
                            startActivity(new Intent(ToolActivity.this, aClass));
                        }
                    }
                });

    }

    @Override
    public void onItemClick(ToolsBean toolsBean, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, HomeActivity_loan.class));
                break;
            case 1:
                Intent intent = new Intent(this, AllExchangeActivity.class);
                intent.putExtra("title", "长度转换");
                intent.putExtra("tvSelectTop", "米");
                intent.putExtra("tvSelectbottom", "厘米");
                intent.putExtra("tvDwtop", getString(R.string.lenth_m));
                intent.putExtra("tvDwbottom",getString(R.string.lenth_lm));
                startActivity(intent);
                break;
            case 2:
                startActivity(new Intent(this, ExchangeActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, GSActivity.class));
                break;
            case 4:
                Intent intent2 = new Intent(this, AllExchangeActivity.class);
                intent2.putExtra("title", "大写数字");
                intent2.putExtra("tvSelectTop", "");
                intent2.putExtra("tvSelectbottom", "");
                intent2.putExtra("tvDwtop", "");
                intent2.putExtra("tvDwbottom", "");
                startActivity(intent2);
                break;
            case 5:
                startActivity(new Intent(this, RelationActivity.class));
                break;
            case 6:
                checkRuntimePermission(CycleRulerActivity.class);
                break;
            case 7:
                startActivity(new Intent(this, HexExchangeActivity.class));
                break;
            case 8:
                checkRuntimePermission(DistanceActivity.class);
                break;
            case 9:
                startActivity(new Intent(this, HorizontalActivity.class));
                break;
            case 10:
                startActivity(new Intent(this, CarlendarCaculateActivity.class));
                break;
            case 11:
                checkRuntimePermission(MirrorActivity.class);
                break;
            case 12:
                startActivity(new Intent(this, RulerActivity2.class));
                break;
        }
    }
}
