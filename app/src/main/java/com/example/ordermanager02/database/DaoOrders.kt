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
                "table_orders.quantity, " +
                "table_product.nameProduct, " +
                "table_product.priceProduct, " +
                "table_orders.totalPrice " +
                "FROM table_orders JOIN table_users " +
                "ON table_orders.id_users = table_users.user_id " +
                "JOIN table_product " +
                "ON table_orders.id_product = table_product.product_id "
    )
    fun getAllOrders(): LiveData<List<JoinOrder>>

    @Query(
        """
     
INSERT INTO table_orders (id_users, id_product, quantity, description, date, totalPrice)
                VALUES
     (1, 1, 2, 'Заказ для Ивана', '2023-01-01', (SELECT priceProduct FROM table_product WHERE product_id = 1) * 2),
    (2, 3, 1, 'Заказ для Екатерины', '2023-01-02', (SELECT priceProduct FROM table_product WHERE product_id = 3) * 1),
    (3, 2, 3, 'Заказ для Михаила', '2023-01-03', (SELECT priceProduct FROM table_product WHERE product_id = 2) * 3),
    (4, 4, 1, 'Заказ для Ольги', '2023-01-04', (SELECT priceProduct FROM table_product WHERE product_id = 4) * 1),
    (5, 5, 2, 'Заказ для Дмитрия', '2023-01-05', (SELECT priceProduct FROM table_product WHERE product_id = 5) * 2)
 
    """
    )
    fun testDataOrders()

    @Query("DELETE FROM table_orders")
    fun truncateOrders()


    @Insert
    fun insert(appOrder: AppOrder)

    @Delete
    fun delete(appOrder: AppOrder)


}