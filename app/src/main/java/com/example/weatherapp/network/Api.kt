package com.example.weatherapp.network

import com.example.weatherapp.models.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val APIKEY = "y6ggPiDtveLzjvUCVY7YfJwxgmHLAgD7"

interface Api {
    @GET("locations/v1/cities/search")
    suspend fun searchLocation(
        @Query("apikey") apikey:String = APIKEY,
        @Query("q") query:String
    ):Response<List<Location>>

    @GET("forecasts/v1/daily/5day/locationKey")
    suspend fun fiveday(
        @Query("apikey") apikey:String = APIKEY
    )
}