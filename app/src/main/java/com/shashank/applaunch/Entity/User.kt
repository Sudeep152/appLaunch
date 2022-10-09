package com.shashank.applaunch.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    val firstName:String,val lastName:String,val email:String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}