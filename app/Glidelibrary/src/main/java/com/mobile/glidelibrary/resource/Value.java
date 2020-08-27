package com.mobile.glidelibrary.resource;

import android.graphics.Bitmap;
import android.util.Log;

import com.mobile.glidelibrary.utils.Tool;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class Value {
    private final String TAG = Value.class.getSimpleName();

    private Value() {
    }

    public static volatile Value value;

    public static Value getInstance() {

        if (null == value) {
            synchronized (Value.class) {
                if (null == value) {
                    value = new Value();
                }
            }
        }
        return value;
    }

    private Bitmap mBitmap;
    // 使用计数
    private int count;

    private ValueCallBack mCallBack;

    public void setCallBack(ValueCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ValueCallBack getmCallBack() {
        return mCallBack;
    }

    public void setmCallBack(ValueCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String mKey) {
        this.mKey = mKey;
    }

    private String mKey;

    /**
     *
     */
    public void useAction() {
        Tool.checkNotEmpty(mBitmap);
        if (mBitmap.isRecycled()) {
            Log.d(TAG, "useAction : 已经被回收了" );
            return;
        }
        Log.d(TAG, "useAction : count 加一" + count);
        count++;
    }

    /**
     * 使用完了 --1
     */
    public void usedAction() {
        count--;
        if (count <= 0 && mCallBack != null) {
            // 回调接口告诉外界，不再使用。
            mCallBack.valueNonUseListener(mKey, this);
        }
        Log.d(TAG, "usedAction : count 减一" + count);
    }

    /**
     * 释放资源
     */
    public void recyclerBitmap() {
        if (count > 0) {
            Log.d(TAG, "recyclerBitmap 引用 : count {大于0}" + count);
            return;
        }
        if (mBitmap.isRecycled()) {
            return;
        }
        mBitmap.recycle();
        value = null;
        System.gc();
    }
}
