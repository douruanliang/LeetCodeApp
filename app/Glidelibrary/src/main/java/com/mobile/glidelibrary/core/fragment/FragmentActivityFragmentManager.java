package com.mobile.glidelibrary.core.fragment;

import androidx.fragment.app.Fragment;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class FragmentActivityFragmentManager extends Fragment {

    private LifecycleCallback mLifecycleCallback;

    public FragmentActivityFragmentManager(LifecycleCallback mLifecycleCallback) {
        this.mLifecycleCallback = mLifecycleCallback;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (null != mLifecycleCallback) {
            mLifecycleCallback.glideInitStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (null != mLifecycleCallback) {
            mLifecycleCallback.glideStopAction();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mLifecycleCallback) {
            mLifecycleCallback.glideRecycleAction();
        }
    }
}
