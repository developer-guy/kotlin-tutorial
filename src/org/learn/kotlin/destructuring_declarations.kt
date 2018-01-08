package org.learn.kotlin

// data class also provides componentN functions by default.
data class Article constructor(val name: String, val author: String)

fun main(args: Array<String>) {
    val article = Article("React&Redux", "Batuhan")

    val (name, author) = article

    println("Name $name author $author")

    val name2 = article.component1()
    val author2 = article.component2()

    println("Name $name2 author $author2")


}