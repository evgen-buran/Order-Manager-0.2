package com.example.ordermanager02.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_status")
data class AppStatus(
    @PrimaryKey(autoGenerate = true)
    val id_status: Int = 0,
    @ColumnInfo
    val status: String,
)