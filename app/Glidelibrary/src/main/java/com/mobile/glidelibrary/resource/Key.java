package com.mobile.glidelibrary.resource;

import com.mobile.glidelibrary.utils.Tool;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class Key {
    //需要加密
    String key;

    public Key(String key) {
        this.key = Tool.getSHA256StringJava(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = Tool.getSHA256StringJava(key);
    }
}
