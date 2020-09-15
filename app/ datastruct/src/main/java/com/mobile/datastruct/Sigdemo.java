package com.mobile.datastruct;

/**
 * @author: douruanliang
 * @date: 2020/9/10
 */
public class Sigdemo {

    private Sigdemo(){}
    public static volatile  Sigdemo mInstance;
    public static  Sigdemo getInstance(){
        if (mInstance == null){
            synchronized (Sigdemo.class){
                if (mInstance == null){
                    mInstance = new Sigdemo();
                }
            }
        }
        return mInstance;
    }
}
