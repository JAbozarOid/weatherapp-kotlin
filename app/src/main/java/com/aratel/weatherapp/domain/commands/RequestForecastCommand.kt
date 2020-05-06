package com.aratel.weatherapp.domain.commands

import com.aratel.weatherapp.data.ForecastRequest
import com.aratel.weatherapp.domain.mappers.ForecastDataMapper
import com.aratel.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}