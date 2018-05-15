package org.learn.kotlin

/**
 * @author Batuhan Apaydın
 */


@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy(val why: String) {
}


@Fancy("example")
class Foo {

}