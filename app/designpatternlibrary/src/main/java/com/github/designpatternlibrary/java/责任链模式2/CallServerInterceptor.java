package com.github.designpatternlibrary.java.责任链模式2;

/**
 * @author: douruanliang
 * @date: 2020/9/8
 */
public class CallServerInterceptor implements Interceptor {
    @Override
    public String interceptor(Chain chain) {
        System.out.println("CallServerInterceptor_start");
        System.out.println("-----服务端接受到请求数据为"+ chain.request());
        System.out.println("CallServerInterceptor_end");

        return "发送成功";
    }
}
