package org.learn.kotlin

private fun vb_foo() {}
// sadece bu dosya içerisinde görünür.
// protected ile benzer fakat protected tanımlanan değişkenen alt sınıflardan erişilebilir.

public var vb_bar: Int = 5
//değişkene her yerden erişilir fakat sadece
// bu dosya içerisinden atama yapılabilir
    private set

internal val baz = 6 // aynı paket içerisinde gözükür.

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4

    protected class Nested {
        public val e: Int = 5
    }
}

class SubClass : Outer() {
    override val b: Int // b'nin de visibility modifieri protected'tır.
        get() = 5
}

class Unrelated constructor(val o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}


class T private constructor(a: Int) {

}