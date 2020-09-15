package com.github.leetcodeapp.kotlin学习

/**

@author: douruanliang
@date: 2020/9/10
 */
 interface Flyer {
    val speed :Int
    fun kind();
    fun Ifly(){
        println("I can fly")
    }
}