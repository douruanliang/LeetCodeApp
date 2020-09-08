package com.github.designpatternlibrary.java.责任链模式2;

/**
 * @author: douruanliang
 * @date: 2020/9/8
 */
public class RetryAndFollowInterceptor implements Interceptor {
    @Override
    public String interceptor(Chain c) {
        System.out.println("RetryAndFollowInterceptor_start");
        String response = c.proceed(c.request());
        System.out.println("RetryAndFollowInterceptor_end");
        return response;
    }
}
