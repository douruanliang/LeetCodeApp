package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/22
 */


class MyClass<T>(t: T) {
    var args: T

    init {
        this.args = t
    }
}

fun main() {
    var myClass = MyClass<String>("hello")

    println(myClass.args)
}

