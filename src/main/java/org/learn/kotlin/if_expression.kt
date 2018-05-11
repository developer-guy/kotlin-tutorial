package org.learn.kotlin


fun main(args: Array<String>) {
    val a = 5
    val b = 10
    var tazx = a
    if (a < b) tazx = b


    var max1: Int
    if (a > b) {
        max1 = a
    } else {
        max1 = b
    }


    val max2 = if (a > b) a else b

    val max3 = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }


    val isOverSpeed = isOverSpeed(100)
    println("Speed $isOverSpeed")
}

fun isOverSpeed(speed: Int) = if (speed > 100) "Evet" else "Hayır"