package com.shashank.applaunch.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.shashank.applaunch.R
import com.shashank.applaunch.remote.WeatherApi
import com.shashank.applaunch.remote.repository.WeatherRepository
import com.shashank.applaunch.remote.viewmodel.WeatherViewModel
import com.shashank.applaunch.viewmodel.UserViewModel

class WeatherScreen :Fragment(R.layout.weather_screen){

    lateinit var viewModel :WeatherViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val repository = WeatherRepository()



//        viewModel.weatherResponse.observe(requireActivity(),{
//            Toast.makeText(requireContext(), it.minutely.toString(), Toast.LENGTH_SHORT).show()
//
//        })
    }
}