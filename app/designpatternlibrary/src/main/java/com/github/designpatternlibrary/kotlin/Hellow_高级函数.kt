package com.github.designpatternlibrary.kotlin

/**

high - order function

1 一个lambda 表达式格式要求

总是被 {} 包围
如果有参数的是 在 -> 的左边
执行体 在 -> 右边
@author: dourl
@date: 2020/6/23
 */


var subtract = { a: Int, b: Int -> a - b }

var multiply: (Int, Int) -> Int = { a, b -> a + b }


fun String.filter(predicate: (Char) -> Boolean): String {
    val ab = StringBuffer()

    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) {
            ab.append(element)
        }
    }
    return ab.toString()
}

fun main() {
    val str = "hello 28 world "
    println(str.filter { it.isLetter() })
}
