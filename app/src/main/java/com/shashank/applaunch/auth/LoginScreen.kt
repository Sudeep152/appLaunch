package com.shashank.applaunch.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shashank.applaunch.R
import kotlinx.android.synthetic.main.login_screen.*

class LoginScreen:Fragment(R.layout.login_screen){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_homeScreen)

        }


    }


}