package org.learn.kotlin

import java.time.LocalDateTime

class Box<T> constructor(t: T) {
    val value = t
}


fun main(args: Array<String>) {


    var box: Box<Int> = Box(1)
    println("Box value ${box.value}")

    val box2: Box<String> = Box("1")
    println("Box value ${box2.value}")

    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)

    val copyNumbers: Array<Number> = copy(numbers)
    println("3.index number in copy numbers: ${copyNumbers[3]}")

    copy2(copyNumbers)


    1.convertToString()
    "a".convertToString()
    1.0.convertToString()

    singletonList(1.0, 1, "a")

    sort(listOf(1, 2, 3))

}

fun copy2(arr: Array<in Int>) { // in Int means -->  ? super Int

}

fun copy(from: Array<out Any>): Array<Number> { // out Any means --> ? extends Any
    var to: Array<Number> = Array(from.size, { i: Int -> i })
    println("Copy started: ${LocalDateTime.now()}")
    for ((index, value) in from.withIndex()) {
        to[index] = value as Int // type casting
    }
    println("Copy finished: ${LocalDateTime.now()}")


    return to

    //sort(listOf<HashMap<String, Object>>())
}


fun <T> singletonList(vararg t: T): List<Array<out T>> {
    return listOf(t)
}

fun <T> T.convertToString(): String = this.toString()


fun <T : Comparable<T>> sort(list: List<T>) {

}

/*
fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
        where T : Comparable<T>,
              T : Cloneable {
    return list.filter { it > threshold }.map { it.clone() }
}
*/

