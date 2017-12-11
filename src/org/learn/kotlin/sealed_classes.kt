package org.learn.kotlin

sealed class Expr {
    abstract fun sayHello(): String
}

data class Const(val number: Double) : Expr() {
    override fun sayHello(): String = "Hello From Const"
}

data class Sum(val e1: Expr, val e2: Expr) : Expr() {
    override fun sayHello(): String = "Hello From Sum"
}

object NotANumber : Expr() {
    override fun sayHello(): String = "Hello From Not a number"
}

fun main(args: Array<String>) {
    var const = Const(10.1)
    println(eval(const))
}

fun eval(expr: Expr): Any? = when (expr) {
    is Const -> expr.sayHello()
    is NotANumber -> Double.NaN
    else -> null
}

