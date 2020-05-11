package com.aratel.weatherapp.domain.commands

/**
 * These commands will execute an operation and return an object of the class specified in its generic type.
 * Interfaces in Kotlin are more powerful than Java (prior to Java 8), because they can contain code.
 */
/**
 * The first command needs to request the forecast to the API and convert it to domain classes.
 */
interface Command<out T> {
    fun execute(): T
}