package com.aratel.weatherapp.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aratel.weatherapp.R
import com.aratel.weatherapp.activities.ForecastListAdapter
import com.aratel.weatherapp.data.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

/**
 * This activity will render a list of daily forecasts for the next seven days
 */
class MainActivity : AppCompatActivity() {

    // constant list which called immutable
    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * we can access to the TextView via it's id without findviewbyid, because of "Kotlin Android Extensions"
         * this import automatically : import kotlinx.android.synthetic.main.activity_main.*
         * Kotlin interoperability use message.text instead of message.setText
         */
        //message.text = "Hello Kotlin!"



        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter =
            ForecastListAdapter(items)

        val url = "https://api.openweathermap.org/data/2.5/forecast/daily?APPID=15646a06818f61f7b8d7823ca833e1ce&zip=94043&mode=json&units=metric&cnt=7"

        /**
         * uiThread has a different implementations depending on
         * the caller object. If it’s used by an Activity,
         * the uiThread code won’t be executed if activity.isFinishing() returns true,
         * and it won’t crash if the activity is no longer valid.
         */
        /**
         * doAsync returns a java Future
         */
        doAsync {
            Request(url).run()
            uiThread { longToast("Request Performed") }
        }

    }
}
