package com.example.ordermanager02.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoOrders {
    @Query(
        "SELECT " +
                "table_orders.Id," +
                "table_orders.description, " +
                "table_users.nameUser, " +
                "table_users.secondNameUser, " +
                "table_orders.date, " +
                "table_orders.quantity," +
                "table_product.nameProduct, " +
                "table_product.priceProduct, " +
                "table_orders.totalPrice " +
                "FROM table_orders JOIN table_users " +
                "ON table_orders.id_users = table_users.user_id " +
                "JOIN table_product " +
                "ON table_orders.id_product = table_product.product_id "
    )
    fun getAllOrders(): LiveData<List<JoinOrder>>

    @Insert
    fun insert(appOrder: AppOrder)

    @Delete
    fun delete(appOrder: AppOrder)


}