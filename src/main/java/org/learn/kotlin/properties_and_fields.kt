package org.learn.kotlin

class Address {
    var size = 0
    var name: String = ""
        set(value) {
            if (value.length >= 5) field = value
        }
    var state: String? = ""
        get() = field.toString()
        set(x) {
            if (this.size >= 0) field = x
        }
    var zip: String = ""

    val isEmpty: Boolean
        get() = this.size <= 0

    // val olarak tanımlanan değişkenin setter methodu olamaz
    // val isEmpty get() = this.size <= 0 olarak tip belirtilmeden tanımlanabilir.
    // var x : String

    fun copyAddress(address: Address): Address {
        val result = Address()
        result.name = address.name
        result.state = address.state
        result.zip = address.zip
        result.size = address.size
        return result
    }
}


fun main(args: Array<String>) {
    var address = Address()
    address.name = "Resi"
    address.zip = "34325"
    address.state = null
    address.size = 0
    var copyAddress = address.copyAddress(address)

    println("Copy address name ${copyAddress.name} and isEmpty : ${copyAddress.isEmpty}")
}