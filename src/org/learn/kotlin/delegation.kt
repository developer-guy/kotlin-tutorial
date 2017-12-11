package org.learn.kotlin

interface IBase {
    fun print()
}


class BaseImpl(val x: Int) : IBase {
    override fun print() {
        println(x)
    }
}

class DerivedClass(proxyIBase: IBase) : IBase by proxyIBase


interface Driver {
    val age: Int
    fun isLicenceValid(): Boolean = age >= 18
}

class Sam : Driver {
    override val age: Int
        get() = 20
}

class ProxyDriver(driver: Driver) : Driver by driver


fun main(args: Array<String>) {
    val b = BaseImpl(10)

    DerivedClass(b).print()

    val sam = Sam()
    println("Is valid : ${ProxyDriver(sam).isLicenceValid()}")
}
