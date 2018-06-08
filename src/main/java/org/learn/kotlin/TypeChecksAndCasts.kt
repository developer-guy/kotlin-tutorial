package org.learn.kotlin

//We can check whether an object conforms to a given type at runtime
// by using the "is" operator or its negated form "!is".
fun main(args: Array<String>) {
    val obj: Any = "Batuhan"

    if (obj is String) { //same as instanceof in java.
        print(obj.length)
    }

    if (obj !is String) {
        print("Not String")
    }

    //unsafe cast operator
    val y: String = obj as String //when obj is null this code throws an exception.
    // but we can use safe nullable cast operator

    val t: String? = obj as? String // safe nullable cast operator
}

//In many cases, one does not need to use explicit cast operators in Kotlin,
// because the compiler tracks the "is-checks"
// and explicit casts for immutable values and inserts (safe) casts automatically when needed:
fun demo(x: Any) {
    if (x is String) {
        print(x.length) //x is automatically cast to String
    }
//Such smart casts work for when-expressions and while-loops as well:
    when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    }
}