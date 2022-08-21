package com.practice.dishlist.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practice.dishlist.model.entities.DishList

@Database(entities = [DishList::class], version = 1)
abstract class DishListRoomDatabase : RoomDatabase() {

    abstract fun dishListDao(): DishListDao

    companion object {
        @Volatile
        private var INSTANCE: DishListRoomDatabase? = null

        fun getDatabase(context: Context): DishListRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DishListRoomDatabase::class.java,
                    "dish_list_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}