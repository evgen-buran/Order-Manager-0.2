package com.example.ordermanager02.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "table_product"
)
data class AppProduct(
    @PrimaryKey(autoGenerate = true)
    val product_id: Int = 0,
    @ColumnInfo
    val nameProduct: String,
    @ColumnInfo
    val descriptionProduct: String,
    @ColumnInfo
    val priceProduct: Float,
) : Serializable {
    override fun toString(): String {
        return nameProduct
    }
}
