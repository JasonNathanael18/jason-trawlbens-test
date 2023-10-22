package com.example.router

import androidx.navigation.NavController

interface FeatureScreenRepoListRouteContract {
    fun show(dataToPass: String, navController: NavController)
}