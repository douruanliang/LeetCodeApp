package com.github.leetcodeapp.imooc.nick.cardtestproject.view;


import com.github.leetcodeapp.imooc.nick.cardtestproject.bean.QuestionInfo;

import java.util.List;

public interface ITestView {

    void updateUI(List<QuestionInfo> list);

    void setBottomTipView(String count);
}
