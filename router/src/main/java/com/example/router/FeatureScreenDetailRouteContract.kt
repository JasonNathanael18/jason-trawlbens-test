package com.example.router

import androidx.navigation.NavController

interface FeatureScreenDetailRouteContract {
    fun show(dataToPass: String, navController: NavController)
}