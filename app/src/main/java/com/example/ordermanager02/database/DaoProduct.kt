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
        """
            INSERT INTO table_product (nameProduct, descriptionProduct, priceProduct)
VALUES
    ('Samsung Galaxy S21', 'Смартфон с высокой производительностью', 59990.00),
    ('iPhone 13', 'Новый айфон с улучшенной камерой', 79990.00),
    ('Xiaomi Redmi Note 10', 'Бюджетный смартфон с хорошей батареей', 18990.00),
    ('Google Pixel 6', 'Смартфон с отличной камерой и чистым Android', 69990.00),
    ('OnePlus 9 Pro', 'Флагманский смартфон от OnePlus', 89990.00)

        """
    )
    fun testDataProducts()

    @Query("DELETE FROM table_product")
    fun truncateProducts()


    @Query(
        "SELECT * FROM table_product"
    )
    fun getListProducts(): List<AppProduct>

    @Insert
    fun insert(appProduct: AppProduct)

    @Delete
    fun delete(appProduct: AppProduct)


}
