package org.learn.kotlin

import kotlin.properties.Delegates
import kotlin.reflect.KProperty


/*
*
* - lazy properties: the value gets computed only upon first access.
* - observable properties: listeners get notified about changes to this property.
* - storing properties in a map, instead of a separate field for each property.
*
* */


// custom delegation
class Example {
    var p: String by Delegate("10")
}

class Delegate constructor(private val default: Any) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("$thisRef, thank you for delegating '${property.name}' to me!")
        return default as String
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}


// delegation için "by" keywordü kullanılıyor.
// constructor keywordü opsiyonel yani yazmasak da olur.
class UserByMap internal constructor(lazyMap: Map<String, Any?>) {
    val gender: String  by lazy(mode = LazyThreadSafetyMode.NONE, initializer = { "male" })
    val name: String by lazyMap  // val keywordü için Map kullanılırken var olsaydı Mutablemap demeliydik.
    val age: Int     by lazyMap
}


fun main(args: Array<String>) {
    val ex = Example()
    println(ex.p)
    ex.p = "NEW"

    val lazyVal: String by lazy(mode = LazyThreadSafetyMode.NONE, initializer = { "Init" })

    val delegetaesObservable =
            { _: KProperty<*>, oldValue: String, newValue: String -> println("$oldValue -> $newValue") }


    var observableVal: String by Delegates.observable("<no-name>",
            onChange = delegetaesObservable)

    observableVal = "10"
    observableVal = "20"

    var user = UserByMap(mapOf(
            "name" to "John Doe",
            "age" to 20
    ))

    println(user.name) // Prints "John Doe"
    println(user.age)
    println(user.gender)

}





