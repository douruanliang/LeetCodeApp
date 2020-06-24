package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/20
 */

fun main() {

    // println(convert2Int("adb"))

    var array = listOf<String>("hello", "world", "hello world")

    /* for (item in array) {
         println(item)
     }

     when {
         "world" in array -> println("world in collection");
     }*/

    getMyWord(array);

    myPrint(5,20);
}

fun convert2Int(s: String): Int? {

    return try {
        s.toInt();
    } catch (e: NumberFormatException) {
        null;
    }
}


fun getMyWord(words: List<String>) {
    words.filter { it.length > 5 }
        .map { it.toUpperCase() }
        .sorted().forEach {
            println(it)
        }
}

fun myPrint(a: Int, b: Int) {

    println("$a + $b = ${a + b}")
}

