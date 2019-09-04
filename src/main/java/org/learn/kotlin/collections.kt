package org.learn.kotlin

fun main(args: Array<String>) {
    val numbers = mutableListOf(1, 2, 3)
    numbers.add(numbers.size, 6) //same as below
    numbers += 10  //adding element to list
    println(numbers)
    numbers.clear()
    println(numbers)

    //only has read operations.

    var listOf = listOf(1, 2, 3, 4, 5)

    println(listOf.none { it > 7 })

    val elements = hashSetOf(1, 2, 3)

    assert(value = elements.size == 3)

    val mutableListOfContainsNullArguments = mutableListOf(1, 2, "a", 1.2)

    mutableListOfContainsNullArguments.requireNoNulls()

    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)

    println(readWriteMap["foo"])  // prints "1"

    val snapshot: Map<String, Int> = HashMap(readWriteMap)

    println(snapshot)

    val mutableListWithNull = mutableListOf(1, null, 2, null)

    val mutableListWithOutNull = mutableListWithNull.filterNulls()

    mutableListWithOutNull.forEach { println(it) }

    val sampleList = mutableListOf(1, 2, 3, 4, 5, 6, 7)

    sampleList.filter { it > 5 }.forEach(::println)

}

fun <T> MutableList<T>.filter(predicate: (t: T) -> Boolean): MutableList<T> {
    val blackList = mutableListOf<T>()

    for (item in this) {
        if (!predicate(item)) {
            println("Item $item adding to blacklist.")
            blackList.add(item)
        }
    }

    println("Blacklist contains : $blackList .")

    this.removeAll(blackList)

    return this
}


fun <T> MutableList<T>.filterNulls(): MutableList<T> {
    this.removeIf {
        it == null
    }
    return this
}