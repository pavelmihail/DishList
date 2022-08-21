package com.practice.dishlist.model.database

import androidx.room.Dao
import androidx.room.Insert
import com.practice.dishlist.model.entities.DishList

@Dao
interface DishListDao {

    @Insert
    suspend fun insertDishListDetails(dishList: DishList)
}