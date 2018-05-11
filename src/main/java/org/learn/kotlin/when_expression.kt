package org.learn.kotlin

var x: Int = 100

fun main(args: Array<String>) {
    when (x) {
        100 -> println("x == 100")
        101 -> println("x == 101")
        else -> {
            println("neither 100 or 101")
        }
    }


    when (x) {
        100, 101 -> println("x is 100 or 101")
        else -> {
            println("neither 100 or 101")
        }
    }

    val y = 10

    when (y) {
        in 10 until 20 -> println("yes")
        else -> println("no")
    }


    x = 108

    val validNumbers = arrayOf(108, 109, 110)
    when (x) {
        in 100..105 -> {
            print("x is in the range")
        }
        in validNumbers -> print("x is valid")
        else -> print("none of the above")
    }

    var team = Team(10)
    isEvenOrOdd(team.isOdd())

    val increaseCount = team.increaseCount()
    println("Team count $increaseCount")
}


data class Team(val count: Int) {
    var teamCount = count

    fun isOdd(): Boolean = count % 2 == 0

    fun increaseCount(): Int = ++teamCount

}


fun hasPrefix(x: Any): Boolean = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}


fun isEvenOrOdd(x: Boolean) {
    when (x) {
        true -> print("Evet takım sayısı tekil")
    }
}