package org.learn.kotlin

fun main(args: Array<String>) {
    val numbers = mutableListOf(1, 2, 3)
    numbers.add(numbers.size, 6) //same as below
    numbers += 10  //adding element to list
    println(numbers)
    numbers.clear()
    println(numbers)

    //only has read operations.
    val listOf = listOf(1, 2, 3, 4, 5)

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
}


fun <T> MutableList<T>.filterNulls(): MutableList<T> {
    val willRemoveElements = mutableListOf<T>()
    for (element in this) {
        if (element == null) {
            val ind = willRemoveElements.size
            willRemoveElements.add(ind, element)
        }
    }

    this.removeAll(willRemoveElements)

    return this
}