package com.github.designpatternlibrary.kotlin

import java.io.BufferedWriter
import java.io.FileWriter

/**

@author: dourl
@date: 2020/6/20
 */


/**
 * 对称加码的使用场景
 */
fun main(args: Array<String>) {

    // aes 要求16位
    val key = "1234567812345678";

    //讲网络数据缓存到本地：加密

    val br = BufferedWriter(FileWriter("user.db"))


}