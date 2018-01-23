package org.learn.kotlin

interface MyInterface { //içerisindeki function veya fieldlar default olarak open tanımlı.
    val prop: Int //abstract

    val propertyWithImpl: String
        get() = "foo"

    fun bar()
    fun foo() {
        print(prop)
    }
}


class Child : MyInterface {
    override val prop: Int
        get() = "123".toInt()

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun main(args: Array<String>) {
    val child = Child()
    child.foo()
}