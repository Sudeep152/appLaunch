package com.shashank.todoapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shashank.applaunch.Dao.UserDao
import com.shashank.applaunch.Entity.User



@Database(entities = arrayOf(User::class),version = 1,exportSchema = false)
abstract class UserDatabase:RoomDatabase()  {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null


        fun getDatabase(
            context: Context
        ): UserDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}