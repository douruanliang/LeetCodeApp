package com.github.leetcodeapp.demo.impl;

import android.graphics.Bitmap;

import com.github.leetcodeapp.demo.CacheApi;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 */
public class MemeryCacheImpl implements CacheApi {
    @Override
    public Bitmap loadByUrl(String url) {
        System.out.println("内存加载");
        return null;
    }
}
