package com.mobile.glidelibrary.cache;

import com.mobile.glidelibrary.resource.Value;
import com.mobile.glidelibrary.resource.ValueCallBack;
import com.mobile.glidelibrary.utils.Tool;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 活动缓存 真正在被使用的资源
 *
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class ActiveCache {
    private Map<String, WeakReference<Value>> map = new HashMap<>();
    //目的 ：为了监听 弱应用是否被回收了
    private ReferenceQueue<Value> mQueue;
    private boolean isCloseThread ;
    private Thread thread;
    private boolean isByRemove = false;
    private ValueCallBack mValueCallBack;

    public ActiveCache(ValueCallBack mValueCallBack) {
        this.mValueCallBack = mValueCallBack;
    }

    /**
     * 添加 活动缓存
     *
     * @param key
     * @param value
     */
    public void put(String key, Value value) {
        Tool.checkNotString(key);
        //绑定Value 的监听 --> value 发起的（value没有被使用了，就会发起这个监听，给外界业务需要使用）
        value.setCallBack(mValueCallBack);
        map.put(key, new CustomWeakReference(value, getQueue(), key));
    }

    /**
     * 获取
     *
     * @param key
     * @return
     */
    public Value get(String key) {
        WeakReference<Value> valueWeakReference = map.get(key);
        if (null != valueWeakReference) {
            return valueWeakReference.get();
        }
        return null;
    }

    /**
     * 手动移除
     *
     * @param key
     * @return
     */
    public Value remove(String key) {
        isByRemove = true;
        WeakReference<Value> valueWeakReference = map.remove(key);
        isByRemove = false;
        if (null != valueWeakReference) {
            return valueWeakReference.get();
        }
        return null;
    }

    /**
     * 关闭线程
     */
    public void closeThread() {
        isCloseThread = true;
        /*if (null != thread) {
            thread.interrupt(); //中断线程
            try {
                thread.join(TimeUnit.SECONDS.toMillis(5));
                if (thread.isAlive()) {
                    throw new IllegalStateException("活动缓存中 关闭线程 线程没有关闭");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        map.clear();
        System.gc();
    }

    public class CustomWeakReference extends WeakReference<Value> {
        private String key;
        public CustomWeakReference(Value referent, ReferenceQueue<? super Value> q, String key) {
            super(referent, q);
            this.key = key;
        }
    }

    private ReferenceQueue<Value> getQueue() {
        if (null == mQueue) {
            mQueue = new ReferenceQueue<>();
        }
        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("ReferenceQueue 线程状态" + isCloseThread);
                while (!isCloseThread) {
                    try {
                        if (!isByRemove) { //不是手动移除的时候
                            System.out.println("ReferenceQueue  手动" + isByRemove);
                            Reference<? extends Value> remove = mQueue.remove();
                            CustomWeakReference weakReference = (CustomWeakReference) remove;
                            if (map != null && !map.isEmpty()) {
                                map.remove(weakReference.key);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        return mQueue;
    }
}
