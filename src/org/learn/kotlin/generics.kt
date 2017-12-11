package org.learn.kotlin

import java.time.LocalDateTime

class Box<T> constructor(t: T) {
    var value = t
}


fun main(args: Array<String>) {
    var box: Box<Int> = Box(1)
    println("Box value ${box.value}")

    val box2 = Box("1")
    println("Box value ${box2.value}")

    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val copyNumbers: Array<in Int> = copy(numbers)
    println("3.index number in copy numbers: ${copyNumbers[3]}")

    copy2(copyNumbers)
}

fun copy2(arr: Array<in Int>) { // in Int means -->  ? super Int

}

fun copy(from: Array<out Any>): Array<in Int> { // out Any means -- >
    var to: Array<Number> = Array(from.size, { it })
    println("Copy started: ${LocalDateTime.now()}")
    for ((i, v) in from.withIndex()) {
        to[i] = v as Int
    }
    println("Copy finished: ${LocalDateTime.now()}")
    return to


    1.convertToString()
    "a".convertToString()
    1.0.convertToString()

    singletonList(1)
    singletonList("a")
    singletonList(1.0)

    sort(listOf(1, 2, 3))
    //sort(listOf<HashMap<String, Object>>())
}


fun <T> singletonList(t: T): List<T> {
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

