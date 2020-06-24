package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/21
 */

class Hellow_GetSet(address: String) {

    var address: String = address
        get() {
            println("get() invoked")
            return field
        }
        set(value) {
            println("set() invoked")
            field = value
            println("set() invoked $field")
        }


    /**
     * 不能在 primary constructor 声明的属性上
     * 不能自定义set/getter
     * 不能声明 在val
     *  不能声明属性可以为空，且不能是原声类型
     */
    lateinit var name :String

   // lateinit var sex:

    fun init(tempName:String){
        name = tempName;
    }

    fun pr(){
        println("$name")
    }
}

fun main() {
    var getSet = Hellow_GetSet("damndan");

    getSet.address = "lili"
    getSet.init("zhanpin")

    getSet.pr()
}