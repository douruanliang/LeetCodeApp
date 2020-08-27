package com.mobile.glidelibrary.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.mobile.glidelibrary.core.fragment.ActivityFragmentManager;
import com.mobile.glidelibrary.core.fragment.FragmentActivityFragmentManager;


/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class RequestManager {
    private Context requestManagerContext;
    private final String FRAGMENT_ACTIVITY_NAME = "fragment_activity_name";
    private final String ACTIVITY_NAME = "activity_name";
    private RequestTargetEngine requestTargetEngine;

    {
        if (requestTargetEngine == null) {
            requestTargetEngine = new RequestTargetEngine();
        }
    }

    public RequestManager(FragmentActivity fragmentActivity) {
        this.requestManagerContext = fragmentActivity;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Fragment fragment = supportFragmentManager.findFragmentByTag(FRAGMENT_ACTIVITY_NAME);
        if (fragment == null) {
            //fragment 声明周期关联了
            fragment = new FragmentActivityFragmentManager(requestTargetEngine);
            supportFragmentManager.beginTransaction()
                    .add(fragment, FRAGMENT_ACTIVITY_NAME)
                    .commitAllowingStateLoss();
        }
        mHandle.sendEmptyMessage(9999);
    }

    public RequestManager(Activity activity) {
        this.requestManagerContext = activity;
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        android.app.Fragment fragment = fragmentManager.findFragmentByTag(ACTIVITY_NAME);

        if (null == fragment) {
            fragment = new ActivityFragmentManager(requestTargetEngine);
            fragmentManager.beginTransaction()
                    .add(fragment, ACTIVITY_NAME)
                    .commitAllowingStateLoss();
        }
        mHandle.sendEmptyMessage(9999);
    }

    public RequestManager(Context context) {
        this.requestManagerContext = context;
    }

    Handler mHandle = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            return false;
        }
    });

    /**
     * @param url
     * @return
     */
    public RequestTargetEngine load(String url) {

        // 移除Handler
        mHandle.removeMessages(9999);
        // 把值传递给 引擎
        requestTargetEngine.loadValueInitAction(url,requestManagerContext);
        return requestTargetEngine;
    }
}
