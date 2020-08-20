package com.github.leetcodeapp.view.listData;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.leetcodeapp.R;

/**
 * @author: douruanliang
 * @date: 2020/8/20
 */
public class ListScreenMenuAdapter extends BaseMenuAdapter {
    private Context mContext;
    private String[] mItems ={"类型","品牌","价格","更多"};
    public ListScreenMenuAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public View getTabView(int position, ViewGroup parent) {
        TextView tabView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_tab,parent,false);
        tabView.setText(mItems[position]);
        tabView.setTextColor(Color.BLACK);
        return tabView;
    }

    @Override
    public View getMenuView(int position, ViewGroup parent) {
        // 真正开发过程中，不同的位置显示的布局不一样
        TextView menuView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_menu,parent,false);
        menuView.setText(mItems[position]);
        return menuView;
    }
}
