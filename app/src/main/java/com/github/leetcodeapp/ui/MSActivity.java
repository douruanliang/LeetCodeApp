package com.github.leetcodeapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;

import com.github.leetcodeapp.KeepManager;
import com.github.leetcodeapp.R;

import java.util.HashMap;

public class MSActivity extends Activity {

    private Handler childHandler;
    HashMap map;
    SparseArray demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_s);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabOnClick();
            }
        });

      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("main 开启子线程");
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

        KeepManager.getInstance().registerKeep(this);


        //** 变量合并

        String s7 = "good good" + " study";

        String s8 = "good good study";

        System.out.println(s7 == s8);
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        KeepManager.getInstance().unregisterKeep(this);
    }
}
