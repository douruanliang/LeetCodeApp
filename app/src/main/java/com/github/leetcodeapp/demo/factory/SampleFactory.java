package com.github.leetcodeapp.demo.factory;

import com.github.leetcodeapp.demo.Api;
import com.github.leetcodeapp.demo.impl.ApiImpl;

/**
 * 简单工厂
 * @author: douruanliang
 * @date: 2020/8/21
 */
public class SampleFactory {

    public static Api createApi(){
        return new ApiImpl();
    }
}
