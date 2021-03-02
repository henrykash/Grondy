package com.example.grondy.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.grondy.data.models.ToDoData

@Dao
interface TodoDao {
    //write our own customized queries here so we are going to create a customized functions
       @Query("SELECT * FROM todo_table ORDER BY id ASC")
      fun getAllData(): LiveData <List<ToDoData>>

    //create another function to insert data
      @Insert(onConflict = OnConflictStrategy.IGNORE) //this tells the database to ignore items that are inserted even if they exist
     suspend fun insertData(toDoData: ToDoData)
}