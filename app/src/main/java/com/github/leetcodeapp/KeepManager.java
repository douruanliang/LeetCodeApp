package com.github.leetcodeapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.github.leetcodeapp.ui.KeepActivity;

import java.lang.ref.WeakReference;

/**
 * @author: dourl
 * @date: 2020/6/19
 */
public class KeepManager {
    private static volatile KeepManager mInstance;
    private KeepReceiver mKeepReceiver;
    private WeakReference<Activity> mKeepActivity;

    public static KeepManager getInstance() {

        if (mInstance == null) {
            synchronized (KeepManager.class) {
                if (mInstance == null) {
                    mInstance = new KeepManager();
                }
            }
        }
        return mInstance;
    }

    private KeepManager() {
    }


    /**
     * 注册广播
     *
     * @param context
     */
    public void registerKeep(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        mKeepReceiver = new KeepReceiver();
        context.registerReceiver(mKeepReceiver, intentFilter);
    }

    /**
     * 取消广播
     *
     * @param context
     */
    public void unregisterKeep(Context context) {
        if (mKeepReceiver != null) {
            context.unregisterReceiver(mKeepReceiver);
        }

    }

    /**
     * 启动Activity
     *
     * @param context
     */
    public void startKeep(Context context) {
        Log.d("KeepManager","start");
        Intent intent = new Intent(context, KeepActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    /**
     * 关闭Activity
     *
     */
    public void finishKeep() {
        Log.d("KeepManager","finish");
        if (mKeepActivity != null) {
            Activity activity = mKeepActivity.get();
            if (activity != null) {
                activity.finish();
            }
            mKeepActivity = null;
        }
    }

    /**
     * 设置
     *
     * @param activity
     */
    public void setKeepActivity(KeepActivity activity) {
        mKeepActivity = new WeakReference<>(activity);
    }
}
