package com.mobile.glidelibrary.core;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.mobile.glidelibrary.cache.ActiveCache;
import com.mobile.glidelibrary.cache.MemoryCache;
import com.mobile.glidelibrary.cache.MemoryCacheCallback;
import com.mobile.glidelibrary.cache.disk.DiskLruCacheImpl;
import com.mobile.glidelibrary.core.fragment.LifecycleCallback;
import com.mobile.glidelibrary.core.load.LoadDataManager;
import com.mobile.glidelibrary.core.load.ResponseListener;
import com.mobile.glidelibrary.resource.Key;
import com.mobile.glidelibrary.resource.Value;
import com.mobile.glidelibrary.resource.ValueCallBack;
import com.mobile.glidelibrary.utils.Tool;

/**
 * 加载图片引擎
 *
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class RequestTargetEngine implements LifecycleCallback,
        ValueCallBack,
        MemoryCacheCallback,
        ResponseListener {

    private ActiveCache mActiveCache;
    private MemoryCache memoryCache;
    private DiskLruCacheImpl mDiskCache;
    public static String TAG = RequestTargetEngine.class.getSimpleName();

    @Override
    public void glideInitStart() {

        Log.d(TAG, " glide 声明周期之 初始化");
    }

    @Override
    public void glideStopAction() {

        Log.d(TAG, "glide 声明周期之 已经停止加载");
    }

    @Override
    public void glideRecycleAction() {

        Log.d(TAG, "glide 声明周期之 释放资源 缓存策略释放操作");
        if (mActiveCache != null) {
            mActiveCache.closeThread();
        }
    }

    private String path;
    private Context glideContext;
    private String key;
    private ImageView imageView;

    public void loadValueInitAction(String path, Context context) {
        this.path = path;
        this.glideContext = context;
        this.key = new Key(path).getKey();
    }

    public void into(ImageView imageView) {
        this.imageView = imageView;
        Tool.assertMainThread();

        // 加载资源--》 缓存---》 网络/SD/ 加载成功后 --》
        // 资源保存到缓存中 》》
        Value value = cacheAction();
        if (value != null && imageView != null) {
            imageView.setImageBitmap(value.getBitmap());
            value.usedAction();
        }

    }

    private Value cacheAction() {
        //TODO 第一步
        Value value = mActiveCache.get(key);
        if (value != null) {
            Log.d(TAG, "cache 本次加载是在（活动缓存）中>>>");
            value.useAction();
            return value;
        }
        value = memoryCache.get(key);
        // TODO 第二步
        if (value != null) {
            memoryCache.removeBy(key);
            mActiveCache.put(key, value);
            Log.d(TAG, "cache 本次加载是在（内存缓存）中>>>");
            value.useAction();
            return value;
        }

        // TODO 第三步
        value = mDiskCache.get(key);
        if (null != value) {
            mActiveCache.put(key, value);
            Log.d(TAG, "cache 本次加载是在 (磁盘缓存)中");
            value.useAction();
            return value;
        }
        // TODO 第四步 （网络加载）
        value = new LoadDataManager().loadResource(path, this, glideContext);
        if (value != null) {
            Log.d(TAG, "资源网络加载中");
            return value;
        }
        return null;
    }

    private final int MEMORY_CACHE_SIZE = 1024 * 1024 * 60;

    public RequestTargetEngine() {
        if (mActiveCache == null) {
            mActiveCache = new ActiveCache(this);
        }
        if (memoryCache == null) {
            memoryCache = new MemoryCache(MEMORY_CACHE_SIZE);
            memoryCache.setMemoryCacheCallback(this);
        }
        mDiskCache = new DiskLruCacheImpl();
    }


    /**
     * 活动缓存告诉外界 移除
     *
     * @param key
     * @param value
     */
    @Override
    public void valueNonUseListener(String key, Value value) {
        if (key != null && value != null) {
            Log.d(TAG, "把活动缓存操作的Value加入到 内存缓存中"+key);
            memoryCache.put(key, value);
        }
    }

    /**
     * 内存缓存告诉外界 移除
     *
     * @param key
     * @param oldValue
     */
    @Override
    public void entryRemoveMemoryCache(String key, Value oldValue) {
      // 添加 控流
    }

    /**
     * 外部资源加载结束
     *
     * @param value
     */
    @Override
    public void responseSuccess(Value value) {
        if (value != null) {
            // 此key已经加密
            saveCache(key, value);
            imageView.setImageBitmap(value.getBitmap());
        }
    }

    @Override
    public void responseException(Exception e) {
        Log.d(TAG, "网络加载异常");
    }

    /**
     * 保存到磁盘缓存中
     *
     * @param key
     * @param value
     */
    public void saveCache(String key, Value value) {
        value.setKey(key);
        if (mDiskCache != null) {
            mDiskCache.put(key, value);
        }

    }
}
