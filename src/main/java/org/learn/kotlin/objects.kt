package org.learn.kotlin

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

// syntax

/* val x = object {
    var a: String = "a"
    var b: String  = "b"
}
*/

open class ClassOne(x: Int) {
    open val y: Int = x
}

interface InterfaceOne

interface Factory<T> {
    fun create(): T
}


//companion objects
internal class MyClass2 private constructor() {
    val myClassSingleRefId = Math.random()

    companion object : Factory<MyClass2> {     // isim verildi sonra kaldırıldı. // eğer factory ismi verilmesiydi MyClass2.Companion diye çağrım yapılacaktı.
        override fun create(): MyClass2 = MyClass2()  //MyClass2.Companion.create()
    }
}

fun main(args: Array<String>) {

    val jsonObject = object {
        var node1: String = "123"
        var node2: Int = 19
    }

    println(jsonObject.node1.toInt() + jsonObject.node2)

    val abObject: ClassOne = object : ClassOne(1), InterfaceOne {
        override val y: Int
            get() = 12
    }

    println(abObject.y)

    //object classes properties can call this way (like static)
    println("${SampleObject.foo()} and the lenght of retun ${SampleObject.lenghtOfFooReturn}")

    val myClassInstance = MyClass2.create()
    println(myClassInstance.myClassSingleRefId)

    val myClassInstance2 = MyClass2.create()
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


