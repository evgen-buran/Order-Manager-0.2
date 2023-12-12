package com.example.ordermanager02.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoProduct {
    @Query(
        "SELECT * FROM table_product"
    )
    fun getAllProduct(): LiveData<List<AppProduct>>

    @Query(
        "SELECT * FROM table_product"
    )
    fun getListProducts(): List<AppProduct>

    @Insert
    fun insert(appProduct: AppProduct)

    @Delete
    fun delete(appProduct: AppProduct)


}
