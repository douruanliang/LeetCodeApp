package com.github.leetcodeapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

/**
 * @author: dourl
 * @date: 2020/6/19
 */
public class KeepReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.d("KeepReceiver",action);
        if (TextUtils.equals(action, Intent.ACTION_SCREEN_ON)) {
            //开幕
            Log.d("KeepReceiver","开幕");
            KeepManager.getInstance().finishKeep();
        } else if (TextUtils.equals(action, Intent.ACTION_SCREEN_OFF)) {
            //关闭
            Log.d("KeepReceiver","关闭");
            KeepManager.getInstance().startKeep(context);
        }
    }
}
