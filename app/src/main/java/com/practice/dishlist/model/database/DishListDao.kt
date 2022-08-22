package com.practice.dishlist.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.practice.dishlist.model.entities.DishList
import kotlinx.coroutines.flow.Flow

@Dao
interface DishListDao {

    @Insert
    suspend fun insertDishListDetails(dishList: DishList)

    @Query("SELECT * FROM DISH_LIST_TABLE ORDER BY ID")
    fun getAllDishedList(): Flow<List<DishList>>
}