package org.learn.kotlin

abstract class Shape constructor(private val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

interface RectangleProperties {
    val isSquare: Boolean
}

inline fun <reified T : Any> members() = T::class.members

<<<<<<< HEAD
class Rectangle internal constructor(var height: Double, var length: Double)
=======
class Rectangle internal constructor(private var height: Double, private var length: Double)
>>>>>>>  This is the 1st commit message:
    : Shape(listOf(height, length)),
        RectangleProperties {

    override fun calculateArea(): Double = if (!isSquare) height * length else (-1).toDouble()

    override val isSquare: Boolean
        get() {
            if (length == height) {
                throw AssertionError("rectangle height and length must be different from each other.")
            }
            return length == height
        }

}


fun main(args: Array<String>) {
    val rectangle = Rectangle(5.0, 2.0)
    println("Area of rectangle is ${rectangle.calculateArea()}, " +
            "its perimeter is ${rectangle.perimeter}")

    members<Rectangle>()

}