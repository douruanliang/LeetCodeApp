package com.github.leetcodeapp.demo.impl;

import com.github.leetcodeapp.demo.bean.UserInfo;
import com.github.leetcodeapp.demo.Api;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 */
public class ApiImpl_B implements Api {
    @Override
    public UserInfo create() {
        return new UserInfo("bb");
    }
}
