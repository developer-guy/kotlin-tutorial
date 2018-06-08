package org.learn.kotlin

import java.util.*

private fun <T> MutableList<T>.swap(index1: Int, index2: Int): MutableList<T> {
    val tmp = this[index1] // veya get(index1) //burada this kelimesi mutablelist'e tekabül eder.
    this[index1] = this[index2]
    this[index2] = tmp
    return this
}

val <T> MutableList<T>?.lastIndex: Int get() = this!!.size - 1

val <T> MutableList<T>.lastElement: T get() = this[this.lastIndex]

//Nullable Receiver
fun Any?.toString(): String = if (Objects.isNull(this)) "null" else toString()

fun main(args: Array<String>) {

    var mutableList: MutableList<Int> = mutableListOf(1, 2, 3)

    mutableList = mutableList.filterNulls()

    val lastIndex = mutableList.lastIndex

    val lastElement = mutableList.lastElement

    println("lastElement in list: $lastElement")

    println("Last index $lastIndex ")

    println("BEFORE SWAP ")

    for ((i, v) in mutableList.withIndex()) {
        println("Index: $i --- Value:$v")
    }

    val swap = mutableList.swap(1, 2)

    println("AFTER SWAP ")

    for ((i, v) in swap.withIndex()) {
        println("Index: $i --- Value:$v")
    }

    X().foo(1)

    Myclass.xxxx()

    Z().caller(D())

    val number: Any? = null

    var isNull = number.toString()

    println("Is null $isNull")
}


class X {
    fun foo() {
        println("I am a member")
    }
}

fun X.foo(i: Int) {
    println("I am an extension function with $i")
}

interface IMyClass {
    fun xxxx(): Unit
}

class Myclass {
    companion object : IMyClass { //like static methods
        override fun xxxx() {
            println("Companion")
        }
    }
}


class D {
    fun bar() {

    }

    override fun toString(): String {
        return "Hello I am D"
    }
}

class Z {


    fun baz() {

    }

    fun D.foo() {
        println(this.toString()) // D'nin toString() çağırır
        println(this@Z.toString()) //Z'nin toString() çağırır
        bar()
        baz()
    }

    fun caller(d: D) {
        d.foo()
    }

    override fun toString(): String {
        return "Hello ı am Z"
    }

}