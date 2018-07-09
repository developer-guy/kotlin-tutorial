package org.learn.kotlin

import java.util.logging.Logger

//kotlindeki tüm sınıfların süper sınıfı "Any"'dir.
val logger: Logger = Logger.getLogger("Person")

open class Human constructor(val name: String) {
    open val sex: Int
        get() = 1
    // "open" keywordü sınıfın diğer sınıflar tarafından
    // inherit edilmesine izin vermek için kullanılır.
    // defaultta tüm kotlin sınıfları "final" olarak tanımlıdır ve inherit edilemez durumdadır.

    open fun v() {}
    fun nv() {}

}

open class Person constructor(name: String) : Human(name) {
    /*    The primary constructor cannot contain any code.
        Initialization code can be placed in initializer blocks, which are prefixed with the "init" keyword.*/
    init {
        logger.info("Super class field name is : ${super.name}")
        logger.info("Person initialized with name $name")
    }

    constructor(name: String, i: Int) : this(name) {
    }

    constructor(name: String, d: Double) : this(name) {
    }


    override val sex: Int
        get() = 5

    override fun v() {
        logger.info("I am v")
    }
}


class AnotherPerson(name: String) : Person(name) {
    override val sex: Int get() = 10
    override fun v() {
        super.v()   // alt sınıftan üst sınıfın methodun çağrım örneği
        println("Insıde another person")
    }

    inner class Priority {
        fun g() {
            super@AnotherPerson.v() // inner sınıfın outer sınıfın methodunun çağrım örneği
            println(super@AnotherPerson.sex)
        }
    }
}


open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {  //interfaceler ve elemanları default olarak "open" ile tanımlıdır.
    fun f() {
        print("B")
    }

    fun b() {
        print("b")
    }
}


class C : A(), B {
    // C'nin inherit ettiği A sınıfı ve B arayüzü f() methoduna sahip dolayısıyla
    // C bu methodu override etmeli ve bu üst sınıf , arayüzü "super<X>."
    // şeklinde elemanlarına ulaşıyoruz.
    override fun f() {
        super<A>.f() //super ve generic olarak üst sınıflar çağrılabilir
        super<B>.f()
    }
}

abstract class Derived { // open olarak tanımlı.
    abstract fun f(): String //open olarak tanımlı.
}

class Base : Derived() {
    override fun f(): String = "In Base"
}

fun main(args: Array<String>) {
    val person = AnotherPerson("Batuhan")
    person.v()
    println("Person sex ${person.sex}")


    val base = Base()
    println(base.f())
}