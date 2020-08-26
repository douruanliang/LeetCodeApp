package com.mobile.glidelibrary.core;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.FragmentActivity;

/**
 * 管理RequestManager
 *
 * @author: douruanliang
 * @date: 2020/8/26
 */
class RequestManagerRetriver {
    public RequestManager get(FragmentActivity fragmentActivity) {

        return new RequestManager(fragmentActivity);
    }

    public RequestManager get(Activity activity) {
        return new RequestManager(activity);
    }

    public RequestManager get(Context context) {
        return new RequestManager(context);
    }
}
