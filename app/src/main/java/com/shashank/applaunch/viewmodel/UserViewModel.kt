package com.shashank.applaunch.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.shashank.applaunch.Entity.User
import com.shashank.applaunch.remote.repository.WeatherRepository
import com.shashank.applaunch.repository.UserRepository
import com.shashank.todoapp.Database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application) {
    val repository : UserRepository
    val allUser :LiveData<List<User>>

    init {
        val dao = UserDatabase.getDatabase(application).userDao()
        repository= UserRepository(dao)
        allUser = repository.allUser
    }

    fun insertUser(user: User) =viewModelScope.launch ( Dispatchers.IO){
        repository.insert(user)
    }

    fun deleteNote (user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(user)
    }

}