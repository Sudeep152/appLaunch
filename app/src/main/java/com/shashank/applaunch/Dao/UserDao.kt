package com.shashank.applaunch.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shashank.applaunch.Entity.User

@Dao
interface UserDao {


    @Query("SELECT * FROM User ORDER BY id ASC ")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)


    @Delete
     fun delete(user: User)
}