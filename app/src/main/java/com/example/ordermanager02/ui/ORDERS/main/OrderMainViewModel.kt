package com.example.ordermanager02.ui.ORDERS.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ordermanager02.database.JoinOrder
import com.example.ordermanager02.database.OrderDatabase
import com.example.ordermanager02.database.OrderRepository
import com.example.ordermanager02.utils.REPOSITORY

class OrderMainViewModel(application: Application) : AndroidViewModel(application) {
    val context = application
    lateinit var liveData: LiveData<List<JoinOrder>>

    fun getAllOrders() {
        liveData = REPOSITORY.getAllOrders()
    }

    fun initBD() {
        val database = OrderDatabase.getInstance(context)
        val daoOrder = database.getDaoOrders()
        val daoUsers = database.getDaoUsers()
        val daoProduct = database.getDaoProduct()
        val daoStatus = database.getDaoStatus()
        REPOSITORY = OrderRepository(daoOrder, daoUsers, daoProduct, daoStatus)
    }

}