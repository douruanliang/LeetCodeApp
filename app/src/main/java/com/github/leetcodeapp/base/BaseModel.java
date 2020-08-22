package com.github.leetcodeapp.base;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 * 接受P层交给它的需求（基类）
 */

public abstract class BaseModel<P extends BasePresenter,CONTRACT> {

    protected P p;

    public BaseModel(P p) {
        this.p = p;
    }

    public abstract CONTRACT getContract();
}
