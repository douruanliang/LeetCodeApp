package com.github.leetcodeapp

/**

@author: dourl
@date: 2020/6/22
 */

open class ClaZZ {
    private val age = 3;
    protected val address = "beijing"
    internal val ems = "048207"

}

class ClaZZ1 : ClaZZ() {

    // protected 可以
    val fromParenAddress: String = address

    // 同模块
    val from_ems: String = ems

}


class ClaZZ2 {

}