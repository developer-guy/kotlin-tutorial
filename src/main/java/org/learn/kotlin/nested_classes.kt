package org.learn.kotlin


class OuterClass {
    private val bar: Int = 1

    inner class NestedClass {
        fun foo() = bar    // inner sınıf inner keywordü ile işaretlenmez ise outer sınıfın öğelerini göremez
    }
}


fun main(args: Array<String>) {
    val demo = OuterClass().NestedClass().foo()
    println(demo)
}