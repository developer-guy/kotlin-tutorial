package org.learn.kotlin

interface Nameable {
    var name: String
}

class JackName : Nameable {
    override var name = "Jack"
}


class LongDistanceRunner : Runnable {
    override fun run() {
        println("long")
    }
}

class PersonX(nameable: Nameable, runnable: Runnable) : Nameable by nameable, Runnable by runnable

interface Driver {
    val age: Int
    val name: String
    fun isLicenceValid(): Boolean = this.age >= 19
}

class Driver1 : Driver {
    override val age: Int
        get() = 20

    override val name: String
        get() = "Sam"
}

class Driver2 : Driver {
    override val age: Int
        get() = 12

    override val name: String
        get() = "Fox"
}

class ProxyDriver(d: Driver) : Driver by d


fun main(args: Array<String>) {
    val driver1 = Driver1()
    val driver2 = Driver2()
    printInformationAboutDriver(driver1, driver2)

    val personX = PersonX(JackName(),LongDistanceRunner())
    println(personX.name)
    println(personX.run())
}


fun printInformationAboutDriver(vararg drivers: Driver) {
    for (driver in drivers) {
        println("Is ${driver.name} driver licence valid : ${ProxyDriver(driver).isLicenceValid()}")
    }
}
