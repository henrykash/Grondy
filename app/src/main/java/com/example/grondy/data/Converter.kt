package com.example.grondy.data

import androidx.room.TypeConverter
import com.example.grondy.data.models.Priority

class Converter {
    //converts priority object to string when writing to a database
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    //converts Priority Object to String when reading from the database
    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}