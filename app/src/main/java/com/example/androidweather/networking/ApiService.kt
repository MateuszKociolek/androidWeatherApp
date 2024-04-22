package com.example.androidweather.networking

import com.example.androidweather.model.WeatherNow
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m&timezone=auto")
    fun getWeatherData(): Call<WeatherNow>
}