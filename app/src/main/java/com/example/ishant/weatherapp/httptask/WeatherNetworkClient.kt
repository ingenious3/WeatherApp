package com.example.ishant.weatherapp.httptask

import android.content.Context
import com.example.ishant.weatherapp.R
import com.example.ishant.weatherapp.model.Weather
import com.example.ishant.weatherapp.model.WeatherServices
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherNetworkClient(val context : Context){
    val apiKey = context.resources.getString(R.string.open_weathermap_api);

    fun getWeatherFromZip(zipcode : Int): Call<Weather>{
        val network = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val weatherServices = network.create(WeatherServices::class.java)
        val weather = weatherServices.weatherByZip("imperial",zipcode,apiKey)
        return weather
    }
}