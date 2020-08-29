package com.github.leetcodeapp.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.github.leetcodeapp.R;
import com.mobile.glidelibrary.core.Glide;

public class GlideActivity extends FragmentActivity {
    ImageView imageView, imageView2;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  1 设置全面屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 是否支持刘海屏
        boolean hasDisplayCutout = hasDisplayCutout(window);
        if (hasDisplayCutout) {
            // 2 让内容区域延伸进刘海
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(layoutParams);
            // 3 设置成沉浸式

            int flags = View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            int visibility = window.getDecorView().getSystemUiVisibility();
            visibility|= flags; //追加沉浸式设置

            window.getDecorView().setSystemUiVisibility(visibility);


        }


        setContentView(R.layout.activity_glide);
        imageView = findViewById(R.id.id_image);
        imageView2 = findViewById(R.id.id_image_2);
        // 运行时权限申请（6.0+）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (checkSelfPermission(perms[0]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(perms, 200);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private boolean hasDisplayCutout(Window window) {
        DisplayCutout displayCutout;
        View rootView = window.getDecorView();
        WindowInsets insets = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            insets = rootView.getRootWindowInsets();
        }
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) && insets != null) {
            displayCutout = insets.getDisplayCutout();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                if ((displayCutout.getBoundingRects() != null) && (displayCutout.getBoundingRects().size() > 0)
                        && (0 < displayCutout.getSafeInsetTop())) {
                    return true;

                }
            }
        }

        return true;

    }

    public int getStatusBarHeight(Context context) {
        int resID = context.getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resID > 0) {
            return context.getResources().getDimensionPixelSize(resID);
        }
        return 96;
    }


    public void testLoad(View view) {
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598461850886&di=97167e7e8a0f49a27adcb8717d9c7e3b&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fsoftbbs%2F1109%2F07%2Fc0%2F8900901_1315408796310_1024x1024soft.jpg")
                .into(imageView);
    }

    public void testLoad2(View view) {
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598461850886&di=97167e7e8a0f49a27adcb8717d9c7e3b&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fsoftbbs%2F1109%2F07%2Fc0%2F8900901_1315408796310_1024x1024soft.jpg")
                .into(imageView2);
    }

}