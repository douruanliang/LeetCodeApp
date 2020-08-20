package com.github.leetcodeapp.view.listData;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author: douruanliang
 * @date: 2020/8/20
 */
public abstract class BaseMenuAdapter {

    //tab项
    public abstract int getCount();
    public abstract View getTabView(int position, ViewGroup parent);
    public abstract View getMenuView(int position,ViewGroup parent);
    /**
     * 菜单打开
     * @param tabView
     */
    public void menuOpen(View tabView) {

    }

    /**
     * 菜单关闭
     * @param tabView
     */
    public void menuClose(View tabView) {

    }

}
