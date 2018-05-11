package org.learn.kotlin

import java.io.Serializable

interface BaseEntity<T : Serializable> {
    fun getId(): T?
    fun setId(t: T)
}

