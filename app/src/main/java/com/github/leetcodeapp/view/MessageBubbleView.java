package com.github.leetcodeapp.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.Nullable;

import com.github.leetcodeapp.util.BubbleUtils;

/**
 * @author: douruanliang
 *  仿qq 未读消息小红点拖拽效果
 * @date: 2020/8/19
 */
public class MessageBubbleView extends View {

    //两个圆的圆形
    private PointF mFixActionPoint, mDragPoint;
    //拖拽圆的半径
    private int mDragRadius = 12;
    //固定圆的最大半径
    private int mFixMixRadius = 8;
    //固定圆的最小半径
    private int mFixMinRadius = 5;
    //变化中的半径
    private int mFixRadius;
    //画笔
    private Paint mPaint;
    //被拖拽的镜像图片
    private Bitmap mDragBitmap;
    public MessageBubbleView(Context context) {
        this(context, null);
    }

    public MessageBubbleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessageBubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDragRadius = dip2px(mDragRadius);
        mFixMixRadius = dip2px(mFixMixRadius);
        mFixMinRadius = dip2px(mFixMinRadius);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true); //仿锯齿
        mPaint.setDither(true); //仿抖动
    }


    /**
     * 初始化圆的位置 两圆在一起重叠，圆心未手指按下的点
     *
     * @param downX
     * @param downY
     */
    public void initPoint(float downX, float downY) {
        mFixActionPoint = new PointF(downX, downY);
        mDragPoint = new PointF(downX, downY);
        invalidate();
    }
    public void setDragBitmap(Bitmap dragBitmap) {
        this.mDragBitmap = dragBitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mDragPoint == null || mFixActionPoint == null) return;
        // 拖拽的圆
        canvas.drawCircle(mDragPoint.x, mDragPoint.y, mDragRadius, mPaint);
        // 两圆之间的距离
        double distance = getDistance(mDragPoint,mFixActionPoint);
        // 随着距离的增大，半径在减小
        mFixRadius = (int) (mFixMixRadius - distance / 14);
        // 贝塞尔曲线
        Path bezeierPath = getBazeierPath();
        if (bezeierPath != null) {
            canvas.drawCircle(mFixActionPoint.x, mFixActionPoint.y, mFixRadius, mPaint);
            // 画贝塞尔曲线
            canvas.drawPath(bezeierPath, mPaint);
        }

        if (mDragBitmap!=null){
            canvas.drawBitmap(mDragBitmap, mDragPoint.x - mDragBitmap.getWidth() / 2, mDragPoint.y - mDragBitmap.getHeight() / 2, null);
        }


    }

    /**
     * 获取贝塞尔路径
     *
     * @return
     */
    private Path getBazeierPath() {
        if (mFixRadius < mFixMinRadius) {
            return null;
        }

        Path bezeierPath = new Path();

        // 求a 角
        float dx = mDragPoint.x - mFixActionPoint.x;
        float dy =  mDragPoint.y -mFixActionPoint.y;

        float tanA = dy / dx;
        //角A
        double aTan = Math.atan(tanA);
        // 固定圆的起点
        float p0X = (float) (mFixActionPoint.x + mFixRadius * Math.sin(aTan));
        float p0Y = (float) (mFixActionPoint.y - mFixRadius * Math.cos(aTan));

        float p1X = (float) (mDragPoint.x + mDragRadius * Math.sin(aTan));
        float p1Y = (float) (mDragPoint.y - mDragRadius * Math.cos(aTan));

        float p2X = (float) (mDragPoint.x - mDragRadius * Math.sin(aTan));
        float p2Y = (float) (mDragPoint.y + mDragRadius * Math.cos(aTan));

         // 固定圆的终点
        float p3X = (float) (mFixActionPoint.x - mFixRadius * Math.sin(aTan));
        float p3Y = (float) (mFixActionPoint.y + mFixRadius * Math.cos(aTan));

        bezeierPath.moveTo(p0X, p0Y);

        PointF controlPoint = getControllPoint();
        bezeierPath.quadTo(controlPoint.x, controlPoint.y, p1X, p1Y);

        bezeierPath.lineTo(p2X, p2Y);
        bezeierPath.quadTo(controlPoint.x, controlPoint.y, p3X, p3Y);

        bezeierPath.close();
        return bezeierPath;
    }

    private PointF getControllPoint() {

        return new PointF((mDragPoint.x + mFixActionPoint.x) / 2, (mDragPoint.y + mFixActionPoint.y) / 2);
    }

    private double getDistance(PointF mFixActionPoint, PointF mDragPoint) {
        float dx = mFixActionPoint.x - mDragPoint.x;
        float dy = mFixActionPoint.y - mDragPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * 固定圆 手指按下 半径会随着两圆的距离 逐渐减小
     * 拖拽圆 半径不变 位置随着手指移动
     *
     * @param event
     * @return
     */
   /* @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float dx = event.getX();
                float dy = event.getY();
                initPoint(dx, dy);
                break;
            case MotionEvent.ACTION_MOVE:
                float mx = event.getX();
                float my = event.getY();
                updateDragPoint(mx, my);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }*/

    /**
     * 更新当前拖拽点的位置
     *
     * @param moveX
     * @param moveY
     */
    public void updateDragPoint(float moveX, float moveY) {
        mDragPoint.x = moveX;
        mDragPoint.y = moveY;
        invalidate();
    }



    /**
     * 处理手指松开
     */
    public void handleAction() {
        if (mFixRadius > mFixMinRadius) {
            // 回弹
            ValueAnimator animator = ObjectAnimator.ofFloat(1f);
            animator.setDuration(250);
            final PointF start = new PointF(mDragPoint.x, mDragPoint.y);
            final PointF end = new PointF(mFixActionPoint.x, mFixActionPoint.y);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float percent = (float) animation.getAnimatedValue();// 0 - 1
                    PointF pointF = BubbleUtils.getPointByPercent(start, end, percent);
                    // 用代码更新拖拽点
                    updateDragPoint(pointF.x, pointF.y);
                }
            });
            // 设置一个差值器 在结束的时候回弹
            animator.setInterpolator(new OvershootInterpolator(3f));
            animator.start();
            // 还要通知 TouchListener 移除当前View 然后显示静态的 View
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    if (mListener != null) {
                        mListener.restore();
                    }
                }
            });
        } else {
            // 爆炸
            if (mListener != null) {
                mListener.dismiss(mDragPoint);
            }
        }
    }

    /**
     * 绑定可以拖砖的控件
     *
     * @param view     target
     * @param listener
     */
    public static void attach(View view, BubbleMessageTouchListener.BubbleDisappearListener listener) {
        view.setOnTouchListener(new BubbleMessageTouchListener(view.getContext(), view, listener));
    }

    private MessageBubbleListener mListener;

    public void setMessageBubbleListener(MessageBubbleListener listener) {
        this.mListener = listener;
    }

    public interface MessageBubbleListener {
        public void restore();

        public void dismiss(PointF endPointF);
    }

    private int dip2px(int i) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
    }
}
