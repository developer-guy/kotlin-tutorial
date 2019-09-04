package org.learn.kotlin

import kotlin.reflect.KClass

/**
 * @author Batuhan Apaydın
 */


class Reflection constructor(val reflectionProp: Int)

class Reflection2

val qert = 1
var qert2 = 1

fun main(args: Array<String>) {
    //class referencess
    val c: KClass<*> = Reflection::class

    println("Class -->  $c")
    //////////////////


    //function references
    val predicate: (Int) -> Boolean = ::isOdd

    val numbers = listOf(1, 2, 3)

    numbers.filter(predicate)

    // numbers.filter(::isOdd)

    val isEmptyStringList: List<String>.() -> Boolean = List<String>::isEmpty

    val words = listOf("a", "ab", "abc", "abcd")

    val toto = "upperCase"

    val toUpperCaseFunc = toto::toBoolean

    println(words.filter(compose(::isOdd, ::length)).map(String::toUpperCase))
    //////////////////////

    //property references
    ::qert2.set(10)
    println(::qert.get())
    println(::qert.name)

    println(Reflection::reflectionProp)
    /////////////////////


    //constructor references

    fun function(smd: () -> Reflection2) {
        val reflection = smd()
    }


    function(::Reflection2)

}

fun isOdd(i: Int) = i % 2 != 0

fun length(s: String): Int = s.length

fun <A, B, C> compose(f: (C) -> A, g: (B) -> C): (B) -> A {
    return { element -> f(g(element)) }
}