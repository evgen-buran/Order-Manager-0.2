package com.example.ordermanager02.ui.ORDERS.add_new_order

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ordermanager02.database.AppOrder
import com.example.ordermanager02.database.AppProduct
import com.example.ordermanager02.database.AppUser
import com.example.ordermanager02.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddOrderViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "myLog"
    var liveData: LiveData<List<AppUser>>
    var liveDataProduct:LiveData<List<AppProduct>>
    lateinit var listUsers: List<AppUser>
    var liveDataListUsers = MutableLiveData<List<AppUser>>()
    val context: Context = application

    init {
        liveData = REPOSITORY.getAllUsers()
        liveDataProduct = REPOSITORY.getAllProducts()
//        liveData.value?.let { userList ->
//            // Этот код будет выполнен, если значение не равно null
//            listUsers = userList
//        }
    }
    fun getAllUsers() {
        liveData = REPOSITORY.getAllUsers()
    }

    fun getAllProduct() {
        liveDataProduct = REPOSITORY.getAllProducts()
    }
    suspend fun getListUsers() {
        viewModelScope.launch(Dispatchers.IO) { listUsers = REPOSITORY.getListUsers() }

    }

    fun insertOrder(order: AppOrder) {
        viewModelScope.launch(Dispatchers.IO) { REPOSITORY.insertOrder(order) }
    }
}
