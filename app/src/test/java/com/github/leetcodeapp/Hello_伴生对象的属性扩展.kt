package com.github.leetcodeapp

/**

@author: dourl
@date: 2020/6/22
 */

class CompanionObject {
    companion object MyObject{

    }
}

fun CompanionObject.MyObject.method(){
    println("hello word")
}

fun main() {
    CompanionObject.method()
}