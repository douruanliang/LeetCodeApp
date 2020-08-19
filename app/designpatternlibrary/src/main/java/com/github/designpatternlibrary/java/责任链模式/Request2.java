package com.github.designpatternlibrary.java.责任链模式;

/**
 * @author: dourl
 * @date: 2020/7/12
 */
public class Request2 extends AbstractRequest {
    public Request2(Object mObject) {
        super(mObject);
    }

    @Override
    public int getQuestLevel() {
        return 2;
    }
}
