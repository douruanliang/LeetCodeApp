package com.mobile.glidelibrary.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.mobile.glidelibrary.resource.Value;
import com.mobile.glidelibrary.utils.Tool;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class MemoryCache extends LruCache<String, Value> {

    private boolean isRemoveBy;
    private MemoryCacheCallback memoryCacheCallback;

    /**
     * 手动移除
     *
     * @param key
     * @return
     */
    public Value removeBy(String key) {
        isRemoveBy = true;
        Value value = remove(key);
        isRemoveBy = false;
        return value;
    }

    public void setMemoryCacheCallback(MemoryCacheCallback memoryCacheCallback) {
        this.memoryCacheCallback = memoryCacheCallback;
    }

    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public MemoryCache(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int sizeOf(String key, Value value) {
        Bitmap bitmap = value.getBitmap();
        if (bitmap != null) {
            return Tool.getSize(bitmap);
        }
        return 0;
    }

    /**
     * 重复的key
     * 最少使用的元素会被移除
     *
     * @param evicted
     * @param key
     * @param oldValue
     * @param newValue
     */
    @Override
    protected void entryRemoved(boolean evicted, String key, Value oldValue, Value newValue) {
        super.entryRemoved(evicted, key, oldValue, newValue);
        if (memoryCacheCallback != null && !isRemoveBy) {
            memoryCacheCallback.entryRemoveMemoryCache(key, oldValue);
        }
    }
}
