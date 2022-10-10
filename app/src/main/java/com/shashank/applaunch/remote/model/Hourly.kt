package com.shashank.applaunch.remote.model

data class Hourly(
    val clouds: Float ,
    val dew_point: Double,
    val dt: Float,
    val feels_like: Double,
    val humidity: Float,
    val pop: Double,
    val pressure: Float,
    val rain: Rain,
    val temp: Double,
    val uvi: Double ,
    val visibility: Float,
    val weather: List<WeatherX>,
    val wind_deg: Float,
    val wind_gust: Double,
    val wind_speed: Double
)