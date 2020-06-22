package com.aratel.weatherapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aratel.weatherapp.R
import com.aratel.weatherapp.domain.model.Forecast
import com.aratel.weatherapp.domain.model.ForecastList
import com.aratel.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.jetbrains.anko.find
import java.util.zip.Inflater

class ForecastListAdapter(
    private val weekForecast: ForecastList,
    //private val itemClick: ForecastListAdapter.OnItemClickListener
    // using lambdas for click in items of list like below
    private val itemClick: (Forecast) -> Unit
) :
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {


    // when the item layout is a simple textview
    /*override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            TextView(parent.context)
        )
    }*/

    // define item_forecast
    // parent.ctx uses from file ui/utils/ViewExtension.kt >>> it’s another good example of how to use extension properties
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
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
        // when the view is a single line of TextView
        /*with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }*/

        // when the view for items in list is item_forecast
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int {
        //return weekForecast.dailyForecast.size
        /**
         * according to onBindViewHolder use above or below code
         */
        return weekForecast.size
    }

    // use this single line code when the view is a simple textview
    //class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    // handle item_forecast view with this class
    class ViewHolder(
        view: View,
        //val itemClick: OnItemClickListener
        // using lambdas for handling click on item
        val itemClick: (Forecast) -> Unit
    ) :
        RecyclerView.ViewHolder(view) {

        //private val iconView = view.find<ImageView>(R.id.icon)
        //private val dateView = view.find<TextView>(R.id.date)
        //private val descriptionView = view.find<TextView>(R.id.description)
        //private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        //private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                // *** when using import kotlinx.android.synthetic.main.item_forecast.view.* NOT using find
                Picasso.get().load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    // the invoke method can be omitted when called
    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

}