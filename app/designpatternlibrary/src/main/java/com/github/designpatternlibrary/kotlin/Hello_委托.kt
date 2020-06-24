package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/23
 */


//类委托 对象为类本身


interface MyInterface {
    fun MyPrint()
}


class MyInterFaceImpl(val str: String) : MyInterface {
    override fun MyPrint() {
        println("welcome" + str);
    }
}

class MyPClass(myInterface: MyInterface) : MyInterface by myInterface{
    override fun MyPrint() {
        println("welcome MyCLass");
    }
}


fun main() {
    val myInterFaceImpl :MyInterface = MyInterFaceImpl("shanhao");
    MyPClass(myInterFaceImpl).MyPrint()
}