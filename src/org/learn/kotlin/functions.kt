package org.learn.kotlin

fun doubleIt(x: Int): Int = x * 2

fun main(args: Array<String>) {
    val result = doubleIt(x = 2)
    println("$result")
    // Sample().foo() // Sample sınıfından bir instance üretilip foo methodunun çağrımı



    foo(1, 3, ::innerMethod)  // Uses the default value baz = 1
    foo { s, y -> println("hello") }// Uses both default values bar = 0 and baz = 1

    reformat(str = "a") //named argument

    variableArgs(numbers = *intArrayOf(1, 2, 3))  // variadic function example with spread operator
    variableArgs(1, 2, 3, 4, 5, 6) // variadic function example

    val numbers: List<Int> = asList(1, 2, 3, 4, 5, 6)
    numbers.forEach { println(it) }

    1 double 2


    println(lock(body = { x -> x * 2 }))
}

fun innerMethod(s: String, y: Int): Unit {
    println(s + y)
}


fun powerOf(number: Int, exponent: Int) {

}

interface k {

}


fun defaultArguments(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
}

fun foo(bar: Int = 0, baz: Int = 1, qux: (s: String, y: Int) -> Unit) {}

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {

}


fun variableArgs(vararg numbers: Int) {} //variadic function

fun printHello(name: String?): Unit { //unit returning function
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
}
// `return Unit` or `return` is optional


fun <T> asList(vararg numbers: T): List<T> {
    val result = ArrayList<T>()
    result += numbers
    return result
}


// define extension to Int
infix fun Int.double(x: Int): Int {
    return x * 2
}


// High order functions means takes functions as a parameter
fun <T> lock(body: (x: Int) -> T): T {
    return body(5)
}
