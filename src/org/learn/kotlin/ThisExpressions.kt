package org.learn.kotlin

/* To access this from an outer scope (a class, or extension function, or labeled function literal with receiver)
 we write this@label where @label is a label on the scope this is meant to be from:
  */

class V { //implicit label @V
    inner class Q { //implicit label @Q
        fun Int.foo() { //implicit label @foo
            val a = this@V
            val b = this@Q


            val c = this@foo
        }
    }
}