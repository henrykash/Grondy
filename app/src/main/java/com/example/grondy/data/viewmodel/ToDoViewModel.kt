package com.example.grondy.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.grondy.data.ToDoDatabase
import com.example.grondy.data.repository.ToDoRepository
import com.example.grondy.data.models.ToDoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application): AndroidViewModel(application){
    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository : ToDoRepository
     val getAllData: LiveData<List<ToDoData>>

     init {
         repository = ToDoRepository(toDoDao)
         getAllData = repository.getAllData
     }
     //when a user wants to insert a new data to the db we use the following function
    fun insertData(toDoData: ToDoData){
         viewModelScope.launch(Dispatchers.IO) {
             toDoDao.insertData(toDoData)
         }
     }
}