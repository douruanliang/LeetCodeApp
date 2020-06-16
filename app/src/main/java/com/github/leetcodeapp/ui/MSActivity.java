package com.github.leetcodeapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.github.leetcodeapp.R;

public class MSActivity extends Activity {

    private Handler childHandler;

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

        new Thread(new Runnable() {
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
        }).start();
    }


    public void fabOnClick(){
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

}
