package com.practice.dishlist.model.database

import androidx.room.Dao
import androidx.room.Insert
import com.practice.dishlist.model.entities.DishList

@Dao
interface DishListDAO {

    @Insert
    suspend fun insertDishListDetails(dishList: DishList)
}