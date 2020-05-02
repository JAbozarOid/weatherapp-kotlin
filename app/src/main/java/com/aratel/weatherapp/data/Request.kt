package com.aratel.weatherapp.data

import android.util.Log
import java.net.URL

/**
 * HTTP requests are not allowed in the main thread
 */
class Request(private val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}