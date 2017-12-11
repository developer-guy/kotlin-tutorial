package org.learn.kotlin

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class Userc(userProp: Map<String, Any?>) {
    val gender: String  by lazy(mode = LazyThreadSafetyMode.NONE, initializer = { "male" })
    val name: String by userProp  // val keywordü için Map kullanılırken var olsaydı Mutablemap demeliydik.
    val age: Int     by userProp
}


fun main(args: Array<String>) {
    val ex = Example()
    println(ex.p)
    ex.p = "NEW"

    val lazyVal: String by lazy(LazyThreadSafetyMode.NONE, { "Init" })

    var observableVal: String by Delegates.observable("<no-name>") { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }

    observableVal = "10"
    observableVal = "20"

    var user = Userc(mapOf(
            "name" to "John Doe",
            "age" to 20
    ))

    println(user.name) // Prints "John Doe"
    println(user.age)
    println(user.gender)

}

