package com.mobile.datastruct;

import android.text.TextUtils;

/**
 * @author: douruanliang
 * @date: 2020/9/11
 */
public class TestDemo {
    // fun --》 uuid
    private TestDemo() {
    }

    public static volatile TestDemo instance;

    public static TestDemo getInstance() {
        if (instance == null) {
            synchronized (TestDemo.class) {
                if (instance == null) {
                    instance = new TestDemo();
                }
            }
        }
        return instance;
    }


    public static volatile String result = "";

    private static String createUUID() {
        return "CCC"; // 不同
    }

    //TAG
    public static  String getUUID() {

        if (TextUtils.isEmpty(result)){
            synchronized(TestDemo.class){
                if (TextUtils.isEmpty(result)) {
                    result = createUUID();
                }
            }
        }
        return result;  // 同一个
    }



}
