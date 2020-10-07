package com.mobile.datastruct

/**

@author: douruanliang
@date: 2020/9/24
 */

fun main(){

   // foo{return };
    fooo();
}


fun localReturn(){
    //函数体中的return只会在该函数的局部生效
    return
}

fun fooo(){
    println("before local return");
    localReturn()
    println("after local return");
    return
}

inline fun foo(returning: () -> Unit) {

    println("before local return");
    returning()
    println("after local return");
    return

}
