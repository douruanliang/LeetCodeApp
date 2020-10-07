package com.mobile.datastruct


/**

@author: douruanliang
@date: 2020/9/24
 */

class Son{
    fun foo(){
        println("foo in class son")
    }
}

class  Parent{
    fun foo(){
        println("foo in class Parent")
    }

    fun Son.foo2(){
        this.foo()
        this@Parent.foo()
    }
}

object Test2{
    @JvmStatic
    fun main(args: Array<String>) {
        //Son().foo2()
    }
}