package com.github.designpatternlibrary.kotlin

import kotlin.reflect.KClass

/**
meta-annotation 通过元注解 赋予一颗新的意义
@author: dourl
@date: 2020/6/23
 */

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CONSTRUCTOR
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class MyAnnotation


/**
 *
 * 注解 可以有拥有自己的构造方法 并且构造方法也可以接受参数
 * 构造方法所允许的 参数类型
 * 与java 元生类型一样 Int Long Short Byte Float Double Boolean Char
 * String
 * 枚举
 * 其他注解
 * 不可以为 空类型 JVM 不支持 null
 *
 * 如果某个注解被用于其他注解的参数 那么其名字不用@ 开始
 */
annotation class MyAnnotation2(val str: String, val annotion: MyAnnotation)



@MyAnnotation
class MyAnnitationClass {

    @MyAnnotation
    fun getAnnotation() {

    }

}

/**
 * 用于构造方法
 */
class MyAnnitationClass2 @MyAnnotation constructor(a: Int) {

}

annotation class MyAnnotation4(val arg1: KClass<*>, val arg2: KClass<out Any>)

@MyAnnotation4(String::class, Int::class)
class MyClass4 {}