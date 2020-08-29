package com.github.leetcodeapp.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author: douruanliang
 * @date: 2020/8/29
 */
public class PixUtils {

    private static PixUtils mPixUtils;
    //屏幕显示的宽高
    private int mDisplayWidth;
    private int mDisplayHeight;

    //设计稿的参考宽高
    private  static final float STANDARD_WIDTH = 720;
    private  static final float STANDARD_HEIGHT = 1280;

    private PixUtils(Context context) {
        if (mDisplayWidth == 0 || mDisplayHeight == 0) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);

                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    mDisplayWidth = displayMetrics.heightPixels;
                    mDisplayHeight = displayMetrics.widthPixels;
                } else {
                    mDisplayWidth = displayMetrics.widthPixels;
                    mDisplayHeight = displayMetrics.heightPixels -getStatusBarHeight(context);
                }

            }

        }
    }

    public int getStatusBarHeight(Context context){
        int resID = context.getResources().getIdentifier("status_bar_height",
                "dimen","android");
        if (resID>0){
            return context.getResources().getDimensionPixelSize(resID);
        }
        return 0;
    }
    public static PixUtils getInstance(Context context) {
        if (mPixUtils == null) {
            mPixUtils = new PixUtils(context.getApplicationContext());
        }
        return mPixUtils;
    }
    //获取水平方向的缩放比例
    public float getHorizontalScale(){
        return  mDisplayWidth/STANDARD_WIDTH;
    }
    //获取竖直方向的缩放比例
    public float getVerticalScale(){
        return  mDisplayHeight/STANDARD_HEIGHT;
    }

}
