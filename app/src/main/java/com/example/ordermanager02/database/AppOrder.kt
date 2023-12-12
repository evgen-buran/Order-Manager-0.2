package com.example.ordermanager02.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "table_orders", foreignKeys = [ForeignKey(
        entity = AppUser::class,
        parentColumns = ["user_id"],
        childColumns = ["id_users"],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = AppProduct::class,
        parentColumns = ["product_id"],
        childColumns = ["id_product"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class AppOrder(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val id_users: Int,

    @ColumnInfo
    val id_product: Int,

    @ColumnInfo
    val quantity: Int,

    @ColumnInfo
    val description: String,

    @ColumnInfo
    val date: String,

    @ColumnInfo
    val totalPrice : Float,
) : Serializable {

}