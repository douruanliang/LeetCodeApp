package com.github.designpatternlibrary.java.责任链模式2;

/**
 * @author: douruanliang
 * @date: 2020/9/8
 */
public class BridgeInterceptor implements Interceptor {
    @Override
    public String interceptor(Chain c) {
        System.out.println("BridgeInterceptor_start");
        String response = c.proceed(c.request());
        System.out.println("BridgeInterceptor_end");
        return response;
    }
}
