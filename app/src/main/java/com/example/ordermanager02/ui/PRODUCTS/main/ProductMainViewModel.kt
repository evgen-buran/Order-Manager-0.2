package com.example.ordermanager02.ui.PRODUCTS.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ordermanager02.database.AppProduct
import com.example.ordermanager02.utils.REPOSITORY

class ProductMainViewModel(application: Application) : AndroidViewModel(application) {
    val context: Context = application
    lateinit var liveData: LiveData<List<AppProduct>>

    fun getAllProducts() {
        liveData = REPOSITORY.getAllProducts()
    }
}