package com.mobile.glidelibrary.core;

import android.util.Log;
import android.widget.ImageView;

import com.mobile.glidelibrary.core.fragment.LifecycleCallback;

/**
 * 加载图片引擎
 *
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class RequestTargetEngine implements LifecycleCallback {

    public static String TAG = RequestTargetEngine.class.getSimpleName();

    @Override
    public void glideInitStart() {
        Log.d(TAG, "Start");
    }

    @Override
    public void glideStopAction() {
        Log.d(TAG, "stop");
    }

    @Override
    public void glideRecycleAction() {
        Log.d(TAG, "destroy");
    }

    public void into(ImageView imageView) {

    }
}
