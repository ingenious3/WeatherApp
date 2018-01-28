package com.example.ishant.weatherapp.model

import com.google.gson.annotations.SerializedName

class Weather{
    var main:Main = Main();
}

class Main {
    @SerializedName("temp")
    var temp : Float = 0.0f;
    @SerializedName("temp_min")
    var minTemp: Float = 0.0f;
    @SerializedName("temp_max")
    var maxTemp: Float = 0.0f;
    @SerializedName("pressure")
    var pressure: Int = 0;
    @SerializedName("humidity")
    var humidity: Int = 0;

}
