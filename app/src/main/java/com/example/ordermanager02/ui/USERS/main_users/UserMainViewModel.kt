package com.example.ordermanager02.ui.USERS.main_users

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ordermanager02.database.AppUser
import com.example.ordermanager02.utils.REPOSITORY

class UserMainViewModel(application: Application): AndroidViewModel(application) {
    lateinit var liveData: LiveData<List<AppUser>>
    val context: Context = application
    fun getAllUsers() {
//        val daoUser = OrderDatabase.getInstance(context).getDaoUsers()
        liveData = REPOSITORY.getAllUsers()
    }


}