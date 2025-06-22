package com.example.androidweather

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidweather.model.WeatherNow
import com.example.androidweather.networking.RetrofitService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentTemperatureTextView = findViewById<TextView>(R.id.currentWeather)
        val currentDate = findViewById<TextView>(R.id.currentTime)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        val call = service.getWeatherData()

        fun formatDateTime(inputDateTime: String?): String {
            if (inputDateTime.isNullOrBlank()) return ""

            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
            val outputFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

            return try {
                val date = inputFormat.parse(inputDateTime)
                outputFormat.format(date)
            } catch (ex: Exception) {
                ""
            }
        }

        call.enqueue(object : Callback<WeatherNow> {
            override fun onResponse(
                call: Call<WeatherNow>,
                response: Response<WeatherNow>
            ) {
                if (response.isSuccessful){
                    var weatherResponse = response.body()
                    weatherResponse?.let {
                        val currentWeather = it.current
                        val tempnow = currentWeather?.temperature2m
                        val timenow = currentWeather?.time


                        currentTemperatureTextView.text = tempnow.toString() + "°"
                        currentDate.text = formatDateTime(timenow)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherNow>, t: Throwable) {
                currentTemperatureTextView.text = "ERROR"
            }
        })



    }
}
