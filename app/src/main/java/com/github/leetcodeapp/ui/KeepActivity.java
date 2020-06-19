package com.github.leetcodeapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.github.leetcodeapp.KeepManager;

/**
 * @author: dourl
 * @date: 2020/6/19
 */
public class KeepActivity extends Activity {

    private static final String TAG = "KeepActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setGravity(Gravity.START | Gravity.TOP);

        WindowManager.LayoutParams params = window.getAttributes();
        params.width = 1;
        params.height = 1;

        params.x = 0;
        params.y = 0;

        window.setAttributes(params);

        Log.d("KeepReceiver","KeepActivity");
        KeepManager.getInstance().setKeepActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
