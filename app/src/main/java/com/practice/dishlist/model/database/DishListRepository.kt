package com.practice.dishlist.model.database

import androidx.annotation.WorkerThread
import com.practice.dishlist.model.entities.DishList
import kotlinx.coroutines.flow.Flow

class DishListRepository(private val dishListDao: DishListDao) {

    @WorkerThread
    suspend fun insertDishListData(dishList : DishList){
        dishListDao.insertDishListDetails(dishList)
    }

    val allDishesList: Flow<List<DishList>> = dishListDao.getAllDishedList()
}