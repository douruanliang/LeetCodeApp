package com.github.designpatternlibrary.java.责任链模式2;

/**
 * @author: douruanliang
 * @date: 2020/9/8
 */
public interface Interceptor {

    public String interceptor(Chain c);

    interface Chain{
        String request();
        String proceed(String request);
    }
}
