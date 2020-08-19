package com.github.leetcodeapp.demo;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;

import androidx.annotation.Nullable;

/**
 * @author: dourl
 * @date: 2020/7/8
 */
public class IdleHandler_Test extends Activity {



    MessageQueue.IdleHandler idleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {

            //false 表示一次行买卖 执行完成就移除
            return false;
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Looper.myQueue().addIdleHandler(idleHandler);
    }
}
