package com.github.leetcodeapp

/**

@author: dourl
@date: 2020/6/22
 */


open class AA

class BB : AA() {

}


fun AA.a() = "a"


fun BB.a() = "b"


/**
 * 调用是有对象声所决定的，而不是有对象的实际类型决定的
 */
fun MyPrint(aa: AA) {

    println(aa.a());
}

class ExtensionTest {
    fun add(a: Int, b: Int) = a + b

    fun subtract(a: Int, b: Int) = a - b
}

fun ExtensionTest.multiply(a: Int, b: Int) = a * b


//扩展一个乘法
fun main() {

    var e = ExtensionTest();
    var result = e.multiply(2, 19);
    println(result)


    MyPrint(BB())
}