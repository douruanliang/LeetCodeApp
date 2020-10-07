package com.mobile.datastruct

/**

@author: douruanliang
@date: 2020/9/23
 */

class Test {

    var flag: Boolean = false
        private set

    /**
     * 判断 是否是数字
     */
    fun isNumber(char: Char): Boolean {
        return char in '0'..'9';
    }

    fun strToInt(str: String?): Int {
        if (str == null) {
            flag = false
            println("no");
            return -1
        }
        flag = true
        var res = 0
        var i = 0

        var minus = false

        if (str[i] == '-') {
            minus = true
            i++
        }
        if (str[i] == '+') {
            minus = true
            i++
        }

        while (i < str.length) {
            if (isNumber(str[i])) {
                res = res * 10 + str[i].toInt() - '0'.toInt()
            } else {
                flag = false
                println("不是数字")
                return -1
            }
            i++
        }
        return if (minus) -res else res
    }

    
}