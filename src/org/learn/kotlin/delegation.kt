package org.learn.kotlin

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

class ProxyDriver(driver: Driver) : Driver by driver


fun main(args: Array<String>) {
    val driver1 = Driver1()
    val driver2 = Driver2()
    printInformationAboutDriver(driver1, driver2)

}


fun printInformationAboutDriver(vararg drivers: Driver) {
    for (driver in drivers) {
        println("Is ${driver.name} driver licence valid : ${ProxyDriver(driver).isLicenceValid()}")
    }
}
