package com.github.designpatternlibrary.java.责任链模式;

/**
 * @author: dourl
 * @date: 2020/7/12
 */
public class Handler2 extends AbstractHandler {
    @Override
    protected int getHandlerLevel() {
        return 2;
    }

    @Override
    protected void handle(AbstractRequest abstractRequest) {
        System.out.println(" handler 2 handle request:{QuestLevel}" + abstractRequest.getQuestLevel());
    }
}
