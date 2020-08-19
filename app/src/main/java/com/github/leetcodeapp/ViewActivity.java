package com.github.leetcodeapp;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.github.leetcodeapp.view.BubbleMessageTouchListener;
import com.github.leetcodeapp.view.ColorTrackTextView;
import com.github.leetcodeapp.view.LoadingView;
import com.github.leetcodeapp.view.MessageBubbleView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ViewActivity extends Activity {

    ColorTrackTextView mColorTrackText;
    LoadingView mLoadLayout;

    Handler childHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                fabOnClick();
            }

        });

        MessageBubbleView.attach(findViewById(R.id.id_eg), new BubbleMessageTouchListener.BubbleDisappearListener() {
            @Override
            public void dismiss(View view) {

            }
        });



/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                childHandler = new Handler(){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        System.out.println("这个消息是从-->>" + msg.obj+ "过来的，在" + "btn的子线程当中" + "中执行的");
                    }
                };

                Looper.loop();
            }
        }).start();*/
    }


    public void fabOnClick() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Message msg = childHandler.obtainMessage();
                msg.what = 1;
                msg.obj = "fabClick";
                childHandler.sendMessage(msg);
            }
        }).start();
    }

    public void fromLeft(View v) {
       /* mColorTrackText.setDirection(ColorTrackTextView.Direction.LEFT_TO_RIGHT);
        ValueAnimator animator = ObjectAnimator.ofFloat(0, 1);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mColorTrackText.setmCurrentProgress(value);
            }
        });
        animator.start();*/
    }

    public void fromRight(View v) {
       /* mColorTrackText.setDirection(ColorTrackTextView.Direction.RIGHT_TO_LEFT);
        ValueAnimator animator = ObjectAnimator.ofFloat(0, 1);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float value = (float) animation.getAnimatedValue();
                mColorTrackText.setmCurrentProgress(value);
            }
        });
        animator.start();*/
    }

    public void exchange(View v) {
        /*ValueAnimator animator = ObjectAnimator.ofFloat(0, 10);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();

                if ((int) (value % 2)== 0) {
                    System.out.println("value % 2"+(value % 2));
                    mShapeView.exchange();
                }

            }
        });
        animator.start();*/
        if (mLoadLayout != null) {
            System.out.println("MMMMMMMMM");
            mLoadLayout.setVisibility(View.INVISIBLE);
        }

    }

}
