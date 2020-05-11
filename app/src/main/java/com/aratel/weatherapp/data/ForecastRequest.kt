package com.aratel.weatherapp.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * HTTP requests are not allowed in the main thread
 */
class ForecastRequest(private val zipCode: String) {

    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        Log.d("ForecastRequestURL", COMPLETE_URL + zipCode)
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d("ForecastRequestResponse",forecastJsonStr)
        return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)
    }
}