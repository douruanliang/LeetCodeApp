package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/21
 */

open class Parent(name: String) {

}


class Child0(name: String) : Parent(name) {

}

/***
 * 如果一个类没有 primary 构造方法，那么这个类的 每个次构造方法需要调用super关键子来初始化
 * 不同的次构造方法可以调用附类型的不同的构造方法
 */
class Child : Parent {

    constructor(name: String) : super(name) {

    }
}


/**
 * 方法的重写
 */
open class Fruit {
    open fun name() {
        println("水果名称")
    }

    fun expirationDate() {
        println("expirationDate")
    }

}

class Apple : Fruit() {
    override fun name() {
        println("水果名称:苹果")
    }
}

/*fun main() {
    var apple = Apple()
    apple.expirationDate()
    apple.name()

}*/

open class MyParent {
    open val name: String = "MyParent";
    open var level: String = "局长";
}

class MyChild : MyParent() {
    override val name: String = "myChile"

    override var level: String
        get() = super.level
        set(value) {}
}

fun main() {
    var myClass = MyChild()
    println("myClass"+myClass.name)
    println("myClass"+myClass.level)
}