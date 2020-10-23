package com.nanjing.tqlhl.calculator.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.nanjing.tqlhl.calculator.base.activity.BaseRxActivity;
import com.nanjing.tqlhl.calculator.ui.fragment.CalendarFragment1;
import com.nanjing.tqlhl.calculator.ui.fragment.CalendarFragment2;
import com.nanjing.tqlhl.calculator.ui.fragment.CalendarFragment3;
import com.nanjing.tqlhl.calculator.ui.fragment.CalendarFragment4;
import com.nanjing.tqlhl.calculator.weiget.SwitchButton;
import com.nanjing.tqlhl.R;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarlendarCaculateActivity extends BaseRxActivity {
    List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.switchButton)
    SwitchButton switchButton;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.title_left_text)
    TextView title_left_text;
    @BindView(R.id.title_content_text)
    TextView title_content_text;
    @BindView(R.id.include_title)
    LinearLayout include_title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carlendar);
        ButterKnife.bind(this);
        bindView();
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

    private void bindView() {
        include_title.setBackgroundResource(R.color.colorTheme);
        title_content_text.setText("日期计算");
        FragmentManager f = getSupportFragmentManager();
        fragments.add(CalendarFragment1.newInstance(f));
        fragments.add(CalendarFragment2.newInstance(f));
        fragments.add(CalendarFragment3.newInstance(f));
        fragments.add(CalendarFragment4.newInstance(f));
        view_pager.setAdapter(new FragmentAdapter(f, fragments));
        view_pager.setOffscreenPageLimit(4);
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switchButton.setCheckedPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        switchButton.setOnChangeListener(new SwitchButton.OnChangeListener() {
            @Override
            public void onChange(int position) {
                view_pager.setCurrentItem(position);
            }
        });
        view_pager.setCurrentItem(0);
    }

    class FragmentAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments;

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


    @OnClick({R.id.title_left_text
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.title_left_text:
                finish();
                break;
            case R.id.tv_pulltoselect_end:

                break;
        }
    }
}
