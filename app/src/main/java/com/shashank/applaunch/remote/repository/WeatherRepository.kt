package com.shashank.applaunch.remote.repository

import com.shashank.applaunch.remote.WeatherApi
import com.shashank.applaunch.remote.client
import com.shashank.applaunch.remote.model.Weather
import retrofit2.Response

class WeatherRepository(val apiservice:WeatherApi) {

    suspend fun  getWeather(lat:Double,lon:Double): Response<Weather> {
         return apiservice.getWeather(lat,lon)
    }
}