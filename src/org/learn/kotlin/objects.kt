package org.learn.kotlin

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

// syntax

/* val x = object {
    a: String = "a"
    b: String  = "b"
}
*/

open class ClassOne(x: Int) {
    open val y: Int = x
}

interface InterfaceOne {

}

interface Factory<T> {
    fun create(): T
}


//companion objects
internal class MyClass private constructor() {
    val myClassSingleRefId = 12312312421L

    companion object FactoryObject : Factory<MyClass> {     // isim verildi sonra kaldırıldı. eğer factory ismi verilmesiydi MyClass.Companion diye çağrım yapılacaktı.
        override fun create(): MyClass = MyClass()  //MyClass.Companion.create()
    }
}

fun main(args: Array<String>) {

    var jsonObject = object {
        var node1: String = "123"
        var node2: Int = 19
    }

    println(jsonObject.node1.toInt() + jsonObject.node2)

    val ab: ClassOne = object : ClassOne(1), InterfaceOne {
        override val y: Int
            get() = 12
    }

    println(ab.y)

    //object classes properties can call this way (like static)
    println("${SampleObject.foo()} and the lenght of retun ${SampleObject.lenghtOfFooReturn}")

    val myClassInstance = MyClass.create()
    println(myClassInstance.myClassSingleRefId)

    val myClassInstance2 = MyClass.create()
    println(myClassInstance2.myClassSingleRefId)

}

fun foo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }

    print(adHoc.x + adHoc.y)
}

fun countClicks(window: JComponent) {
    window.addMouseListener(MouseAdapterListener)
}


//objects can't have constructors but have super classes
object MouseAdapterListener : MouseAdapter() {
    var clickCount = 0
    var enterCount = 0
    override fun mouseClicked(e: MouseEvent) {
        clickCount++
    }

    override fun mouseEntered(e: MouseEvent) {
        enterCount++
    }
}

object SampleObject {
    fun foo(): String {
        return "abc"
    }

    val lenghtOfFooReturn: Int
        get() {
            return foo().length
        }
}


