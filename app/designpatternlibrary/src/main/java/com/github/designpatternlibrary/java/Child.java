package com.github.designpatternlibrary.java;

/**
 * @author: douruanliang
 * @date: 2020/7/30
 */
class Child extends Parent {
    static String name = "hello_coming";

    {
        System.out.println("Child block");
        System.out.println(Parent.name);
    }

    static {
        System.out.println("Child static block");
    }

    public Child() {
        System.out.println("child constructor");
    }
}
