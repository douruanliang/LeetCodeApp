package com.github.designpatternlibrary.java.责任链模式;

/**
 * @author: dourl
 * @date: 2020/7/12
 */
public class TestHandleRequet {
    public static void main(String[] args) {
        Request1 request1 = new Request1("1");
        Request2 request2 = new Request2("2");
        Request3 request3 = new Request3("3");

        Handler1 handler1 = new Handler1();
        Handler2 handler2 = new Handler2();

        handler1.nextHandler = handler2;

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);


    }
}
