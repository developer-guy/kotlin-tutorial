package org.learn.kotlin

abstract class Shape constructor(val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

interface RectangleProperties {
    val isSquare: Boolean
}

class Rectangle constructor(var height: Double, var length: Double) :
        Shape(listOf(height, length)), RectangleProperties {
    override fun calculateArea(): Double = height * length

    override val isSquare: Boolean get() = length == height

}

fun main(args: Array<String>) {
    val rectangle = Rectangle(5.0, 2.0)
    println("Area of rectangle is ${rectangle.calculateArea()}, " +
            "its perimeter is ${rectangle.perimeter}")

}