package com.mobile.datastruct

/**

@author: douruanliang
@date: 2020/9/3
 数组连续最大和
 */
fun MaxSubArray(array: IntArray):Int{

    var thisSum :Int;
    var maxSum = 0;
    var i:Int =0;
    var j:Int;
    var k:Int;

    while (i< array.size){
        j= i;
        while (j <array.size){
            thisSum = 0;
            k=i;
            while (k< j){
                thisSum +=array[k]
                k++
            }
            if (thisSum >maxSum){
                maxSum =thisSum
            }
            j++
        }
        i++
    }

    return maxSum
}