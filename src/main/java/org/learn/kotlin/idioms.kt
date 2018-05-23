package org.learn.kotlin

import java.io.File as javaioFile

/* data : provides a functionally to class for example equals,hashCode,copy,toString,componentN functions for all properties etc. */
data class Customer constructor(val name: String, val email: String)


class RelationShip constructor(val name: String, val timeToSpend: Int) {
    fun makePeace() {
        println("Making peace")
    }

    fun beOffended() {
        println("Making offended")
    }
}

fun main(args: Array<String>) {
    val name = "Batuhan"
    val customer = Customer(name, "bapaydin67@gmail.com")
    printCustomerInformation(customer.email)

    var numbers = listOf(1, 2, 3, 4, 5)
    val filteredNumbers = numbers.filter { it >= 3 }
    // 'it' value is the shorter of element.
    // you can use filter like this
    // x -> x >= 3

    for (number in filteredNumbers) {
        println("Value : $number")
    }

    val s: Any = true

    val result = when (s) {
        is String -> "Evet bu bir string"
        is Long -> "Evet bu bir long"
        else -> "Bilmiyoz"
    }

    println("Doktor bu ne ? : $result")


    //for (i in 1..100){} // 100 geçerli
    //for(i in 1 until 100) // 100 geçerli değil
    //for (x in 2..100 step 3) // 3 er 3 er artarak
    //for(y in 100 downTo 5 step 10) 100 den 5 e kadar 10 ar 10 ar azalarak

    //if ( x in 1..10) x 1 ile 10 arasında mı ?


    // val p : String  by lazy {}

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    val i = map["a"]
    println("Key a value is : $i")

    name.spaceToCamelCase()


    val listFiles = javaioFile("Test").listFiles()
    println(listFiles?.size ?: "empty")

    val transform = transform("Red")
    println(transform)


    /* if expression */
    val param = 10

    val ifExpResp = if (param == 10) {
        "ten"
    } else if (param == 2) {
        "two"
    } else {
        "three"
    }

    val result2 = theAnswer()


    arrayOf(1, 2, 3, 4, 5)
    val asc: Array<String> = Array(5, { item -> (item * item).toString() })

    val x: IntArray = intArrayOf(1, 2, 3)


    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin(">")


    println(Resource.name)

    println(text)

    println(name.lastCharacter)


    val count = try {
        count(name)
    } catch (e: Exception) {
        throw IllegalStateException(e)
    }

    println("$name length is $count")


    val relationShip = RelationShip("asena&batuhan", 3)

    with(relationShip) {
        beOffended()
        makePeace()
    }

}

fun count(str: String?): Int {
    if (str == null) throw NullPointerException()

    return str.length
}

/* default values for function parameters*/
fun printCustomerInformation(email: String = "xx", name: String = "Asena") {
    println("The name is $name and the email is $email")
}


/* extension functions  */
fun String.spaceToCamelCase() {
    println(this + ":: spaceToCamelCase called")
}


val String.lastCharacter: Char
    get() {
        return this[this.length - 1]
    }

// the second way
// val String.lastCharacter: Char get() = this[this.length -1]

/* creating singleton */
object Resource {
    val name = "Name"
}

/* return on when statement*/
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        else -> throw IllegalArgumentException("Invalid color")
    }
}


fun theAnswer() = 42





