package org.learn.kotlin

interface Parent { //içerisindeki function veya fieldlar default olarak open tanımlı.
    val prop: Int //abstract - needs to be implement

    fun bar() // needs to be implement

    val propertyWithImpl: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}


class Child : Parent {
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