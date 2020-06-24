package com.github.designpatternlibrary.kotlin

import java.lang.Integer.parseInt

/**

kotlin 异常是 有返回值的
@author: dourl
@date: 2020/6/23
 */


fun main() {
    val num = "";
    val result = try {
        parseInt(num)
    } catch (e: NumberFormatException) {
        null
    } finally {
        println("finally invokedo")
    }
    println(result)
    println("-------throw-表达式的类型是一种特殊的类型 Nothing--------")
    val str: String? = ""
    val str1 = str ?: throw IllegalArgumentException("值不能为空")

    println(str1)
    println("----------------")

    val a = null

    println(a is Nothing?)
    println("-------Nothing--2-------")
    var b = listOf(null)
    println(b is List<Nothing?>)

    println("-------Nothing---1------")
}