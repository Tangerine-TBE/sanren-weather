package com.nanjing.tqlhl.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.nanjing.tqlhl.db.newcache.bean.CityCacheBean;
import com.nanjing.tqlhl.ui.fragment.CurrentCityFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinming QQ:1245074510
 * @name WeatherOne
 * @class name：com.nanjing.tqlhl.ui.adapter
 * @class describe
 * @time 2020/9/17 11:30
 * @class describe
 */
public class SelectCityAdapter extends FragmentStatePagerAdapter {

    public SelectCityAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        CurrentCityFragment cityFragment = CurrentCityFragment.getInstance(mList.get(position));
        return cityFragment;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        CurrentCityFragment fragment = (CurrentCityFragment)super.instantiateItem(container, position);
        fragment.updateArguments(position);
        return super.instantiateItem(container, position);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    private  List<CityCacheBean>  mList=new ArrayList<>();
    public void setData(List<CityCacheBean> data){
        mList.clear();
        mList.addAll(data);
        notifyDataSetChanged();
    }

    public static Fragment instantFragment;
    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        instantFragment = (Fragment) object;
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getInstantFragment(){
        return instantFragment;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }


}
