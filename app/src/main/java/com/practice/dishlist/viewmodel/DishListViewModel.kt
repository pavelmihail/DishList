package com.practice.dishlist.viewmodel

import androidx.lifecycle.*
import com.practice.dishlist.model.database.DishListRepository
import com.practice.dishlist.model.entities.DishList
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class DishListViewModel(private val repository: DishListRepository) : ViewModel() {

    fun insert(dish: DishList) = viewModelScope.launch {
        repository.insertDishListData(dish)
    }
    val allDishesList: LiveData<List<DishList>> = repository.allDishesList.asLiveData()
}

class DishListViewModelFactory(private val repository: DishListRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DishListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DishListViewModel(repository) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }
}

