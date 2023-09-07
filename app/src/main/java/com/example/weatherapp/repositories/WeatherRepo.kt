package com.example.weatherapp.repositories

import com.example.weatherapp.models.BaseModel
import com.example.weatherapp.models.DailyForecasts
import com.example.weatherapp.models.HourlyForecast
import com.example.weatherapp.models.Location

interface WeatherRepo {
    suspend fun searchLocation(query: String): BaseModel<List<Location>>
    suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts>
    suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>>
}
