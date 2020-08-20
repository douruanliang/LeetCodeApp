package com.github.leetcodeapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author: douruanliang
 * @date: 2020/8/20
 */
class LoadingFView extends View {
    public LoadingFView(Context context) {
        this(context,null);
    }

    public LoadingFView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadingFView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //怎么让圆旋转
        drawRotationAnimator(canvas);
    }

    private void drawRotationAnimator(Canvas canvas) {

    }
}
