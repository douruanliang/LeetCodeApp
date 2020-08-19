package com.github.leetcodeapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.drawable.AnimationDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.github.leetcodeapp.R;
import com.github.leetcodeapp.util.BubbleUtils;

/**
 * @author: douruanliang
 * @date: 2020/8/19
 * <p>
 * 监听当前View 触摸事件
 */
public class BubbleMessageTouchListener implements View.OnTouchListener, MessageBubbleView.MessageBubbleListener {

    private View mStaticView;
    private WindowManager mWindowManager;
    private MessageBubbleView messageBubbleView;
    private WindowManager.LayoutParams layoutParams;
    private Context mContext;
    private FrameLayout mBombFrame;
    private ImageView mBombImageView;
    private BubbleDisappearListener mDisappearlistener;
    BubbleMessageTouchListener(Context context, View view,BubbleDisappearListener listener) {
        this.mStaticView = view;
        this.mContext = context;
        this.mDisappearlistener =listener;
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        messageBubbleView = new MessageBubbleView(context);
        messageBubbleView.setMessageBubbleListener(this);
        layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSPARENT;

        mBombFrame = new FrameLayout(mContext);
        mBombImageView = new ImageView(mContext);
        mBombImageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mBombFrame.addView(mBombImageView);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStaticView.setVisibility(View.INVISIBLE);
                //
                mWindowManager.addView(messageBubbleView, layoutParams);
                // 保证固定圆的中心在View的中心
                int[] location = new int[2];
                mStaticView.getLocationOnScreen(location);
                Bitmap bitmap = getBitmapByView(mStaticView);
                messageBubbleView.initPoint(location[0] + mStaticView.getWidth() / 2,
                        location[1] + mStaticView.getWidth() / 2 - BubbleUtils.getStatusBarHeight(mContext));
                messageBubbleView.setDragBitmap(bitmap);

                break;
            case MotionEvent.ACTION_MOVE:
                messageBubbleView.updateDragPoint(event.getRawX(), event.getRawY() - BubbleUtils.getStatusBarHeight(mContext));
                break;
            case MotionEvent.ACTION_UP:
                messageBubbleView.handleAction();
                break;
        }
        return true;
    }

    private Bitmap getBitmapByView(View view) {
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    @Override
    public void restore() {
        // 消息的view 移除
        mWindowManager.removeView(messageBubbleView);
        mStaticView.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismiss(PointF endPointF) {
        //执行爆炸效果
        // 原来的View的View肯定要移除
        mWindowManager.removeView(messageBubbleView);
        mWindowManager.addView(mBombFrame, layoutParams);
        mBombImageView.setBackgroundResource(R.drawable.anim_bubble_pop);

        AnimationDrawable animaDrawable = (AnimationDrawable) mBombImageView.getBackground();
        animaDrawable.start();
        mBombImageView.setX(endPointF.x-animaDrawable.getIntrinsicWidth()/2);
        mBombImageView.setY(endPointF.y-animaDrawable.getIntrinsicHeight()/2);
        mBombImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWindowManager.removeView(mBombFrame);
                if (mDisappearlistener !=null){
                    mDisappearlistener.dismiss(mStaticView);
                }
            }
        }, getAnimationDrawableTime(animaDrawable));
    }

    private long getAnimationDrawableTime(AnimationDrawable drawable) {

        int num = drawable.getNumberOfFrames();

        long time = 0;
        for (int i = 0; i < num; i++) {
            time += drawable.getDuration(i);
        }
        return time;
    }

    public interface BubbleDisappearListener{
        void dismiss(View view);
    }
}
