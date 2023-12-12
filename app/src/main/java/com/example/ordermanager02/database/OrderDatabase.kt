package com.example.ordermanager02.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AppOrder::class, AppUser::class, AppProduct::class, AppStatus::class], version = 2)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun getDaoOrders(): DaoOrders
    abstract fun getDaoUsers(): DaoUsers
    abstract fun getDaoProduct():DaoProduct
    abstract fun getDaoStatus():DaoStatus

    companion object {
        @Volatile
        private var database: RoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): OrderDatabase {
            if (database == null) {
                database =
                    Room.databaseBuilder(context, OrderDatabase::class.java, "orderDB").build()
                return database as OrderDatabase
            } else {
                return database as OrderDatabase
            }

        }
    }

}