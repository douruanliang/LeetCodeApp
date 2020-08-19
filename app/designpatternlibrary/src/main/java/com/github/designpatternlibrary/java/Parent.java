package com.github.designpatternlibrary.java;

/**
 * @author: douruanliang
 * @date: 2020/7/30
 */
class Parent {

    static String name = "hello";

    {
        System.out.println("parent block");
    }

    static {
        System.out.println("parent static block");
    }

    public Parent() {
        System.out.println("parent constructor");
    }
}

