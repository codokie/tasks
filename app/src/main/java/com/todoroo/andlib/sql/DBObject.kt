package com.todoroo.andlib.sql

import java.util.*

abstract class DBObject internal constructor(val expression: String) : Cloneable {
    var alias: String? = null

    abstract fun `as`(newAlias: String): DBObject

    protected fun hasAlias() = alias != null

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is DBObject) {
            return false
        }
        return expression == other.expression && alias == other.alias
    }

    override fun hashCode() = Objects.hash(expression, alias)

    override fun toString() = alias ?: expression
}