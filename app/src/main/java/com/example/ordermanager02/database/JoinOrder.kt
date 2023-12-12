package com.example.ordermanager02.database

import java.io.Serializable

data class JoinOrder(
    val id: Int,
    val description: String,
    val nameUser: String,
    val secondNameUser: String,
    val date: String,
    val quantity: Int,
    val nameProduct: String,
    val priceProduct: Float,
    val totalPrice: Float
) : Serializable {
    fun calculateTotalPrice(): Float {
        return priceProduct * quantity
    }
}
