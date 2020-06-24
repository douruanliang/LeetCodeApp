package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/21
 */


/**
 * 单例
 */
object Hellow_Object {
    fun method() {

    }
}

/**
 * kotlin 没有静态方法
 */

class MyTest {

    /**
     * 一个类只能有一个 半生对象，
     * 如果没有名字，则半生对象默认的名字为 Companion
     */
    companion object  {
        var a: String = "100"

        fun method() {
            println("method invoked");
        }
    }
}

fun main() {
    MyTest.method()
    println( MyTest.Companion.a)

    val v = MyTest.Companion

    println(v.javaClass)
}