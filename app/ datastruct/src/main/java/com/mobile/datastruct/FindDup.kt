package com.mobile.datastruct

/**

@author: douruanliang
@date: 2020/9/2
 */

fun findDup(array: IntArray): Int {
    val len = array.size;
    var index = 0;
    val i = 0;
    while (true) {
        if (array[i]>= len) return -1;
        if (array[index] <0) break;   //关键，请自己get
        array[index] *= -1;  // 标记
         // 解释一下 原先的都是+ 的，
        index = array[index]*(-1);
        if (index >= len){
            return -1  //下标不存在
        }
    }
    return index
}

fun main(){
    println(findDup(intArrayOf(1,3,4,3,5,2)));
}