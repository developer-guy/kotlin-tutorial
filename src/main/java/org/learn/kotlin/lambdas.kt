package org.learn.kotlin

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock


fun main(args: Array<String>) {

    fun toBeSync() = 5

    lock(lock = ReentrantLock(), body = ::toBeSync)

    //more convenient way to pass lambda expression
    lock(lock = ReentrantLock(), body = { toBeSync() })   // yerlerini sırasına uygun vermedik çünkü named argument kullandık sırası farklı olabilir.

    lock({ "Hello Message" }, lock = ReentrantLock())

    /*  In Kotlin, there is a convention that if the last parameter of a
      function accepts a function, a lambda expression that is passed as the corresponding argument can be placed outside the parentheses:

      val product = items.fold(1) { acc, e -> acc * e }

      */

    val ints = listOf(1, 2, 3, 4, 5)

    val doubledInts: List<Double> = ints.map { i -> i.toDouble() }

    //only available if that function takes one argument ,
    // implicit name of a single parameter
    val map2: List<Double> = ints.map { it.toDouble() }

    val namesAndAges = mapOf("asena" to 19, "batuhan" to 23)

    // we can use underscore(_) for unused lambda parameters.
    namesAndAges.forEach({ _, v -> println(v) })

    val names = listOf("Batuhan", "Asena", "Mehmet", "Ayşe")

    val filter = fun(s: String): Boolean {  //anonymous function example
        return s.length >= 5
    }

    names.filter(filter)

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
    val sum2: Int.(Int) -> Int = fun Int.(other: Int): Int = this + other

    val sum5: Int.(Int) -> Int = sum5@{ valid: Int ->
        return@sum5 this + valid

    }

    println(1.sum5(10))

    println(1.sum2(5))

    println(1 sum3 5)

//    val represent: String.(Int) -> Boolean = { other -> this.toIntOrNull() == other }

    val rePresent: Int.(String) -> Boolean = fun Int.(s: String): Boolean {
        return s.toInt() == this
    }

//    println(15.rePresent("15"))
//    println("123".represent(123))

    val htmlResult = html {
        this.body()   // lambda with receiver begins here
        // calling a method on the receiver object
        return@html this.head() //'this' can be omit

        /* We can explicitly return a value from the lambda using the qualified return syntax.
             Otherwise, the value of the last expression is implicitly returned.

            return@filter shouldFilter
       */
    }

    println("Result of html function: $htmlResult")

    val operationResult = operation(5, 6) { e1, e2 ->
        return@operation this + e1 + e2
    }

    println("Result of operation function $operationResult")
}


fun operation(firstOperand: Int, secondOperand: Int, operate: Int.(Int, Int) -> Int): Int {
    val result = 0
    return result.operate(firstOperand, secondOperand)
}

infix fun Int.sum3(other: Int): Int = this + other


// High order functions means take a function as parameter or return function.
fun <T> lock(body: () -> T, lock: Lock?): T {
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

    fun head(): String {
        return "I am receiver's method to"
    }
}


fun html(init: HTML.() -> String): String {
    val html = HTML()
    return html.init()
}