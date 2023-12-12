package com.example.ordermanager02.ui.ORDERS.detail_order

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ordermanager02.database.JoinOrder

class OrderViewModel:ViewModel() {
    val orderLiveData = MutableLiveData<JoinOrder>()

}