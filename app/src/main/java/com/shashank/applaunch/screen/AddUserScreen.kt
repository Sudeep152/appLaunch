package com.shashank.applaunch.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.shashank.applaunch.Entity.User
import com.shashank.applaunch.R
import com.shashank.applaunch.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.user_screen.*

class AddUserScreen:Fragment(R.layout.user_screen) {

    lateinit var viewM :UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewM= ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)


         cancel_button.setOnClickListener {
             findNavController().popBackStack()
         }


        Save_button.setOnClickListener {
            val firstname = nameEdt.text.toString()
            val lastName = lastEdt.text.toString()
            val email = emailEdt.text.toString()


            if(firstname.isEmpty() || lastName.isEmpty() ||email.isEmpty()){
                Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }else{
                viewM.insertUser(User(firstname,lastName,email))
                findNavController().popBackStack()
            }



        }
    }
}