package com.github.designpatternlibrary.kotlin

/**


函数返回 多个结果

@author: dourl
@date: 2020/6/23
 */


data class MyResult(val result: String, val status: Int)


fun myMethod(): MyResult {
    return MyResult("Success", 200)
}

fun myMethod1() : Pair<String,Int>{
    return Pair("fail",400)
}
fun main() {
    val (result, status) = myMethod()

    println(result)
    println(status)

    println("-------------")

    val (a,b) = myMethod1();
    println(a)
    println(b)
}