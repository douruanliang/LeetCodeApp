package com.mobile.datastruct

/**

@author: douruanliang
@date: 2020/9/24
 */


data class Area(val v:Double)


operator fun Area.plus(that:Area):Area{
    return Area(this.v + that.v)
}


fun MutableList<Int>.exchange(from:Int,to:Int){
    val tmp = this[from];
    this[from] = this[to];
    this[to] = tmp
}
fun main() {
    println(Area(1.0) + Area(2.0))
    val list = mutableListOf<Int>(1,2,3,4)
    list.exchange(1,3);

    println(list)
}