package org.learn.kotlin


//operator overloading :: http://kotlinlang.org/docs/reference/operator-overloading.html
data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)


fun main(args: Array<String>) {
    val point = Point(10, 20)
    println(-point)
}