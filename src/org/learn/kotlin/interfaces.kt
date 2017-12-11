package org.learn.kotlin

interface MyInterface {
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
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}