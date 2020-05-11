package com.aratel.weatherapp.ui.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aratel.weatherapp.domain.model.ForecastList

class ForecastListAdapter(private val weekForecast: ForecastList) :
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            TextView(parent.context)
        )
    }

    /**
     * with basicaly receives an object and an extension function as parameters, and makes the object execute the function.
     * This means that all the code we define inside the brackets acts as an extension function for the object
     * provided in the first parameter, and we can use all its public functions and properties, as well as this.
     */
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /**
         * we can get the size of weekForecast list like this
         */
        /*with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }*/

        /**
         * or we can get the size of the weekForecast list by implementation get method ForecastList data class in DomainClasses
         */
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int {
        //return weekForecast.dailyForecast.size
        /**
         * according to onBindViewHolder use above or below code
         */
        return weekForecast.size
    }


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}