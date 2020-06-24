package com.github.leetcodeapp

/**

@author: dourl
@date: 2020/6/22
 */


class MyExtension


val MyExtension.name :String
    get() = "hello"


/**
 *
 */
fun main() {
    var myExtension = MyExtension()
    println(myExtension.name)
}