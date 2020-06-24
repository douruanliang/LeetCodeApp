package com.github.designpatternlibrary.kotlin

/**
闭包 可以修改 所在外层的属性
@author: dourl
@date: 2020/6/23
 */

fun main() {
    var str = ""

    val strs = arrayOf("hello", "world", "type")
    strs.filter { it.length > 3 }.forEach {
        str += it
    }

    println(str)
}