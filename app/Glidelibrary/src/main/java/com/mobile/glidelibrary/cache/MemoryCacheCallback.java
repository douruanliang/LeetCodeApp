package com.mobile.glidelibrary.cache;

import com.mobile.glidelibrary.resource.Value;

/** 内存缓存中 元素被移除的接口回调
 * @author: douruanliang
 * @date: 2020/8/26
 */
public interface MemoryCacheCallback {
    /**
     * 内存缓存中移除的key -- value
     * @param key
     * @param oldValue
     */
    public void entryRemoveMemoryCache(String key, Value oldValue);
}
