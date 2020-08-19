package com.github.designpatternlibrary.java.责任链模式;

/**
 * @author: dourl
 * @date: 2020/7/12
 * <p>
 * 抽象请求者
 */
public abstract class AbstractRequest {

    //处理者对象
    private Object mObject;

    public AbstractRequest(Object mObject) {
        this.mObject = mObject;
    }

    public Object getContent() {
        return mObject;
    }

    public abstract int getQuestLevel();
}
