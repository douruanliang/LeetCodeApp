package com.github.leetcodeapp.demo.factory;

import com.github.leetcodeapp.demo.Api;
import com.github.leetcodeapp.demo.impl.ApiImpl_A;
import com.github.leetcodeapp.demo.impl.ApiImpl_B;

public
/**
  参数工厂
 @author: douruanliang
 @date: 2020/8/21
 */
class ParameterFactory {

    public static Api create(int parameter){

        switch (parameter){
            case 1:
                return new ApiImpl_A();
            case 2:
                return new ApiImpl_B();
        }
        return null;
    }
}
