package com.shashank.applaunch.auth

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shashank.applaunch.R
import kotlinx.android.synthetic.main.login_screen.*
import kotlinx.android.synthetic.main.login_screen.view.*

class LoginScreen:Fragment(R.layout.login_screen){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.setOnClickListener {

            val email= emilEdt.text.isValidEmail()
            val password = passwordEdt.text.toString()

            if (email && isValidPassword(password)){
                findNavController().navigate(R.id.action_loginScreen_to_homeScreen)

            } else{
                Toast.makeText(requireContext(), "this is wrong format", Toast.LENGTH_SHORT).show()

            }




        }


    }

    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false
        if (password.filter { it.isDigit() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
        if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true
    }
}