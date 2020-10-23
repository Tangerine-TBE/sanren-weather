package com.nanjing.tqlhl.calculator.ui.activity;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nanjing.tqlhl.calculator.base.activity.BaseActivity;
import com.nanjing.tqlhl.calculator.bean.Relation;
import com.nanjing.tqlhl.calculator.present.ExchangePressenter;
import com.nanjing.tqlhl.calculator.present.RelationPresenter;
import com.nanjing.tqlhl.calculator.view.IRelationView;
import com.nanjing.tqlhl.calculator.weiget.SingleLineZoomTextView;
import com.nanjing.tqlhl.R;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RelationActivity extends BaseActivity implements IRelationView {
    private static final String TAG = "RelationFragment";

    @BindView(R.id.rl_screen)
    RelativeLayout mRlScreen;

    @BindView(R.id.tv_call)
    SingleLineZoomTextView mTvCall;

    @BindView(R.id.tv_relation)
    TextView mTvRelation;

    @BindView(R.id.ll_keyboard)
    LinearLayout mLlKeyBoard;

    @BindView(R.id.btn_husband)
    TextView mTvHusband;

    @BindView(R.id.btn_wife)
    TextView mTvWife;

    @BindView(R.id.btn_del)
    RelativeLayout mRlDel;

    @BindView(R.id.btn_AC)
    TextView mTvAC;

    @BindView(R.id.btn_fathter)
    TextView mTvFather;

    @BindView(R.id.btn_mother)
    TextView mTvMother;

    @BindView(R.id.btn_bro1)
    TextView mTvBro1;

    @BindView(R.id.btn_bro2)
    TextView mTvBro2;

    @BindView(R.id.btn_sister1)
    TextView mTvSister1;

    @BindView(R.id.btn_sister2)
    TextView mTvSister2;

    @BindView(R.id.btn_son)
    TextView mTvSon;

    @BindView(R.id.btn_daughter)
    TextView mTvDaughter;

    @BindView(R.id.btn_each_other)
    TextView mTvEachOther;

    @BindView(R.id.btn_equal)
    TextView mTvEqual;

    @BindView(R.id.title_left_text)
    TextView title_left_text;
    @BindView(R.id.title_content_text)
    TextView title_content_text;
    /**
     * 每次删除的字数
     */
    private int deleteNum = 4;

    /**
     * 点击次数
     */
    private int count = 0;

    /**
     * 最大点击次数
     */
    private int maxCount = 10;

    private StringBuffer mRelation = new StringBuffer("");

    private RelationPresenter mPresenter = RelationPresenter.newInstance();


    @Override
    protected ExchangePressenter initInjector() {
        return new ExchangePressenter();
    }


    @Override
    protected void onCreateActivity() {
        setContentView(R.layout.activity_relationship);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);//禁止弹出软键盘最有效的方法
        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void bindView() {
        title_content_text.setText("亲戚关系计算");
        mRelation.append(getString(R.string.me));
    }

    @OnClick({R.id.btn_husband, R.id.btn_wife, R.id.btn_fathter, R.id.btn_mother,
            R.id.btn_bro1, R.id.btn_bro2, R.id.btn_sister1, R.id.btn_sister2,
            R.id.btn_son, R.id.btn_daughter, R.id.btn_AC, R.id.btn_del, R.id.title_left_text})
    public void onClickRelation(View view) {
        String link = getString(R.string.link);
        switch (view.getId()) {
            case R.id.btn_husband:
                mRelation.append(link).append(getString(R.string.husband1));
                count++;
                break;
            case R.id.btn_wife:
                mRelation.append(link).append(getString(R.string.wife1));
                count++;
                break;
            case R.id.btn_fathter:
                mRelation.append(link).append(getString(R.string.father));
                count++;
                break;
            case R.id.btn_mother:
                mRelation.append(link).append(getString(R.string.mother));
                count++;
                break;
            case R.id.btn_bro1:
                mRelation.append(link).append(getString(R.string.brother1));
                count++;
                break;
            case R.id.btn_bro2:
                mRelation.append(link).append(getString(R.string.brother2));
                count++;
                break;
            case R.id.btn_sister1:
                mRelation.append(link).append(getString(R.string.sister1));
                count++;
                break;
            case R.id.btn_sister2:
                mRelation.append(link).append(getString(R.string.sister2));
                count++;
                break;
            case R.id.btn_son:
                mRelation.append(link).append(getString(R.string.son));
                count++;
                break;
            case R.id.btn_daughter:
                mRelation.append(link).append(getString(R.string.daughter));
                count++;
                break;
            case R.id.btn_AC:
                //清空文本内容
                count = 0;
                mRelation.delete(0, mRelation.length());
                mRelation.append("我");
                Log.e(TAG, mRelation.toString());

                //清空称呼
                mTvCall.setText("");
                break;
            case R.id.btn_del:
                count--;
                //删除
                if (mRelation.length() >= deleteNum) {
                    mRelation.delete(mRelation.length() - 3, mRelation.length());
                }
                break;
            case R.id.title_left_text:
                finish();
                break;
            default:
                break;
        }
        if (count > maxCount) {
            mTvRelation.setText(getString(R.string.big_count));
        } else {
            mTvRelation.setText(mRelation);
        }
    }

    @OnClick(R.id.btn_equal)
    public void onClickEqual() {
        final List<Relation.ResultBean.RelationBean> relationList = new ArrayList<>();
        mPresenter.getRelationByJSON(relationList, getContext());
        if (mRelation.toString().equals(getString(R.string.me))) {
            mTvCall.setText(getString(R.string.me));
        } else {
            String call = mPresenter.getRelationship(mRelation, relationList);
            Log.e(TAG, "关系：" + mRelation);
            Log.e(TAG, "最终称呼：" + call);

            mTvCall.setText(call);
        }
    }

    @Override
    public void finishRefresh(String msg) {

    }
}
