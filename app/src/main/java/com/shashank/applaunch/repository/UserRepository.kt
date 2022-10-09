package com.shashank.applaunch.repository

import androidx.lifecycle.LiveData
import com.shashank.applaunch.Dao.UserDao
import com.shashank.applaunch.Entity.User


class UserRepository(private val dao: UserDao) {

    val allUser:LiveData<List<User>> =dao.getUsers()


    suspend fun  insert(user: User){
        dao.insert(user)
    }

    suspend fun delete(user: User){
        dao.delete(user)
    }


}