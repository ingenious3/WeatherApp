package com.example.ishant.weatherapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.example.ishant.weatherapp.R
import com.example.ishant.weatherapp.httptask.WeatherNetworkClient
import com.example.ishant.weatherapp.model.Main
import com.example.ishant.weatherapp.model.Weather
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zipcode.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                val zipcode = s.toString()
                if(zipcode.length ==5 ){
                    getWeatherFromZipCode(zipcode.toInt())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

    }

    private fun getWeatherFromZipCode(zipcode : Int){
        val networkOperation = WeatherNetworkClient(applicationContext)
        val networkCall = networkOperation.getWeatherFromZip(zipcode)
        networkCall.enqueue(object : retrofit2.Callback<Weather> {
            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                if(response != null ){
                    val weather : Weather? = response?.body()
                    val main = weather?.main
                    main?.let { presentData(it) }

                }
            }
        })
    }

    private fun presentData(main : Main){
        with(main){
            currentTempTextview.text = "${main.temp}"
            highTempTextview.text = "High : ${main.maxTemp}"
            lowTempTextview.text = "Low : ${main.minTemp}"
            pressureTextview.text = "Pressure : ${main.pressure}"
            humidityTextview.text = "Humidity : ${main.humidity}"
        }
    }
}

