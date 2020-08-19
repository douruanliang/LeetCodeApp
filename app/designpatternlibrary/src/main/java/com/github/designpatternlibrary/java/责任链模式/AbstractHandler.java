package com.github.designpatternlibrary.java.责任链模式;

/**
 * @author: dourl
 * @date: 2020/7/12
 * 抽象处理者
 */
public abstract class AbstractHandler {

    protected AbstractHandler nextHandler;

    /**
     * 逻辑判断
     * @param request
     */
    public final void handleRequest(AbstractRequest request) {
        if (request == null) {
            return;
        }
            // 1   ----------- 3
        if (getHandlerLevel() == request.getQuestLevel()) {
            handle(request);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println(" all of handler can not handle the request");
            }
        }
    }

    /**
     * 业务逻辑处理
     * @param abstractRequest
     */
    protected void handle(AbstractRequest abstractRequest) {
    }

    protected abstract int getHandlerLevel();
}
