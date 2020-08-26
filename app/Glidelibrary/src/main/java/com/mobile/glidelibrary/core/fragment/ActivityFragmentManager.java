package com.mobile.glidelibrary.core.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */

public class ActivityFragmentManager extends Fragment {
    private LifecycleCallback lifecycleCallback;

    public ActivityFragmentManager() {
    }

    @SuppressLint("ValidFragment")
    public ActivityFragmentManager(LifecycleCallback mCallback) {
        this.lifecycleCallback = mCallback;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (null != lifecycleCallback) {
            lifecycleCallback.glideInitStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (null != lifecycleCallback) {
            lifecycleCallback.glideStopAction();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != lifecycleCallback) {
            lifecycleCallback.glideRecycleAction();
        }
    }
}
