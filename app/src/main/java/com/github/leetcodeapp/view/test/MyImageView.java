package com.github.leetcodeapp.view.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author: douruanliang
 * @date: 2020/9/21
 */
public class MyImageView extends AppCompatImageView {
    public MyImageView(@NonNull Context context) {
        super(context);
    }

    public MyImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("xx", "MyButton的onTouchEvent--" + event.getAction());
        return super.onTouchEvent(event);

    }
}
