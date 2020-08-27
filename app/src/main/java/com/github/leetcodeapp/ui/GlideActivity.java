package com.github.leetcodeapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.leetcodeapp.R;
import com.mobile.glidelibrary.core.Glide;

public class GlideActivity extends FragmentActivity {
    ImageView  imageView,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView =  findViewById(R.id.id_image);
        imageView2 =  findViewById(R.id.id_image_2);
        // 运行时权限申请（6.0+）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (checkSelfPermission(perms[0]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(perms, 200);
            }
        }
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