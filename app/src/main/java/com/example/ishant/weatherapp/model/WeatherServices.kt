package com.example.ishant.weatherapp.model

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServices{
    @GET("/data/2.5/weather")
    fun weatherByZip(@Query("units")units : String, @Query("zip") zip : Int, @Query("APPID") apiKey: String ): retrofit2.Call<Weather>
}