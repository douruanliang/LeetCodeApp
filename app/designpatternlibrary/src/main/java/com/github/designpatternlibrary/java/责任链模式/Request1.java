package com.github.designpatternlibrary.java.责任链模式;

/**
 * @author: dourl
 * @date: 2020/7/12
 */
public class Request1 extends AbstractRequest {
    public Request1(Object mObject) {
        super(mObject);
    }

    @Override
    public int getQuestLevel() {
        return 1;
    }
}
