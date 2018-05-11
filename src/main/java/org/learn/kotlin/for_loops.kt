package org.learn.kotlin

/* for(item in collection) print(item) */

fun main(args: Array<String>) {
    val ints = arrayOf(1, 2, 3, 4, 5)

    //First way to iterate on array
    val lenghOfArray = ints.size

    for (i in 0 until lenghOfArray) {
        println("Index $i value at index ${ints[i]}")
    }

    //Second way to iterate on array
    /** the old way of iterating on array*/
    for (index in ints.indices) {
        println(ints[index])
    }

    //Third way to iterate on array
    for ((index, value) in ints.withIndex()) {
        println("$index.element's value : $value")
    }
}