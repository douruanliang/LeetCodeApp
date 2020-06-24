package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/21
 */

interface A {
    fun method() {
        println("a")
    }
}

open class B {
    open fun method() {
        println("b")
    }
}

class C : A, B() {
    override fun method() {
        super<B>.method()

        println("c")
    }
}

fun main() {
    var c = C();
    c.method()
}