package com.mobile.datastruct

/**

 如何找出数组出现奇数次的数
@author: douruanliang
@date: 2020/9/3
 */


fun get2Num(intArray: IntArray){

    if (intArray.isEmpty()) return

    val map  = hashMapOf<Int,Int>();
    for (i in 0 until intArray.size){
        if (!map.containsKey(intArray[i])){
            map.put(intArray[i],1)
        }else{
            map.put(intArray[i],0)
        }
    }

    println(map)
    map.entries.iterator().forEach {
        if(it.value ==1){
            println(it.key);
        }
    }
}


fun get2YHNum(array: IntArray){

    var result =0;
    var position =0;

    for (i in array.indices){
        result = result xor array[i];
    }
    //临时保存异或结果
    val tmpResult = result;
    var i = result;
    while (i and 1 == 0){ // 关键字 and 位与
        position++;
        i = i shr 1 //有符号右移动
    }
    array.indices.asSequence().filter {
        array[it] shr position and 1 ==1
    }.forEach {
        result = result xor array[it];
    }

    println(result)
    println(result xor tmpResult)

}
fun main(){
    var array = intArrayOf(3,5,6,6,5,7,7,7,2,2)
    //期望结果为：1，7

    //get2Num(array)
    get2YHNum(array)
}