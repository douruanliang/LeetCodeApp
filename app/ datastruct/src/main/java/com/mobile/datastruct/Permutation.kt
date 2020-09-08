package com.mobile.datastruct

/**

@author: douruanliang
@date: 2020/9/3
 */


/**
 * 指定下标交换
 */
fun swap(str:CharArray ,i: Int,j:Int){
    val tmp = str[i];
    str[i] = str[j];
    str[j]= tmp;
}

/**
 * 置换
 * str 待置换的字符串
 * start 为待排序的子字符串的首字符下标
 */
fun permutation(str: CharArray,start:Int){
    if (start <0) return
    // 完成全排序后输出当前排列的字符串
    if (start == str.size-1){  // 2 的时候打印了 abc
        println(str)
    }
    else{
        for (i in start until str.size ){
            //交换 start and i char by index
            swap(str,start,i);
            //固定第一个字符，对剩下的字符进行全排列
            permutation(str,start+1)
            //还原star 与 i 所在的字符
            swap(str,start,i)
        }
    }
}

fun main(){
    permutation("abc".toCharArray(),0)
}