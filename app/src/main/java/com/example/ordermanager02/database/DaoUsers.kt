package com.example.ordermanager02.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoUsers {
    @Query(
        "SELECT * FROM table_users"
    )
    fun getAllUsers(): LiveData<List<AppUser>>

    @Query(
        "SELECT * FROM table_users"
    )
    fun getListUsers(): List<AppUser>

    @Insert
    fun insert(appUser: AppUser)

    @Delete
    fun delete(appUser: AppUser)


}
