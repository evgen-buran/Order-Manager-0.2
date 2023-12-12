package com.example.ordermanager02.ui.PRODUCTS.add_new_product

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ordermanager02.database.AppProduct
import com.example.ordermanager02.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddProductViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context = application

    fun insertProduct(product: AppProduct) {
        viewModelScope.launch(Dispatchers.IO){ REPOSITORY.insertProduct(product)}
    }
}