package com.github.leetcodeapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 * View 基类
 */
public abstract class BaseView<P extends BasePresenter,CONTRACT> extends AppCompatActivity {

    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = getPresenter();
        p.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.unBindView();
    }

    /**
     * 让P层做什么需求
     * @return
     */
    public abstract CONTRACT getConTract();

    /**
     *  从子类中获取具体的契约
     * @return
     */
    public abstract P getPresenter();


    public void error(Exception e){}
}
