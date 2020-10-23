package com.nanjing.tqlhl.db.newcache.present.view;

import com.nanjing.tqlhl.base.IBaseCallback;
import com.nanjing.tqlhl.db.newcache.bean.WeaCacheBean;

import java.util.List;

/**
 * @author: 铭少
 * @date: 2020/9/12 0012
 * @description：
 */
public interface IWeaCallback extends IBaseCallback {

    void onLoadSave(boolean b);

    void onLoadCacheList(List<WeaCacheBean> weaCacheBeanList);

    void onDeleteCache(boolean b);

    void onLoadCacheOneList(List<WeaCacheBean> weaCacheBeanList);
}
