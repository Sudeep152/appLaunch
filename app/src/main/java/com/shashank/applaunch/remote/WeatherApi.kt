package com.shashank.applaunch.remote

import com.shashank.applaunch.remote.model.Weather
import com.shashank.applaunch.utils.Const.Companion.appId
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/onecall")
   suspend fun getWeather(
        @Query("lat")las:Double,
        @Query("lon")lon:Double,
        @Query("units")uinits:String="imperial",
        @Query("appid")appid:String=appId
   ):Response<Weather>

}