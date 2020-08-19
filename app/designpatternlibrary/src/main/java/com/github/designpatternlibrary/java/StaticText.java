package com.github.designpatternlibrary.java;

/**
 * @author: douruanliang
 * @date: 2020/7/30
 */
class StaticText {


    int a = 100;
    static int b = 111;


    {
        System.out.println("2");
    }

    static {
        //只执行一次
        System.out.println("1");
    }

    //构造方法
    StaticText(){
        System.out.println("3");

        System.out.println("a="+a+",b="+b);
    }

    static  void staticFunction(){
        System.out.println(4);
    }

    void startFunction(){

    }
    public static void main(String[] args) {
        staticFunction();
    }
}
