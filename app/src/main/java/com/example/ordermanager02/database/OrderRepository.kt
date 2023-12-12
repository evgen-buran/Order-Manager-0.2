package com.example.ordermanager02.database

import androidx.lifecycle.LiveData

class OrderRepository(
    val daoOrders: DaoOrders,
    val daoUsers: DaoUsers,
    val daoProduct: DaoProduct,
    val daoStatus:DaoStatus,
) {

    //-------------------------getAll*----------------------для статуса методы не внесены,
    // т.к. перечень статусов будет вноситься при инициализации
    fun getAllOrders(): LiveData<List<JoinOrder>> {
        return daoOrders.getAllOrders()
    }

    fun getAllUsers(): LiveData<List<AppUser>> {
        return daoUsers.getAllUsers()
    }

    fun getAllProducts(): LiveData<List<AppProduct>> {
        return daoProduct.getAllProduct()
    }

    fun getListUsers(): List<AppUser> {
        return daoUsers.getListUsers()
    }

    // ------------------insert*---------------
    fun insertOrder(appOrder: AppOrder) {
        return daoOrders.insert(appOrder)
    }

    fun insertUser(appUser: AppUser) {
        return daoUsers.insert(appUser)
    }

    fun insertProduct(appProduct: AppProduct) {
        return daoProduct.insert(appProduct)
    }
    fun insertStatus(appStatus: AppStatus) {
        return daoStatus.insert(appStatus)
    }

    //-----------------delete*-------------------
    fun deleteOrder(appOrder: AppOrder) {
        return daoOrders.delete(appOrder)
    }

    fun deleteUser(appUser: AppUser) {
        return daoUsers.delete(appUser)
    }

    fun deleteProduct(appProduct: AppProduct) {
        return daoProduct.delete(appProduct)
    }
}