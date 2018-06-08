package org.learn.kotlin

/* To access this from an outer scope (a class, or extension function, or labeled function literal with receiver)
 we write this@label where @label is a label on the scope this is meant to be from:
  */

class V { //implicit label @V
    private val classVName: String? = V::class.simpleName

    inner class Q { //implicit label @Q
        private val classQName: String? = Q::class.simpleName
        fun Int.intval() { //implicit label @foo
            val a = this@V.classVName
            val b = this@Q.classQName

            println(a)
            println(b)


            val c = this@intval

            println("What is my type : ${c.javaClass.typeName}")
        }
    }
}