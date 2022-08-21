package com.practice.dishlist.application

import android.app.Application
import com.practice.dishlist.model.database.DishListRepository
import com.practice.dishlist.model.database.DishListRoomDatabase

class DishListApplication: Application() {

    private val database by lazy{ DishListRoomDatabase.getDatabase(this@DishListApplication)}

    val repository by lazy {DishListRepository(database.dishListDao())}
}
