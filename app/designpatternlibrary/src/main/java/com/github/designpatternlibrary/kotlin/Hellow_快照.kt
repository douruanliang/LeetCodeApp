package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/23
 */

fun main() {

    var item_befor = mutableListOf<String>("q", "w", "e")
    val items = item_befor.toList();

    item_befor.add("s")

    println(items)
    println(item_befor)
}