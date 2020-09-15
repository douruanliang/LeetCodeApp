package com.github.leetcodeapp.kotlin学习

import java.util.*

/**

@author: douruanliang
@date: 2020/9/10
 */
class People (id:String) {
    var mId:String
    init {
        this.mId = id
    }
    constructor(timestamp:Long) : this("")
    constructor(age: Int) :this(Long.MAX_VALUE)

    fun getAgeById(age:Int){

    }
}