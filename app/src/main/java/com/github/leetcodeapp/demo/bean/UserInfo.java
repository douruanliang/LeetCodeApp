package com.github.leetcodeapp.demo.bean;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 */
public class UserInfo {

  private String name;

    public UserInfo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
