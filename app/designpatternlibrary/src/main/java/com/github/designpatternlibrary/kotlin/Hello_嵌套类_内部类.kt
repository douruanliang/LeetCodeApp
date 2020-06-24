package com.github.designpatternlibrary.kotlin

/**

@author: dourl
@date: 2020/6/22
 */

/*class Tree(var type: String) {

    private var mType: String = type;

    //内部类呢
    inner class Flavor() {
        fun innerMethod() = this@Tree.mType
    }

    //嵌套类
    class Grass(var name: String = "野草") {

        fun getGressName(): String {
            return this.name
        }

        fun getGrassName() = this.name
    }
}*/


class Tree(var treeName: String) {
    var mName: String = this.treeName

    //嵌套类
    class Flower(var flowerName: String) {
        fun getName(): String = this.flowerName
    }

    // 内部类
    inner class Grass(var grassName: String) {
        fun getName(): String {
            return "名称： ${grassName}"
        }
    }
    //局部嵌套类

    fun getName():String{

        class LocalNestedClass{
            val name:String = "瞎玩"
        }
        return LocalNestedClass().name
    }
}

fun main() {
    var name: String = Tree("老槐树").Grass("小草").getName()
    println(name)
    println("-----------------")
    name = Tree.Flower("菊花").getName()
    println(name)
}