package com.github.designpatternlibrary.kotlin

import kotlin.properties.Delegates

/**

@author: dourl
@date: 2020/6/23
 */


/**
 *
 * 1 延迟属性
 *  NONE : 只有一个线程时候用
 *  SYNCHRONIZED : 同步，只会有一个线程中得到计算，其他线程都会使用相同的一个结果
 *  PUBLICATION : 如果不需要初始化委托的同步，多个线程可以同时执行
 */
val myClass: Int by lazy(LazyThreadSafetyMode.NONE) {
    30
}

//2 可观察属性 observable

class Person {

    var age: Int by Delegates.observable(20) { property, oldValue, newValue ->
        println("${property.name},oldValue:${oldValue},newValue:${newValue}")
    }
}


class Person2 {
    var age: Int by Delegates.vetoable(20) { property, oldValue, newValue ->
        when {
            newValue >= oldValue -> true
            else -> false
        }
    }
}

//3 非空是属性

class MyPerson {
    var address: String by Delegates.notNull<String>()
}

//4 map属性


fun main() {
  /*  println(myClass)

    var mPerson = MyPerson();
    println("-------------")
    mPerson.address = "文化路2"
    println(mPerson.address)

    val p = Person()
    p.age = 29
    p.age = 30
    println("-------------")*/

    var p2 = Person2();

    println("${p2.age}") //20
    p2.age = 30;
    println("${p2.age}") //30
    p2.age = 10;
    println("${p2.age}") //30
}