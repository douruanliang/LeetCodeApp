package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/21

 构造方法 和初始化工程
 */

class EmptyClass


class MyClass33(userName: String) {
    init {
        //给类的属性
        println(userName)
    }

    private val username: String = userName
}


class Person33(userName: String) {
    private var username: String
    private var age: Int
    private var address: String

    init {
        this.username = userName
        age = 10;
        address = "beijing"
    }

    constructor(userName: String, age: Int) : this(userName){
        this.age = age
        this.username = username
    }

    fun printInfo(){
        println("username: ${this.username},age : ${this.age},address: ${this.address}")
    }

}


class Student(private val userName: String,private val age: Int){
    fun printInfo(){
        println("userName : $userName")
    }
}

/**
 * 在JVM 上 如果primary 构造方法的所有参数都拥有默认值，那么kotlin编译器会为这个类生成一个没有参数的是构造方法，
 * 并且这个不带参构造方法会使用这些参数的默认值，这样做的目的是为
 */
class Student4(val username:String = "李四")

fun main() {
    var myClass = Person33("dou")
    //myClass.printInfo()
    var myClass2 =Person33("dourl",20)
    //myClass2.printInfo()

    var student = Student("张三",19);
    student.printInfo()

    var student4 = Student4()
    println(student4.username)
}