package org.learn.kotlin

/** Defining Functions with inferred return type and expression body*/
fun sum(a: Int, b: Int) = a + b

// same as above
/*fun sum(a: Int,b : Int): Int {
    return a+b
}*/

/** Function with an expression body and inferred return type*/
fun subtraction(a: Int?, b: Int?): Int? =
        if (a == null || b == null) null
        else a - b

/** Function returning no meaningful value
 *  "Unit" return type can be omitted.
 * */
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}


/* Using conditional expression */
fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? = str.toIntOrNull()


fun printProduct(arg1: String, arg2: String) {
    val x: Int? = parseInt(arg1)
    val y: Int? = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either $arg1 or $arg2 is not a number")
    }

}


fun getStringLength(obj: Any?): Int? {
    return obj?.let {
        // execute this block if not null
        return if (it is String) { // type  kontrolü
            (it as String).length
            // burada as operatorü ile cast işlemi yapmamıza gerek yok çünkü yukarıda is kontrolü
            // ile type kontrolü yaptığımız için kotlin compile
            // time da bu blok içerisinde değişkenin bir string olarak davranması gerektiğinih anlıyor.
        } else
            null
    }
}


infix fun Int.existsInBetween(range: IntRange): Boolean {
    var index = -1
    for ((i, v) in range.iterator().withIndex()) {
        if (this == v) {
            index = i
        }
    }
    return index != -1
}

/*

inline fun <reified T: Any> runApplication(vararg args: String,instance : T.() -> Unit){
    val kClass = T::class
    SpringApplicatipon.run(kClass,args)
    return T
}
*/



fun main(args: Array<String>) {

//    runApplication<BlogApplication>(*args)

    val arg1 = 5 //means constant
    val arg2 = 6
    val additionResult: Int = sum(arg1, arg2)
    val substractionResult: Int? = subtraction(arg2, arg1)

    println("Sum of values $arg1 and $arg2 is $additionResult")
    println("Substraction of values $arg2 and $arg1 is ${substractionResult ?: "sadasda"}")
    printSum(5, 6)

    // "expression ?: value" --> means if expression is null return value,but
    // if expression is not null return expression.

    var a: Any = 1 //immediate assignment -- Any is super-type of every type.
    val b = 2 //Int type is inferred
    val c: Int // Type required when no initializer is provided
    c = 3

    val s1 = "a is $a"

    a = 2

    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s2)

    println("max of 0 and 42 is ${maxOf(0, 42)}")


    printProduct("6", "7")
    printProduct("a", "7")


    //define function as a variable.
    val printLength = fun(obj: Any): Unit {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, is empty or not a string at all"} ")
    }

    //   ?: --> elvis operator
    //   ? --> nullable operator
    //   !! --> not null assertion operator, converts any value to a non-null type and throws an exception.
    // lambda expression
    val printLength2 = { obj: Any ->
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, is empty or not a string at all"} ")
    }

    printLength("Incomprehensibilities")
    printLength2(1000)


    val fruits: List<String> = listOf("apple", "banane", "kiwi")

    for (index in fruits.indices) {
        println("item at $index is ${fruits[index]}")
    }

    var index = 0

    while (index < fruits.size) {
        println("item at $index is ${fruits[index]}")
        index++
    }

    println(describe(1))

    val x = 10
    val y = 9

    if (x in 1..y + 1) println("fits in range")

    if (-1 !in 0..fruits.lastIndex) {
        println("-1 is out of range")
    }

    (1..10 step 2).withIndex().forEach { (i, x) ->
        // 2 şer artarak yazar.
        println("$i. eleman $x 'tir.")
    }


    val intProgression = 10 downTo 0 step 3

    for (p in intProgression) {
        println(p)
    }

    when {
        "orange" in fruits -> println("Juicy")
        "apple" in fruits -> println("apple is fine too")
    }

    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it.length }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    println(3.existsInBetween(1..4))
}


fun describe(obj: Any): String =
        when (obj) {
            1 -> "One" //obj = 1
            "Hello" -> "Greeting" //obj = "Hello"
            is Long -> "Long"  // obj is instance of Long
            !is String -> "Not a string" //obj is not instance of String
            else -> "Unkwon"
        }