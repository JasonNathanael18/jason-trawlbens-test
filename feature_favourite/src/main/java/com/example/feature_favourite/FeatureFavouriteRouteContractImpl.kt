package com.example.feature_favourite

import androidx.navigation.NavController
import com.example.favourite.R
import com.example.router.FeatureScreenFavouriteRouteContract

class FeatureFavouriteRouteContractImpl : FeatureScreenFavouriteRouteContract {
    override fun show(navController: NavController) {
        navController.navigate(R.id.nav_graph_favourite)
    }
}