package com.shashank.applaunch.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.shashank.applaunch.R
import com.shashank.applaunch.remote.WeatherApi
import com.shashank.applaunch.remote.client
import com.shashank.applaunch.remote.repository.WeatherRepository
import com.shashank.applaunch.remote.viewmodel.WeatherViewModel
import com.shashank.applaunch.remote.viewmodel.WeathervViewModelFactory
import com.shashank.applaunch.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.weather_screen.*

class WeatherScreen : Fragment(R.layout.weather_screen) {

    lateinit var viewModel: WeatherViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofitService = client.api
        val mainRepository = WeatherRepository(retrofitService)


        viewModel = ViewModelProvider(this,
            WeathervViewModelFactory(mainRepository)).get(WeatherViewModel::class.java)


        viewModel.weatherResponse.observe(requireActivity()) {


            tvTemperature.text = it.current.temp.toString()
            tvWind.text = it.current.wind_speed.toString()
            tvDescription.text = it.current.weather[it.current.uvi].description.toString()
            tvHumidity.text = it.current.humidity.toString()+"%"


        }

    }

}