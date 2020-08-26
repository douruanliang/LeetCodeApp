package com.mobile.glidelibrary.core;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.FragmentActivity;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class Glide {

    RequestManagerRetriver managerRetriver;

    public Glide(RequestManagerRetriver managerRetriver) {
        this.managerRetriver = managerRetriver;
    }

    public static RequestManager with(FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    public static RequestManager with(Activity activity) {
        return getRetriever(activity).get(activity);
    }

    public static RequestManager with(Context context) {
        return getRetriever(context).get(context);
    }

    private static RequestManagerRetriver getRetriever(Context context) {

        return Glide.get(context).getRetriver();
    }


    public static Glide get(Context context) {
        return new GlideBuilder().build();
    }

    public RequestManagerRetriver getRetriver() {
        return managerRetriver;
    }
}
