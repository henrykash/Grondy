package com.example.grondy.data.repository

import androidx.lifecycle.LiveData
import com.example.grondy.data.TodoDao
import com.example.grondy.data.models.ToDoData

class ToDoRepository(private val todoDao: TodoDao) {

    val getAllData: LiveData<List<ToDoData>> = todoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        todoDao.insertData(toDoData)
    }
}