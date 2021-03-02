package com.example.grondy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set the navigation bar with the nav controller
        setupActionBarWithNavController(findNavController(R.id.navHostFragmet))
    }
   //this navigates user to main screen
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragmet)
        return navController.navigateUp() || super.onNavigateUp()

    }
}