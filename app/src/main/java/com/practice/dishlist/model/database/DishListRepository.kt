package com.practice.dishlist.model.database

import androidx.annotation.WorkerThread
import com.practice.dishlist.model.entities.DishList

class DishListRepository(private val dishListDAO: DishListDao) {

    @WorkerThread
    suspend fun insertDishListData(dishList : DishList){
        dishListDAO.insertDishListDetails(dishList)
    }
}