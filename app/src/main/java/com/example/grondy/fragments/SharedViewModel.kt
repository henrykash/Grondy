package com.example.grondy.fragments

import android.app.Application

import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.example.grondy.R
import com.example.grondy.data.models.Priority


class SharedViewModel(application: Application): AndroidViewModel(application) {
     val listener: AdapterView.OnItemSelectedListener = object :
       AdapterView.OnItemSelectedListener {
         override fun onItemSelected(
             parent: AdapterView<*>?,
             view: View?,
             postion: Int,
             id: Long
         ) {
             when(postion) {
                 0 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.red))}
                 1 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.yellow))}
                 2 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.green))}
             }

         }

         override fun onNothingSelected(p0: AdapterView<*>?) {
             TODO("Not yet implemented")
         }
     }


    fun verifyDataFromUser(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())
    }

    fun parsePriority(priority: String): Priority {
        return when(priority){
            "High Priority" -> { Priority.HIGH }
            "Medium Priority" -> { Priority.MEDIUM }
            "Low Priority" -> { Priority.LOW }
            else -> Priority.LOW
        }
    }

}