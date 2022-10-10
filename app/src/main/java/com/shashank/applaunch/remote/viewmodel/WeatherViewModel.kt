package com.shashank.applaunch.remote.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.applaunch.remote.model.Weather
import com.shashank.applaunch.remote.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel(val repository: WeatherRepository):ViewModel() {

    var  lat =12.908284762331
        var lon =77.65197822993314
    private val _response = MutableLiveData<Weather>()
    val weatherResponse: LiveData<Weather>
        get() = _response


    init {
        getWeather()
    }

    private fun getWeather() =viewModelScope.launch {
       repository.getWeather(lat,lon).let {
               response ->
           if (response.isSuccessful) {
               _response.postValue(response.body())
           } else {
               Log.d("tag", "getWeather Error: ${response.code()}")
           }
       }
    }
}