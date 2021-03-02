package com.example.grondy.data

import android.content.Context
import androidx.room.*
import com.example.grondy.data.models.ToDoData

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase : RoomDatabase() {

    //returns a ToDoDao class
    abstract fun toDoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null
        fun getDatabase(context: Context): ToDoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            //we use this to prevent multiple threads to create multiple instances
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}