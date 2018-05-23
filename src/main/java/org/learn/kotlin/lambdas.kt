package org.learn.kotlin

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock


fun main(args: Array<String>) {

    fun toBeSync() = 5

    lock(lock = ReentrantLock(), body = ::toBeSync)

    //more convenient way to pass lambda expression
    lock(lock = ReentrantLock(), body = { toBeSync() })

    lock(lock = ReentrantLock()) {
        toBeSync()
    }

    val ints = listOf(1, 2, 3, 4, 5)

    val map: List<Double> = ints.map { i -> i.toDouble() }

    //only avaliable if that function takes one argument ,
    // implicit name of a single parameter
    val map2: List<Double> = ints.map { it.toDouble() }

    val namesAndAges = mapOf("asena" to 19, "batuhan" to 23)

    // we can use underscore(_) for unused lambda parameters.
    namesAndAges.forEach({ _, v -> println(v) })

    val names = listOf("Batuhan", "Asena", "Mehmet", "Ayşe")


    val filterFun = fun(s: String): Boolean {  //anonymous function example
        return s.length >= 5
    }

    names.filter(filterFun)

    val upperCaseAndLengthGreaterThanFiveNames = names
            .filter { it.length >= 5 }
            .sortedBy { it }
            .map { it.toUpperCase() }

    println(upperCaseAndLengthGreaterThanFiveNames)

    // A lambda expression is always surrounded by curly braces,
    val sum = { x: Int, y: Int -> x + y } //Lambda expression syntax

    val sum4 = fun(x: Int, y: Int): Int { // the same as above
        return x + y
    }

    // Function Literals with Receiver
    // { other -> this + other } şeklinde de tanımlanabilirdi.
    val sum2: Int.(Int) -> Int = fun Int.(other: Int) = this + other

    val represent: String.(Int) -> Boolean = { other -> this.toIntOrNull() == other }

    println(1.sum2(1))

    println(1 sum3 5)


    val rePresent: Int.(String) -> Boolean = fun Int.(s: String): Boolean {
        return s.toInt() == this
    }

    fun execute(s: String, intFunc: Int.(s: String) -> Boolean, i: Int) {
        i.intFunc(s)
    }

    execute("123", rePresent, 123)


    println("123".represent(123))

    html {
        body()   // lambda with receiver begins here
        // calling a method on the receiver object
    }
}

infix fun Int.sum3(other: Int): Int = this + other


// High order functions means take a function as parameter or return function.
fun <T> lock(lock: Lock?, body: () -> T): T {
    lock!!.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

fun <T, R> List<T>.map(transform: (T) -> R): List<R> {
    val result = arrayListOf<R>()

    for (item in this)
        result.add(transform(item))

    return result
}


class HTML {
    fun body(): String {
        return "I am receiver's method"
    }
}


fun html(init: HTML.() -> String): HTML {
    val html = HTML()
    println(html.init())
    return html
}