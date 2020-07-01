package com.aratel.weatherapp.ui.utils

import kotlin.reflect.KProperty

/**
 * Kotlin object Expressions.
 * The object keyword can also be used to create objects of an anonymous class known as anonymous objects.
 * They are used if you need to create an object of a slight modification of some class or interface without declaring a subclass for it.
 */
object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T> {

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
        value ?: throw IllegalStateException("${property.name} not initialized")

    /**
     * to create a non-nullable delegate that can be only
     * assigned once. Second time it’s assigned, it will throw an exception.
     */
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}