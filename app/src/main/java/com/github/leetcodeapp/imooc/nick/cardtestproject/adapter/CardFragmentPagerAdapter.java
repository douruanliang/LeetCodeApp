package com.github.leetcodeapp.imooc.nick.cardtestproject.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.github.leetcodeapp.imooc.nick.cardtestproject.bean.QuestionInfo;
import com.github.leetcodeapp.imooc.nick.cardtestproject.fragment.CardFragment;

import java.util.List;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<QuestionInfo> mList;

    public CardFragmentPagerAdapter(FragmentManager fm, List<QuestionInfo> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return CardFragment.newInstance(mList.get(position));
    }

    @Override
    public int getCount() {
        return this.mList.size();
    }
}
