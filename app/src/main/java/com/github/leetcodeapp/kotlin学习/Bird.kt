package com.github.leetcodeapp.kotlin学习

import kotlin.properties.Delegates

/**

@author: douruanliang
@date: 2020/9/10
 */


/**
 * 构造方法的参数名前带上var|vaL 等价在bird 类内部声明了一个同名的属性
 */
open class Bird(
   val weight: Double,
    age: Int,
    color: String
) {

    var age: Int

    init {
        this.age = age
    }

    // ----初始代码块----
    val sex:String by lazy {
        if(color =="yellow") "male" else "female"
    }

   /* var address:String by lazy {
        "ssss"
    }*/
    fun getWeight(){
       println(this.weight)
   }
    var test by Delegates.notNull<Int>()

     fun doSomething(){
         test = 1
         println(test)
     }

    open fun fly(){
        println("i can fly");
    }
}

class Penguin :Bird(1.0,3,"🐧"),Flyer{
    override val speed: Int
        get() = 200

    override fun kind() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        println("i can't fly")
    }
}

fun main() {
    var penguin = Penguin();
    println(penguin.weight)
    penguin.fly()
    penguin.age = 100
}