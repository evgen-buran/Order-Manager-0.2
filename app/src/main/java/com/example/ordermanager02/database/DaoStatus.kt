package com.example.ordermanager02.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface DaoStatus {
    @Query(
        "SELECT * FROM table_status"
    )
    fun getAllStatus(): LiveData<List<AppStatus>>

    @Query(
        "SELECT * FROM table_status"
    )
    fun getListStatus(): List<AppStatus>

    @Insert
    fun insert(appStatus: AppStatus)

    @Delete
    fun delete(appStatus: AppStatus)


}