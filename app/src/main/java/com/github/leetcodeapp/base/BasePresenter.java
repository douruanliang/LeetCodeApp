package com.github.leetcodeapp.base;

import java.lang.ref.WeakReference;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 * Presenter 基类
 */
public abstract class BasePresenter <V extends BaseView,M extends BaseModel,CONTRACT> {

    protected M m;
    private WeakReference<V> vWeakReference;

    public BasePresenter() {
        m = getM();
    }

    public void bindView(V v) {
        vWeakReference = new WeakReference<>(v);
    }
    public void unBindView() {
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference =null;
        }
    }

    /**
     * 获取 View （P ->V）
     * @return
     */
    public V getView(){
        if (vWeakReference!=null){
            return vWeakReference.get();
        }
        return null;
    }

    /**
     * 获取子类具体的契约 （M V 层协商的共同业务）
     * @return
     */
    public abstract CONTRACT getContract();

    public abstract M getM();
}
