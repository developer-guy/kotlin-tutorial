package org.learn.kotlin

import java.io.Serializable

abstract class AbstractEntity<T : Serializable> : BaseEntity<T>, Serializable {
    private lateinit var id: T

    override fun getId(): T? = id

    override fun setId(id: T) {
        this.id = id
    }
}