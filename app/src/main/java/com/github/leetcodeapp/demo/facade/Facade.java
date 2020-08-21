package com.github.leetcodeapp.demo.facade;

import com.github.leetcodeapp.demo.impl.DiskCacheImpl;
import com.github.leetcodeapp.demo.impl.MemeryCacheImpl;
import com.github.leetcodeapp.demo.impl.NetWorkCacheImpl;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 *
 * 门面模式
 */
public class Facade {

    private String url;
    private NetWorkCacheImpl mNet;
    private DiskCacheImpl mDisk;
    private MemeryCacheImpl mMemeryCache;

    public Facade(String url) {
        this.url = url;
        mNet = new NetWorkCacheImpl();
        mDisk =new DiskCacheImpl();
        mMemeryCache = new MemeryCacheImpl();
    }

    public void loader(){
        mNet.loadByUrl(url);
        mDisk.loadByUrl(url);
        mMemeryCache.loadByUrl(url);
    }
}
