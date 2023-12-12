package com.example.ordermanager02.ui.USERS.add_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ordermanager02.database.AppUser
import com.example.ordermanager02.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddUserViewModel : ViewModel() {

    fun insert(user: AppUser) {
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.insertUser(user)
        }
    }
}