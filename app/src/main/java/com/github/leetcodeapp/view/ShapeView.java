package com.github.leetcodeapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.github.leetcodeapp.R;

/**
 * @author: dourl
 * @date: 2020/6/11
 */
public class ShapeView extends View {

    private Shape mCurrentShape = Shape.CIRCLE;
    private Paint mPaint;
    private Path mPath;
    public ShapeView(Context context) {
        this(context,null);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(Math.min(w,h),(Math.min(w,h)));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        // 方
        // 三
        // 圆
        switch (mCurrentShape){
            case CIRCLE:
                int center = getWidth()/2;
                mPaint.setColor(Color.BLACK);
                canvas.drawCircle(center,center,center,mPaint);
                break;
            case SQUARE:
                mPaint.setColor(R.color.rect);
                canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
                break;
            case TRIANGLE:
                mPaint.setColor(Color.GREEN);
                if (mPath == null){
                    mPath = new Path();
                }
                mPath.moveTo(getWidth()/2,0);
                mPath.lineTo(0,(float) (getWidth()/2 * Math.sqrt(3)));
                mPath.lineTo(getWidth(),(float) (getWidth()/2 * Math.sqrt(3)));
                mPath.close();
                canvas.drawPath(mPath,mPaint);
                break;
        }
    }

    public void exchange() {
        switch (mCurrentShape){
            case CIRCLE:
                mCurrentShape = Shape.SQUARE;
                break;
            case SQUARE:
                mCurrentShape = Shape.TRIANGLE;
                break;
            case TRIANGLE:
                mCurrentShape = Shape.CIRCLE;
                break;
        }

        invalidate();
    }


    public enum Shape{
        CIRCLE,SQUARE,TRIANGLE;
    }

    public Shape getCurrentShape() {
        return mCurrentShape;
    }
}
