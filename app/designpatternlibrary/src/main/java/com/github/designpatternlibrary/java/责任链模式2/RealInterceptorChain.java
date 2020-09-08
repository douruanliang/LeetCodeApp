package com.github.designpatternlibrary.java.责任链模式2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: douruanliang
 * @date: 2020/9/8
 */
public class RealInterceptorChain implements Interceptor.Chain {
    private List<Interceptor> interceptors;
    private int index;
    private String request;

    public RealInterceptorChain(List<Interceptor> interceptors, int index, String request) {
        this.interceptors = interceptors;
        this.index = index;
        this.request = request;
    }
    @Override
    public String request() {
        return request;
    }
    @Override
    public String proceed(String request) {
        System.out.println("param -->" + request);
        if(index>= interceptors.size())
        return null;
        RealInterceptorChain next = new RealInterceptorChain(interceptors,index+1,request);
        Interceptor interceptor = interceptors.get(index); //0
        return interceptor.interceptor(next);
    }

    public static void main(String[] args) {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new RetryAndFollowInterceptor());
        interceptors.add(new BridgeInterceptor());
        interceptors.add(new CallServerInterceptor());

        RealInterceptorChain chain = new RealInterceptorChain(interceptors,0,"ooo");

        String response = chain.proceed("xiaoming 123");
        System.out.println("服务端返回结果为："+response);
    }
}
