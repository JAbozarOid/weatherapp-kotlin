package com.aratel.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This activity will render a list of daily forecasts for the next seven days
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * we can access to the TextView via it's id without findviewbyid, because of "Kotlin Android Extensions"
         * this import automatically : import kotlinx.android.synthetic.main.activity_main.*
         * Kotlin interoperability use message.text instead of message.setText
         */
        message.text = "Hello Kotlin!"

    }
}
