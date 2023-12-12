package com.example.ordermanager02.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_users")
data class AppUser(
    @PrimaryKey(autoGenerate = true) val user_id: Int = 0,
    @ColumnInfo val nameUser: String,
    @ColumnInfo val secondNameUser: String,
) : Serializable {
    override fun toString(): String {
        return nameUser
    }


}
