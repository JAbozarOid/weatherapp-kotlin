package com.aratel.weatherapp.ui

import android.app.Application
import com.aratel.weatherapp.ui.utils.DelegatesExt
import kotlin.properties.Delegates

//Singleton
// we’ll need to have an easier access to the application context
class App : Application() {
    /**
     * we cannot initialise a non-nullable property, because its value
     * needs to be defined in the constructor
     */
    companion object {
        // instance is a nullable value
        //private var instance: Application? = null

        // this function returns non-nullable value
        //fun instance() = instance!!

        // or we can define instance property with lateinit
        // when a property is lateinit which means that property should take non-nullable value
        /** The problem with this solution is that we could change the value of this instance
         * from anywhere in the App, because a var property is required if we want to use lateinit
         * That’s easy to solve by using a private set:
         */
        //lateinit var instance: App
            //private set

        // orr we can use our custom delegate
        /**
         * to create a non-nullable delegate that can be only
         * assigned once. Second time it’s assigned, it will throw an exception.
         */
        var instance : App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this;
    }
}