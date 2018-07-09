package org.learn.kotlin

//operator overloading :: http://kotlinlang.org/docs/reference/operator-overloading.html
data class Point(var x: Int, var y: Int) {
    var listOfPoints: MutableList<Point> = mutableListOf()

    constructor() : this(0, 0) { // delegation to primary constructor using "this" keyword.
        println("Secondary constructor initialized..")
    }
}

operator fun Point.get(index: Int): Point {
    println("Get called...")
    return this.listOfPoints.get(index)
}

operator fun Point.unaryMinus() = Point(-x, -y)

operator fun Point.set(index: Int, p: Point) {
    println("Set calledd....")
    this.listOfPoints.add(index, p)
}

fun main(args: Array<String>) {
    val point = Point(10, 20)

    println(-point)

    val point2 = Point()
    point2[0] = Point(5, 10)


    println(point2[0])
}