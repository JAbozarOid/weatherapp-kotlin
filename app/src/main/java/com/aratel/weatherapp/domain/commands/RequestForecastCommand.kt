package com.aratel.weatherapp.domain.commands

import com.aratel.weatherapp.data.ForecastRequest
import com.aratel.weatherapp.domain.mappers.ForecastDataMapper
import com.aratel.weatherapp.domain.model.ForecastList

// val means the zipCode value can only be requested, but not modified which means immutable
// private means shouldn't be visible
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}