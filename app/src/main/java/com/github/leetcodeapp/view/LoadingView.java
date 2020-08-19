package com.github.leetcodeapp.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.github.leetcodeapp.R;

/**
 * @author: douruanliang
 * @date: 2020/8/18
 */
public class LoadingView extends LinearLayout {
    private ShapeView mShapeView; //上面的形状分
    private View mShadowView; //下面的阴影
    private int mTranslationDistance = 0;

    AnimatorSet set = new AnimatorSet();
    // 是否停止动画
    private boolean mIsStopAnimator = false;
    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }


    private void initLayout() {
        inflate(getContext(), R.layout.ui_loading_view, this);
        mShapeView = findViewById(R.id.id_shape_view);
        mShadowView = findViewById(R.id.id_shadow_view);
        mTranslationDistance = dip2px(80);
        post(new Runnable() {
            @Override
            public void run() {
                startFallAnimator();
            }
        });

    }

    private int dip2px(int dip) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dip, getResources().getDisplayMetrics());
    }

    /**
     * 下落动画
     */
    private void startFallAnimator() {

        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(
                mShapeView, "translationY",0,mTranslationDistance
                );
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(
                mShadowView, "scaleX",1f,0.3f
        );

        set.setDuration(500);
        set.playTogether(translationAnimator,scaleXAnimator);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //改变形状
                mShapeView.exchange();
                //下落完之后就上抛
                startUpAnimator();
            }
        });
        set.start();

    }

    /**
     * 上抛动画 并旋转
     */
    private void startUpAnimator() {
        if(mIsStopAnimator){
            return;
        }
        Log.e("TAG","startUpAnimator"+this);
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(
                mShapeView, "translationY",mTranslationDistance,0
        );
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(
                mShadowView, "scaleX",0.3f,1f
        );
        AnimatorSet setUp = new AnimatorSet();
        setUp.setDuration(500);
        setUp.playTogether(translationYAnimator,scaleXAnimator);
        setUp.setInterpolator(new DecelerateInterpolator());
        setUp.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startFallAnimator();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                startRotationAnimator();
            }
        });

        setUp.start();

    }

    private void startRotationAnimator(){

        ObjectAnimator rotation = null;
      switch (mShapeView.getCurrentShape()){
          case CIRCLE:

          case SQUARE:
              rotation = ObjectAnimator.ofFloat(mShapeView,"rotation",0,180);
              break;

          case TRIANGLE:
              rotation = ObjectAnimator.ofFloat(mShapeView,"rotation",0,-60);
              break;
      }

        rotation.setDuration(500);
        rotation.start();
    }
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(View.INVISIBLE);// 不要再去排放和计算，少走一些系统的源码（View的绘制流程）
        Log.e("TAG","setVisibility");
        // 清理动画
        mShapeView.clearAnimation();
        mShadowView.clearAnimation();
        // 把LoadingView从父布局移除
        ViewGroup parent = (ViewGroup) getParent();
        if(parent != null){
            parent.removeView(this);// 从父布局移除
            removeAllViews();// 移除自己所有的View
        }
        mIsStopAnimator = true;

        set.cancel();
    }
}
